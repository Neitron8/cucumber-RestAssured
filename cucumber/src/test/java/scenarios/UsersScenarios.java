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

public class UsersScenarios {

    private String path;
    private Response response;


    @Given("the users endpoint exists")
    public void getUsers() {
        RestAssured.baseURI = "https://reqres.in/api";
        path = "/users";
    }

    @When("I send a valid get users")
    public void getResponseUsers() {
        response = given()
                .get(path)
                .then().extract().response();
    }

    @Then("response status code should be {int}")
    public void checkResponseStatusCode(int code) {
        Assertions.assertEquals(code, response.getStatusCode());
    }

    @And("get users response should be validthe user's response must have email, first_name, last_name for each use")
    public void verifyResponse() {

        JsonPath numberOfUsers = response.jsonPath();
        int numberUsers = numberOfUsers.get("data.id[-1]");

        JsonPath responseData = response.jsonPath();
        String responseEmail;
        String responseFirstName;
        String responseLastName;

        for(int i = 0; i < numberUsers; i++ ){
            String firstName = "data.first_name[" + i + "]";
            String lastName = "data.last_name[" + i + "]";
            String email = "data.email[" + i + "]";

            responseFirstName = responseData.get(firstName);
            responseLastName = responseData.get(lastName);
            responseEmail = responseData.get(email);

            Assertions.assertNotEquals(responseFirstName, null);
            Assertions.assertNotEquals(responseLastName, null);
            Assertions.assertNotEquals(responseEmail, null);

            System.out.println("First: " + responseFirstName + " last: " + responseLastName + " Email: " + responseEmail);
        }
    }
}

// step 2

