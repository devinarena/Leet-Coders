package com.devinarena;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeetCoder {
    
    private WebDriver driver;

    public LeetCoder() {
        driver = new ChromeDriver();
    }

    public void open(String url) {
        driver.get(url);
    }

}
