package org.minions.devfund.sergio;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SquarelotronTest {

    private StringBuilder test = new StringBuilder();
    private Squarelotron squarelotron;

    @Test
    public void testSetValuesForSize2x2() {
        squarelotron = new Squarelotron(2);
        test.append("01 02").append("\n")
            .append("03 04");
        assertEquals(squarelotron.showSquare(squarelotron), test.toString().trim());
    }

    @Test
    public void testSetValuesForSize5x5() {
        squarelotron = new Squarelotron(5);
        test.append("01 02 03 04 05").append("\n")
            .append("06 07 08 09 10").append("\n")
            .append("11 12 13 14 15").append("\n")
            .append("16 17 18 19 20").append("\n")
            .append("21 22 23 24 25");
        assertEquals(squarelotron.showSquare(squarelotron), test.toString().trim());
    }

    @Test
    public void testGetNumberOfRingsInA4x4Square() {
        squarelotron = new Squarelotron(4);
        int ringsExpected = 2;
        assertEquals(squarelotron.getNumberOfRings(), ringsExpected);
    }

    @Test
    public void testGetNumberOfRingsInA5x5Square() {
        squarelotron = new Squarelotron(5);
        int ringsExpected = 3;
        assertEquals(squarelotron.getNumberOfRings(), ringsExpected);
    }

    @Test
    public void testRingCheckTrueInA3x3Square() {
        squarelotron = new Squarelotron(3);
        assertTrue(squarelotron.ringCheck(1, 1,2));
    }

    @Test
    public void testRingCheckFalseInA4x4Square() {
        squarelotron = new Squarelotron(4);
        assertFalse(squarelotron.ringCheck(0,0,2));
    }

    @Test
    public void testUpsideDownFlipInA5x5SquareRingOne() {
        squarelotron = new Squarelotron(5);
        test.append("21 22 23 24 25").append("\n")
            .append("16 07 08 09 20").append("\n")
            .append("11 12 13 14 15").append("\n")
            .append("06 17 18 19 10").append("\n")
            .append("01 02 03 04 05");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.upsideDownFlip(1)));
    }

    @Test
    public void testUpsideDownFlipInA6x6SquareRingTwo() {
        squarelotron = new Squarelotron(6);
        test.append("01 02 03 04 05 06").append("\n")
            .append("07 26 27 28 29 12").append("\n")
            .append("13 20 15 16 23 18").append("\n")
            .append("19 14 21 22 17 24").append("\n")
            .append("25 08 09 10 11 30").append("\n")
            .append("31 32 33 34 35 36");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.upsideDownFlip(2)));
    }

    @Test
    public void testUpsideDownFlipIn6x6SquareRingThree() {
        squarelotron = new Squarelotron(6);
        test.append("01 02 03 04 05 06").append("\n")
            .append("07 08 09 10 11 12").append("\n")
            .append("13 14 21 22 17 18").append("\n")
            .append("19 20 15 16 23 24").append("\n")
            .append("25 26 27 28 29 30").append("\n")
            .append("31 32 33 34 35 36");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.upsideDownFlip(3)));
    }

    @Test
    public void testMainDiagonalFlipIn2x2SquareRingOne() {
        squarelotron = new Squarelotron(2);
        test.append("01 03").append("\n")
            .append("02 04");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.mainDiagonalFlip(1)));
    }

    @Test
    public void testMainDiagonalFlipIn6x6SquareRingOne() {
        squarelotron = new Squarelotron(6);
        test.append("01 07 13 19 25 31").append("\n")
            .append("02 08 09 10 11 32").append("\n")
            .append("03 14 15 16 17 33").append("\n")
            .append("04 20 21 22 23 34").append("\n")
            .append("05 26 27 28 29 35").append("\n")
            .append("06 12 18 24 30 36");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.mainDiagonalFlip(1)));
    }

    @Test
    public void testMainDiagonalFlipIn4x4RingTwo() {
        squarelotron = new Squarelotron(4);
        test.append("01 02 03 04").append("\n")
            .append("05 06 10 08").append("\n")
            .append("09 07 11 12").append("\n")
            .append("13 14 15 16");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.mainDiagonalFlip(2)));
    }

    @Test
    public void testRotateEastIn2x2OneTurn() {
        squarelotron = new Squarelotron(2);
        test.append("03 01").append("\n")
            .append("04 02");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.rotateEast(1)));
    }

}
