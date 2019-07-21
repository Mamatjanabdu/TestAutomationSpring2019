package com.cybertek.HomeWork.ThursdayHomeWork;

import com.cybertek.Utilities.BrowserFactory;
import com.cybertek.Utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

class EncapsulationDemo{
    static WebDriver driver = BrowserFactory.getDriver("chrome");
    public static void main(String[] args) {
        opPage();
    }



    public static void opPage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com");
        WebElement element = driver.findElement(By.xpath("//h3[text()='Dropdown List']"));
        SeleniumUtils.waitPlease(2);

        if(element.isDisplayed() ){
            System.out.println("PASSED");
            System.out.println(element.getText()+": is visible");
            SeleniumUtils.waitPlease(2);
        }else{
            System.out.println("FAILED");
            System.out.println(element.getText()+": is not visible!");
             SeleniumUtils.waitPlease(2);
        }
    }
}
