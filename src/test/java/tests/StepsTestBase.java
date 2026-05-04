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

        String loginSelenoid =  System.getProperty("loginSelenoid");
        String passwordSelenoid =  System.getProperty("passwordSelenoid");
        String urlSelenoid = System.getProperty("urlSelenoid");

        System.out.println("Test baseUrl is: " + baseUrlAddress);
        System.out.println("Test browser is: " + browserUsing);
        System.out.println("Test headless is: " + headlessFlag);
        System.out.println("Test browserSize is: " + browserScreen);
        System.out.println("Test loginSelenoid is: " + loginSelenoid);
        System.out.println("Test passwordSelenoid is: " + passwordSelenoid);
        System.out.println("Test urlSelenoid is: " + urlSelenoid);



        Configuration.baseUrl = baseUrlAddress;
        Configuration.browser = browserUsing;
        Configuration.headless = headlessFlag;
        Configuration.browserSize = browserScreen;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "https://" + loginSelenoid + ":" + passwordSelenoid + "@" + urlSelenoid;

//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
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
