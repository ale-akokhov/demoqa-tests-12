package guru.qa.tests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormWithPageObjectsTests extends TestBase {

    @Test
    void successfulTest() {

        registrationFormPage.openPage()
                            .setFirstName(firstName)
                            .setLastName(lastName)
                            .setEmail(email)
                            .setGender(gender)
                            .setMobileNumber(mobileNumber)
                            .setDateOfBirth(monthOfBirth, yearOfBirth, dayOfBirth)
                            .setSubjects(subject1, subject2)
                            .setHobbies(hobby1, hobby2)
                            .uploadPicture()
                            .setCurrentAddress(current_address)
                            .setStateAndCity(state, city)
                            .submit();

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
