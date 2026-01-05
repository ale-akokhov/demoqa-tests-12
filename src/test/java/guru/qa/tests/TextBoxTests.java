package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextBoxTests {

    @BeforeAll
    static void setUp() {
        //Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {

        String name = "Ivanov Ivan";
        String e_mail = "i_i-i@gmail.com";
        String current_address = "London";
        String permanent_address = "New-York";


        open("/text-box");

        //$("[id = userName]").shouldBe(visible);
        $("[id = userName]").setValue(name);
        $("[id = userEmail]").setValue(e_mail);
        $("[id = currentAddress]").setValue(current_address);
        $("[id = permanentAddress]").setValue(permanent_address);
        $("[id = submit]").click();

        $("[id = output]").shouldHave(text("Name:" + name),
                text("Email:" + e_mail),
                text("Current Address :" + current_address),
                text("Permananet Address :" + permanent_address));

        $("[id = output] [id = name]").shouldHave(text(name));
        $("[id = output]").$(" [id = name]").shouldHave(text(name));
        $("p[id = permanentAddress]").shouldHave(text("Permananet Address :" + permanent_address));

        String expectedPermanentAddress = "Permananet Address :" + permanent_address;
        String actualPermanentAddress = $("p[id = permanentAddress]").text();
        assertEquals(expectedPermanentAddress, actualPermanentAddress);
    }
}
