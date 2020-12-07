package scenarios;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class UserSevenScenarios {

    private String path;
    private Response response;

    @Given("the user seven endpoint exists")
    public void getUserSeven() {
        RestAssured.baseURI = "https://reqres.in/api";
        path = "/users/?id=7";
    }

    @When("I send a valid get user")
    public void createUser() {
        response = given()
                .get(path)
                .then().extract().response();
    }

    @Then("response user status code should be {int}")
    public void checkResponseStatusCode(int code) {
        Assertions.assertEquals(code, response.getStatusCode());
    }

    @And("get user seven response")
    public void verifyResponseUserSeven() {

        JsonPath responseUser = response.jsonPath();
        int responseId;
        String responseEmail;
        String responseFirstName;
        String responseLastName;

        responseId = responseUser.get("data.id");
        responseEmail = responseUser.get("data.email");
        responseFirstName = responseUser.get("data.first_name");
        responseLastName = responseUser.get("data.last_name");

        Assertions.assertEquals(responseId, 7);
        Assertions.assertEquals(responseEmail, "michael.lawson@reqres.in");
        Assertions.assertEquals(responseFirstName, "Michael");
        Assertions.assertEquals(responseLastName, "Lawson");

        System.out.println("id: "+ responseId + "First: " + responseFirstName + " last: " + responseLastName + " Email: " + responseEmail);

    }
}

