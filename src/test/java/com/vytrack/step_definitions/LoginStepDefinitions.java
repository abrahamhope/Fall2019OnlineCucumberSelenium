package com.vytrack.step_definitions;

import com.vytrack.page.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
    LoginPage loginPage =new LoginPage();


    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
        System.out.println("I am on login page");
        String URL = ConfigurationReader.getProperty("qa3");
        Driver.getDriver().get(URL);
    }

    @When("user logs in as a sales manager")
    public void user_logs_in_as_a_sales_manager() {
        System.out.println("I logged in as a sales manager");
        loginPage.login("salesmanager110","UserUser123");
    }

    @When("user logs in as a store manager")
    public void user_logs_in_as_a_store_manager() {
        System.out.println("I logged in as a store manager");

        loginPage.login("storemanager85","UserUser123");

    }

    @Then("user should verify that title is {string}")
    public void user_should_verify_that_title_is(String string) {
        System.out.println("I verfied the title is "+string);
        Assert.assertEquals("Dashboard", Driver.getDriver().getTitle());
        Driver.closeDriver();
    }


}
