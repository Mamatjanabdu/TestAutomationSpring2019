package com.cybertek.HomeWork;

import com.cybertek.Utilities.SeleniumUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class BreetAPPUtils {

    static WebDriver driver;


    private static String usernameLocator="login";
    private static String passwordLocator="password";

    public static void login(WebDriver driver, String username, String password){

        driver.findElement(By.id(usernameLocator)).sendKeys(username);
        //Keys.ENTER means click enter after entering password
        //in this way, we don't need to click login button
        driver.findElement(By.id(passwordLocator)).sendKeys(password, Keys.ENTER);
        SeleniumUtils.waitPlease(3);
    }
    public static void navigateToModule(WebDriver driver, String tab){
        String tabLocator = "//span[contains(text(),'"+tab+"') and contains(@class, 'oe_menu_text')]";
        // String moduleLocator = "//span[contains(text(),'"+module+"') and contains(@class, 'oe_menu_text')]";
        driver.findElement(By.xpath(tabLocator)).click();
        SeleniumUtils.waitPlease(3);
        //driver.findElement(By.xpath(moduleLocator)).click();
        //SeleniumUtilities1.waitPlease(2);

    }

    public static void takeAscreenShot(String Event) throws IOException {

        //Here I am taking the screenshot
        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Here I want to store it
        FileUtils.copyFile(file, new File((new File("/Users/emraypala/IdeaProjects/TestSeleniumAutomation/src/test/java/Homeworks")) + Event + ".jpg"));
    }
}


