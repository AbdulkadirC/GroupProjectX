package com.translantik.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends BasePage{

    @FindBy(xpath = "(//h1)[2]")
    public WebElement pageName;

    @FindBy(css = "#user-menu > a")
    public WebElement fullName;

    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    @FindBy(css = "div[class='loader-mask shown']")
    @CacheLookup
    protected WebElement loaderMask;


}
