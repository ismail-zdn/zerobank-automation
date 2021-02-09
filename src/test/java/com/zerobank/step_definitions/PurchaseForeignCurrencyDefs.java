package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class PurchaseForeignCurrencyDefs {
    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> countries) {
        PayBillsPage payBillsPage = new PayBillsPage();
        List<String> options = BrowserUtils.getElementsText(payBillsPage.getSelectDropDown(payBillsPage.currencyDropDownElement).getOptions());
        options.remove(0);
        Assert.assertEquals(countries,options);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.getSelectDropDown(payBillsPage.currencyDropDownElement).selectByIndex(0);
        payBillsPage.amountInputBox.sendKeys("100");
        payBillsPage.selectedCurrencyRadioButton.click();
        payBillsPage.calculateCostsButton.click();

    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertTrue(new PayBillsPage().isAlertPresent());
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        PayBillsPage payBillsPage = new PayBillsPage();
        payBillsPage.getSelectDropDown(payBillsPage.currencyDropDownElement).selectByIndex(2);
        payBillsPage.amountInputBox.clear();
        payBillsPage.selectedCurrencyRadioButton.click();
        payBillsPage.calculateCostsButton.click();

    }
}
