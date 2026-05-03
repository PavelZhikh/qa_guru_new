package tests;


import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Story("Registration form")
public class RegistrationWithPageObjectTests extends StepsTestBase {

    @Test
    @DisplayName("Successful Registration")
    void successfulRegistrationTest() {

        step("Open registration page", () ->
                registrationPage.openPage());
        step("Fill registration form", () -> {
            registrationPage
                    .setFirstName("Peter")
                    .setLastName("Ivanov")
                    .setEmail("peter@ivanov.com")
                    .setGender("Other")
                    .setUserNumber("5554567890")
                    .setDateOfBirth("23", "July", "2000");
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
        step("Check registration form results data", () -> {
            step("Check registration form results component appears", () -> {
                $(".modal-dialog").should(appear);
                $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            });
            registrationPage.checkResult("Student Name", "Peter Ivanov")
                    .checkResult("Student Email", "peter@ivanov.com");
        });
    }

    @Test
    @DisplayName("Broken Registration")
    void brokenRegistrationTest() {

        step("Open registration page", () ->
                registrationPage.openPage());

        step("Fill registration form", () -> {
            registrationPage
                    .setFirstName("Peter")
                    .setLastName("Ivanov")
                    .setGender("Other")
                    .setUserNumber("5554567890");
            $("#submit").click();
        });

        step("Check registration form results data", () -> {
            step("Check registration form results component appears", () -> {
                $(".modal-dialog").should(appear);
                $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            });

            registrationPage.checkResult("Student Name", "Peter Ivanov")
                    .checkResult("Student Email", "peter@ivanov.com");
        });
    }
}
