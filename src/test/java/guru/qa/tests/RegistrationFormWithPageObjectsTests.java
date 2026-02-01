package guru.qa.tests;
import org.junit.jupiter.api.Test;
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
                            .uploadPicture(file)
                            .setCurrentAddress(current_address)
                            .setStateAndCity(state, city)
                            .submit()
                            .checkTableTitle(resultTableTitle)
                            .checkResult("Student Name", firstName + " " + lastName)
                            .checkResult("Student Email", email)
                            .checkResult("Gender", gender)
                            .checkResult("Mobile", mobileNumber)
                            .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                            .checkResult("Subjects", subject1 + ", " + subject2)
                            .checkResult("Hobbies", hobby1 + ", " + hobby2)
                            .checkResult("Address", current_address)
                            .checkResult("State and City", state + " " + city);
    }
}