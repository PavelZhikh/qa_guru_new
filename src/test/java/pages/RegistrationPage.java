package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckRegistrationPage;
import pages.components.StateCityComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    StateCityComponent stateCity = new StateCityComponent();
    CheckRegistrationPage asserting = new CheckRegistrationPage();

    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderContainer = $("#genterWrapper");
    private final SelenideElement phoneNumberInput = $("#userNumber");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper = $("#hobbiesWrapper");
    private final SelenideElement pictureUpload = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement submitClick = $("#submit");



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
        genderContainer.$(byText(value)).click();

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

    public RegistrationPage submitPage() {
        submitClick.click();

        return this;
    }

    public RegistrationPage checkPage(String value) {
        asserting.checkModalHead(value);

        return this;
    }

    public RegistrationPage checkPage(String key, String value) {
        asserting.checkFields(key, value);

        return this;
    }
}
