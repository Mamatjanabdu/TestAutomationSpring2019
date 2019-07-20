package com.cybertek.HomeWork;

import com.cybertek.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VytrackTitleTest {

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();

        driver.get("http://qa2.vytrack.com/user/login");
        Thread.sleep(3000);

        WebElement name = driver.findElement(By.name("_username"));
        name.sendKeys("User188"+ Keys.ENTER);

        WebElement passWord = driver.findElement(By.name("_password"));
        passWord.sendKeys("UserUser123"+Keys.ENTER);
        Thread.sleep(2000);

       WebElement fristName= driver.findElement(By.xpath("//a[@class='dropdown-toggle']"));
        SeleniumUtils.waitPlease(2);
      fristName.click();

      WebElement configElement= driver.findElement(By.xpath("//a[text()='My Configuration']"));
      configElement.click();
        SeleniumUtils.waitPlease(2);

      if(driver.getTitle().contains(fristName.getText())){
          System.out.println(true);
      }else {
          System.out.println(false);
      }




    }
}
