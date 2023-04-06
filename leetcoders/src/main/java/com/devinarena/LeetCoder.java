package com.devinarena;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
            // TODO: For now just throw an exception to fail the test
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

    public String getSolution(int problem) {
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("solutions", "problem" + problem + ".txt")));

            String line = null;
            while ((line = br.readLine()) != null) {
                builder.append(line);
                builder.append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString().trim();
    }

    public void clearPrevious() {
        getElement(By.xpath("//*[@id=\"editor\"]/div[4]/div[1]/div/div/div[1]/textarea")).clear();
    }

    public void dispose() {
        driver.quit();
        leetCoder = null;
    }

}
