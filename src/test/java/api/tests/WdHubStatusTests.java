package api.tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;

public class WdHubStatusTests extends TestBase {

    @Test
    public void statusTest() {
        given()
                .log().all()
                .auth().basic("user1", "1234")
                .when()
                .get("/wd/hub/status")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void responseMessageTest() {
        given()
                .log().all()
                .auth().basic("user1", "1234")
                .when()
                .get("/wd/hub/status")
                .then()
                .log().all()
                .body(matchesJsonSchemaInClasspath("schemas/wd_hub_response_schema.json"))
                .body("value.message", is("Selenoid 1.11.3 built at 2024-05-25_12:34:40PM"));
    }

    @Test
    public void responseReadyTest() {
        given()
                .log().all()
                .auth().basic("user1", "1234")
                .when()
                .get("/wd/hub/status")
                .then()
                .log().all()
                .body(matchesJsonSchemaInClasspath("schemas/wd_hub_response_schema.json"))
                .body("value.ready", is(true));
    }

    @Test
    public void responseSchemaTest() {
        given()
                .log().all()
                .auth().basic("user1", "1234")
                .when()
                .get("/wd/hub/status")
                .then()
                .log().all()
                .body(matchesJsonSchemaInClasspath("schemas/wd_hub_response_schema.json"));
    }

    @Test
    public void wrongUriTest() {
        given()
                .log().all()
                .when()
                .get("/wd/hubs")
                .then()
                .log().all()
                .statusCode(404);
    }

    @Test
    public void unauthorizedStatusTest() {
        given()
                .log().all()
                .when()
                .get("/wd/hub/status")
                .then()
                .log().all()
                .statusCode(401);
    }
}



