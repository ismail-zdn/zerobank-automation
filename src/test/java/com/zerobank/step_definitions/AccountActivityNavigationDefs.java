package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;


public class AccountActivityNavigationDefs {

    @Given("the user logged in")
    public void the_user_logged_in() {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().login();
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String tab) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

        for (WebElement webElement : accountSummaryPage.webElementLinkList) {

                if (webElement.getText().equals(tab)){
                    webElement.click();
                    break;
                }
        }
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        Assert.assertEquals("Account Activity",new AccountActivityPage().getPageTabText());
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String option) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Assert.assertEquals(option,
                accountActivityPage.getSelectDropDown(accountActivityPage.accountDropDown).getFirstSelectedOption().getText());
    }


}
