package org.minions.devfund.sergio;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test methods for Squarelotron.
 *
 * @author Sergio Navarro
 * @since 4/20/2018
 */
public class SquarelotronTest {

    private StringBuilder test = new StringBuilder();
    private Squarelotron squarelotron;

    /**
     * Tests the values in the square of 2x2.
     */
    @Test
    public void testSetValuesForSize2x2() {
        final int size = 2;
        squarelotron = new Squarelotron(size);
        test.append("01 02").append("\n")
                .append("03 04");
        assertEquals(squarelotron.showSquare(squarelotron.getOriginalSquareArray()), test.toString().trim());
    }

    /**
     * Tests the values in the square of 5x5.
     */
    @Test
    public void testSetValuesForSize5x5() {
        final int size = 5;
        squarelotron = new Squarelotron(size);
        test.append("01 02 03 04 05").append("\n")
                .append("06 07 08 09 10").append("\n")
                .append("11 12 13 14 15").append("\n")
                .append("16 17 18 19 20").append("\n")
                .append("21 22 23 24 25");
        assertEquals(squarelotron.showSquare(squarelotron.getOriginalSquareArray()), test.toString().trim());
    }

    /**
     * Tests the values in the square of 4x4.
     */
    @Test
    public void testGetNumberOfRingsInA4x4Square() {
        final int size = 4;
        squarelotron = new Squarelotron(size);
        final int ringsExpected = 2;
        assertEquals(squarelotron.getNumberOfRings(), ringsExpected);
    }

    /**
     * Tests the values in the square of 5x5.
     */
    @Test
    public void testGetNumberOfRingsInA5x5Square() {
        final int size = 5;
        squarelotron = new Squarelotron(size);
        final int ringsExpected = 3;
        assertEquals(squarelotron.getNumberOfRings(), ringsExpected);
    }

    /**
     * Tests the values in the square of 3x3.
     */
    @Test
    public void testRingCheckTrueInA3x3Square() {
        final int size = 3;
        squarelotron = new Squarelotron(size);
        assertTrue(squarelotron.ringCheck(1, 1, 2));
    }

    /**
     * Tests the values in the square of 4x4.
     */
    @Test
    public void testRingCheckFalseInA4x4Square() {
        final int size = 4;
        squarelotron = new Squarelotron(size);
        assertFalse(squarelotron.ringCheck(0, 0, 2));
    }

    /**
     * Tests the values in the square of 5x5.
     */
    @Test
    public void testUpsideDownFlipInA5x5SquareRingOne() {
        final int size = 5;
        squarelotron = new Squarelotron(size);
        test.append("21 22 23 24 25").append("\n")
                .append("16 07 08 09 20").append("\n")
                .append("11 12 13 14 15").append("\n")
                .append("06 17 18 19 10").append("\n")
                .append("01 02 03 04 05");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.upsideDownFlip(1)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 6x6.
     */
    @Test
    public void testUpsideDownFlipInA6x6SquareRingTwo() {
        final int size = 6;
        squarelotron = new Squarelotron(size);
        test.append("01 02 03 04 05 06").append("\n")
                .append("07 26 27 28 29 12").append("\n")
                .append("13 20 15 16 23 18").append("\n")
                .append("19 14 21 22 17 24").append("\n")
                .append("25 08 09 10 11 30").append("\n")
                .append("31 32 33 34 35 36");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.upsideDownFlip(2)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 6x6.
     */
    @Test
    public void testUpsideDownFlipIn6x6SquareRingThree() {
        final int size = 6;
        final int ring = 3;
        squarelotron = new Squarelotron(size);
        test.append("01 02 03 04 05 06").append("\n")
                .append("07 08 09 10 11 12").append("\n")
                .append("13 14 21 22 17 18").append("\n")
                .append("19 20 15 16 23 24").append("\n")
                .append("25 26 27 28 29 30").append("\n")
                .append("31 32 33 34 35 36");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.upsideDownFlip(ring)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values of the processed square of the method upsideDownFlip.
     */
    @Test
    public void testUpsideDownFlipInOverCharge() {
        final int size = 5;
        squarelotron = new Squarelotron(size);
        test.append("21 22 23 24 25").append("\n")
                .append("16 07 08 09 20").append("\n")
                .append("11 12 13 14 15").append("\n")
                .append("06 17 18 19 10").append("\n")
                .append("01 02 03 04 05");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.upsideDownFlip(1)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 2x2.
     */
    @Test
    public void testMainDiagonalFlipIn2x2SquareRingOne() {
        final int size = 2;
        squarelotron = new Squarelotron(size);
        test.append("01 03").append("\n")
                .append("02 04");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.mainDiagonalFlip(1)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 6x6.
     */
    @Test
    public void testMainDiagonalFlipIn6x6SquareRingOne() {
        final int size = 6;
        squarelotron = new Squarelotron(size);
        test.append("01 07 13 19 25 31").append("\n")
                .append("02 08 09 10 11 32").append("\n")
                .append("03 14 15 16 17 33").append("\n")
                .append("04 20 21 22 23 34").append("\n")
                .append("05 26 27 28 29 35").append("\n")
                .append("06 12 18 24 30 36");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.mainDiagonalFlip(1)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 4x4.
     */
    @Test
    public void testMainDiagonalFlipIn4x4RingTwo() {
        final int size = 4;
        squarelotron = new Squarelotron(size);
        test.append("01 02 03 04").append("\n")
                .append("05 06 10 08").append("\n")
                .append("09 07 11 12").append("\n")
                .append("13 14 15 16");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.mainDiagonalFlip(2)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values of the processed square of the method mainDiagonalFlip.
     */
    @Test
    public void testMainDiagonalFlipOverCharge() {
        final int size = 4;
        squarelotron = new Squarelotron(size);
        test.append("01 05 09 13").append("\n")
                .append("02 06 07 14").append("\n")
                .append("03 10 11 15").append("\n")
                .append("04 08 12 16");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.mainDiagonalFlip(1)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 2x2.
     */
    @Test
    public void testRotateEastIn2x2OneTurn() {
        final int size = 2;
        final int ring = 1;
        final int turns = 1;
        squarelotron = new Squarelotron(size);
        test.append("03 01").append("\n")
                .append("04 02");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.rotateEast(turns, ring)));
    }

    /**
     * Tests the values in the square of 4x4.
     */
    @Test
    public void testRotateEastIn4x4TwoTurns() {
        final int size = 4;
        final int ring = 1;
        final int turns = 2;
        squarelotron = new Squarelotron(size);
        test.append("16 15 14 13").append("\n")
                .append("12 06 07 09").append("\n")
                .append("08 10 11 05").append("\n")
                .append("04 03 02 01");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.rotateEast(turns, ring)));
    }

    /**
     * Tests the values in the square of 6x6.
     */
    @Test
    public void testRotateEastIn6x6FourTurns() {
        final int size = 6;
        final int ring = 1;
        final int turns = 4;
        squarelotron = new Squarelotron(size);
        test.append("01 02 03 04 05 06").append("\n")
                .append("07 08 09 10 11 12").append("\n")
                .append("13 14 15 16 17 18").append("\n")
                .append("19 20 21 22 23 24").append("\n")
                .append("25 26 27 28 29 30").append("\n")
                .append("31 32 33 34 35 36");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.rotateEast(turns, ring)));
    }

    /**
     * Tests the values in the square of 2x2.
     */
    @Test
    public void testRotateWestIn2x2OneTurn() {
        final int size = 2;
        final int ring = 1;
        final int turns = -1;
        squarelotron = new Squarelotron(size);
        test.append("02 04").append("\n")
                .append("01 03");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.rotateWest(turns, ring)));
    }

    /**
     * Tests the values in the square of 4x4.
     */
    @Test
    public void testRotateWestIn4x4TwoTurns() {
        final int size = 4;
        final int turns = -2;
        final int ring = 1;
        squarelotron = new Squarelotron(size);
        test.append("16 15 14 13").append("\n")
                .append("12 06 07 09").append("\n")
                .append("08 10 11 05").append("\n")
                .append("04 03 02 01");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.rotateWest(turns, ring)));
    }

    /**
     * Tests the values in the square of 6x6.
     */
    @Test
    public void testRotateWestIn6x6FourTurns() {
        final int size = 6;
        final int turns = -4;
        final int ring = 1;
        squarelotron = new Squarelotron(size);
        test.append("01 02 03 04 05 06").append("\n")
                .append("07 08 09 10 11 12").append("\n")
                .append("13 14 15 16 17 18").append("\n")
                .append("19 20 21 22 23 24").append("\n")
                .append("25 26 27 28 29 30").append("\n")
                .append("31 32 33 34 35 36");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.rotateWest(turns, ring)));
    }

    /**
     * Tests the values of the method RotateRight.
     */
    @Test
    public void testRotateRightWithPositiveTurns() {
        final int size = 4;
        squarelotron = new Squarelotron(size);
        test.append("16 15 14 13").append("\n")
                .append("12 11 10 09").append("\n")
                .append("08 07 06 05").append("\n")
                .append("04 03 02 01");
        squarelotron.rotateRight(2);
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.getOriginalSquareArray()));
    }

    /**
     * Tests the values of the method RotateRight.
     */
    @Test
    public void testRotateRightWithNegativeTurns() {
        final int size = 4;
        final int turns = -2;
        squarelotron = new Squarelotron(size);
        test.append("16 15 14 13").append("\n")
                .append("12 11 10 09").append("\n")
                .append("08 07 06 05").append("\n")
                .append("04 03 02 01");
        squarelotron.rotateRight(turns);
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 3x3.
     */
    @Test
    public void testUpsideDownFlipDimensionThreeRingOne() {
        final int size = 3;
        final int ring = 1;
        squarelotron = new Squarelotron(size);
        test.append("07 08 09").append("\n")
                .append("04 05 06").append("\n")
                .append("01 02 03");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.upsideDownFlip(ring)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 3x3.
     */
    @Test
    public void testUpsideDownFlipDimensionThreeRingTwo() {
        final int size = 3;
        final int ring = 2;
        squarelotron = new Squarelotron(size);
        test.append("01 02 03").append("\n")
                .append("04 05 06").append("\n")
                .append("07 08 09");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.upsideDownFlip(ring)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 5x5.
     */
    @Test
    public void testMainDiagonalFlipIn5x5RingOne() {
        final int size = 5;
        final int ring = 1;
        squarelotron = new Squarelotron(size);
        test.append("01 06 11 16 21").append("\n")
                .append("02 07 08 09 22").append("\n")
                .append("03 12 13 14 23").append("\n")
                .append("04 17 18 19 24").append("\n")
                .append("05 10 15 20 25");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.mainDiagonalFlip(ring)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 5x5.
     */
    @Test
    public void testMainDiagonalFlipIn5x5RingTwo() {
        final int size = 5;
        final int ring = 2;
        squarelotron = new Squarelotron(size);
        test.append("01 02 03 04 05").append("\n")
                .append("06 07 12 17 10").append("\n")
                .append("11 08 13 18 15").append("\n")
                .append("16 09 14 19 20").append("\n")
                .append("21 22 23 24 25");
        assertEquals(test.toString().trim(), squarelotron.showSquare(squarelotron.mainDiagonalFlip(ring)
                .getOriginalSquareArray()));
    }
}
