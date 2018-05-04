package org.minions.devfund.dennis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * Unit Test class for Squarelotron for all methods.
 */
public class SquarelotronTest {

    /**
     * Unit test for constructor where dimension is 2.
     */
    @Test
    public void testConstructorDimension2andSize2() {
        final int dimension = 2;
        final int size = 2;
        final Squarelotron squarelotronMatrix = new Squarelotron(dimension);
        final int[][] expectedMatrix = {{1, 2}, {3, 4}};
        assertArrayEquals(expectedMatrix, squarelotronMatrix.getMatrix());
        assertEquals(size, squarelotronMatrix.getSize());
    }

    /**
     * Unit test for constructor where dimension is 5.
     */
    @Test
    public void testConstructorDimension5andSize5() {
        final int dimension = 5;
        final int size = 5;
        final Squarelotron squarelotronMatrix = new Squarelotron(dimension);
        final int[][] expectedMatrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        assertArrayEquals(expectedMatrix, squarelotronMatrix.getMatrix());
        assertEquals(size, squarelotronMatrix.getSize());
    }

    /**
     * Unit test for testRotateRight where dimension is 2 and numberOfTurns = 1.
     */
    @Test
    public void testRotateRightDimension2Turns1() {
        final int dimension = 2;
        final int numberOfTurns = 1;
        final Squarelotron squarelotronMatrix = new Squarelotron(dimension);
        final int[][] expectedMatrix = {{3, 1}, {4, 2}};
        squarelotronMatrix.rotateRight(numberOfTurns);
        assertArrayEquals(expectedMatrix, squarelotronMatrix.getMatrix());
    }

    /**
     * Unit test for testRotateRight where dimension is 2 and numberOfTurns = -1.
     */
    @Test
    public void testRotateRightDimension2TurnsNegative1() {
        final int dimension = 2;
        final int numberOfTurns = -1;
        final Squarelotron squarelotronMatrix = new Squarelotron(dimension);
        final int[][] expectedMatrix = {{2, 4}, {1, 3}};
        squarelotronMatrix.rotateRight(numberOfTurns);
        assertArrayEquals(expectedMatrix, squarelotronMatrix.getMatrix());
    }

    /**
     * Unit test for testRotateRight where dimension is 2 and numberOfTurns = 2.
     */
    @Test
    public void testRotateRightDimension2Turns2() {
        final int dimension = 2;
        final int numberOfTurns = 2;
        final Squarelotron squarelotronMatrix = new Squarelotron(dimension);
        final int[][] expectedMatrix = {{4, 3}, {2, 1}};
        squarelotronMatrix.rotateRight(numberOfTurns);
        assertArrayEquals(expectedMatrix, squarelotronMatrix.getMatrix());
    }

    /**
     * Unit test for testRotateRight where dimension is 3 and numberOfTurns = 1.
     */
    @Test
    public void testRotateRightDimension3Turns1() {
        final int dimension = 3;
        final int numberOfTurns = 1;
        final Squarelotron squarelotronMatrix = new Squarelotron(dimension);
        final int[][] expectedMatrix = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        squarelotronMatrix.rotateRight(numberOfTurns);
        assertArrayEquals(expectedMatrix, squarelotronMatrix.getMatrix());
    }

    /**
     * Unit test for UpsideDownFlip where dimension is 4 and ring 1.
     */
    @Test
    public void testUpsideDownFlipDimension4Ring1() {
        final int dimension = 4;
        final int ring = 1;
        final Squarelotron squarelotronMatrix = new Squarelotron(dimension);
        final int[][] expectedMatrix = {{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
        Squarelotron result = squarelotronMatrix.upsideDownFlip(ring);
        assertArrayEquals(expectedMatrix, result.getMatrix());
    }

    /**
     * Unit test for UpsideDownFlip where dimension is 4 and ring 2.
     */
    @Test
    public void testUpsideDownFlipDimension4Ring2() {
        final int dimension = 4;
        final int ring = 2;
        final Squarelotron squarelotronMatrix = new Squarelotron(dimension);
        final int[][] expectedMatrix = {{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
        Squarelotron result = squarelotronMatrix.upsideDownFlip(ring);
        assertArrayEquals(expectedMatrix, result.getMatrix());
    }

    /**
     * Unit test for MainDiagonalFlip where dimension is 2 and ring 1.
     */
    @Test
    public void testMainDiagonalFlipDimension2Ring1() {
        final int dimension = 2;
        final int ring = 1;
        final Squarelotron squarelotronMatrix = new Squarelotron(dimension);
        final int[][] expectedMatrix = {{1, 3}, {2, 4}};
        Squarelotron result = squarelotronMatrix.mainDiagonalFlip(ring);
        assertArrayEquals(expectedMatrix, result.getMatrix());
    }

    /**
     * Unit test for MainDiagonalFlip where dimension is 3 and ring 1.
     */
    @Test
    public void testMainDiagonalFlipDimension3Ring1() {
        final int dimension = 3;
        final int ring = 1;
        final Squarelotron squarelotronMatrix = new Squarelotron(dimension);
        final int[][] expectedMatrix = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        Squarelotron result = squarelotronMatrix.mainDiagonalFlip(ring);
        assertArrayEquals(expectedMatrix, result.getMatrix());
    }

    /**
     * Unit test for MainDiagonalFlip where dimension is 4 and ring 2.
     */
    @Test
    public void testMainDiagonalFlipDimension4Ring2() {
        final int dimension = 4;
        final int ring = 2;
        final Squarelotron squarelotronMatrix = new Squarelotron(dimension);
        final int[][] expectedMatrix = {{1, 2, 3, 4}, {5, 6, 10, 8}, {9, 7, 11, 12}, {13, 14, 15, 16}};
        Squarelotron result = squarelotronMatrix.mainDiagonalFlip(ring);
        assertArrayEquals(expectedMatrix, result.getMatrix());
    }
}
