package com.briteERP.pages.crmPages;

import com.briteERP.utilities.Driver;
import com.briteERP.utilities.SeleniumUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CRMPage {
    WebDriver driver = Driver.getDriver();
    String CRMModuleLocator = "//span[@class='oe_menu_text' and contains(text(),'CRM')]";
    String viewList = "//button[@class='btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list']";
    String pivotLocator = "[class='btn btn-icon fa fa-lg fa-table o_cp_switch_pivot']";
    String plusLocator = "[class='o_pivot_header_cell_closed']";
    String oppourtunityLocator = "//li[25]/a";
    String secondItemValue = "//table[1]/tbody/tr[4]/td[2]";
    String ItemValueOnViewList = "//table[1]/tbody/tr[1]/td[2]";
    String revenueOfBye="//table[1]/tfoot/tr/td[9]";
    String expected="30,800.00";
    String revenueOfBooksale= "//table[1]/tbody/tr[2]/td[2]";
    String revenueOfBakeSale= "//table[1]/tbody/tr[2]/td[2]";

    public void CRMpageClick(){
        driver.findElement(By.xpath(CRMModuleLocator)).click();

    }
    public void CRMRevenueCompare(){
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(viewList)).click();
        SeleniumUtils.waitPlease(3);
        String actualValueOnViewListPage = driver.findElement(By.xpath(revenueOfBye)).getText();
        Assert.assertEquals(actualValueOnViewListPage, expected);
        driver.findElement((By.cssSelector(pivotLocator))).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.cssSelector(plusLocator)).click();
        SeleniumUtils.waitPlease(2);
        driver.findElement(By.xpath(oppourtunityLocator)).click();
        SeleniumUtils.waitPlease(2);

        String actualValueOnPivotPage = driver.findElement(By.xpath(ItemValueOnViewList)).getText();
        Assert.assertEquals(expected,actualValueOnPivotPage);


        System.out.println(actualValueOnPivotPage);
        System.out.println(actualValueOnViewListPage);



    }
}