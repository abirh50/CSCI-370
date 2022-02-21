package edu.qc.seclass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuggyClassTestBC2 {
    // Achieves more than 50% branch coverage of buggyMethod2 and reveal the fault therein
    @Test
    public void buggyMethod2() {
        assertEquals(1, BuggyClass.buggyMethod2(3, 3));
        assertEquals(3, BuggyClass.buggyMethod2(9, 3));
        assertEquals(5, BuggyClass.buggyMethod2(5, 25));
        assertEquals(0, BuggyClass.buggyMethod2(3, 0));
    }
}
