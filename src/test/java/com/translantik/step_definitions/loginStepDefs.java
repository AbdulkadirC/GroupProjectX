package com.translantik.step_definitions;

import com.translantik.pages.Dashboard;
import com.translantik.pages.LoginPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;


public class loginStepDefs {

    LoginPage loginPage=new LoginPage();
    Dashboard dashboard=new Dashboard();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        Driver.get().get(ConfigurationReader.get("url"));
    }

    @And("the user enters own {string} and {string}")
    public void theUserEntersOwnAnd(String arg0, String arg1) {
    }


    @When("the user log in as {string}")
    public void the_user_log_in_as(String userType) {
        //Driver.get().get(ConfigurationReader.get("url"));
        String username = null;
        String password = null;

        if (userType.equals("driver")) {
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
        } else if (userType.equals("sales_manager")) {
            username = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");
        } else if (userType.equals("store_manager")) {
            username = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");
        }
        new LoginPage().login(username, password);

    }

    @Then("the page contains {string}")
    public void the_page_contains(String pageTitle) {
        System.out.println("pageTitle = " + pageTitle);
        BrowserUtils.waitFor(3);
        Assert.assertTrue(Driver.get().getTitle().contains(pageTitle));
    }

    @Given("the user enter {string} and {string}")
    public void the_user_enter_and(String wrongName, String wrongPassword) {
        //LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys(wrongName);
        loginPage.password.sendKeys(wrongPassword);
        loginPage.submit.click();
        BrowserUtils.waitFor(1);

    }

    @Then("the error \"\"Invalid user name or password.{string} displayed")
    public void the_error_Invalid_user_name_or_password_displayed(String actualErrorMessage) {
        actualErrorMessage = loginPage.alertMessageLocator.getText();
        System.out.println("actualErrorMessage = " + actualErrorMessage);
        Assert.assertEquals("Invalid user name or password.", actualErrorMessage);
    }

    @Then("the user can see own {string}")
    public void the_user_can_see_own(String expectedUserName) {
        Assert.assertEquals(expectedUserName,dashboard.fullName.getText());

    }


    @Given("the user enter the following {string}")
    public void the_user_enter_the_following(String actualUserName) {
        loginPage.username.sendKeys(ConfigurationReader.get("driver_username"));
    }

    @When("the user enter own password")
    public void the_user_enter_own_password() {
        loginPage.password.sendKeys(ConfigurationReader.get("driver_password"));
    }

    @Then("the user see that as bullet sign")
    public void the_user_see_that_as_bullet_sign() {
        Assert.assertTrue(loginPage.password.isDisplayed());
    }

    @Given("the user should be able to click on the link")
    public void the_user_should_be_able_to_click_on_the_link() {
        loginPage.forgotPasswordLink.click();
        String actualLink=Driver.get().getCurrentUrl();
        Assert.assertEquals("verify the link is clickable","http://qa.translantik.com/user/reset-request",actualLink);

    }

    @Then("the user should land on {string} page")
    public void the_user_should_land_on_page(String forgotPassword) {
        forgotPassword=loginPage.forgotPasswordPage.getText();
        Assert.assertEquals("Forgot Password",forgotPassword);
    }

    @Given("the user should be able to see {string} link")
    public void the_user_should_be_able_to_see_link(String actualLink) {
        Assert.assertEquals("Remember me on this computer",actualLink);
    }

    @Then("the link should be clickable")
    public void the_link_should_be_clickable() {
        JavascriptExecutor jse = (JavascriptExecutor)Driver.get();
        jse.executeScript("arguments[0].click();", loginPage.rememberMeLink);
        BrowserUtils.waitFor(4);
        Assert.assertTrue("verify",loginPage.rememberMeLink.isSelected());
    }

    @Given("the user enter own username and press enter")
    public void the_user_enter_own_username_and_press_enter() {
        loginPage.username.sendKeys(ConfigurationReader.get("driver_username")+Keys.ENTER);
        BrowserUtils.waitFor(1);

    }

    @Then("the user enter own password and press enter")
    public void the_user_enter_own_password_and_press_enter() {
        loginPage.password.sendKeys(ConfigurationReader.get("driver_password")+Keys.ENTER);
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        String actualTitle=Driver.get().getTitle();
        String expectedTitle="Dashboard";
        Assert.assertEquals("verify the title",actualTitle,expectedTitle);
    }



}
