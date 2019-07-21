package com.cybertek.day14_properties_singleton_driver_test_base;


import com.cybertek.Utilities.TestBase;
import org.testng.annotations.Test;

public class UsesTestBaseTest2 extends TestBase {

        @Test
        public void test1(){
            driver.get("https://cybertekschool.com");
            System.out.println(driver.getTitle());
        }



    }


