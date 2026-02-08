package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.generateRandomEmail;
import static utils.RandomUtils.getRandomString;

public class RegistrationFormWithFakerTests {

    Faker faker = new Faker();
    Faker fakerRu = new Faker(new Locale("ru"));

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.browserSize = "1920x1080";
    }
    @Test
    void successfulTest() {

        String firstName = fakerRu.address().firstName(),
                lastName = fakerRu.address().lastName(),
                email = faker.internet().emailAddress(),
                current_address = fakerRu.address().fullAddress(),
                mobileNumber = faker.phoneNumber().subscriberNumber(10),
                dayOfBirth = "14",
                yearOfBirth = "1988",
                monthOfBirth = "April",
                state = "Rajasthan",
                city = "Jaipur",
                subject1 = "Arts",
                subject2 = "Maths",
                gender = "Female",
                hobby1 = "Sports",
                hobby2 = "Music";

        File file = new File("src/test/resources/picture1.jpg");

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
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
