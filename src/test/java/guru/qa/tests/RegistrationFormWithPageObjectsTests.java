package guru.qa.tests;
import org.junit.jupiter.api.Test;

import static guru.qa.tests.TestData.*;

public class RegistrationFormWithPageObjectsTests extends TestBase {
    @Test
    void successfulTest() {
        registrationFormPage.openPage()
                            .setFirstName(FIRST_NAME)
                            .setLastName(LAST_NAME)
                            .setEmail(E_MAIL)
                            .setGender(GENDER)
                            .setMobileNumber(MOBILE_NUMBER)
                            .setDateOfBirth(MONTH_OF_BIRTH, YEAR_OF_BIRTH, DAY_OF_BIRTH)
                            .setSubjects(SUBJECT_1, SUBJECT_2)
                            .setHobbies(HOBBY_1, HOBBY_2)
                            .uploadPicture(FILE)
                            .setCurrentAddress(CURRENT_ADDRESS)
                            .setStateAndCity(STATE, CITY)
                            .submit()
                            .checkTableTitle(RESULT_TABLE_TITLE)
                            .checkResult("Student Name", FIRST_NAME + " " + LAST_NAME)
                            .checkResult("Student Email", E_MAIL)
                            .checkResult("Gender", GENDER)
                            .checkResult("Mobile", MOBILE_NUMBER)
                            .checkResult("Date of Birth", DAY_OF_BIRTH + " " + MONTH_OF_BIRTH + "," + YEAR_OF_BIRTH)
                            .checkResult("Subjects", SUBJECT_1 + ", " + SUBJECT_2)
                            .checkResult("Hobbies", HOBBY_1 + ", " + HOBBY_2)
                            .checkResult("Address", CURRENT_ADDRESS)
                            .checkResult("State and City", STATE + " " + CITY);
    }
}