package com.cybertek.day12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ThreadSleepAndImplicitWaitTest {

    WebDriver driver;

    String helloWorldMessage="#finish";
    String startButtonLocator="#start>button";

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        //can handle noSuchElementException within given time frame. (driver will wait up to 10 seconds,
        // not strictly 10 seconds)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");

    }

    @Test
    public void waitTest1(){

        driver.findElement(By.cssSelector(startButtonLocator)).click();
//        try{
//            Thread.sleep(8000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        String expected="Hello World!";
        String actual= driver.findElement(By.cssSelector(helloWorldMessage)).getText();
        Assert.assertEquals(expected,actual);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
