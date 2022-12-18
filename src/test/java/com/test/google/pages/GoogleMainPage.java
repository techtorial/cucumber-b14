package com.test.google.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class GoogleMainPage {

    public GoogleMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='q']")
    WebElement searchBox;

    @FindBy(xpath = "//a")
    List<WebElement> allLinks;

    @FindBy(id = "result-stats")
    WebElement result;

    @FindBy(xpath = "//div[@id='result-stats']//nobr")
    WebElement timeResult;

    public void searchItem(String word){
        searchBox.sendKeys(word, Keys.ENTER);
    }

    public int numberOfLinks(){
        return allLinks.size();
    }

    public int result(){
        String[] resultOfSearch= BrowserUtils.getText(result).split(" ");
        //About 9,4343,433 results
        return Integer.parseInt(resultOfSearch[1].replace(",",""));
    }

    public double getSecondFromResult(){
        String[] time=BrowserUtils.getText(timeResult).split(" ");
        return Double.parseDouble(time[0].substring(1));//(0.44
       // return Double.parseDouble(BrowserUtils.getText(timeResult).substring(1,5));//(0.44 seconds)
    }



}
