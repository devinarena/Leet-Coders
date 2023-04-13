package com.devinarena;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignoutTest {
    
    private LeetCoder leetCoder;
    
    

    @BeforeClass
    public void setUp() {
        leetCoder = LeetCoder.getInstance();
    }

    @Test(priority = 1, dependsOnGroups = {"solve-problem"})
    public void signoutTest() throws InterruptedException {

        leetCoder.click(By.xpath("//*[@id=\"__next\"]/div/div/div/nav/div/div/div[3]/div[3]"));

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 1000));

        leetCoder.click(By.linkText("Sign Out"));

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 5000));
    }

    @AfterClass
    public void tearDown() {
        leetCoder.dispose();
    }

}
