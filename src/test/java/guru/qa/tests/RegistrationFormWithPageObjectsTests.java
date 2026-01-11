package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormWithPageObjectsTests {
    @BeforeAll
    static void setUp() {
        //Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.browserSize = "1920x1080";
    }

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void successfulTest() {

        String firstName = "Ivan",
                lastName = "Ivanov",
                email = "i_ivanov@gamil.com",
                gender = "Female",  // Male || Female || Other
                mobileNumber = "1234567890",
                dayOfBirth = "14",
                monthOfBirth = "April",
                yearOfBirth = "1988",
                subject1 = "Arts",
                subject2 = "Maths",
                hobby1 = "Sports",
                hobby2 = "Music",
                current_address = "Baker st. 24, London, Great Britain",
                state = "Rajasthan",
                city = "Jaipur";

        File file = new File("src/test/resources/picture1.jpg");

        registrationFormPage.openPage()
                            .setFirstName(firstName)
                            .setLastName(lastName)
                            .setEmail(email)
                            .setGender(gender);

        $("#userNumber").setValue(mobileNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth).click();
        $("#subjectsInput").setValue(subject1);
        $("#subjectsInput").pressEnter();
        $("#subjectsInput").setValue(subject2);
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue(current_address);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text(firstName + " " + lastName),
                text(email),
                text(current_address),
                text(mobileNumber),
                text(subject1 + ", " + subject2),
                text(state + " " + city),
                text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth),
                text(gender),
                text(hobby1 + ", " + hobby2));
    }
}
