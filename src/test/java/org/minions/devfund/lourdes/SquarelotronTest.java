package org.minions.devfund.lourdes;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Test for Test for {@link Squarelotron}.
 */
public class SquarelotronTest {

    /**
     * Test to validate upside down flip for matrix of one dimension.
     */
    @Test
    public void testUpsideDownFlipDimensionOne() {
        final int size = 1;
        final int ring = 1;
        final int[] expected = new int[]{1};
        Squarelotron squarelotron = new Squarelotron(size);
        assertArrayEquals(squarelotron.upsideDownFlip(ring).getMatrixSquarelotron()[0], expected);
    }

    /**
     * Test to validate upside down flip for two dimension matrix.
     */
    @Test
    public void testUpsideDownFlipDimensionTwo() {
        final int size = 2;
        final int ring = 1;
        final int[][] expected = new int[][]{{3, 4}, {1, 2}};
        Squarelotron squarelotron = new Squarelotron(size);
        assertArrayEquals(squarelotron.upsideDownFlip(ring).getMatrixSquarelotron(), expected);
    }

    /**
     * Test to verify upside down flip fot three dimension matrix.
     */
    @Test
    public void testUpsideDownFlipDimensionThree() {
        final int size = 3;
        final int ring = 1;
        final int[][] expected = new int[][]{{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        Squarelotron squarelotron = new Squarelotron(size);
        assertArrayEquals(squarelotron.upsideDownFlip(ring).getMatrixSquarelotron(), expected);
    }

    /**
     * Test that verify  to upside down flip a matrix with dimension Four.
     */
    @Test
    public void testUpsideDownFlipDimensionFour() {
        final int size = 4;
        final int ring = 1;
        final int[][] expected = new int[][]{{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
        Squarelotron squarelotron = new Squarelotron(size);
        assertArrayEquals(squarelotron.upsideDownFlip(ring).getMatrixSquarelotron(), expected);
    }

    /**
     * Test that verify to upside down flip a matrix with dimension Four for ring two.
     */
    @Test
    public void testUpsideDownFlipDimensionFourRingTwo() {
        final int size = 4;
        final int ring = 2;
        final int[][] expected = new int[][]{{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
        Squarelotron squarelotron = new Squarelotron(size);
        assertArrayEquals(squarelotron.upsideDownFlip(ring).getMatrixSquarelotron(), expected);
    }

    /**
     * Test that verify to upside down flip a matrix with dimension five.
     */
    @Test
    public void testUpsideDownFlipDimensionFive() {
        final int size = 5;
        final int ring = 1;
        final int[][] expected = new int[][]{{21, 22, 23, 24, 25}, {16, 7, 8, 9, 20}, {11, 12, 13, 14, 15},
                {6, 17, 18, 19, 10}, {1, 2, 3, 4, 5}};
        Squarelotron squarelotron = new Squarelotron(size);
        assertArrayEquals(squarelotron.upsideDownFlip(ring).getMatrixSquarelotron(), expected);
    }

    /**
     * Test that verify to upside down flip a matrix with dimension five for ring two.
     */
    @Test
    public void testUpsideDownFlipDimensionFiveRingTwo() {
        final int size = 5;
        final int ring = 2;
        final int[][] expected = new int[][]{{1, 2, 3, 4, 5}, {6, 17, 18, 19, 10},
                {11, 12, 13, 14, 15}, {16, 7, 8, 9, 20}, {21, 22, 23, 24, 25}};
        Squarelotron squarelotron = new Squarelotron(size);
        assertArrayEquals(squarelotron.upsideDownFlip(ring).getMatrixSquarelotron(), expected);
    }

    /**
     * Test that verify to upside down flip a matrix with dimension five for ring three.
     */
    @Test
    public void testUpsideDownFlipDimensionFiveRingThree() {
        final int size = 5;
        final int ring = 3;
        final int[][] expected = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Squarelotron squarelotron = new Squarelotron(size);
        assertArrayEquals(squarelotron.upsideDownFlip(ring).getMatrixSquarelotron(), expected);
    }

    /**
     * Test that verify to flip the main diagonal given a matrix with dimension one.
     */
    @Test
    public void testMainDiagonalFlipDimensionOne() {
        final int size = 1;
        final int ring = 1;
        final int[] expected = new int[]{1};
        Squarelotron squarelotron = new Squarelotron(size);
        assertArrayEquals(squarelotron.mainDiagonalFlip(ring).getMatrixSquarelotron()[0], expected);
    }

    /**
     * Test that verify to flip the main diagonal given a matrix with dimension two.
     */
    @Test
    public void mainDiagonalFlipDimensionTwo() {
        final int size = 2;
        final int ring = 1;
        final int[][] expected = new int[][]{{1, 3}, {2, 4}};
        Squarelotron squarelotron = new Squarelotron(size);
        assertArrayEquals(squarelotron.mainDiagonalFlip(ring).getMatrixSquarelotron(), expected);
    }

    /**
     * Test that verify to flip the main diagonal given a matrix with dimension three.
     */
    @Test
    public void testMainDiagonalFlipDimensionThree() {
        final int size = 3;
        final int ring = 1;
        final int[][] expected = new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        Squarelotron squarelotron = new Squarelotron(size);
        assertArrayEquals(squarelotron.mainDiagonalFlip(ring).getMatrixSquarelotron(), expected);
    }

    /**
     * Test that verify to flip the main diagonal given a matrix with dimension four.
     */
    @Test
    public void testMainDiagonalFlipDimensionFour() {
        final int size = 4;
        final int ring = 1;
        final int[][] expected = new int[][]{{1, 5, 9, 13}, {2, 6, 7, 14}, {3, 10, 11, 15}, {4, 8, 12, 16}};
        Squarelotron squarelotron = new Squarelotron(size);
        assertArrayEquals(squarelotron.mainDiagonalFlip(ring).getMatrixSquarelotron(), expected);
    }

    /**
     * Test that verify to flip the main diagonal given a matrix with dimension Five for ring one.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingOne() {
        final int size = 5;
        final int ring = 1;
        final int[][] expected = new int[][]{{1, 6, 11, 16, 21}, {2, 7, 8, 9, 22}, {3, 12, 13, 14, 23},
                {4, 17, 18, 19, 24}, {5, 10, 15, 20, 25}};
        Squarelotron squarelotron = new Squarelotron(size);
        assertArrayEquals(squarelotron.mainDiagonalFlip(ring).getMatrixSquarelotron(), expected);
    }

    /**
     * Test that verify to flip the main diagonal given a matrix with dimension Five for ring two.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingTwo() {
        final int size = 5;
        final int ring = 2;
        final int[][] expected = {{1, 2, 3, 4, 5}, {6, 7, 12, 17, 10}, {11, 8, 13, 18, 15},
                {16, 9, 14, 19, 20}, {21, 22, 23, 24, 25}};
        Squarelotron squarelotron = new Squarelotron(size);
        assertArrayEquals(squarelotron.mainDiagonalFlip(ring).getMatrixSquarelotron(), expected);
    }

    /**
     * Test that verify to flip the main diagonal given a matrix with dimension Five for ring three.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingThree() {
        final int size = 5;
        final int ring = 3;
        final int[][] expected = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Squarelotron squarelotron = new Squarelotron(size);
        assertArrayEquals(squarelotron.mainDiagonalFlip(ring).getMatrixSquarelotron(), expected);
    }

    /**
     * Test that verify one rotation for squareletron matrix.
     */
    @Test
    public void testRotateRight1() {
        final int size = 5;
        final int numberOfRotate = 1;
        final int[][] expected = {{21, 16, 11, 6, 1}, {22, 17, 12, 7, 2}, {23, 18, 13, 8, 3},
                {24, 19, 14, 9, 4}, {25, 20, 15, 10, 5}};
        Squarelotron squarelotron = new Squarelotron(size);
        squarelotron.rotateRight(numberOfRotate);
        assertArrayEquals(squarelotron.getMatrixSquarelotron(), expected);
    }

    /**
     * Test that verify two rotation for squareletron matrix.
     */
    @Test
    public void testRotateRight2() {
        final int size = 5;
        final int numberOfRotate = 2;
        final int[][] expected = {{25, 24, 23, 22, 21}, {20, 19, 18, 17, 16}, {15, 14, 13, 12, 11},
                {10, 9, 8, 7, 6}, {5, 4, 3, 2, 1}};
        Squarelotron squarelotron = new Squarelotron(size);
        squarelotron.rotateRight(numberOfRotate);
        assertArrayEquals(squarelotron.getMatrixSquarelotron(), expected);
    }

    /**
     * Test that verify three rotation for squarelotron matrix.
     */
    @Test
    public void testRotateRight3() {
        final int size = 5;
        final int numberOfRotate = 3;
        final int[][] expected = {{5, 10, 15, 20, 25}, {4, 9, 14, 19, 24}, {3, 8, 13, 18, 23}, {2, 7, 12, 17, 22},
                {1, 6, 11, 16, 21}};
        Squarelotron squarelotron = new Squarelotron(size);
        squarelotron.rotateRight(numberOfRotate);
        assertArrayEquals(squarelotron.getMatrixSquarelotron(), expected);
    }

    /**
     * Test that verify four rotation for squarelotron matrix.
     */
    @Test
    public void testRotateRight4() {
        final int size = 5;
        final int numberOfRotate = 4;
        final int[][] expected = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Squarelotron squarelotron = new Squarelotron(size);
        squarelotron.rotateRight(numberOfRotate);
        assertArrayEquals(squarelotron.getMatrixSquarelotron(), expected);
    }


    /**
     * Test that verify five rotation for squarelotron matrix.
     */
    @Test
    public void testRotateRight5() {
        final int size = 5;
        final int numberOfRotate = 5;
        final int[][] expected = {{21, 16, 11, 6, 1}, {22, 17, 12, 7, 2}, {23, 18, 13, 8, 3},
                {24, 19, 14, 9, 4}, {25, 20, 15, 10, 5}};
        Squarelotron squarelotron = new Squarelotron(size);
        squarelotron.rotateRight(numberOfRotate);
        assertArrayEquals(squarelotron.getMatrixSquarelotron(), expected);
    }

    /**
     * Test that verify one rotation to the left side of squarelotron matrix.
     */
    @Test
    public void testRotateLeft1() {
        final int size = 5;
        final int numberOfRotate = -1;
        final int[][] expected = {{5, 10, 15, 20, 25}, {4, 9, 14, 19, 24}, {3, 8, 13, 18, 23},
                {2, 7, 12, 17, 22}, {1, 6, 11, 16, 21}};
        Squarelotron squarelotron = new Squarelotron(size);
        squarelotron.rotateRight(numberOfRotate);
        assertArrayEquals(squarelotron.getMatrixSquarelotron(), expected);
    }

    /**
     * Test that verify two rotation to the left side of squarelotron matrix.
     */
    @Test
    public void testRotateLeft2() {
        final int size = 5;
        final int numberOfRotate = -2;
        final int[][] expected = {{25, 24, 23, 22, 21}, {20, 19, 18, 17, 16}, {15, 14, 13, 12, 11},
                {10, 9, 8, 7, 6}, {5, 4, 3, 2, 1}};
        Squarelotron squarelotron = new Squarelotron(size);
        squarelotron.rotateRight(numberOfRotate);
        assertArrayEquals(squarelotron.getMatrixSquarelotron(), expected);
    }

    /**
     * Test that verify three rotation to the left side of squarelotron matrix.
     */
    @Test
    public void testRotateLeft3() {
        final int size = 5;
        final int numberOfRotate = -3;
        final int[][] expected = {{21, 16, 11, 6, 1}, {22, 17, 12, 7, 2}, {23, 18, 13, 8, 3},
                {24, 19, 14, 9, 4}, {25, 20, 15, 10, 5}};
        Squarelotron squarelotron = new Squarelotron(size);
        squarelotron.rotateRight(numberOfRotate);
        assertArrayEquals(squarelotron.getMatrixSquarelotron(), expected);
    }

    /**
     * Test that verify four rotation to the left side of squarelotron matrix.
     */
    @Test
    public void testRotateLeft4() {
        final int size = 5;
        final int numberOfRotate = -4;
        final int[][] expected = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Squarelotron squarelotron = new Squarelotron(size);
        squarelotron.rotateRight(numberOfRotate);
        assertArrayEquals(squarelotron.getMatrixSquarelotron(), expected);
    }

    /**
     * Test that verify five rotation to the left side of squarelotron matrix.
     */
    @Test
    public void testRotateLeft5() {
        final int size = 5;
        final int numberOfRotate = -5;
        final int[][] expected = {{5, 10, 15, 20, 25}, {4, 9, 14, 19, 24}, {3, 8, 13, 18, 23},
                {2, 7, 12, 17, 22}, {1, 6, 11, 16, 21}};
        Squarelotron squarelotron = new Squarelotron(size);
        squarelotron.rotateRight(numberOfRotate);
        assertArrayEquals(squarelotron.getMatrixSquarelotron(), expected);
    }
}
