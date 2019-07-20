package com.cybertek.HomeWork;

import com.cybertek.Utilities.BrowserFactory;
import com.cybertek.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DeselectPractice {

    static WebDriver driver = BrowserFactory.getDriver("chrome");

    public static void main(String[] args) {
//        deselectAll();
//deselectByIndex();
//deselectByValue();
//deselectByVisibleText();
isMultiple();

    }


    public static void deselectAll() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        SeleniumUtils.waitPlease(2);

        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropdownState);
        dropDownSelect.deselectAll();
//        String expected = "Select a State";
//        String actual = dropdownState.getText();
//        SeleniumUtils.verifyEquals(actual,expected);
    }


    public static void deselectByIndex() {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        SeleniumUtils.waitPlease(2);

        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropdownState);
        dropDownSelect.deselectByIndex(2);

    }

    public static void deselectByValue() {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        SeleniumUtils.waitPlease(2);

        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropdownState);
        dropDownSelect.deselectByValue("Viginia");

    }

    public static void deselectByVisibleText() {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        SeleniumUtils.waitPlease(2);

        WebElement dropdownState = driver.findElement(By.id("state"));
        Select dropDownSelect = new Select(dropdownState);
        dropDownSelect.deselectByVisibleText("Viginia");

    }

    public static void isMultiple() {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
        SeleniumUtils.waitPlease(2);

        WebElement multipleSelectionWebElement = driver.findElement(By.xpath("//select[@name='Languages']"));
        Select multipleSelectionSelect = new Select(multipleSelectionWebElement);

        SeleniumUtils.waitPlease(2);
        multipleSelectionSelect.selectByVisibleText("Java");
        SeleniumUtils.waitPlease(2);
        multipleSelectionSelect.isMultiple();


    }
}