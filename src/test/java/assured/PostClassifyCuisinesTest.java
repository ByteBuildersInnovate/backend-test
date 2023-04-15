package assured;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class PostClassifyCuisinesTest extends AbstractTest{

    @Test
    void MisoSoupTest() {

        given()
                .queryParam("apiKey", getApiKey())
                .formParam("title", "Miso soup")
                .when()
                .post(getBaseUrl() + "/recipes/cuisine")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .contentType(ContentType.JSON)
                .body("cuisine", equalTo("Japanese"));
    }

    @Test
    void CheeseburgerTest() {

        given()
                .queryParam("apiKey", getApiKey())
                .formParam("title", "Cheeseburger")
                .when()
                .post(getBaseUrl() + "/recipes/cuisine")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .contentType(ContentType.JSON)
                .body("cuisine", equalTo("American"));
    }

    @Test
    void FishAndChipsTest() {

        given()
                .queryParam("apiKey", getApiKey())
                .formParam("title", "Fish and chips")
                .when()
                .post(getBaseUrl() + "/recipes/cuisine")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .contentType(ContentType.JSON)
                .body("cuisine", equalTo("British"));
    }

    @Test
    void HotDogTest() {

        given()
                .queryParam("apiKey", getApiKey())
                .formParam("title", "Hot Dog")
                .when()
                .post(getBaseUrl() + "/recipes/cuisine")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .contentType(ContentType.JSON)
                .body("cuisine", equalTo("American"))
                .body("confidence", equalTo(0.85F));
    }

    @Test
    void NachosTest() {

        given()
                .queryParam("apiKey", getApiKey())
                .formParam("title", "Nachos")
                .when()
                .post(getBaseUrl() + "/recipes/cuisine")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .contentType(ContentType.JSON)
                .body("cuisine", equalTo("Mexican"))
                .body("confidence", equalTo(0.85F));
    }
}
