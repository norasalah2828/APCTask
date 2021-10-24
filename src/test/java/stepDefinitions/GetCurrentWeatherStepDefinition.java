package stepDefinitions;

import data.Specifications;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@RunWith(Cucumber.class)
public class GetCurrentWeatherStepDefinition {

    RequestSpecification res;
    Response response;
    JsonPath postJS;

    @Given("user choose CurrentWeatherAPI with {string} and {string}")
    public void userChooseCurrentWeatherAPIWithValidAccessKeyAndValidCountry(String accessKey,String country) {
        res=given().log().all().
                spec(Specifications.requestSpecification(accessKey,country));
    }

    @When("user calls GetCurrentWeatherAPI with Get http request")
    public void userCallsGetCurrentWeatherAPIWithGetHttpRequest() {
        response = res.when().log().all().get();
    }


    @And("{string} {string} {string} and {string} will be displayed in response body")
    public void name_type_region_and_timezone_id_will_be_displayed_in_the_response_body(String name, String type, String region,String timezone_id) {
        postJS=new JsonPath(response.asString());
        assertEquals(name,postJS.getJsonObject("location.name"));
        assertEquals(type,postJS.getString("request.type"));
        assertEquals(region,postJS.getString("location.region"));
        assertEquals(timezone_id,postJS.getString("location.timezone_id"));
    }

    @And("API response body contains invalid country error details")
    public void apiResponseBodyContainsInvalidCountryErrorDetails() {
        response.then()
                .log()
                .all()
                .assertThat()
                .body(Matchers.equalTo("{\"success\":false,\"error\"" +
                        ":{\"code\":615,\"type\":\"request_failed\",\"info\":" +
                        "\"Your API request failed. Please try again or contact support.\"}}"));
    }

    @And("API response body contains {string} invalid key error details")
    public void apiResponseBodyContainsErrorDetails(String InvalidAccessKeyError) {
        postJS=new JsonPath(response.asString());
        assertEquals(InvalidAccessKeyError,postJS.getJsonObject("error.type"));
    }

    @And("API response body contains {string} missing key error details")
    public void apiResponseBodyContainsMissingAccessKeyErrorDetails(String missingAccessKeyError) {
        postJS=new JsonPath(response.asString());
        assertEquals(missingAccessKeyError,postJS.getJsonObject("error.type"));
    }

    @And("API response body contains {string} missing query error details")
    public void apiResponseBodyContainsMissingQueryErrorDetails(String missingQueryError) {
        postJS=new JsonPath(response.asString());
        assertEquals(missingQueryError,postJS.getJsonObject("error.type"));
    }

    @Then("API call will with have status code {int}")
    public void apiCallWillWithHaveStatusCodeStatus(int status) {
        assertEquals(status,response.getStatusCode());
    }
}
