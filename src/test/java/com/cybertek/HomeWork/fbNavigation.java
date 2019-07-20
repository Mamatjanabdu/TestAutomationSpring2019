package com.cybertek.HomeWork;

import com.cybertek.Utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class fbNavigation {

    static WebDriver driver = BrowserFactory.getDriver("chrome");
    public static void main(String[] args) {
        System.out.println();
    }


    static void verifyUrlAndTitle(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get("http://www.facebook.com");
        boolean title= driver.getTitle().contains("facebook");
        boolean URL= driver.getCurrentUrl().equals("www.facebook.com");

    }

}
