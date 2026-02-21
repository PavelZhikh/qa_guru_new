package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;


public class TestBase {

    @Test
    void openForm() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        // Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.timeout = 10000;

    }
}
