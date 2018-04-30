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
        final int[][] expected = {{1, 2}, {3, 4}};
        squarelotron = new Squarelotron(size);
        assertEquals(Squarelotron.showSquare(expected),
                Squarelotron.showSquare(squarelotron.getOriginalSquareArray()));
    }


    /**
     * Tests the values in the square of 5x5.
     */
    @Test
    public void testSetValuesForSize5x5() {
        final int size = 5;
        final int[][] expected = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        squarelotron = new Squarelotron(size);
        assertEquals(Squarelotron.showSquare(expected),
                Squarelotron.showSquare(squarelotron.getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 4x4.
     */
    @Test
    public void testGetNumberOfRingsInA4x4Square() {
        final int size = 4;
        squarelotron = new Squarelotron(size);
        final int ringsExpected = 2;
        assertEquals(ringsExpected, squarelotron.getNumberOfRings());
    }

    /**
     * Tests the values in the square of 5x5.
     */
    @Test
    public void testGetNumberOfRingsInA5x5Square() {
        final int size = 5;
        squarelotron = new Squarelotron(size);
        final int ringsExpected = 3;
        assertEquals(ringsExpected, squarelotron.getNumberOfRings());
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
        final int[][] expected = {{21, 22, 23, 24, 25}, {16, 7, 8, 9, 20}, {11, 12, 13, 14, 15},
                {6, 17, 18, 19, 10}, {1, 2, 3, 4, 5}};
        squarelotron = new Squarelotron(size);
        assertEquals(Squarelotron.showSquare(expected), Squarelotron.showSquare(squarelotron.upsideDownFlip(1)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 6x6.
     */
    @Test
    public void testUpsideDownFlipInA6x6SquareRingTwo() {
        final int size = 6;
        final int[][] expected = {{1, 2, 3, 4, 5, 6}, {7, 26, 27, 28, 29, 12}, {13, 20, 15, 16, 23, 18},
                {19, 14, 21, 22, 17, 24}, {25, 8, 9, 10, 11, 30}, {31, 32, 33, 34, 35, 36}};
        squarelotron = new Squarelotron(size);
        assertEquals(Squarelotron.showSquare(expected), Squarelotron.showSquare(squarelotron.upsideDownFlip(2)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 6x6.
     */
    @Test
    public void testUpsideDownFlipIn6x6SquareRingThree() {
        final int size = 6;
        final int ring = 3;
        final int[][] expected = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 21, 22, 17, 18},
                {19, 20, 15, 16, 23, 24}, {25, 26, 27, 28, 29, 30}, {31, 32, 33, 34, 35, 36}};
        squarelotron = new Squarelotron(size);
        assertEquals(Squarelotron.showSquare(expected), Squarelotron.showSquare(squarelotron.upsideDownFlip(ring)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values of the processed square of the method upsideDownFlip.
     */
    @Test
    public void testUpsideDownFlipInOverCharge() {
        final int size = 5;
        final int[][] expected = {{1, 2, 3, 4, 5}, {6, 17, 18, 19, 10}, {11, 12, 13, 14, 15},
                {16, 7, 8, 9, 20}, {21, 22, 23, 24, 25}};
        squarelotron = new Squarelotron(size);
        assertEquals(Squarelotron.showSquare(expected), Squarelotron.showSquare(squarelotron.upsideDownFlip(2)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 2x2.
     */
    @Test
    public void testMainDiagonalFlipIn2x2SquareRingOne() {
        final int size = 2;
        final int[][] expected = {{1, 3}, {2, 4}};
        squarelotron = new Squarelotron(size);
        assertEquals(Squarelotron.showSquare(expected), Squarelotron.showSquare(squarelotron.mainDiagonalFlip(1)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 6x6.
     */
    @Test
    public void testMainDiagonalFlipIn6x6SquareRingOne() {
        final int size = 6;
        final int[][] expected = {{1, 7, 13, 19, 25, 31}, {2, 8, 9, 10, 11, 32}, {3, 14, 15, 16, 17, 33},
                {4, 20, 21, 22, 23, 34}, {5, 26, 27, 28, 29, 35}, {6, 12, 18, 24, 30, 36}};
        squarelotron = new Squarelotron(size);
        assertEquals(Squarelotron.showSquare(expected), Squarelotron.showSquare(squarelotron.mainDiagonalFlip(1)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 4x4.
     */
    @Test
    public void testMainDiagonalFlipIn4x4RingTwo() {
        final int size = 4;
        final int[][] expected = {{1, 2, 3, 4}, {5, 6, 10, 8}, {9, 7, 11, 12},
                {13, 14, 15, 16}};
        squarelotron = new Squarelotron(size);
        assertEquals(Squarelotron.showSquare(expected), Squarelotron.showSquare(squarelotron.mainDiagonalFlip(2)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values of the processed square of the method mainDiagonalFlip.
     */
    @Test
    public void testMainDiagonalFlipOverCharge() {
        final int size = 4;
        final int[][] expected = {{1, 5, 9, 13}, {2, 6, 7, 14}, {3, 10, 11, 15},
                {4, 8, 12, 16}};
        squarelotron = new Squarelotron(size);
        assertEquals(Squarelotron.showSquare(expected), Squarelotron.showSquare(squarelotron.mainDiagonalFlip(1)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 2x2.
     */
    @Test
    public void testRotateEastIn2x2OneTurn() {
        final int size = 2;
        final int turns = 1;
        final int[][] expected = {{3, 1}, {4, 2}};
        squarelotron = new Squarelotron(size);
        assertEquals(Squarelotron.showSquare(expected), Squarelotron.showSquare(squarelotron.rotateEast(turns)));
    }

    /**
     * Tests the values in the square of 4x4.
     */
    @Test
    public void testRotateEastIn4x4TwoTurns() {
        final int size = 4;
        final int turns = 2;
        final int[][] expected = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5},
                {4, 3, 2, 1}};
        squarelotron = new Squarelotron(size);
        assertEquals(Squarelotron.showSquare(expected), Squarelotron.showSquare(squarelotron.rotateEast(turns)));
    }

    /**
     * Tests the values in the square of 6x6.
     */
    @Test
    public void testRotateEastIn6x6FourTurns() {
        final int size = 6;
        final int turns = 4;
        final int[][] expected = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24}, {25, 26, 27, 28, 29, 30}, {31, 32, 33, 34, 35, 36}};
        squarelotron = new Squarelotron(size);
        assertEquals(Squarelotron.showSquare(expected), Squarelotron.showSquare(squarelotron.rotateEast(turns)));
    }

    /**
     * Tests the values in the square of 2x2.
     */
    @Test
    public void testRotateWestIn2x2OneTurn() {
        final int size = 2;
        final int turns = -1;
        final int[][] expected = {{2, 4}, {1, 3}};
        squarelotron = new Squarelotron(size);
        assertEquals(Squarelotron.showSquare(expected), Squarelotron.showSquare(squarelotron.rotateWest(turns)));
    }

    /**
     * Tests the values in the square of 4x4.
     */
    @Test
    public void testRotateWestIn4x4TwoTurns() {
        final int size = 4;
        final int turns = -2;
        final int[][] expected = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5},
                {4, 3, 2, 1}};
        squarelotron = new Squarelotron(size);
        assertEquals(Squarelotron.showSquare(expected), Squarelotron.showSquare(squarelotron.rotateWest(turns)));
    }

    /**
     * Tests the values in the square of 6x6.
     */
    @Test
    public void testRotateWestIn6x6FourTurns() {
        final int size = 6;
        final int turns = -4;
        final int[][] expected = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24}, {25, 26, 27, 28, 29, 30}, {31, 32, 33, 34, 35, 36}};
        squarelotron = new Squarelotron(size);
        assertEquals(Squarelotron.showSquare(expected), Squarelotron.showSquare(squarelotron.rotateWest(turns)));
    }

    /**
     * Tests the values of the method RotateRight.
     */
    @Test
    public void testRotateRightWithPositiveTurns() {
        final int size = 4;
        final int[][] expected = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5},
                {4, 3, 2, 1}};
        squarelotron = new Squarelotron(size);
        test.append("16 15 14 13").append("\n")
            .append("12 11 10 09").append("\n")
            .append("08 07 06 05").append("\n")
            .append("04 03 02 01");
        squarelotron.rotateRight(2);
        assertEquals(Squarelotron.showSquare(expected), Squarelotron.showSquare(squarelotron.getOriginalSquareArray()));
    }

    /**
     * Tests the values of the method RotateRight.
     */
    @Test
    public void testRotateRightWithNegativeTurns() {
        final int size = 4;
        final int turns = -2;
        final int[][] expected = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5},
                {4, 3, 2, 1}};
        squarelotron = new Squarelotron(size);
        squarelotron.rotateRight(turns);
        assertEquals(Squarelotron.showSquare(expected), Squarelotron.showSquare(squarelotron.getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 3x3.
     */
    @Test
    public void testUpsideDownFlipDimensionThreeRingOne() {
        final int size = 3;
        final int ring = 1;
        final int[][] expected = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        squarelotron = new Squarelotron(size);
        assertEquals(Squarelotron.showSquare(expected), Squarelotron.showSquare(squarelotron.upsideDownFlip(ring)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 3x3.
     */
    @Test
    public void testUpsideDownFlipDimensionThreeRingTwo() {
        final int size = 3;
        final int ring = 2;
        final int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        squarelotron = new Squarelotron(size);
        assertEquals(Squarelotron.showSquare(expected), Squarelotron.showSquare(squarelotron.upsideDownFlip(ring)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 5x5.
     */
    @Test
    public void testMainDiagonalFlipIn5x5RingOne() {
        final int size = 5;
        final int ring = 1;
        final int[][] expected = {{1, 6, 11, 16, 21}, {2, 7, 8, 9, 22}, {3, 12, 13, 14, 23},
                {4, 17, 18, 19, 24}, {5, 10, 15, 20, 25}};
        squarelotron = new Squarelotron(size);
        assertEquals(Squarelotron.showSquare(expected), Squarelotron.showSquare(squarelotron.mainDiagonalFlip(ring)
                .getOriginalSquareArray()));
    }

    /**
     * Tests the values in the square of 5x5.
     */
    @Test
    public void testMainDiagonalFlipIn5x5RingTwo() {
        final int size = 5;
        final int ring = 2;
        final int[][] expected = {{1, 2, 3, 4, 5}, {6, 7, 12, 17, 10}, {11, 8, 13, 18, 15},
                {16, 9, 14, 19, 20}, {21, 22, 23, 24, 25}};
        squarelotron = new Squarelotron(size);
        test.append("01 02 03 04 05").append("\n")
            .append("06 07 12 17 10").append("\n")
            .append("11 08 13 18 15").append("\n")
            .append("16 09 14 19 20").append("\n")
            .append("21 22 23 24 25");
        assertEquals(Squarelotron.showSquare(expected), Squarelotron.showSquare(squarelotron.mainDiagonalFlip(ring)
                .getOriginalSquareArray()));
    }
}
