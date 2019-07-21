package com.cybertek.Day4;


    import com.cybertek.Utilities.ConfigurationReader;
import com.cybertek.Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
    import org.testng.annotations.BeforeClass;

    import java.util.concurrent.TimeUnit;

    public class TestBase {

        protected WebDriver driver;
        protected Actions actions;
        protected WebDriverWait wait;

        @BeforeClass
        public void setUpMethod() throws InterruptedException {
            driver = Driver.getDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            actions = new Actions(driver);

            driver.get(ConfigurationReader.getProperty("url"));

        }

        @AfterClass
        public void tearDownMethod(){
            Driver.closeDriver();
        }


    }

