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
import org.openqa.selenium.support.ui.Select;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public class FindTransactionsDefs {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().login();
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.accessTab(accountSummaryPage.webElementTabList,"Account Activity");
        new AccountActivityPage().findTransactionsTab.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String date1, String date2) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.fromDateInputBox.clear();
        accountActivityPage.toDateInputBox.clear();
        accountActivityPage.fromDateInputBox.sendKeys(date1);
        accountActivityPage.toDateInputBox.sendKeys(date2);
    }

    @When("clicks Find")
    public void clicks_Find() {
        new AccountActivityPage().findButton.click();
        BrowserUtils.waitFor(1);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String dateString1, String dateString2) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Date date1 = accountActivityPage.parseStringToDate(dateString1);
        Date date2 = accountActivityPage.parseStringToDate(dateString2);
        List<Date> dateList = accountActivityPage.getDateListOfElements(accountActivityPage.rowsElementsOfDateColumn);
        for (Date date : dateList) {
            Assert.assertTrue(!date1.after(date) && !date2.before(date));
        }

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<Date> dateList = accountActivityPage.getDateListOfElements(accountActivityPage.rowsElementsOfDateColumn);
        List<Date> sortedList = accountActivityPage.getDateListOfElements(accountActivityPage.rowsElementsOfDateColumn);
        Collections.sort(sortedList);
        Collections.reverse(sortedList);
        Assert.assertEquals(sortedList,dateList);
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> dateListAsString = BrowserUtils.getElementsText(accountActivityPage.rowsElementsOfDateColumn);
        Assert.assertFalse(dateListAsString.contains(date));
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.descriptionInputBox.clear();
        accountActivityPage.descriptionInputBox.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> descriptionRows = BrowserUtils.getElementsText(accountActivityPage.rowsElementsOfDescriptionColumn);
        for (String descriptionRow : descriptionRows) {
            Assert.assertTrue(descriptionRow.contains(description));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String description) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> descriptionRows = BrowserUtils.getElementsText(accountActivityPage.rowsElementsOfDescriptionColumn);
        for (String descriptionRow : descriptionRows) {
            Assert.assertFalse(descriptionRow.contains(description));
        }
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String columnHeader) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> rows = BrowserUtils.getElementsText(accountActivityPage.findElementWithHeader(columnHeader));
        Assert.assertFalse(rows.isEmpty());
    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        BrowserUtils.waitForClickablility(new AccountActivityPage().typeDropDownElement,3);
        Select select = new Select(new AccountActivityPage().typeDropDownElement);
        select.selectByVisibleText(type);
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String columnHeader) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        List<String> rows = BrowserUtils.getElementsText(accountActivityPage.findElementWithHeader(columnHeader));
        Assert.assertFalse(rows.isEmpty());
    }

}
