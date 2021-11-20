package com.translantik.pages;

import com.translantik.utilities.ConfigurationReader;
import com.translantik.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="prependedInput")
    public WebElement username;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(name = "_submit")
    public WebElement submit;

    @FindBy (css = ".alert.alert-error")
    public WebElement alertMessageLocator;

    @FindBy(css = ".control-group.form-row > a")
    public WebElement forgotPasswordLink;

    @FindBy(id = "remember_me")
    public WebElement rememberMeLink;

    @FindBy(xpath = "//h2[contains(text(),'Forgot Password')]")
    public WebElement forgotPasswordPage;


    public void login(String userNameStr, String passwordStr) {
        username.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();

    }

   /* public void loginFillOutMessage(){
        String expectedMessage="Invalid user name or password.";
        LoginPage loginPage;
        if (expectedMessage.equals("Invalid user name or password.")){
            Assert.assertEquals(expectedMessage, loginPage.errorMessage.getText());
        }else if (expectedMessage.equals("Please fill out this field.")){
            String actual1 = loginPage.username.getAttribute("validationMessage");
            String actual2 = loginPage.password.getAttribute("validationMessage");


            if (loginPage.username.getAttribute("value") == null && loginPage.password.getAttribute("value") == null){
                Assert.assertEquals(expectedMessage, actual1);
            }else if (loginPage.password.getAttribute("value") == null){
                Assert.assertEquals(expectedMessage, actual2);
            }else if (loginPage.username.getAttribute("value") == null){
                Assert.assertEquals(expectedMessage, actual1);
            }
        }
    }*/




}
