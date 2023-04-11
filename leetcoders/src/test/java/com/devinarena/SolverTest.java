package com.devinarena;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

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

    @Test(priority = 1, groups = {"solve-problem"}, dependsOnGroups = {"find-problem"})
    public void changeLanguageTest() throws InterruptedException {
        leetCoder.click(By.xpath("//*[@id=\"editor\"]/div[3]/div[1]/div[1]/div"));

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 500));

        leetCoder.click(By.xpath("/html/body/div[1]/div/div/div/div/div/div[3]/div/div[1]/div/div/div/div[3]/div[1]/div[1]/div/ul/li[4]"));

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 1000));
    }

    @Test(priority = 2, groups = {"solve-problem"}, dependsOnGroups = {"find-problem"})
    public void clearPrevious() throws InterruptedException {
        leetCoder.click(By.xpath("//*[@id=\"editor\"]/div[3]/div[2]/div/div[3]/button"));

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 1000));

        leetCoder.click(By.xpath("//*[@id=\"editor\"]/div[3]/div[2]/div/div[3]/div/div/div/div[2]/div/div[2]/div/div/div[2]/button"));

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 1000));
    }

    @Test(priority = 3, groups = {"solve-problem"}, dependsOnGroups = {"find-problem"})
    public void failProblem() throws InterruptedException {
        leetCoder.click(By.xpath("//*[@id=\"qd-content\"]/div[3]/div/div[3]/div/div/div/div/div/div[3]/button[3]"));

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 5000));

        leetCoder.click(By.xpath("//*[@id=\"qd-content\"]/div[3]/div/div[3]/div/div/div[1]/div/div[3]/div[4]"));

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 1000));
    }

    @Test(priority = 4, groups = {"solve-problem"}, dependsOnGroups = {"find-problem"})
    public void attemptSolve() throws InterruptedException, IOException {

        String solution = leetCoder.getSolution(23);

        StringSelection selection = new StringSelection(solution);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        
        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 2500));

        leetCoder.click(By.xpath("//*[@id=\"qd-content\"]/div[3]"));

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 1000));

        leetCoder.clearPrevious();

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

        leetCoder.paste();

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 1000));

        leetCoder.click(By.xpath("//*[@id=\"qd-content\"]/div[1]/div/div[3]/div/div/div[3]/div/div/div[3]/button[3]"));

        Thread.sleep((long) (LeetCoder.TIME_FACTOR * 5000));
    }

    @AfterTest
    public void tearDown() {
        leetCoder.dispose();
    }

}
