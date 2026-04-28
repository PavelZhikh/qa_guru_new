package api.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    public static final String statusPath = "/status";
    public static final String wdHubStatusPath = "/wd/hub/status";

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://selenoid.autotests.cloud";
    }
}
