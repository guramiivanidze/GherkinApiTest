package com.example.steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserSteps {

    private String baseUrl = "https://reqres.in/api";
    private String apiKey = "reqres-free-v1";
    private Response response;
    private String endpoint;

    @Given("I set POST endpoint for user")
    public void i_set_post_endpoint_for_user() {
        endpoint = baseUrl + "/users";
    }

    @When("I send POST request with name {string} and job {string}")
    public void i_send_post_request(String name, String job) {
        response = given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .body("{\"name\":\"" + name + "\", \"job\":\"" + job + "\"}")
                .when()
                .post(endpoint);
    }

    @Then("I receive valid status code {int}")
    public void i_receive_status_code(int code) {
        response.then().statusCode(code);
    }

    @Then("Response should contain name {string} and job {string}")
    public void response_should_contain_name_and_job(String name, String job) {
        response.then()
                .body("name", equalTo(name))
                .body("job", equalTo(job));
    }

    @Given("I set GET endpoint for users")
    public void i_set_get_endpoint_for_users() {
        endpoint = baseUrl + "/users?page=2";
    }

    @When("I send GET request")
    public void i_send_get_request() {
        response = given().when().get(endpoint);
    }

    @Then("Response should contain {string}")
    public void response_should_contain(String key) {
        response.then().body("$", hasKey(key));
    }

    @Given("I set PUT endpoint for user with id {int}")
    public void i_set_put_endpoint_for_user_with_id(Integer id) {
        endpoint = baseUrl + "/users/" + id;
    }

    @When("I send PUT request with name {string} and job {string}")
    public void i_send_put_request(String name, String job) {
        response = given()
                .header("Content-Type", "application/json")
                .header("x-api-key", apiKey)
                .body("{\"name\":\"" + name + "\", \"job\":\"" + job + "\"}")
                .when()
                .put(endpoint);
    }

    @Then("Response should contain updated name {string} and job {string}")
    public void response_should_contain_updated_data(String name, String job) {
        response.then()
                .body("name", equalTo(name))
                .body("job", equalTo(job));
    }

    @Given("I set DELETE endpoint for user with id {int}")
    public void i_set_delete_endpoint_for_user_with_id(Integer id) {
        endpoint = baseUrl + "/users/" + id;
    }

    @When("I send DELETE request")
    public void i_send_delete_request() {
        response = given()
                .header("x-api-key", apiKey)
                .when()
                .delete(endpoint);
    }
}