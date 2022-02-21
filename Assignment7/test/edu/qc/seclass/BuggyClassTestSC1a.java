package edu.qc.seclass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuggyClassTestSC1a {

    // Achieves 100% statement coverage of buggyMethod1 and not reveal the fault therein
    @Test
    public void buggyMethod1() {
        assertEquals(1, BuggyClass.buggyMethod1(3, 3));
        assertEquals(3, BuggyClass.buggyMethod1(3, 9));
        assertEquals(3, BuggyClass.buggyMethod1(9, 3));
    }
}
