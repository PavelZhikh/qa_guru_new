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

        Configuration.baseUrl = baseUrlAddress;
        Configuration.browser = browserUsing;
        Configuration.headless = headlessFlag;
        Configuration.browserSize = browserScreen;

        Configuration.timeout = 10000;
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }
}
