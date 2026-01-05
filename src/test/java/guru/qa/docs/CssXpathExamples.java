package guru.qa.docs;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void CssXpathExamples() {

        $("[data-testId=email]").setValue("123");
        $(by("data-testId", "email")).setValue("123");

        $("[id=email]").setValue("123");
        $("#email").setValue("123");
        $(byId("email")).setValue("123");
        $(By.id("email")).setValue("123");
        $x("//*[@id='email']").setValue("123");
        $(byXpath("//*[@id='email']")).setValue("123");

        $("[name=email]").setValue("123");
        $(byName("email")).setValue("123");

        $("[class=login_from_input_box]").setValue("123");
        $(".login_from_input_box").setValue("123");
        $(".inputtext.login_from_input_box").setValue("123");
        $("input.inputtext.login_from_input_box").setValue("123");
        $x("//input[@class='login_from_input_box']").setValue("123");
        $x("//input[@class='inputtext'][@class='login_from_input_box']").setValue("123");

        $("input.inputtext.login_from_input_box#email[name=email][data-testId=email]").setValue("123");

        $x("//div[text()='Hello qa.guru']");
        $x("//div[contains(text(), 'ello qa.gur')]");
        $x("//div[text()[contains(., 'ello qa.gur')]]");
        $(byText("Hello qa.guru"));
        $(withText("ello qa.gur"));
    }
}
