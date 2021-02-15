package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;


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
        Assert.assertEquals("Zero - Account Activity",Driver.get().getTitle());
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String option) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Assert.assertEquals(option,
                accountActivityPage.getSelectDropDown(accountActivityPage.accountDropDown).getFirstSelectedOption().getText());
    }

    @When("the user clicks on {string} tab")
    public void the_user_clicks_on_tab(String tab) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.accessTab(accountActivityPage.webElementTabList,tab);
    }

    @When("Account drop down should have the following options:")
    public void account_drop_down_should_have_the_following_options(List<String> expectedDropDownOptions) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> actualDropDownOptions =
                BrowserUtils.getElementsText(accountActivityPage.getSelectDropDown(accountActivityPage.accountDropDown).getOptions());
        Assert.assertEquals(expectedDropDownOptions,actualDropDownOptions);
    }

    @Then("Transactions table should have column names:")
    public void transactions_table_should_have_column_names(List<String> expectedTransactionsColumns) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> actualTransActionsColumns =
                BrowserUtils.getElementsText(accountActivityPage.transactionsColumnList);
        Assert.assertEquals(expectedTransactionsColumns,actualTransActionsColumns);
    }
}
