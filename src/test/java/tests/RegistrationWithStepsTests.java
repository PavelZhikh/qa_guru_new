package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class RegistrationWithStepsTests extends StepsTestBase {
    @Test
    void successfulRegistrationTest() {
        step("Open form", () -> {
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            executeJavaScript(
                    "if(document.getElementById('fixedban')) document.getElementById('fixedban').remove();" +
                            "if(document.getElementById('footer')) document.getElementById('footer').remove();"
            );

//            executeJavaScript("$('#fixedban').remove()");
//            executeJavaScript("$('footer').remove()");
        });
        step("Fill form", () -> {
            $("#firstName").setValue("Peter");
            $("#lastName").setValue("Ivanov");
            $("#userEmail").setValue("peter@ivanov.com");
            $("#genterWrapper").$(byText("Other")).click();
            $("#userNumber").setValue("5554567890");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("July");
            $(".react-datepicker__year-select").selectOption("2000");
            $(".react-datepicker__day--023:not(.react-datepicker__day--outside-month)").click();
            $("#subjectsInput").setValue("Math").pressEnter();
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#uploadPicture").uploadFromClasspath("jenkins_ui_img/1.png");
            $("#currentAddress").setValue("Some address 1");
            $("#state").click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Delhi")).click();
            $("#submit").click();
        });
        step("Verify results", () -> {
            $(".modal-dialog").should(appear);
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(text("Peter"), text("Ivanov"),
                    text("peter@ivanov.com"), text("5554567890"));
        });
    }
}
