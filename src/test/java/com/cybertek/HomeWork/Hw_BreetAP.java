package com.cybertek.HomeWork;

import com.cybertek.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Hw_BreetAP {
    WebDriver driver;
    String userNameLocator = "//input[@id='login']";
    String passwordLocator = "//input[@id='password']";
    String LoginLocator = "//button[@class='btn btn-primary']";
    String CreateButton = "//button[@accesskey='c']";
    String evetName = "//input[@name='name']";
    String StartDate = "//input[@name='date_begin']";
    String endDate = "//input[@name='date_end']";
    String SaveButton = "//button[@accesskey='s']";
    String Takvim = "//div[@class='bootstrap-datetimepicker-widget dropdown-menu usetwentyfour top']";

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://34.220.250.213/web/login");
        WebElement usernameField = driver.findElement(By.xpath(userNameLocator));
        //Put value into the username inputbox
        usernameField.sendKeys("eventscrmmanager60@info.com");
        // find the Web element for the password inputbox
        WebElement passwordField = driver.findElement(By.xpath(passwordLocator));
        //Put value into the password inputbox
        passwordField.sendKeys("eventscrmmanager");
        // wait for 2 seconds
        SeleniumUtils.waitPlease(2);
        //find the Web element for login button and click/submit it
        driver.findElement(By.xpath(LoginLocator)).submit();
        SeleniumUtils.waitPlease(2);
    }

    //Test case 1: for this one is:User should be able to see the list the events on event module
    @Test
    public void eventManagerTest() throws IOException, ParseException {
        BreetAPPUtils.navigateToModule(driver, "Events");
        SeleniumUtils.waitPlease(3);
        WebElement pageNameElement = driver.findElement(By.className("active"));
        String expectedMessage = "Events";
        String actualMessage = pageNameElement.getText();
        //  Verify Dashboard page is open
        Assert.assertEquals(expectedMessage, actualMessage);
        System.out.println(actualMessage);
        SeleniumUtils.waitPlease(3);
       // driver.get("http://34.220.250.213/web?#view_type=kanban&model=event.event&menu_id=128&action=142");
        SeleniumUtils.waitPlease(3);
        BreetAPPUtils.takeAscreenShot("Event_page");


        //Test case 2: EventManager should be able to create a new event.
    }
       @Test

        public void eventManagerCreatingnewEvents() throws ParseException {
            BreetAPPUtils.navigateToModule(driver, "Events");
            SeleniumUtils.waitPlease(2);
            driver.findElement(By.xpath(CreateButton)).click();
            SeleniumUtils.waitPlease(4);


            WebElement eventNamefieldField = driver.findElement(By.xpath(evetName));

            eventNamefieldField.sendKeys("admin");//here I am trying to send event name
//        Actions performAct = new Actions(driver);
//        performAct.sendKeys(eventNamefieldField, "admin").build().perform();
//        //Put value into the password inputbox

            // wait for 2 seconds

            SeleniumUtils.waitPlease(4);
            driver.findElement(By.xpath(StartDate)).click();
            WebDriverWait wait = new WebDriverWait(driver, 10);//explicit olmadan code calismadi, oyuzden ekledik

            //we use this condition to wait until overlay screen will disappear
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@class='o_datepicker_input o_input']"))));
            //burda date in visible olmasini  bekliyor, cunku spinnerden sonra code aciliyor.
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='o_datepicker_input o_input']")));

            String setDate = "07/21/2019 14:36:29";
            String currentDate = driver.findElement(By.xpath("//input[@class='o_datepicker_input o_input']")).getText();
            //driver.findElement(By.xpath(Takvim)).click();

            SeleniumUtils.waitPlease(4);
            String strDateFormat = "MM/dd/yyyy a hh:mm:ss";
            Date setdate1 = new SimpleDateFormat(strDateFormat).parse(setDate);
           SeleniumUtils.waitPlease(4);
            Date crntdate = new SimpleDateFormat(" MMMM yyyy").parse(currentDate);


        }


    @AfterMethod//yeri onemli degil burda veya en sonda olabilir
    public void teardown(){
        driver.quit();
    }

}


