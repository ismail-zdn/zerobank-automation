package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AccountActivityPage extends BasePage{

    public AccountActivityPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[id='aa_accountId']")
    public WebElement accountDropDown;

    @FindBy(css = "[href='#ui-tabs-2']")
    public WebElement findTransactionsTab;

    @FindBy(css = "#aa_fromDate")
    public WebElement fromDateInputBox;

    @FindBy(css = "#aa_toDate")
    public WebElement toDateInputBox;

    @FindBy(css = "#aa_description")
    public WebElement descriptionInputBox;

    @FindBy(css = "[class='btn btn-primary']")
    public WebElement findButton;

    @FindBy(css = "[class='well']")
    public WebElement noResultTextElement;

    @FindBy(css = "#aa_type")
    public WebElement typeDropDownElement;

    @FindBy(xpath = "(//*[@class='table table-condensed table-hover'])[2]/tbody//td[1]")
    public List<WebElement> rowsElementsOfDateColumn;

    @FindBy(xpath = "(//*[@class='table table-condensed table-hover'])[2]/tbody//td[2]")
    public List<WebElement> rowsElementsOfDescriptionColumn;

    @FindBy(xpath = "(//*[@class='table table-condensed table-hover'])[2]/tbody//td[3]")
    public List<WebElement> rowsElementsOfDepositColumn;

    @FindBy(xpath = "(//*[@class='table table-condensed table-hover'])[2]/tbody//td[4]")
    public List<WebElement> rowsElementsOfWithdrawalColumn;





    public List<String> getStringListOfElements(List<WebElement> webElementList){
        List<String> textsList = new ArrayList<>();
        for (WebElement webElement : webElementList) {
            textsList.add(webElement.getText());
        }
        return textsList;
    }

    public List<Date> getDateListOfElements(List<WebElement> webElementList) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        List<Date> dateList = new ArrayList<>();
//        System.out.println("webElementList.size() = " + webElementList.size());
//        System.out.println(webElementList);

        try {
            for (WebElement webElement : webElementList) {
//                System.out.println("webElement.getText() = " + webElement.getText());
                dateList.add(dateFormat.parse(webElement.getText()));
            }
        }
        catch (ParseException e){
            e.printStackTrace();
        }

        return dateList;
    }

    public Date parseStringToDate(String dateString){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return date;
    }

    public List<WebElement> findElementWithHeader(String header){
        switch (header){
            case "Date":
                return rowsElementsOfDateColumn;
            case "Description":
                return rowsElementsOfDescriptionColumn;
            case "Deposit":
                return rowsElementsOfDepositColumn;
            case "Withdrawal":
                return rowsElementsOfWithdrawalColumn;
            default:
                return null;
        }
    }

}
