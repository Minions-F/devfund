package org.minios.devfund.chelo;

import org.junit.Test;
import org.minions.devfund.chelo.Squarelotron;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;

/**
 * Test Class Squarelotron.
 */
public class SquarelotronTest {

    /**
     * A test to validate the Main diagonal flip dimension two.
     */
    @Test
    public void testMainDiagonalFlipDimensionTwo() {
        final int size = 2;
        final int ring = 1;
        final int[][] expectedArray = new int[][]{
                {3, 4},
                {1, 2}};

        Squarelotron squarelotron = new Squarelotron(size);
        assertEquals(expectedArray, squarelotron.upsideDownFlip(ring).getSquarelotron());
    }

    /**
     * A test to validate the Main diagonal flip dimension five ring three.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingThree() {
        final int size = 5;
        final int ring = 3;
        final int[][] expectedArray = new int[][] {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};

        Squarelotron squarelotron = new Squarelotron(size);
        assertEquals(expectedArray, squarelotron.mainDiagonalFlip(ring).getSquarelotron());
    }

    /**
     * A test to validate the Main diagonal flip dimension five ring two.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingTwo() {
        final int size = 5;
        final int ring = 2;
        final int[][] expectedArray = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 12, 17, 10},
                {11, 8, 13, 18, 15},
                {16, 9, 14, 19, 20},
                {21, 22, 23, 24, 25}};

        Squarelotron squarelotron = new Squarelotron(size);
        assertEquals(expectedArray, squarelotron.mainDiagonalFlip(ring).getSquarelotron());
    }

    /**
     * A test to validate the Main diagonal flip dimension five ring one.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingOne() {
        final int size = 5;
        final int ring = 1;
        final int[][] expectedArray = new int[][]{
                {1, 6, 11, 16, 21},
                {2, 7, 8, 9, 22},
                {3, 12, 13, 14, 23},
                {4, 17, 18, 19, 24},
                {5, 10, 15, 20, 25}};

        Squarelotron squarelotron = new Squarelotron(size);
        assertEquals(expectedArray, squarelotron.mainDiagonalFlip(ring).getSquarelotron());
    }

    /**
     * A test to validate the upside down flip.
     */
    @Test
    public void testUpsideDownFlip() {
        final int size = 3;
        final int ring = 1;
        final int[][] expectedArray = new int[][]{
                {7, 8, 9},
                {4, 5, 6},
                {1, 2, 3}};

        Squarelotron squarelotron = new Squarelotron(size);
        assertEquals(expectedArray, squarelotron.upsideDownFlip(ring).getSquarelotron());
    }

    /**
     * A test to validate the upside down flip dimension three.
     */
    @Test
    public void testUpsideDownFlipDimensionThree() {
        final int size = 3;
        final int ring = 1;
        final int[][] expectedArray = new int[][]{
                {7, 8, 9},
                {4, 5, 6},
                {1, 2, 3}};

        Squarelotron squarelotron = new Squarelotron(size);
        assertEquals(expectedArray, squarelotron.upsideDownFlip(ring).getSquarelotron());
    }

    /**
     * A test to validate the upside down flip.
     */
    @Test
    public void testNotUpsideDownFlip() {
        final int size = 3;
        final int ring = 1;
        final int[][] expectedArray = new int[][]{
                {7, 8, 7},
                {4, 5, 6},
                {1, 2, 3}};

        Squarelotron squarelotron = new Squarelotron(size);
        assertNotEquals(expectedArray, squarelotron.upsideDownFlip(ring).getSquarelotron());
    }

    /**
     * A test to validate the diagonal flip.
     */
    @Test
    public void testDiagonalFlip() {
        final int size = 3;
        final int ring = 1;
        final int[][] expectedArray = new int[][]{
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}};

        Squarelotron squarelotron = new Squarelotron(size);
        assertEquals(expectedArray, squarelotron.mainDiagonalFlip(ring).getSquarelotron());
    }

    /**
     * A test to validate the diagonal flip.
     */
    @Test
    public void testNotDiagonalFlip() {
        final int size = 3;
        final int ring = 1;
        final int[][] expectedArray = new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}};

        Squarelotron squarelotron = new Squarelotron(size);
        assertNotEquals(expectedArray, squarelotron.mainDiagonalFlip(ring).getSquarelotron());
    }

    /**
     * A test to validate the rotate right.
     */
    @Test
    public void testRotateRight1() {
        final int size = 4;
        final int rotate = 1;
        final int[][] expectedArray = new int[][]{
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}};

        Squarelotron squarelotron = new Squarelotron(size);
        squarelotron.rotateRight(rotate);
        assertEquals(expectedArray, squarelotron.getSquarelotron());
    }

    /**
     * A test to validate the rotate right two.
     */
    @Test
    public void testRotateRight2() {
        final int size = 3;
        final int rotate = 2;
        final int[][] expectedArray = new int[][]{
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}};

        Squarelotron squarelotron = new Squarelotron(size);
        squarelotron.rotateRight(rotate);
        assertEquals(expectedArray, squarelotron.getSquarelotron());
    }

    /**
     * A test to validate the rotate right six.
     */
    @Test
    public void testRotateRight6() {
        final int size = 4;
        final int rotate = 6;
        final int[][] expectedArray = new int[][]{
                {16, 15, 14, 13},
                {12, 11, 10, 9},
                {8, 7, 6, 5},
                {4, 3, 2, 1}};

        Squarelotron squarelotron = new Squarelotron(size);
        squarelotron.rotateRight(rotate);
        assertEquals(expectedArray, squarelotron.getSquarelotron());
    }

    /**
     * A test to validate the rotate right three.
     */
    @Test
    public void testRotateRight1dimensionThree() {
        final int size = 3;
        final int rotate = 1;
        final int[][] expectedArray = new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}};

        Squarelotron squarelotron = new Squarelotron(size);
        squarelotron.rotateRight(rotate);
        assertEquals(expectedArray, squarelotron.getSquarelotron());
    }
}
