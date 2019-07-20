package com.cybertek.HomeWork;

import com.cybertek.Utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EtsySearchTest {


    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://ebay.com");
        WebElement searchBar= driver.findElement(By.xpath("//*[@id='gh-ac']"));
        searchBar.sendKeys("wooden spoon"+ Keys.ENTER);
        WebElement element=driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));

        String str=element.getText();
        String num=str.substring(0, (str.indexOf(" "))   );
        int FristNumber =Integer.parseInt(num);


        WebElement allClick=driver.findElement(By.xpath("//span[text()='All']"));
        allClick.click();
        String allNumber=allClick.getText();
        String seNum=str.substring(0, (str.indexOf(" "))   );
        int seconNUM =Integer.parseInt(seNum);
        if(seconNUM>FristNumber){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

        driver.navigate().back();



//        Integer allNumberInt=Integer.parseInt(allNumber);
//
//        if (i<allNumberInt){
//            System.out.println(true);
//        }else {
//            System.out.println(false);
//        }
//
//        driver.navigate().back();
//        //SeleniumUtils.verifyIsDisplayed("wooden spoon");
    }

}

