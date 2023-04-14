package com.devinarena;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NavigateTest {

    private LeetCoder leetCoder;

    // This will end up on GitHub, but its a dummy account
    // and will be deleted after the project is done
    private final String USERNAME = "swtesting-devinarena";
    private final String PASSWORD = "l33tc0der5";

    @BeforeTest
    public void setUp() {
        leetCoder = LeetCoder.getInstance();
    }

    @Test(priority = 1, groups = {"login", "find-problem"})
    public void navigateTest() throws InterruptedException {
        leetCoder.maximize();
        leetCoder.open("https://leetcode.com/");

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 1000));

        leetCoder.click(By.linkText("Sign in"));

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 1000));
    }

    @Test(priority = 2, groups = {"login", "find-problem"})
    public void loginTest() throws InterruptedException {
        leetCoder.type(By.id("id_login"), USERNAME);
        leetCoder.type(By.id("id_password"), PASSWORD);

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 60000));

        leetCoder.click(By.id("signin_btn"));

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 3000));
    }

    @Test(priority = 3, groups = {"find-problem"})
    @Parameters("problemName")
    public void findProblemTest(String problemName) throws InterruptedException {
        leetCoder.click(By.linkText("Problems"));

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 1000));

        leetCoder.type(
                By.cssSelector("input[placeholder='Search questions']"),
                problemName);

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 2500 ));

        leetCoder.click(By.linkText(problemName));

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 2500));
    }

}
