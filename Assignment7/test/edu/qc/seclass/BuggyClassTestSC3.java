package edu.qc.seclass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuggyClassTestSC3 {
    // Achieves 100% statement coverage, does not achieve 100% branch coverage, and reveals the fault of buggyMethod3
    @Test
    public void buggyMethod3() {
        assertEquals(30, BuggyClass.buggyMethod3(60));
        assertEquals(0, BuggyClass.buggyMethod3(7));
    }
}
