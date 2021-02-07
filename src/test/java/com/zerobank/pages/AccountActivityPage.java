package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage{

    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[id='aa_accountId']")
    public WebElement accountDropDown;

    public Select getSelectDropDown(){
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        return new Select(accountActivityPage.accountDropDown);
    }

}
