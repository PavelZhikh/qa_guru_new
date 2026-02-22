package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class HomeWorkTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulFillFormTest() {

        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .setGender(gender)
                .typeNumber(phoneNumber)
                .setDateOfBirth(day, birthMonth, birthYear)
                .setSubjectsInput(subject)
                .setHobby(hobby)
                .uploadPicture(file)
                .setCurrentAddressInput(address)
                .setStateAndCity(state, city)
                .clickSubmit();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").$(byText("Student Name")).parent().shouldBe(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldBe(text(email));
        $(".table-responsive").$(byText("Gender")).parent().shouldBe(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldBe(text(phoneNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldBe(text("10 May,1990"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldBe(text(subject));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldBe(text(hobby));
        $(".table-responsive").$(byText("Picture")).parent().shouldBe(text(file));
        $(".table-responsive").$(byText("Address")).parent().shouldBe(text(address));
        $(".table-responsive").$(byText("State and City")).parent().shouldBe(text(state + " " + city));
    }
}