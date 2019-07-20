package com.cybertek.HomeWork;

import com.cybertek.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class VytrackShortcutFunctionality {


    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://qa2.vytrack.com/user/login");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        driver.findElement(By.name("_username")).sendKeys("User188" + Keys.ENTER);
        //name.sendKeys("User188" + Keys.ENTER);

        driver.findElement(By.name("_password")).sendKeys("UserUser123" + Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        Assert.assertEquals(driver.getTitle(),"Dashboard");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        //click on shortcut icon
        driver.findElement(By.xpath("//i[@class='fa-share-square']")).click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        //click on link see full list
        driver.findElement(By.xpath("//a[@href='/shortcutactionslist']")).click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        // click on link Opportunities
        driver.findElement(By.xpath("//a[contains(text(),'By Opportunities')]")).click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        Assert.assertEquals(driver.getCurrentUrl(),("http://qa2.vytrack.com/report/static/accounts/by_opportunities"));

        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//i[@class='fa-share-square']")).click();

        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[@href='/shortcutactionslist']")).click();

        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(text(),'Vehicle Services Logs')]")).click();

        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        WebElement ee=driver.findElement(By.name("You do not have permission to perform this action."));
        Assert.assertEquals(ee.getText(),("You do not have permission to perform this action."));

driver.close();

    }
}
