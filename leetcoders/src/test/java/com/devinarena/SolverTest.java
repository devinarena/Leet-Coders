package com.devinarena;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SolverTest {
    
    private LeetCoder leetCoder;

    @BeforeTest
    public void setUp() {
        leetCoder = LeetCoder.getInstance();
    }

    @Test(priority = 1, dependsOnGroups = {"find-problem"})
    public void clearPrevious() throws InterruptedException {
        leetCoder.clearPrevious();

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 1000));
    }


    @Test(priority = 2, dependsOnGroups = {"find-problem"})
    public void attemptSolve() throws InterruptedException {
        String solution = leetCoder.getSolution(23);
        leetCoder.type(By.xpath("//*[@id=\"editor\"]/div[4]/div[1]/div/div/div[1]/textarea"), solution);

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 2500));
    }

    @AfterTest
    public void tearDown() {
        leetCoder.dispose();
    }

}
