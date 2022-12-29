package com.test.products.stepdefinitions;

import com.test.products.pages.ProductLoginPage;
import com.test.products.pages.ProductMainPage;
import com.test.products.pages.ProductOrderPage;
import com.test.products.pages.ProductViewOrderPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.cucumber.java.it.Ma;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class ProductCreationStepDef {
    WebDriver driver = DriverHelper.getDriver();
    ProductLoginPage productLoginPage = new ProductLoginPage(driver);
    ProductMainPage productMainPage = new ProductMainPage(driver);
    ProductOrderPage productOrderPage = new ProductOrderPage(driver);

    ProductViewOrderPage productViewOrderPage = new ProductViewOrderPage(driver);

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

    @Then("User validates all the information {string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void user_validates_all_the_information(String name, String product, String quantity, String street, String city, String zip, String cartType, String cardNumber, String expireDate) {
        productMainPage.clickViewAllOrdersButton();
        productViewOrderPage.validateInformation(name, product, quantity, street, city, zip, cartType, cardNumber, expireDate);
    }

    @When("User enters the product information product and quantity")
    public void user_enters_the_product_information_product_and_quantity(DataTable dataTable) throws InterruptedException {
        Map<String, String> productInformation = dataTable.asMap();//product=MyMoney ,quantity=4
        productOrderPage.sendProductInformation(productInformation.get("product"), productInformation.get("quantity"));
    }

    @When("User enters the address information name, street, city, zip")
    public void user_enters_the_address_information_name_street_city_zip(DataTable dataTable) {
        Map<String, String> addressInformation = dataTable.asMap();
        productOrderPage.sendAddressInformation(addressInformation.get("name"), addressInformation.get("street"), addressInformation.get("city"), addressInformation.get("zip"));
    }

    @When("User enters the payment information cardType, cardNumber,expireDate and click process button")
    public void user_enters_the_payment_information_card_type_card_number_expire_date_and_click_process_button(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> paymentInformation = dataTable.asMap();
        productOrderPage.sendPaymentInformation(paymentInformation.get("cardType"), paymentInformation.get("cardNumber"), paymentInformation.get("expireDate"));

    }

    @Then("User validates the message message")
    public void user_validates_the_message_message(DataTable dataTable) {
        List<String> expectedMessage = dataTable.asList();
        Assert.assertEquals(expectedMessage.get(0), productOrderPage.validateMessage());
    }

}
