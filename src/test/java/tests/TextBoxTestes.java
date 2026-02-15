package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;


public class TextBoxTestes extends TestBase {

    @Test
    void checkPracticeFormTest() {
        open("");
        $$(".card-body").findBy(text("Elements")).click();
        $$(".router-link").findBy(text("Text box")).click();
    }

    @Test
    void successfulFillFormTest() {
       //open("https://demoqa.com");
       $("[id=userName]").setValue("Alex Black");
       $("[id=userEmail]").setValue("alex@black.com");
       $("[id=currentAddress]").setValue("first address 1");
       $("[id=permanentAddress]").setValue("second address 2");
       $("[id=submit]").click();

       $("[id=output] [id=name]").shouldHave(text("Alex Black"));
       $("[id=output] [id=email]").shouldHave(text("alex@black.com"));
       $("[id=output] [id=currentAddress]").shouldHave(text("first address 1"));
       $("[id=output] [id=permanentAddress]").shouldHave(text("second address 2"));
    }
}
