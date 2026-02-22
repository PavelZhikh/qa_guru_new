package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.StateCityComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    StateCityComponent stateCity = new StateCityComponent();

    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement genderContainer = $("#genterWrapper");
    private SelenideElement phoneNumberInput = $("#userNumber");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private SelenideElement pictureUpload = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement submitClick = $("#submit");



    public RegistrationPage openPage() {
        open("");
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();

        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderContainer.$(byText(value)).click();;

        return this;
    }

    public RegistrationPage typeNumber(String value) {
        phoneNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        pictureUpload.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddressInput(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        $("#state").shouldBe(Condition.visible).click();
        stateCity.setStateCity(state, city);

        return this;
    }

    public RegistrationPage clickSubmit() {
        submitClick.click();;

        return this;
    }
}
