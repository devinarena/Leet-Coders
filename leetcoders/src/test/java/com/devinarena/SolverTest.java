package com.devinarena;

import org.testng.annotations.Test;

public class SolverTest {
    
    private LeetCoder leetCoder;

    public SolverTest() {
        leetCoder = LeetCoder.getInstance();
    }

    @Test(priority = 1, dependsOnGroups = {"find-problem"})
    public void exitTest() {
        leetCoder.dispose();
    }

}
