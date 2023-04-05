package com.devinarena;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\devin\\Documents\\chromedriver.exe");

        LeetCoder leetCoder = new LeetCoder();
        leetCoder.open("https://leetcode.com/problemset/all/");

        leetCoder.dispose();
    }
}
