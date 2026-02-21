package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class HomeWorkTests extends TestBase {

    @Test
    void successfulFillFormTest() {

        open("");
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(secondName);

        $("#userEmail").setValue(email);

        $("#genterWrapper").$(byText(gender)).click();

        $("#userNumber").setValue(phoneNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText(birthMonth)).click();
        $(".react-datepicker__year-select").$(byText(birthYear)).click();
        $(".react-datepicker__day--010:not(.react-datepicker__day--outside-month)").click();


        $("#subjectsInput").setValue(subject).pressEnter();

        $("#hobbiesWrapper").$(byText(hobby)).click();

        $("#uploadPicture").uploadFromClasspath(file);

        $("#currentAddress").setValue(address);

        $("#state").shouldBe(Condition.visible).click();
        $("#state").$(byText(state)).shouldBe(Condition.visible).click();
        $("#city").click();
        $("#city").$(byText(city)).shouldBe(Condition.visible).click();

        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").$(byText("Student Name")).parent().shouldBe(text(firstName + " " + secondName));
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