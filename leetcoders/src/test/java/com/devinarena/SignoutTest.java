package com.devinarena;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SignoutTest {
    
    private LeetCoder leetCoder;
    
    public SignoutTest() {
        leetCoder = LeetCoder.getInstance();
    }

    @Test(priority = 1, dependsOnGroups = {"solve-problem"})
    public void signoutTest() throws InterruptedException {

        leetCoder.click(By.xpath("//*[@id=\"__next\"]/div/div/div/nav/div/div/div[3]/div[3]"));

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 1000));

        leetCoder.click(By.linkText("Sign Out"));

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 5000));
    }

    @AfterTest
    public void tearDown() {
        leetCoder.dispose();
    }

}
