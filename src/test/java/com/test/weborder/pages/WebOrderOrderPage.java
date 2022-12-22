package com.test.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class WebOrderOrderPage {

    public WebOrderOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//label[@class='custom-control-label']")
    WebElement groupOrderBox;

    @FindBy(id = "getAddressNextButton")
    WebElement nextButton;

    @FindBy(id = "InviteNote")
    WebElement inviteNote;

    @FindBy(id = "InviteList")
    WebElement inviteList;

    @FindBy(id = "ConfirmAddressID")
    WebElement location;

    @FindBy(id = "addressPreview")
    WebElement address;

    @FindBy(id = "createGroupOrder")
    WebElement createGroupOrderButton;

    @FindBy(tagName = "h1")
    WebElement header;


    public void clickGroupOrderBox(){
        groupOrderBox.click();
    }

    public void clickNextButton(){
        nextButton.click();
    }


    public void chooseDeliveryOption(String option,String expectedAdress){
        BrowserUtils.selectBy(location,option,"text");
        Assert.assertTrue(BrowserUtils.getText(address).contains(expectedAdress));
    }

    public void sendingNote(String invitenote){
        this.inviteNote.sendKeys(invitenote);
    }

    public void sendingInviteList(String e_mail1,String e_mail2){
        inviteList.sendKeys(e_mail1+" , "+e_mail2);
    }

    public void clickOrderButton(){
        createGroupOrderButton.click();
    }

    public boolean validateHeader(String expectedHeader){
        return BrowserUtils.getText(header).equals(expectedHeader);
    }



}
