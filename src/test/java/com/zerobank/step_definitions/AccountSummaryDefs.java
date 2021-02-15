package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryDefs {

    @Then("Account Summary Page should have the title {string}")
    public void account_Summary_Page_should_have_the_title(String title) {
        Assert.assertEquals(title,Driver.get().getTitle());
    }

    @Then("Account summary page should have to following account types:")
    public void account_summary_page_should_have_to_following_account_types(List<String> accountTypes) {
        List<String> actualAccountTypes = BrowserUtils.getElementsText(new AccountSummaryPage().accountTypesList);
        Assert.assertEquals(accountTypes,actualAccountTypes);
    }

    @Then("Credit Accounts table must have columns")
    public void credit_Accounts_table_must_have_columns(List<String> expectedCreditAccountsColumnsList) {
        List<String> actualCreditAccountsColumnsList = BrowserUtils.getElementsText(new AccountSummaryPage().creditAccountsColumnsList);
        Assert.assertEquals(expectedCreditAccountsColumnsList,actualCreditAccountsColumnsList);
    }
}
