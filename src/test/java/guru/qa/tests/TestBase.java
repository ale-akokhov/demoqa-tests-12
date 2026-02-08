package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;

public class TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.browserSize = "1920x1080";
    }


}
