package org.minions.devfund.marcos;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * It is in charged to define the unit tests for Squarelotron class.
 */
public class SquarelotronTest {

    /**
     * Upside Down Flip Basic Test using Squarelotron with dimension 2.
     */
    @Test
    public void upsideDownFlipBasicTest() {
        final int ringNumber = 1;
        final int dimension = 2;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedMatrix = new int[][]{{3, 4}, {1, 2}};
        Squarelotron result = squarelotron.upsideDownFlip(ringNumber);
        for (int i = 0; i < expectedMatrix.length; i++) {
            assertArrayEquals(expectedMatrix[i], result.getSquarematrix()[i]);
        }
    }

    /**
     * Upside Down Flip Extended Test using Squarelotron with dimension 4.
     */
    @Test
    public void upsideDownFlipExtendedTest() {
        final int ringNumber = 2;
        final int dimension = 4;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedMatrix = new int[][]{{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
        Squarelotron result = squarelotron.upsideDownFlip(ringNumber);
        for (int i = 0; i < expectedMatrix.length; i++) {
            assertArrayEquals(expectedMatrix[i], result.getSquarematrix()[i]);
        }
    }

    /**
     * Main Diagonal Flip Test using Squarelotron with dimension 4.
     */
    @Test
    public void mainDiagonalFlipTest() {
        final int ringNumber = 1;
        final int dimension = 4;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedMatrix = new int[][]{{1, 5, 9, 13}, {2, 6, 7, 14}, {3, 10, 11, 15}, {4, 8, 12, 16}};
        Squarelotron result = squarelotron.mainDiagonalFlip(ringNumber);
        for (int i = 0; i < expectedMatrix.length; i++) {
            assertArrayEquals(expectedMatrix[i], result.getSquarematrix()[i]);
        }
    }

    /**
     * Rotate Clock Wise Test using Squarelotron with dimension 4.
     */
    @Test
    public void rotateClockwiseTest() {
        final int dimension = 4;
        final int numberOfTurns = 1;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedMatrix = new int[][]{{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        squarelotron.rotateRight(numberOfTurns);
        for (int i = 0; i < expectedMatrix.length; i++) {
            assertArrayEquals(expectedMatrix[i], squarelotron.getSquarematrix()[i]);
        }
    }

    /**
     * Rotate Counter Clock Wise Test using Squarelotron with dimension 4.
     */
    @Test
    public void rotateCounterClockwiseTest() {
        final int dimension = 4;
        final int numberOfTurns = -2;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedMatrix = new int[][]{{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}};
        squarelotron.rotateRight(numberOfTurns);
        for (int i = 0; i < expectedMatrix.length; i++) {
            assertArrayEquals(expectedMatrix[i], squarelotron.getSquarematrix()[i]);
        }
    }

    /**
     * Rotate Clock Wise Test using Squarelotron with dimension 4 and zero number of turns.
     */
    @Test
    public void rotateCounterClockwiseZeroTurnsTest() {
        final int dimension = 4;
        final int numberOfTurns = 0;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedMatrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        squarelotron.rotateRight(numberOfTurns);
        for (int i = 0; i < expectedMatrix.length; i++) {
            assertArrayEquals(expectedMatrix[i], squarelotron.getSquarematrix()[i]);
        }
    }
}
