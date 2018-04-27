package org.minions.devfund.angela;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Test for {@link Squarelotron} .
 */
public class SquarelotronTest {

    private Squarelotron squarelotron;

    /**
     * Enumerable for numbers.
     */
    public enum Numbers {
        ONE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        ELEVEN(11),
        TWELVE(12),
        THIRTEEN(13),
        FOURTEEN(14),
        FIFTEEN(15),
        SIXTEEN(16);

        private int number;

        /**
         * Constructor for enum.
         *
         * @param value int numeral.
         */
        Numbers(final int value) {
            number = value;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return String.valueOf(number);
        }

        /**
         * Gets the number.
         *
         * @return int number value.
         */
        public int getNumber() {
            return number;
        }
    }

    /**
     * Preconditions.
     */
    @Before
    public void setup() {
        final int size = 4;
        squarelotron = new Squarelotron(size);
    }

    /**
     * Test if Upside Down Flip is working.
     */
    @Test
    public void testUpsideDownFlip() {
        final Squarelotron squareResult = squarelotron.upsideDownFlip(2);
        assertEquals(Numbers.TEN.getNumber(), squareResult.getSquarematrix()[1][1]);
        assertEquals(Numbers.ELEVEN.getNumber(), squareResult.getSquarematrix()[1][2]);
        assertEquals(Numbers.SIX.getNumber(), squareResult.getSquarematrix()[2][1]);
        assertEquals(Numbers.SEVEN.getNumber(), squareResult.getSquarematrix()[2][2]);
    }

    /**
     * Test if Main Diagonal Flip is working.
     */
    @Test
    public void testMainDiagonalFlip() {
        final Squarelotron squareResult = squarelotron.mainDiagonalFlip(2);
        assertEquals(Numbers.SIX.getNumber(), squareResult.getSquarematrix()[1][1]);
        assertEquals(Numbers.TEN.getNumber(), squareResult.getSquarematrix()[1][2]);
        assertEquals(Numbers.SEVEN.getNumber(), squareResult.getSquarematrix()[2][1]);
        assertEquals(Numbers.ELEVEN.getNumber(), squareResult.getSquarematrix()[2][2]);

    }

    /**
     * Tests to rotate the matrix right.
     */
    @Test
    public void rotateRight() {
        squarelotron.rotateRight(1);
        final int[][] matrixResult = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        assertArrayEquals(matrixResult, squarelotron.getSquarematrix());
    }

    /**
     * Tests to rotate the matrix left.
     */
    @Test
    public void rotateLeft() {
        final int numberOfTurns = -1;
        squarelotron.rotateRight(numberOfTurns);
        final int[][] matrixResult = {{4, 8, 12, 16}, {3, 7, 11, 15}, {2, 6, 10, 14}, {1, 5, 9, 13}};
        assertArrayEquals(matrixResult, squarelotron.getSquarematrix());
    }

    /**
     * Tests to rotate the matrix left twice.
     */
    @Test
    public void rotateTwiceLeft() {
        final int numberOfTurns = -2;
        squarelotron.rotateRight(numberOfTurns);
        final int[][] matrixResult = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}};
        assertArrayEquals(matrixResult, squarelotron.getSquarematrix());
    }

    /**
     * Tests to rotate the matrix left three times.
     */
    @Test
    public void rotateThreeTimesLeft() {
        final int numberOfTurns = -3;
        squarelotron.rotateRight(numberOfTurns);
        final int[][] matrixResult = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        assertArrayEquals(matrixResult, squarelotron.getSquarematrix());
    }

    /**
     * Tests to rotate the matrix twice.
     */
    @Test
    public void rotateRightTwice() {
        squarelotron.rotateRight(2);
        final int[][] matrixResult = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}};
        assertArrayEquals(matrixResult, squarelotron.getSquarematrix());
    }

    /**
     * Tests to rotate the matrix three times.
     */
    @Test
    public void rotateRightThreeTimes() {
        final int numberOfTurns = 3;
        squarelotron.rotateRight(numberOfTurns);
        final int[][] matrixResult = {{4, 8, 12, 16}, {3, 7, 11, 15}, {2, 6, 10, 14}, {1, 5, 9, 13}};
        assertArrayEquals(matrixResult, squarelotron.getSquarematrix());
    }
}
