package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").shouldBe(visible);
        $("#userName").setValue("Ivanov Ivan");
        $("#userEmail").setValue("i_i-i@gmail.com");
        $("#currentAddress").setValue("London");
        $("#permanentAddress").setValue("New-York");
        $("#submit").click();

    }
}
