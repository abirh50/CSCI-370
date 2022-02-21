package edu.qc.seclass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuggyClassTestSC1b {

    // Achieves less than 50% statement coverage of buggyMethod1 and reveal the fault therein
    @Test
    public void buggyMethod1() {
        assertEquals(0, BuggyClass.buggyMethod1(0, 3));
    }
}
