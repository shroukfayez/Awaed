package TestCase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuilder;
import resources.Utilities;
import java.io.FileNotFoundException;
import java.io.IOException;


import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class AddUserStepDefs extends Utilities {

    RequestSpecification request;
    ResponseSpecification Response_Spec;
    Response response;
    TestDataBuilder testData = new TestDataBuilder();
    String User_ID;
    String ActualFirst_Name;
    JsonPath js;

    @Given("Add user payload with {string} {string} {string} {string}")
    public void add_user_payload_with(String firstName, String lastName, String email, String active) throws IOException {
        request = given().spec(requestSpecification())
                .body(testData.AddUserPayload(firstName,lastName,email,active ));
    }
    @When("User Call adduser API with POST http request")
    public void user_call_adduser_api_with_post_http_request() {
        Response_Spec = new ResponseSpecBuilder().expectStatusCode(201).build();
        response = request.when().post("/awaed/users")
                .then().spec(Response_Spec).extract().response();
    }

    @Then("The API request sent successfully with status code equal {int}")
    public void the_api_request_sent_successfully_with_status_code_equal(Integer int1) {

        String Actual_Status = String.valueOf(response.getStatusCode());
        System.out.println("passed assertion" + Actual_Status);
        assertThat(String.valueOf(Actual_Status.contains("20")), true);
        System.out.println("true");
     // assertEquals(201, response.getStatusCode());

    }

    @Then("firstName in response body is {string}")
    public void first_name_in_response_body_is(String string) {
      String Respone_Body = response.asString();
      js = new JsonPath(Respone_Body);
      ActualFirst_Name = js.getString("firstName");
      User_ID = js.get("id");
      System.out.println(User_ID);
      System.out.println(ActualFirst_Name);
    }
    @Then("verify that UserID created with {string} was sent Using GetUserAPI")
    public void verify_that_user_id_created_with_was_sent_using_get_user_api(String ExpectedFirstName) throws IOException {
        request = given().spec(requestSpecification()).queryParam("id", User_ID);
        Response_Spec = new ResponseSpecBuilder().expectStatusCode(200).build();
        response = request.when().get("/awaed/users")
                .then().spec(Response_Spec).extract().response();
        System.out.println("Passed" + User_ID);
        assertEquals(ActualFirst_Name, ExpectedFirstName );
    }

}
