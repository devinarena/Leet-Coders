package com.devinarena;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
        // System.setProperty("webdriver.chrome.driver", "C:\\Users\\devin\\Documents\\chromedriver.exe");

        // LeetCoder leetCoder = LeetCoder.getInstance();
        // leetCoder.open("https://leetcode.com/problemset/all/");

        // leetCoder.dispose();

        LeetCoder leetCoder = LeetCoder.getInstance();

        String solution = "";

        try {
            solution = leetCoder.getSolution(23);
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringSelection selection = new StringSelection(solution);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        
        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 1000));

        // print the clipboard contents
        try {
            System.out.println(Toolkit.getDefaultToolkit().getSystemClipboard().getData(
                    java.awt.datatransfer.DataFlavor.stringFlavor));
        } catch (HeadlessException e) {
            e.printStackTrace();
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        leetCoder.dispose();
    }
}
