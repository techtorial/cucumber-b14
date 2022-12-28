package com.test.products.stepdefinitions;

import com.test.products.pages.ProductLoginPage;
import com.test.products.pages.ProductMainPage;
import com.test.products.pages.ProductOrderPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class ProductCreationStepDef {
    WebDriver driver = DriverHelper.getDriver();
    ProductLoginPage productLoginPage = new ProductLoginPage(driver);
    ProductMainPage productMainPage = new ProductMainPage(driver);
    ProductOrderPage productOrderPage = new ProductOrderPage(driver);

    @Given("User navigates to product homepage and click order Button")
    public void user_navigates_to_product_homepage_and_click_order_button() throws InterruptedException {
        productLoginPage.login(ConfigReader.readProperty("productusername"), ConfigReader.readProperty("productpassword"));
        productMainPage.clickOrderButton();
        Thread.sleep(3000);
    }

    @When("User enters the product information {string} and {string}")
    public void user_enters_the_product_information_and(String productName, String quantity) throws InterruptedException {
        productOrderPage.sendProductInformation(productName, quantity);
        Thread.sleep(3000);

    }

    @When("User enters the address information {string},{string},{string},{string}")
    public void user_enters_the_address_information(String name, String street, String city, String zip) throws InterruptedException {
        productOrderPage.sendAddressInformation(name, street, city, zip);
        Thread.sleep(3000);
    }

    @When("User enters the payment information {string},{string},{string} and click process button")
    public void user_enters_the_payment_information_and_click_process_button(String cardType, String cardNumber, String expireDate) throws InterruptedException {
        productOrderPage.sendPaymentInformation(cardType, cardNumber, expireDate);
        Thread.sleep(3000);

    }

    @Then("User validates the message {string}")
    public void user_validates_the_message(String expectedMessage) throws InterruptedException {
        Assert.assertEquals(expectedMessage, productOrderPage.validateMessage());
        Thread.sleep(3000);

    }
}
