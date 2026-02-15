package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTestes {
    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        // Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com/";
        //Configuration.timeout = 10000;
    }

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

       $("[id=output [id=name]").shouldHave(text("Alex Black"));
       $("[id=output [id=userEmail]").shouldHave(text("alex@black.com"));
       $("[id=output [id=currentAddress]").shouldHave(text("first address 1"));
       $("[id=output [id=permanentAddress]").shouldHave(text("second address 2"));
    }
}
