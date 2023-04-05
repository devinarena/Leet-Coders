package com.devinarena;

import org.testng.annotations.Test;

public class NavigateTest {
    
    @Test
    public void navigateTest() {
        LeetCoder leetCoder = new LeetCoder();
        leetCoder.open("https://leetcode.com/problemset/all/");
    }

}
