package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StepsRegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput");

    CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Open registration page /automation-practice-form")
    public StepsRegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript(
                "if(document.getElementById('fixedban')) document.getElementById('fixedban').remove();" +
                        "if(document.getElementById('footer')) document.getElementById('footer').remove();"
        );

        return this;
    }

    @Step("Type first name \"{value}\"")
    public StepsRegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Type last name \"{value}\"")
    public StepsRegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public StepsRegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public StepsRegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public StepsRegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public StepsRegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Check that field \"{key}\" has result \"{value}\"")
    public StepsRegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
}
