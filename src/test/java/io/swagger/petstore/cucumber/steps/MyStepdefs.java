package io.swagger.petstore.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import io.swagger.petstore.usernpetinfo.UserSteps;
import io.swagger.petstore.utils.TestUtils;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class MyStepdefs {


    static String userName = null;

    @Steps
    UserSteps userSteps;
    static ValidatableResponse response;


    @Given("^I am on the Pet store swagger page$")
    public void iAmOnThePetStoreSwaggerPage() {
    }

    @When("^I create a new user by providing the information id \"([^\"]*)\" username \"([^\"]*)\" firstname \"([^\"]*)\" lastname \"([^\"]*)\" email \"([^\"]*)\" password \"([^\"]*)\" phone \"([^\"]*)\" userstatus \"([^\"]*)\"$")
    public void iCreateANewUserByProvidingTheInformationIdUsernameFirstnameLastnameEmailPasswordPhoneUserstatus(int id, String userName1, String firstname, String lastname, String email, String password, String phone, int userstatus) {
        userName = userName1 + TestUtils.getRandomValue();
        response = userSteps.createUser(id,userName,firstname,lastname,email,password,phone,userstatus);
    }

    @Then("^I verify the user with username \"([^\"]*)\" is created$")
    public void iVerifyTheUserWithUsernameIsCreated(String userName1) {
        response.statusCode(200);
        HashMap<String, Object> userMap = userSteps.findUserByUserName(userName);
        Assert.assertThat(userMap, hasValue(userName));
    }

    @And("^I update the user with information id \"([^\"]*)\" username \"([^\"]*)\" firstname \"([^\"]*)\" lastname \"([^\"]*)\" email \"([^\"]*)\" password \"([^\"]*)\" phone \"([^\"]*)\" userstatus \"([^\"]*)\"$")
    public void iUpdateTheUserWithInformationIdUsernameFirstnameLastnameEmailPasswordPhoneUserstatus(int id, String userName1, String firstname, String lastname, String email, String password, String phone, int userstatus) {
        userName = userName1 + "_updated";
        response = userSteps.updateUser(id,userName,firstname,lastname,email,password,phone,userstatus);

    }

    @And("^I verify that the user with the username \"([^\"]*)\" has been updated successfully$")
    public void iVerifyThatTheUserWithTheUsernameHasBeenUpdatedSuccessfully(String userName1) {
        HashMap<String, Object>userMap = userSteps.findUserByUserName(userName);
        Assert.assertThat(userMap, hasValue(userName));
    }

    @And("^I delete the user created with username \"([^\"]*)\"$")
    public void iDeleteTheUserCreatedWithUsername(String userName1) {
        response = userSteps.deleteUserByUsername(userName);

    }

    @Then("^I verify that the user with username \"([^\"]*)\"is deleted successfully from the database$")
    public void iVerifyThatTheUserWithUsernameIsDeletedSuccessfullyFromTheDatabase(String userName1) {
        response.statusCode(200);
        userSteps.getUserByName(userName).statusCode(404);
    }

     @When("^I send a POST request to user endpoint with the information id \"([^\"]*)\" username \"([^\"]*)\" firstname \"([^\"]*)\" lastname \"([^\"]*)\" email \"([^\"]*)\" password \"([^\"]*)\" phone \"([^\"]*)\" userstatus \"([^\"]*)\"$")
    public void iSendAPOSTRequestToUserEndpointWithTheInformationIdUsernameFirstnameLastnameEmailPasswordPhoneUserstatus(int id, String userName, String firstname, String lastname, String email, String password, String phone, int userstatus){
        response = userSteps.createUser(id,userName,firstname,lastname,email,password,phone,userstatus);
    }

    @Then("^I must get back a valid status code \"([^\"]*)\"$")
    public void iMustGetBackAValidStatusCode(int code){
        response.statusCode(code);

    }

    @When("^I send a GET request to username \"([^\"]*)\" endpoint$")
    public void iSendAGETRequestToUsernameEndpoint(String userName2) {
        response = userSteps.getUserByName(userName2);
    }

    @When("^I send a PUT request to username endpoint with updated information id \"([^\"]*)\" username \"([^\"]*)\" firstname \"([^\"]*)\" lastname \"([^\"]*)\" email \"([^\"]*)\" password \"([^\"]*)\" phone \"([^\"]*)\" userstatus \"([^\"]*)\"$")
    public void iSendAPUTRequestToUsernameEndpointWithUpdatedInformationIdUsernameFirstnameLastnameEmailPasswordPhoneUserstatus(int id, String userName2, String firstname, String lastname, String email, String password, String phone, int userstatus){
        response = userSteps.updateUser(id,userName,firstname,lastname,email,password,phone,userstatus);
    }


    @When("^I send a DELETE request to username \"([^\"]*)\" endpoint$")
    public void iSendADELETERequestToUsernameEndpoint(String userName2) {
    response = userSteps.deleteUserByUsername(userName2);
    }
}
