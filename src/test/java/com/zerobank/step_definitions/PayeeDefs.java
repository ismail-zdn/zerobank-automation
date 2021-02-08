package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class PayeeDefs {

    @Given("the user is on the {string} tab")
    public void the_user_is_on_the_tab(String tab) {
        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().login();
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.accessTab(accountSummaryPage.webElementTabList, "Pay Bills");
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.accessTab(payBillsPage.webElementModuleList, tab);
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> newPayeeInfo) {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.payeeNameInputBox.sendKeys(newPayeeInfo.get("Payee Name"));
        payBillsPage.payeeAddressInputBox.sendKeys(newPayeeInfo.get("Payee Address"));
        payBillsPage.payeeAccountInputBox.sendKeys(newPayeeInfo.get("Account"));
        payBillsPage.payeeDetailsInputBox.sendKeys(newPayeeInfo.get("Payee details"));
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String message) {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.addButton.click();
        BrowserUtils.waitForVisibility(payBillsPage.alertContainer,3);
        Assert.assertEquals(message,payBillsPage.alertContainer.getText().substring(2));
    }
}


