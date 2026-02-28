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
import static guru.qa.tests.TestData.*;
import static utils.RandomUtils.generateRandomEmail;
import static utils.RandomUtils.getRandomString;

public class RegistrationFormWithFakerTests {

    Faker faker = new Faker();
    Faker fakerRu = new Faker(new Locale("ru"));

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void successfulTest() {

        String firstName = fakerRu.address().firstName(),
                lastName = fakerRu.address().lastName(),
                email = faker.internet().emailAddress(),
                current_address = fakerRu.address().fullAddress(),
                mobileNumber = faker.phoneNumber().subscriberNumber(10),
                dayOfBirth = DAY_OF_BIRTH,
                yearOfBirth = YEAR_OF_BIRTH,
                monthOfBirth = MONTH_OF_BIRTH,
                state = "Rajasthan",
                city = "Jaipur",
                subject1 = "Arts",
                subject2 = "Maths",
                gender = GENDER,
                hobby1 = "Sports",
                hobby2 = "Music";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        //executeJavaScript("document.querySelector('footer').remove()");
        //executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(FIRST_NAME);
        $("#lastName").setValue(LAST_NAME);
        $("#userEmail").setValue(E_MAIL);
        $("#genterWrapper").$(byText(GENDER)).click();
        $("#userNumber").setValue(MOBILE_NUMBER);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(MONTH_OF_BIRTH);
        $(".react-datepicker__year-select").selectOption(YEAR_OF_BIRTH);
        $(".react-datepicker__day--0" + DAY_OF_BIRTH).click();
        $("#subjectsInput").setValue(SUBJECT_1);
        $("#subjectsInput").pressEnter();
        $("#subjectsInput").setValue(SUBJECT_2);
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText(HOBBY_1)).click();
        $("#hobbiesWrapper").$(byText(HOBBY_2)).click();
        $("#uploadPicture").uploadFile(FILE);
        $("#currentAddress").setValue(CURRENT_ADDRESS);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(STATE)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(CITY)).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text(RESULT_TABLE_TITLE));

        $(".table-responsive").shouldHave(text(FIRST_NAME + " " + LAST_NAME),
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
