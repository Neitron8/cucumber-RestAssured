package scenarios;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;


public class UserUndefinedScenarios {

    private String pathUser;
    private Response response;
    private String validRequest = "{\n" +
            "  \"name\": \"morpheus\",\n" +
            "  \"job\": \"leader\",\n";

    @Given("the user endpoint for created user")
    public void getUserUndefined() {
        RestAssured.baseURI = "https://reqres.in/api";
        pathUser = "/users";
    }

    @When("create user")
    public void createUser() {
        response = given()
                .contentType(ContentType.JSON)
                .body(validRequest)
                .post()
                .then().extract().response();
    }

    @And("check response created user")
    public void verifyCreatedUser() {

        JsonPath responseUser = response.jsonPath();
        String responseCreated;
        responseCreated = responseUser.get("name");
        Assertions.assertEquals(responseCreated , "morpheus");

    }
}

