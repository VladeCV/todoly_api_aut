package runner;

import factoryRequest.RequestInfo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import util.ConfigurationEnv;

import java.util.HashMap;
import java.util.Map;

public class MyStepdefs {
    Response response;
    RequestInfo requestInfo = new RequestInfo();
    Map<String, String> data = new HashMap<>();


}
