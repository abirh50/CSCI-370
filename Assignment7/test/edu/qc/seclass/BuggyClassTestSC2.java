package edu.qc.seclass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuggyClassTestSC2 {
    // Achieves 100% statement coverage of buggyMethod2 and not reveal the fault therein
    @Test
    public void buggyMethod2() {
        assertEquals(1, BuggyClass.buggyMethod2(3, 3));
        assertEquals(3, BuggyClass.buggyMethod2(3, 9));
        assertEquals(3, BuggyClass.buggyMethod2(9, 3));
    }
}
