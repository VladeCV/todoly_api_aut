package runner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RequestUser {
    @Given("I want to create a new user")
    public void iWantToCreateANewUser() {
    }

    @When("I send a {string} request to {string} with body")
    public void iSendARequestToWithBody(String arg0, String arg1) {
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int arg0) {
    }

    @And("the {string} should be save in the {string} variable")
    public void theShouldBeSaveInTheVariable(String arg0, String arg1) {
    }

    @When("I sent a {string} request to {string} with body")
    public void iSentARequestToWithBody(String arg0, String arg1) {
    }

    @And("the {string} should be {string}")
    public void theShouldBe(String arg0, String arg1) {
    }

    @When("I send a {string} request to {string}")
    public void iSendARequestTo(String arg0, String arg1) {
    }
}
