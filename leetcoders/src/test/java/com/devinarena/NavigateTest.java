package com.devinarena;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NavigateTest {

    private LeetCoder leetCoder;
    private final float TIME_FACTOR = 1.0f;

    // This will end up on GitHub, but its a dummy account
    // and will be deleted after the project is done
    private final String USERNAME = "swtesting-devinarena";
    private final String PASSWORD = "l33tc0der5";

    public NavigateTest() {
        leetCoder = new LeetCoder();
    }

    @Test(priority = 1)
    public void navigateTest() throws InterruptedException {
        leetCoder.maximize();
        leetCoder.open("https://leetcode.com/");

        Thread.sleep((long) (TIME_FACTOR * 1000));

        leetCoder.click(By.linkText("Sign in"));

        Thread.sleep((long) (TIME_FACTOR * 1000));
    }

    @Test(priority = 2)
    public void loginTest() throws InterruptedException {
        leetCoder.type(By.id("id_login"), USERNAME);
        leetCoder.type(By.id("id_password"), PASSWORD);

        Thread.sleep((long) (TIME_FACTOR * 1000));

        leetCoder.click(By.id("signin_btn"));

        Thread.sleep((long) (TIME_FACTOR * 2500));
    }

    @Test(priority = 3)
    public void findProblemTest() throws InterruptedException {
        leetCoder.click(By.linkText("Problems"));

        Thread.sleep((long) (TIME_FACTOR * 1000));

        leetCoder.type(
                By.cssSelector("input[placeholder='Search questions']"),
                "Merge k Sorted Lists");

        Thread.sleep((long) (TIME_FACTOR * 2500 ));

        leetCoder.click(By.partialLinkText("Merge k Sorted"));

        Thread.sleep((long) (TIME_FACTOR * 2500));
    }

    @Test(priority = 4)
    public void exitTest() {
        leetCoder.dispose();
    }

}
