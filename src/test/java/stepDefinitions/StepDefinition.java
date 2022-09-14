package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import resources.Utilities;

import java.io.IOException;

public class StepDefinition extends Utilities {
    RequestSpecification httpRequest;
    Response response;
    String responseBody;
    String statusCode;


    @Given("^UnixTimestamp Conversion API$")
    public void unixtimestamp_conversion_api() throws IOException {
        RestAssured.baseURI = getGlobalValue("baseUrl");


    }

    @When("^user enters the UnixTimeStamp as \"([^\"]*)\"$")
    public void user_enters_the_unixtimestamp_as_something(String strArg1) {
        httpRequest = RestAssured.given().queryParam("unixtimestamp", strArg1);

    }

    @Then("^the API Convert it into user readable format as \"([\\w\\s\"{}:-]*)\"$")
    public void the_api_convert_it_into_user_readable_format_as_something(String strArg1) {
         response = httpRequest.request(Method.GET, "/UnixTime/fromunixtimestamp");

         responseBody = response.getBody().asString();
        System.out.println("Response Body is " + responseBody);
        statusCode = Integer.toString(response.getStatusCode());
        Assert.assertEquals(strArg1, responseBody);
    }


    @And("^resoponse code is \"([^\"]*)\"$")
    public void resoponse_code_is_something(String strArg1) {
        System.out.println("Status Code is " + statusCode);

        Assert.assertEquals(statusCode, strArg1);

    }

    @When("^user enters the UnixTimeStamp in wrong format like \"([^\"]*)\"$")
    public void user_enters_the_unixtimestamp_in_wrong_format_like_something(String strArg1) {
        httpRequest = RestAssured.given().queryParam("unixtimestamp", strArg1);
        response = httpRequest.request(Method.GET, "/UnixTime/fromunixtimestamp");

        responseBody = response.getBody().asString();

    }




    @Then("^the API response throws error message saying \"([\\w\\s\"{.}:-]*)\"$")
    public void the_api_response_throws_error_message_saying_something(String strArg1) {
        System.out.println("Response Body is " + responseBody);
        Assert.assertTrue(responseBody.contains(strArg1));
        statusCode = Integer.toString(response.getStatusCode());
        Assert.assertEquals(strArg1, responseBody);

    }
}

