package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

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

    @When("the user enters {string} {string} username and {string} {string} password")
    public void the_user_enters_username_and_password(String userNameType, String username, String passWordType, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.userNameInputBox.sendKeys(username);
        loginPage.passwordInputBox.sendKeys(password);
        loginPage.LoginPageSignInButton.click();

    }

    @Then("Account summary page should be displayed")
    public void account_summary_page_should_be_displayed() {
        Assert.assertEquals("Zero - Account Summary",Driver.get().getTitle());
    }

    @Then("The error message {string} should be displayed.")
    public void the_error_message_should_be_displayed(String errorMessage) {
        LoginPage loginPage = new LoginPage();
        Assert.assertEquals(errorMessage,loginPage.alertError.getText());
    }

}
