package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationForm {
    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void registrationForm() {

        String firstName = "Ivan",
                lastName = "Ivanov",
                email = "i_ivanov@gamil.com",
                current_address = "London",
                mobileNumber = "1234567890",
                yearOfBirth = "1988",
                monthOfBirth = "April";



        open("/automation-practice-form");

        //$("[id = userName]").shouldBe(visible);
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(".custom-radio:nth-child(1) > .custom-control-label").click();
        $("#userNumber").setValue(mobileNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__month-select > option:nth-child(4)").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__year-select > option:nth-child(89)").click();
        $(".react-datepicker__day--014").click();
        $(".subjects-auto-complete__value-container").click();
        $("#subjectsInput").setValue("Arts");
        $("#subjectsInput").pressEnter();
        $(".custom-checkbox:nth-child(1) > .custom-control-label").click();
        $(".custom-checkbox:nth-child(2) > .custom-control-label").click();
        $(".custom-checkbox:nth-child(3) > .custom-control-label").click();
        $("#uploadPicture").click();
        //$("#uploadPicture").setValue("C:\\Users\\Asus\\Desktop\\ExonGroup\\Картинки\\3f4f0067d3f1a894c673f3dc39cea145.jpg");

        //$("#currentAddress").setValue(current_address);
        //$("[id = permanentAddress]").setValue(permanent_address);
       // $("[id = submit]").click();

        //$("[id = output]").shouldHave(text("Name:" + name),
          //      text("Email:" + email),
         //       text("Current Address :" + current_address),
          //      text("Permananet Address :" + permanent_address));

        //$("[id = output] [id = name]").shouldHave(text(name));
       // $("[id = output]").$(" [id = name]").shouldHave(text(name));
      //  $("p[id = permanentAddress]").shouldHave(text("Permananet Address :" + permanent_address));

     //   String expectedPermanentAddress = "Permananet Address :" + permanent_address;
     //   String actualPermanentAddress = $("p[id = permanentAddress]").text();
//assertEquals(expectedPermanentAddress, actualPermanentAddress);
    }
}
