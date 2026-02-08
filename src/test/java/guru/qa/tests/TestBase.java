package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;

public class TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        //Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

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
            city = "Jaipur",
            resultTableTitle = "Thanks for submitting the form";

    File file = new File("src/test/resources/picture1.jpg");

}
