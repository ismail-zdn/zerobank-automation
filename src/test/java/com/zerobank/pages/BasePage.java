package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "(//*[@data-toggle='dropdown'])[2]")
    public WebElement userName;

    @FindBy(css = "[id='account_activity_tab']")
    public WebElement accountActivityTab;

    @FindBy(css = "a[href^='/bank/redirect.html?url']")
    public List<WebElement> webElementTabList;

    public String getPageTitle(){
        return Driver.get().getTitle();
    }

    public String getPageTabText(){
        return accountActivityTab.getText();
    }

    public void accessTab(List<WebElement> webElementList,String tabText){
        try {
            for (WebElement webElement : webElementList) {
                if (webElement.getText().equals(tabText)){
                    webElement.click();
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }





}



