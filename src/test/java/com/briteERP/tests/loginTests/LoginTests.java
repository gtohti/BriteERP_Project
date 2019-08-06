package com.briteERP.tests.loginTests;

import com.briteERP.pages.loginPages.LoginPages;
import com.briteERP.utilities.ConfigurationReader;
import com.briteERP.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests  extends TestBase {
    @Test
    public void Test1(){
        LoginPages loginpage = new LoginPages();
        String username = ConfigurationReader.getProperty("crmUsername");
        String password = ConfigurationReader.getProperty("crmPassword");
        loginpage.login(username,password);
    }
    @Test
    public void negativeLoginTest1(){
        LoginPages loginPage = new LoginPages();
        loginPage.login("wrongusername", "wrongpassword");
        String message = loginPage.errorMessageElement.getText().trim();
        Assert.assertEquals(message, "Wrong login/password");
    }
}






