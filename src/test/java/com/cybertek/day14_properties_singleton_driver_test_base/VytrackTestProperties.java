package com.cybertek.day14_properties_singleton_driver_test_base;

import com.cybertek.Utilities.ConfigurationReader;
import com.cybertek.Utilities.VYTrackUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VytrackTestProperties {


    @Test
    public void loginTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String url = ConfigurationReader.getProperty("url");

        driver.get(url);

        String username = ConfigurationReader.getProperty("salesmanager_username");
        String password = ConfigurationReader.getProperty("salesmanager_password");

        VYTrackUtils.login(driver, username, password);

    }
}