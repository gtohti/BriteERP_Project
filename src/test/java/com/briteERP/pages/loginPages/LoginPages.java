package com.briteERP.pages.loginPages;

import com.briteERP.utilities.Driver;
import com.briteERP.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.awt.peer.TextComponentPeer;

public class LoginPages {
    public TextComponentPeer errorMessageElement;
    WebDriver driver= Driver.getDriver();
    String usernameLocator = "//input[@id='login']";
    String passwordLocator = "//input[@id='password']";
    String loginButtonLocator = "//button[@class='btn btn-primary']";


    public void login(String username, String password){
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(usernameLocator)).sendKeys(username);
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(passwordLocator)).sendKeys(password);
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(loginButtonLocator)).click();
        SeleniumUtils.waitPlease(2);

    }


}

