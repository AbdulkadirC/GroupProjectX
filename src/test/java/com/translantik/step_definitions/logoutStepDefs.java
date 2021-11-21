package com.translantik.step_definitions;

import com.translantik.pages.Dashboard;
import com.translantik.pages.LoginPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class logoutStepDefs {

    LoginPage loginPage=new LoginPage();
    Dashboard dashboard=new Dashboard();

    @Given("the user enter userType and password")
    public void the_user_enter_userType_and_password() {
        loginPage.login(ConfigurationReader.get("driver_username"),ConfigurationReader.get("driver_password"));

    }

    @Given("the user should be able to see logout button")
    public void the_user_should_be_able_to_see_logout_button() {
        dashboard.fullName.click();
        Assert.assertTrue(Driver.get().findElement(By.linkText("Logout")).isDisplayed());
    }

    @When("the user be able to click logout button")
    public void the_user_be_able_to_click_logout_button() {
        dashboard.logOutLink.click();
    }

    @Then("the user be able to logout")
    public void the_user_be_able_to_logout() {

    }
    @Then("the user should land on login page")
    public void the_user_should_land_on_login_page() {
        Assert.assertEquals(Driver.get().getCurrentUrl(),"http://qa.translantik.com/");
    }

    @When("the user click even back button after logout")
    public void the_user_click_even_back_button_after_logout() {
        dashboard.fullName.click();
        dashboard.logOutLink.click();
        Driver.get().navigate().back();
        Assert.assertEquals("http://qa.translantik.com/user/login",Driver.get().getCurrentUrl());
    }

    @Then("the user close the tab")
    public void the_user_close_the_tab() {
        Driver.closeDriver();
    }

    @Then("the user should not be able to login as opening the login page")
    public void the_user_should_not_be_able_to_login_as_opening_the_login_page() {

        Driver.get().get("http://qa.translantik.com");
        BrowserUtils.waitFor(2);

    }

}