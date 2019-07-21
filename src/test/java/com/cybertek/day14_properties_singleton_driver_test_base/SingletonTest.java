package com.cybertek.day14_properties_singleton_driver_test_base;

import com.cybertek.Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {


    @Test
    public void test(){
        String str1 = Singleton.getInstance();

        String str2 = Singleton.getInstance();

        Singleton.getInstance();
        Singleton.getInstance();
        Singleton.getInstance();

        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);

    }

    @Test
    public void test1(){
        // Driver.get() --> open a new browser if there is not browser and return it
        WebDriver driver = Driver.getDriver();

        driver.get("https://google.com");

    }

    @Test
    public void test2(){

        Driver.getDriver().get("https://amazon.com");
        String title = Driver.getDriver().getTitle();

        System.out.println(title);
    }
}

