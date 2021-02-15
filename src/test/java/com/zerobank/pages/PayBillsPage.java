package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PayBillsPage extends BasePage{

    public PayBillsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[href^='#ui-tabs-']")
    public List<WebElement> webElementModuleList;

    @FindBy(css = "#np_new_payee_name")
    public WebElement payeeNameInputBox;

    @FindBy(css = "#np_new_payee_address")
    public WebElement payeeAddressInputBox;

    @FindBy(css = "#np_new_payee_account")
    public WebElement payeeAccountInputBox;

    @FindBy(css = "#np_new_payee_details")
    public WebElement payeeDetailsInputBox;

    @FindBy(css = "#add_new_payee")
    public WebElement addButton;

    @FindBy(css = "[class='alert alert-success hide']")
    public WebElement alertContainer;

    @FindBy(css = "#pc_currency")
    public WebElement currencyDropDownElement;

    @FindBy(css = "#purchase_cash")
    public WebElement purchaseButton;

    @FindBy(css = "#pc_amount")
    public WebElement amountInputBox;

    @FindBy(css = "#pc_inDollars_false")
    public WebElement selectedCurrencyRadioButton;

    @FindBy(css = "#pc_calculate_costs")
    public WebElement calculateCostsButton;

    @FindBy(css = "#sp_payee")
    public WebElement payeeDropDownElement;

    @FindBy(css = "#sp_account")
    public WebElement accountDropDownElement;

    @FindBy(css = "#sp_amount")
    public WebElement payeeAmountInputBox;

    @FindBy(css = "#sp_date")
    public WebElement dateInputBox;

    @FindBy(css = "#sp_description")
    public WebElement descriptionInputBox;

    @FindBy(css = "#pay_saved_payees")
    public WebElement payButton;










}
