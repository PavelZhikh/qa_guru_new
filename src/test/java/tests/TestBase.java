package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void openForm() {
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

//        Configuration.baseUrl = "https://demoqa.com/";
//        Configuration.browser = "chrome";
//        Configuration.headless = false;
//        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }
}
