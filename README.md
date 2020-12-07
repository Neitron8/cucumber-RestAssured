# cucumber-RestAssured
test java cucumber-RestAssured, Gradle

Jdk - last version

It is necessary to make sure of the import before starting:

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

for all test files .java

in the roots of the project folder, execute the "gradle cucumber" command to run.
