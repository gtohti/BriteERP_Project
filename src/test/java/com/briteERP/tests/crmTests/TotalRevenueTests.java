package com.briteERP.tests.crmTests;



import com.briteERP.pages.crmPages.CRMPage;
import com.briteERP.pages.loginPages.LoginPages;
import com.briteERP.utilities.ConfigurationReader;
import com.briteERP.utilities.Driver;
import com.briteERP.utilities.SeleniumUtils;
import com.briteERP.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TotalRevenueTests extends TestBase {

    WebDriver driver = Driver.getDriver();

        /*
          Verify that on the pivot table, the total expected revenue should be the sum of all opportunities’ expected revenue.
        1. PreCondition- each CRM manager user should create at least 3 opportunities on the CRM module.
         (create 2 opportunity just in case)
         2.Pre-condition two: on Pivot table expand total and select opportunity from the dropdown.
         1.log in
         2.click CRM button
         3.click pivot icon
         4. click new and choose opportunity
         5.choose second row and second column /on list board it is first one
        verify they have same revenue
        */


    @Test
    public void test2() {

        LoginPages loginPage = new LoginPages();

        /*
         Verify that on the pivot table, the total expected revenue should be the sum of all opportunities’ expected revenue.
        1. PreCondition- each CRM manager user should create at least 3 opportunities on the CRM module.
         (create 2 opportunity just in case)
         2.Pre-condition two: on Pivot table expand total and select opportunity from the dropdown.
        */
        /*
        1.log in
        2.click CRM button
        3.click pivot icon
       4. click new and choose opportunity
       5.choose second row and second column /on list board it is first one
       6.verify they have same revenue
       */

        String username = ConfigurationReader.getProperty("crmUsername");
        String password = ConfigurationReader.getProperty("crmPassword");
        loginPage.login(username, password);

        CRMPage crmPage = new CRMPage();
        crmPage.CRMpageClick();
        SeleniumUtils.waitPlease(2);
        crmPage.CRMRevenueCompare();
        int sum = 0;
       for (int i = 3; i <=5; i++) {
            WebElement element = driver.findElement(By.xpath("//table[1]/tbody/tr[" + i + "]/td[2]"));
            int revenue =  Integer.parseInt(element.getText().replaceAll("[^\\d]",""));
//
            sum +=revenue;
        }
        System.out.println("sum: "+sum);

        WebElement total = driver.findElement(By.xpath("//table[1]/tbody/tr[1]/td[2]"));
        int totalNumber =   Integer.parseInt(total.getText().replaceAll("[^\\d]",""));

        Assert.assertEquals(totalNumber, sum);
    }
}