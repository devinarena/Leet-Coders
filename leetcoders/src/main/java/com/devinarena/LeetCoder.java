package com.devinarena;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeetCoder {
    
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

    public void dispose() {
        driver.quit();
    }

}
