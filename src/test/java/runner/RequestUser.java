package runner;

import factoryRequest.FactoryRequest;
import factoryRequest.RequestInfo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import util.ConfigurationEnv;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class RequestUser {

    Response response;
    RequestInfo info = new RequestInfo();
    Map<String, String> varMap = new HashMap<>();

    @Given("I have access to todo.ly to create a user")
    public void iHaveAcceessToTodoLyToCreateAUser() {
        info.setUrl(ConfigurationEnv.host);

    }

    @When("I send a {string} request to {string} with body")
    public void iSendARequestToWithBody(String method, String endpoint, String body) {
        info.setUrl(ConfigurationEnv.host + endpoint).setBody(body);
        response = FactoryRequest.make(method).send(info);
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int responseStatus) {
        response.then().statusCode(responseStatus);
    }

    @And("the {string} should be save in the {string} variable")
    public void theShouldBeSaveInTheVariable(String idUser, String value) {
        varMap.put(value, response.then().extract().path(idUser) + "");
    }

    @When("I sent a {string} request to {string} with body")
    public void iSentARequestToWithBody(String method, String endpoint, String body) {
        String credential = Base64.getEncoder().encodeToString((ConfigurationEnv.user + ":" + ConfigurationEnv.pwd).getBytes());
        info.setHeaders("Authorization", "Basic " + credential);
        info.setUrl(ConfigurationEnv.host + replaceValueVariable(endpoint)).setBody(body);
        response = FactoryRequest.make(method).send(info);

    }

    @When("I send a {string} request to {string}")
    public void iSendARequestTo(String method, String endpoint) {
        String credential = Base64.getEncoder().encodeToString((ConfigurationEnv.user + ":" + ConfigurationEnv.pwd).getBytes());
        info.setHeaders("Authorization", "Basic " + credential);
        info.setUrl(ConfigurationEnv.host + replaceValueVariable(endpoint));
        response = FactoryRequest.make(method).send(info);
    }

    private String replaceValueVariable(String value){
        for (String key:varMap.keySet()){
            value= value.replace(key,varMap.get(key));
        }
        return value;
    }
}
