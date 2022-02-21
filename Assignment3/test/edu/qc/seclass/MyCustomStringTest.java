package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers2() {
        mycustomstring.setString("");
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers3() {
        mycustomstring.setString("I'd b3tt3r 324234.23423 put s0me d16.1ts in this 5tr1n6, right?");
        assertEquals(10, mycustomstring.countNumbers());
    }

    @Test(expected = NullPointerException.class)
    public void testCountNumbers4() {
        assertEquals("string is null", mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers5() {
        mycustomstring.setString("Today is 9-17-20"); // fixed issue with index out of bound
        assertEquals(3, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers6() {
        mycustomstring.setString("AAAAAAA");
        assertEquals(0, mycustomstring.countNumbers());
    }


    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
        mycustomstring.setString("");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
        mycustomstring.setString("");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
        mycustomstring.setString("I");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
        mycustomstring.setString("I");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("n can't be 0 or less", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("n can't be 0 or less", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-4, false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("n can't be 0 or less", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("n can't be 0 or less", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-3, true));
    }

    @Test(expected = NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
        assertEquals("String is null and \"n\" is greater than zero", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test(expected = NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
        assertEquals("String is null and \"n\" is greater than zero", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1/2, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
        mycustomstring.setString("A");
        assertEquals("A", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));
    }


    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString("7");
        mycustomstring.convertDigitsToNamesInSubstring(1, 1);
        assertEquals("Seven", mycustomstring.getString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring3() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(23, 17);
        assertEquals("startPosition can't be greater than endPosition", mycustomstring.getString());
    }

    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring4() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(-3, 23);
        assertEquals("startPosition or endPosition less than 1 or greater than string length", mycustomstring.getString());
    }

    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring5() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 245);
        assertEquals("startPosition or endPosition less than 1 or greater than string length", mycustomstring.getString());
    }

    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring6() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(-7, 245);
        assertEquals("startPosition or endPosition less than 1 or greater than string length", mycustomstring.getString());
    }

    @Test(expected = NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring7() {
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("Current string is null", mycustomstring.getString());
    }

    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring8() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(200, 245);
        assertEquals("startPosition or endPosition less than 1 or greater than string length", mycustomstring.getString());
    }

}
