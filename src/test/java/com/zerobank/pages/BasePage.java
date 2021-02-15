package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "a[href^='/bank/redirect.html?url']")
    public List<WebElement> webElementTabList;

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

    public Select getSelectDropDown(WebElement dropDownElement){
        return new Select(dropDownElement);
    }

    public boolean isAlertPresent()
    {
        try
        {
            Driver.get().switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException Ex)
        {
            return false;
        }
    }

}



