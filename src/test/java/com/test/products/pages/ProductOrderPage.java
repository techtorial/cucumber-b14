package com.test.products.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class ProductOrderPage {

    public ProductOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct")
    WebElement product;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement quantity;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtName")
    WebElement name;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    WebElement street;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    WebElement city;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zip;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_0")
    WebElement visaCard;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_1")
    WebElement masterCard;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_2")
    WebElement americanExpressCard;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardNumber;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expireDate;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_InsertButton")
    WebElement processButton;

    @FindBy(xpath = "//strong")
    WebElement message;

    public void sendProductInformation(String productName, String quantity) throws InterruptedException {
        BrowserUtils.selectBy(product, productName, "text");
        Thread.sleep(5000);
        this.quantity.clear();
        this.quantity.sendKeys(quantity);
    }

    public void sendAddressInformation(String name, String street, String city, String zip) {
        this.name.sendKeys(name);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.zip.sendKeys(zip);
    }

    public void sendPaymentInformation(String cardType, String cardNumber, String expireDate) {
        selectCard(cardType);
        this.cardNumber.sendKeys(cardNumber);
        this.expireDate.sendKeys(expireDate);
        processButton.click();
    }

    public void selectCard(String cardType) {
        cardType = cardType.toUpperCase();

        switch (cardType) {

            case "VISA":
                visaCard.click();
                break;
            case "MASTERCARD":
                masterCard.click();
                break;
            case "AMERICAN EXPRESS":
                americanExpressCard.click();
                break;
            default:
                System.out.println("Card Type is incorrect,Please check it");
        }
    }

    public String validateMessage() {
        return BrowserUtils.getText(message);
    }


}
