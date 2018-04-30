package org.minions.devfund.angela;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test for {@link Squarelotron} .
 */
public class SquarelotronTest {

    private Squarelotron squarelotron;

    /**
     * Preconditions.
     */
    @Before
    public void setup() {
        final int size = 4;
        squarelotron = new Squarelotron(size);
    }

    /**
     * Test to verify if a position is part of the ring.
     */
    @Test
    public void testIsPartOfTheRing() {
        assertTrue("The position isn't part of the ring.", squarelotron.isPartOfTheRing(1, 0, 0));
    }

    /**
     * Test to verify if a position is notpart of the ring.
     */
    @Test
    public void testIsNotPartOfTheRing() {
        assertFalse("The position is part of the ring.", squarelotron.isPartOfTheRing(1, 1, 1));
    }
    /**
     * Test if Upside Down Flip is working.
     */
    @Test
    public void testUpsideDownFlip() {
        final Squarelotron squareResult = squarelotron.upsideDownFlip(2);
        final int[][] matrixResult = {{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
        assertArrayEquals(matrixResult, squareResult.getSquarematrix());
    }

    /**
     * Test if Main Diagonal Flip is working.
     */
    @Test
    public void testMainDiagonalFlip() {
        final Squarelotron squareResult = squarelotron.mainDiagonalFlip(2);
        final int[][] matrixResult = {{1, 2, 3, 4}, {5, 6, 10, 8}, {9, 7, 11, 12}, {13, 14, 15, 16}};
        assertArrayEquals(matrixResult, squareResult.getSquarematrix());
    }

    /**
     * Tests to rotate the matrix right.
     */
    @Test
    public void rotateRight() {
        squarelotron.rotate(1);
        final int[][] matrixResult = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        assertArrayEquals(matrixResult, squarelotron.getSquarematrix());
    }

    /**
     * Tests to rotate the matrix left.
     */
    @Test
    public void rotateLeft() {
        final int numberOfTurns = -1;
        squarelotron.rotate(numberOfTurns);
        final int[][] matrixResult = {{4, 8, 12, 16}, {3, 7, 11, 15}, {2, 6, 10, 14}, {1, 5, 9, 13}};
        assertArrayEquals(matrixResult, squarelotron.getSquarematrix());
    }

    /**
     * Tests to rotate the matrix left twice.
     */
    @Test
    public void rotateTwiceLeft() {
        final int numberOfTurns = -2;
        squarelotron.rotate(numberOfTurns);
        final int[][] matrixResult = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}};
        assertArrayEquals(matrixResult, squarelotron.getSquarematrix());
    }

    /**
     * Tests to rotate the matrix left three times.
     */
    @Test
    public void rotateThreeTimesLeft() {
        final int numberOfTurns = -3;
        squarelotron.rotate(numberOfTurns);
        final int[][] matrixResult = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        assertArrayEquals(matrixResult, squarelotron.getSquarematrix());
    }

    /**
     * Tests to rotate the matrix twice.
     */
    @Test
    public void rotateRightTwice() {
        squarelotron.rotate(2);
        final int[][] matrixResult = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}};
        assertArrayEquals(matrixResult, squarelotron.getSquarematrix());
    }

    /**
     * Tests to rotate the matrix three times.
     */
    @Test
    public void rotateRightThreeTimes() {
        final int numberOfTurns = 3;
        squarelotron.rotate(numberOfTurns);
        final int[][] matrixResult = {{4, 8, 12, 16}, {3, 7, 11, 15}, {2, 6, 10, 14}, {1, 5, 9, 13}};
        assertArrayEquals(matrixResult, squarelotron.getSquarematrix());
    }
}
