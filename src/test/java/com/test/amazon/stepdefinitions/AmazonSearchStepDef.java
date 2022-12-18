package com.test.amazon.stepdefinitions;

import com.test.amazon.pages.AmazonMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class AmazonSearchStepDef {
    WebDriver driver= DriverHelper.getDriver();
    AmazonMainPage amazonMainPage=new AmazonMainPage(driver);
    @Given("User navigates to the Amazon")
    public void user_navigates_to_the_amazon() {
    driver.get(ConfigReader.readProperty("amazonurl"));
    }
    @When("User searches for {string} on Amazon")
    public void user_searches_for_on_amazon(String expectedWord) {
    amazonMainPage.searchItem(expectedWord);
    }
    @Then("User validates the result contains {int}")
    public void user_validates_the_result_contains(int expectedNumber) {
        Assert.assertTrue(amazonMainPage.resultNumber(expectedNumber));
    }
    @Then("User validates all header contains {string}")
    public void user_validates_all_header_contains(String expectedKey) {
        amazonMainPage.validateAllHeaders(expectedKey);
    }
}
