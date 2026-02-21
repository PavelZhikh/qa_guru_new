package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorkTests extends TestBase {

    @Test
    void successfulFillFormTest() {

        open("");
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();

        $("#firstName").setValue("Petr");
        $("#lastName").setValue("Ivanov");

        $("#userEmail").setValue("petrIvanov@mail.ru");

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("0123456789");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("May")).click();
        $(".react-datepicker__year-select").$(byText("1990")).click();
        $(".react-datepicker__day--010:not(.react-datepicker__day--outside-month)").click();


        $("#subjectsInput").setValue("Arts").pressEnter();

        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("barselona-messi.jpg");

        $("#currentAddress").setValue("New current address");

        $("#state").shouldBe(Condition.visible).click();
        $("#state").$(byText("Haryana")).shouldBe(Condition.visible).click();
        $("#city").click();
        $("#city").$(byText("Karnal")).shouldBe(Condition.visible).click();

        $("#submit").click();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Petr Ivanov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("petrIvanov@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("0123456789"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("10 May,1990"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Arts"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("barselona-messi.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("New current address"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Haryana Karnal"));
    }
}