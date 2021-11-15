package com.translantik.step_definitions;

import com.translantik.pages.LoginPage;
import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class loginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
       Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user log in as {string}")
    public void the_user_log_in_as(String userType) {
        //Driver.get().get(ConfigurationReader.get("url"));
        String username=null;
        String password=null;

        if(userType.equals("driver")){
            username=ConfigurationReader.get("driver_username");
            password=ConfigurationReader.get("driver_password");
        }else if(userType.equals("sales_manager")){
            username=ConfigurationReader.get("sales_manager_username");
            password=ConfigurationReader.get("sales_manager_password");
        }else if(userType.equals("store_manager")){
            username=ConfigurationReader.get("store_manager_username");
            password=ConfigurationReader.get("store_manager_password");
        }
        new LoginPage().login(username,password);
    }

    @Then("the page contains {string}")
    public void the_page_contains(String pageTitle) {
        System.out.println("pageTitle = " + pageTitle);
        BrowserUtils.waitFor(3);
        Assert.assertTrue(Driver.get().getTitle().contains(pageTitle));
    }

}
