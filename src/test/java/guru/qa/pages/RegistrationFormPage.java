package guru.qa.pages;

import guru.qa.pages.components.CalenderComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    CalenderComponent calenderComponent = new CalenderComponent();


    File file = new File("src/test/resources/picture1.jpg");

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        $("#firstName").setValue(value);
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        $("#lastName").setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setMobileNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }

    public RegistrationFormPage setDateOfBirth(String month, String year, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day).click();
        return this;
    }

    public RegistrationFormPage setSubjects(String value1, String value2) {
        $("#subjectsInput").setValue(value1);
        $("#subjectsInput").pressEnter();
        $("#subjectsInput").setValue(value2);
        $("#subjectsInput").pressEnter();
        return this;
    }
    public RegistrationFormPage setHobbies(String value3, String value4) {
        $("#hobbiesWrapper").$(byText(value3)).click();
        $("#hobbiesWrapper").$(byText(value4)).click();
        return this;
    }

    public RegistrationFormPage uploadPicture() {
        $("#uploadPicture").uploadFile(file);
        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);
        return this;
    }

    public RegistrationFormPage setStateAndCity(String value5, String value6) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value5)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value6)).click();
        return this;
    }

    public RegistrationFormPage submit() {
        $("#submit").click();
        return this;
    }

}
