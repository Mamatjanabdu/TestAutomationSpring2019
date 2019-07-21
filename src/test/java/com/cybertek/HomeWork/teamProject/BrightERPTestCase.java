package com.cybertek.HomeWork.teamProject;

import com.cybertek.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

public class BrightERPTestCase {

    /**

     *
     *
     * Manager should be able to see all reporting page-------------
     * Manager should be able to delete vendor bills---------
     *
     *
     *
     */



        WebDriver driver;
        String emailButton = "#login";
        String passwordButton = "#password";
        String purchaseButtonLocator = "//span[contains( text(), 'Purchases' )and @class='oe_menu_text']";
        //       String createButtonLocator="button[class='btn btn-primary btn-sm o_list_button_add']";
        String reportingButtonLocator = "//a[@href='/web#menu_id=521&action=701']";

        String vendorBillsButtonLocator="//span[contains( text(), 'Vendor Bills' )and @class='oe_menu_text']";
        String vendorButtonLocator="td[class='o_data_cell o_required_modifier']";
        String actionButtonLocator="//button[contains( text(), 'Action' )and @class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle']";
         String deleteButtonLocator="Delete";
         String okButtonLocator="button[class='btn btn-sm btn-primary']";
         String beforeDeleteNumberLocator="span[class='o_pager_limit']";
       String afterDeleteNumberLocator="span[class='o_pager_limit']";


        @BeforeMethod
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            // open the log in page
            driver.get("http://34.220.250.213/web/login");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            //find the name input section and put valid user name
            driver.findElement(By.cssSelector(emailButton)).sendKeys("posmanager50@info.com");
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            //find the password input section and put password  and click enter
            driver.findElement(By.cssSelector(passwordButton)).sendKeys("posmanager", Keys.ENTER);
            SeleniumUtils.waitPlease(5);

        }

        @Test
        public void checkingReports() {
            //find purchases module and click on it
            driver.findElement(By.xpath(purchaseButtonLocator)).click();
            SeleniumUtils.waitPlease(4);
            //find report menue locator and click on it
            driver.findElement(By.xpath(reportingButtonLocator)).click();
            SeleniumUtils.waitPlease(4);
            //validate the report page is open or not.
            Assert.assertTrue(driver.getTitle().contains("Purchase Analysis"));

        }
      @Test
      public void deleteVendorBillTest(){
            //find purchase module button and click it
          driver.findElement(By.xpath(purchaseButtonLocator)).click();
          SeleniumUtils.waitPlease(4);
          //find Vendor Bills menue and click on it
          driver.findElement(By.xpath(vendorBillsButtonLocator)).click();
         SeleniumUtils.waitPlease(4);
         //get the total vendor bills number from right top corner
          String beforeNumStr=driver.findElement(By.cssSelector(beforeDeleteNumberLocator)).getText();
         // print out the vendor bill number before delete
          System.out.println(beforeNumStr);
          //find vendor bills item and click on it
          driver.findElement(By.cssSelector(vendorButtonLocator)).click();
          SeleniumUtils.waitPlease(2);
          //find action button locator and click on it
          driver.findElement(By.xpath(actionButtonLocator)).click();
          SeleniumUtils.waitPlease(2);
          //find delete icon locator and click on it
          driver.findElement(By.linkText(deleteButtonLocator)).click();
          SeleniumUtils.waitPlease(2);
          //find ok button locator and click on it
          driver.findElement(By.cssSelector(okButtonLocator)).click();
          SeleniumUtils.waitPlease(2);
          //get the number text after delete the vendor bill item
          String afterNumStr=driver.findElement(By.cssSelector(afterDeleteNumberLocator)).getText();
          //priint out the number string
          System.out.println(afterNumStr);
          //change the string to the Integer
          int beforeNum=Integer.parseInt(beforeNumStr);
         int afterNum=Integer.parseInt(afterNumStr);
          // and check the number before delete and after delete, if the number before delete is bigger then the number
          // after delete , your delete action is successful.
          Assert.assertTrue(beforeNum>afterNum);




      }
        @AfterMethod
        public void tearDown() {
            driver.close();
        }
    }

/**
 *
 *
 *
 * ●Describe your project--->>
 * ●Which programming language is used?--->>       Java, HTML
 * ●Which core java concept is being used? --->>> polimorphisim
 * ●Which testing tools did you use?  ---->>>     Selenium WebDriver, Maven, TestNG
 * ●Which IDE is used? ----->>                     Intellij Ecilipse
 * ●Which browser did you use? ------>>>           chrome driver,firefox driver
 * ●What is your software methodology? ------>>>    Agile-Scrum, Waterfall
 */





















