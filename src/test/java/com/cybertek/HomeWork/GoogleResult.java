package com.cybertek.HomeWork;

import com.cybertek.Utilities.BrowserFactory;
import com.cybertek.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleResult {


    public static void main(String[] args) throws Exception {
        WebDriver driver= BrowserFactory.getDriver("chrome");

        checkJava();
       checkJUnit();
        RESTAssured();

    }

    public static void checkJava() throws Exception{


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
         Thread.sleep(2000);
         driver.get("http://google.com");
         WebElement searchWord=driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
         searchWord.sendKeys("Java"+Keys.ENTER);
         Thread.sleep(2000);

      //   List <String> searchStrs= Arrays.asList("Java","JUnit","REST Assured");


            WebElement element1= driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/div/cite"));
            String expected=element1.getText();



            WebElement element2 =  driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/h3"));
            element2.click();
            driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
            String actualB= driver.getCurrentUrl();
            String actual=actualB.substring(0,actualB.length()-3);
            System.out.println(actual);
            SeleniumUtils.verifyEquals(expected,actual);
            Thread.sleep(2000);
            driver.navigate().back();
            driver.close();



        }

    public static void checkJUnit() throws Exception{


        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get("http://google.com");
        WebElement searchWord=driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
        searchWord.sendKeys("JUnit"+Keys.ENTER);
        Thread.sleep(2000);

        //   List <String> searchStrs= Arrays.asList("Java","JUnit","REST Assured");


        WebElement element1= driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div/div[1]/a/div/cite"));
        String expected=element1.getText();



        WebElement element2 =  driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div/div[1]/a/h3"));
        element2.click();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        String actual= driver.getCurrentUrl();

        System.out.println(actual);
        SeleniumUtils.verifyEquals(expected,actual);
        Thread.sleep(2000);
        driver.navigate().back();
        driver.close();


    }

    public static void RESTAssured() throws Exception{


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get("http://google.com");

        WebElement searchWord=driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
        searchWord.sendKeys("REST Assured"+Keys.ENTER);
        Thread.sleep(2000);

        //   List <String> searchStrs= Arrays.asList("Java","JUnit","REST Assured");


        WebElement element1= driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div/div[1]/a/div/cite"));
        String expected=element1.getText();

        WebElement element2 =  driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div/div[1]/a/h3"));

        element2.click();
        driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        String actual= driver.getCurrentUrl();

        boolean result=actual.contains(expected);
        System.out.println(result);
        Thread.sleep(2000);
        driver.navigate().back();
        driver.close();


    }
}

