package com.devinarena;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * A singleton class that allows us to interact with the LeetCode website.
 */
public class LeetCoder {

    public static float TIME_FACTOR = 1.0f;

    static LeetCoder leetCoder;

    static LeetCoder getInstance() {
        if (leetCoder == null) {
            leetCoder = new LeetCoder();
        }
        return leetCoder;
    }

    private WebDriver driver;

    public LeetCoder() {
        driver = new ChromeDriver();
    }

    private WebElement getElement(By locator) {
        WebElement el = driver.findElement(locator);

        if (el == null) {
            throw new RuntimeException("Element not found: " + locator.toString());
        }

        return el;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void click(By locator) {
        getElement(locator).click();
    }

    public void type(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    public String getSolution(int problem) throws IOException {
        StringBuilder builder = new StringBuilder();

        BufferedReader br = new BufferedReader(new FileReader(new File("solutions", String.valueOf(problem))));

        String line = null;
        while ((line = br.readLine()) != null) {
            builder.append(line);
            builder.append(System.lineSeparator());
        }

        br.close();

        return builder.toString().trim();
    }

    public void clearPrevious() {
        new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        new Actions(driver).sendKeys(Keys.DELETE).perform();
    }

    public void paste() {
        new Actions(driver).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
    }

    public void submit() {
        new Actions(driver).keyDown(Keys.CONTROL).sendKeys("enter").keyUp(Keys.CONTROL).perform();
    }

    public void takeScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        src.renameTo(new File("output", "screenshot.png"));
    }

    public String getLanguageXPath(String language) {
        if (language.equalsIgnoreCase("C++")) {
            return "/html/body/div[1]/div/div/div/div/div/div[3]/div/div/div/div/div/div[3]/div[1]/div[1]/div/ul/li[1]";
        } else if (language.equalsIgnoreCase("python")) {
            return "/html/body/div[1]/div/div/div/div/div/div[3]/div/div[1]/div/div/div/div[3]/div[1]/div[1]/div/ul/li[4]";
        } else if (language.equalsIgnoreCase("java")) {
            return "/html/body/div[1]/div/div/div/div/div/div[3]/div/div/div/div/div/div[3]/div[1]/div[1]/div/ul/li[2]";
        }

        return "";
    }

    public void dispose() {
        driver.quit();
        leetCoder = null;
    }

}
