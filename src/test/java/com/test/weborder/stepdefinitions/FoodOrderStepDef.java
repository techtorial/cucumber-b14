package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.WebOrderLoginPage;
import com.test.weborder.pages.WebOrderOrderPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class FoodOrderStepDef {
    WebDriver driver= DriverHelper.getDriver();
    WebOrderLoginPage loginPage=new WebOrderLoginPage(driver);
    WebOrderOrderPage orderOrderPage=new WebOrderOrderPage(driver);
    @Given("User navigates to WebOrder and login successfully")
    public void user_navigates_to_web_order_and_login_successfully() {
        loginPage.login(ConfigReader.readProperty("weborderusername"),ConfigReader.readProperty("weborderpassword"));
    }
    @Given("User validates the title {string} from order page")
    public void user_validates_the_title_from_order_page(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle().trim());
    }
    @When("User clicks Group Order Box and Next button")
    public void user_clicks_group_order_box_and_next_button() {
        orderOrderPage.clickGroupOrderBox();
        orderOrderPage.clickNextButton();
    }
    @When("User sends the word {string} for note to invitees section")
    public void user_sends_the_word_for_note_to_invitees_section(String note) {
        orderOrderPage.sendingNote(note);
    }
    @When("User sends e-mail address which are {string} and {string} to Invite List")
    public void user_sends_e_mail_address_which_are_and_to_invite_list(String email1, String email2) {
        orderOrderPage.sendingInviteList(email1,email2);
    }
    @When("User chooses the delivery address {string} and validates the address {string}")
    public void user_chooses_the_delivery_address_and_validates_the_address(String option, String expectedAddress) {
       orderOrderPage.chooseDeliveryOption(option,expectedAddress);
    }
    @When("User clicks the create Group order button")
    public void user_clicks_the_create_group_order_button() {
        orderOrderPage.clickOrderButton();
    }
    @Then("User validates the header of page is {string}")
    public void user_validates_the_header_of_page_is(String expectedHeader) throws InterruptedException {
        Thread.sleep(3000);Assert.assertTrue(orderOrderPage.validateHeader(expectedHeader));
    }

}
