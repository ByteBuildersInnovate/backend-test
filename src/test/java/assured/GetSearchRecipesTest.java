package assured;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetSearchRecipesTest extends AbstractTest {

    @Test
    void SearchRecipesWithoutParamsTest() {
       given()
                .queryParam("apiKey", getApiKey())
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch")
                .then()
               .assertThat()
               .statusCode(200)
               .contentType("application/json")
               .body("totalResults", equalTo(5221));
    }

    @Test
    void SearchRecipesForVegetarianTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("diet", "vegetarian")
                .queryParam("includeIngredients", "tomato","cheese")
                .queryParam("instructionsRequired", true)
                .queryParam("cuisine", "italian")
                .queryParam("maxSaturatedFat", 100)
                .queryParam("maxCalories", 800)
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("results[1].title", equalTo("Roasted Peppers, Spinach & Feta Pizza"));
    }

    @Test
    void SearchRecipesForIDTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("recipeBoxId", 2468)
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("results[0].id", equalTo(1196535));
    }

    @Test
    void SearchRecipesForBreakfastTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "eggs")
                .queryParam("maxReadyTime", 15)
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("results[0].title", equalTo("Scrambled Eggs On Toast With Smoked Salmon"));
    }

    @Test
    void SearchRecipesForLunchTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("type", "main course")
                .queryParam("instructionsRequired", true)
                .queryParam("cuisine", "russia")
                .queryParam("minVitaminD", 20)
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("results[0].id", equalTo(640117));
    }
}
