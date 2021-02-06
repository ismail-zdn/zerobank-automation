package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        new LoginPage().login();
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        Assert.assertEquals("Zero - Account Summary",new LoginPage().getPageTitle());
    }

}
