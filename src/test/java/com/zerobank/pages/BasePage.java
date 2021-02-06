package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    @FindBy(xpath = "(//*[@data-toggle='dropdown'])[2]")
    public WebElement userName;

    @FindBy(css = "[id='account_activity_tab']")
    public WebElement accountActivityTab;

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public String getPageTitle(){
        return Driver.get().getTitle();
    }

    public String getPageTabText(){
        return accountActivityTab.getText();
    }




}



