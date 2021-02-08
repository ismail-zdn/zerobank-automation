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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FindTransactionsDefs {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().login();
        new AccountSummaryPage().accessTab("Account Activity");
        new AccountActivityPage().findTransactionsTab.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String date1, String date2) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.fromDateInputBox.sendKeys(date1);
        accountActivityPage.toDateInputBox.sendKeys(date2);
    }

    @When("clicks Find")
    public void clicks_Find() {
        new AccountActivityPage().findButton.click();
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

    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
