package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryPage extends BasePage{
    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[href='/bank/account-activity.html?accountId=1']")
    public WebElement savingsLink;


//    @FindBy(how = How.CSS,using = "a[href^='/bank/account-activity.html?accountId=']")
//    public List<WebElement> webElementLinkList;

    @FindBy(css = "a[href^='/bank/account-activity.html?accountId=']")
    public List<WebElement> webElementLinkList;







}
