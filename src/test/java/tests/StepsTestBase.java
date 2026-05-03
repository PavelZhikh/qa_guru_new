package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.StepsRegistrationPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class StepsTestBase {

    StepsRegistrationPage registrationPage = new StepsRegistrationPage();

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeAll
    static void beforeAll() {
        String baseUrlAddress = System.getProperty("baseUrlAddress");
        String browserUsing = System.getProperty("browserUsing", "chrome");
        Boolean headlessFlag = Boolean.parseBoolean(System.getProperty("headlessFlag", "false"));
        String browserScreen = System.getProperty("browserScreen");

        System.out.println("Test baseUrl is: " + baseUrlAddress);
        System.out.println("Test browser is: " + browserUsing);
        System.out.println("Test headless is: " + headlessFlag);
        System.out.println("Test browserSize is: " + browserScreen);

        Configuration.baseUrl = baseUrlAddress;
        Configuration.browser = browserUsing;
        Configuration.headless = headlessFlag;
        Configuration.browserSize = browserScreen;

//        String baseUrlAddress = System.getProperty("");
//        System.out.println("Test baseUrl is: " + baseUrlAddress);

//        Configuration.baseUrl = baseUrlAddress;
//        Configuration.browser = "chrome";
//        Configuration.headless = false;
//        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browserSize = "1920x1080";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
//        Attach.attachAsText("Some file", "Some content");
        closeWebDriver();
    }
}
