package edu.qc.seclass;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuggyClassTestBC3 {
    // Achieves 100% branch coverage of buggyMethod3 and not reveal the fault therein
    @Test
    public void buggyMethod3() {
        assertEquals(30, BuggyClass.buggyMethod3(60));
        assertEquals(1, BuggyClass.buggyMethod3(25));
        assertEquals(10, BuggyClass.buggyMethod3(10));
    }
}
