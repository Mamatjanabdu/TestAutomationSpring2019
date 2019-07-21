package com.cybertek.day15_review;

import com.cybertek.Day4.TestBase;
import com.cybertek.Utilities.ConfigurationReader;
import com.cybertek.Utilities.VYTrackUtils;
import com.cybertek.pages.vytrack.CalendarEventsPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CalendarEventTests extends TestBase {

    //BeforeMethod is coming from TestBase
    CalendarEventsPage calendarPage = new CalendarEventsPage();

    @Test
    public void verifyRepeatOptions() {
        //we are reading username from .properties file
        String username = ConfigurationReader.getProperty("storemanagerusername");
        //we are reading password from .properties file
        String password = ConfigurationReader.getProperty("storemanagerpassword");

        VYTrackUtils.login(driver, username, password); //login

        //go to Calendar Events
        VYTrackUtils.navigateToModule(driver, "Activities", "Calendar Events");
        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarPage.createCalendarEventBtnLocator)).click();
        VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
        driver.findElement(By.cssSelector(calendarPage.repeatCheckBoxLocator)).click();

        List<String> expectedOptions = Arrays.asList("Daily", "Weekly", "Monthly","Yearly");
        List<String> actualOptions = calendarPage.getRepeatOptions();
        System.out.println(actualOptions);
        System.out.println(expectedOptions);

        Assert.assertEquals(actualOptions, expectedOptions);


        //AfterMethod id coming from TestBase
    }}
