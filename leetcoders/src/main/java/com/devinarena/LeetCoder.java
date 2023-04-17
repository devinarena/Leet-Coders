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

    /**
     * Returns the singleton instance of the LeetCoder class.
     */
    static LeetCoder getInstance() {
        if (leetCoder == null) {
            leetCoder = new LeetCoder();
        }
        return leetCoder;
    }

    private WebDriver driver;

    /**
     * Private constructor to prevent instantiation.
     */
    private LeetCoder() {
        driver = new ChromeDriver();
    }

    /**
     * Finds the element with the given locator and returns it. If the element is
     * not
     * found, a RuntimeException is thrown.
     * 
     * @param locator The locator of the element to find.
     * @return The element with the given locator.
     */
    private WebElement getElement(By locator) {
        WebElement el = driver.findElement(locator);

        if (el == null) {
            throw new RuntimeException("Element not found: " + locator.toString());
        }

        return el;
    }

    /**
     * Opens the given url in the browser.
     * 
     * @param url
     */
    public void open(String url) {
        driver.get(url);
    }

    /**
     * Maximizes the browser window.
     */
    public void maximize() {
        driver.manage().window().maximize();
    }

    /**
     * Clicks on a specific element.
     * 
     * @param locator The locator of the element to click.
     */
    public void click(By locator) {
        getElement(locator).click();
    }

    /**
     * Enters text into a specific element.
     * 
     * @param locator The locator of the element to enter text into.
     * @param text    The text to enter.
     */
    public void type(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    /**
     * Reads a solution file for a specific problem number.
     * 
     * @param problem The problem number.
     * @return The solution for the given problem number.
     * @throws IOException If the solution file cannot be read.
     */
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

    /**
     * CTRL+A and then deletes the text in the current text field.
     */
    public void clearPrevious() {
        new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        new Actions(driver).sendKeys(Keys.DELETE).perform();
    }

    /**
     * Pastes text from the clipboard.
     */
    public void paste() {
        new Actions(driver).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
    }

    /**
     * Submits the current code.
     */
    public void submit() {
        new Actions(driver).keyDown(Keys.CONTROL).sendKeys("enter").keyUp(Keys.CONTROL).perform();
    }

    /**
     * Takes a screenshot of the current page.
     */
    public void takeScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        src.renameTo(new File("output", "screenshot.png"));
    }

    /**
     * Returns the xpath for the given language.
     * 
     * @param language The language to get the xpath for.
     * @return The xpath for the given language.
     */
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

    /**
     * Disposes of the LeetCoder instance.
     */
    public void dispose() {
        driver.quit();
        leetCoder = null;
    }

}
