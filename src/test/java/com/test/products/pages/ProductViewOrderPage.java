package com.test.products.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ProductViewOrderPage {

    public ProductViewOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr[2]//td")
    List<WebElement> allData;

    public void validateInformation(String name, String product, String quantity, String street, String city, String zip, String cartType, String cardNumber, String expireDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String currentTime = dtf.format(now);
        List<String> expectedValues = Arrays.asList("", name, product, quantity, currentTime, street, city, "", zip, cartType, cardNumber, expireDate);

        for (int i = 1; i < allData.size() - 1; i++) {
            Assert.assertEquals(expectedValues.get(i), BrowserUtils.getText(allData.get(i)));
        }
    }
}
