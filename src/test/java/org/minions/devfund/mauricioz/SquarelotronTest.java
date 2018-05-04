package org.minions.devfund.mauricioz;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;

/**
 * Class that will test the class Squarelotron.
 */
public class SquarelotronTest {

    /**
     * This method will test squarelotron is instance of the Squareletron class.
     */
    @Test
    public void testSquarelotronInstanceOfSquarelotronClass() {

        final int localSize = 5;
        Squarelotron actualSquare = new Squarelotron(localSize);
        assertThat(actualSquare, instanceOf(Squarelotron.class));

    }

    /**
     * This method will test the flip using the first ring.
     */
    @Test
    public void testUpSideDownFlipFirstRing() {
        final int[][] expected = {{21, 22, 23, 24, 25}, {16, 7, 8, 9, 20},
                {11, 12, 13, 14, 15}, {6, 17, 18, 19, 10}, {1, 2, 3, 4, 5}};
        final int ring = 1;
        final int localSize = 5;
        Squarelotron actualSquare = new Squarelotron(localSize);
        actualSquare = actualSquare.upsideDownFlip(ring);
        assert Arrays.deepEquals(actualSquare.getTwoDimentionalSquarelotron(), expected);
    }

    /**
     * This method will test the flip using the second ring.
     */
    @Test
    public void testUpSideDownFlipThirdRing() {
        final int[][] expected = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        final int localSize = 5;
        final int ring = 3;
        Squarelotron actualSquare = new Squarelotron(localSize);
        actualSquare = actualSquare.upsideDownFlip(ring);
        assert Arrays.deepEquals(actualSquare.getTwoDimentionalSquarelotron(), expected);
    }

    /**
     * This method will test a diagonal flip with size 2 on the first and only ring.
     */
    @Test
    public void testMainDiagonalFlipSize2With1Ring() {

        final int[][] expected = {{1, 3}, {2, 4}};
        final int localSize = 2;
        final int ring = 1;
        Squarelotron actualSquare = new Squarelotron(localSize);
        actualSquare = actualSquare.mainDiagonalFlip(ring);
        assert Arrays.deepEquals(actualSquare.getTwoDimentionalSquarelotron(), expected);
    }

    /**
     * This method will test a diagonal flip with size 2 on the first and negative ring ring.
     */
    @Test
    public void testMainDiagonalFlipSize2WithNegativeRing() {

        final int[][] expected = {{1, 2}, {3, 4}};
        final int localSize = 2;
        final int ring = -1;
        Squarelotron actualSquare = new Squarelotron(localSize);
        actualSquare = actualSquare.mainDiagonalFlip(ring);
        assert Arrays.deepEquals(actualSquare.getTwoDimentionalSquarelotron(), expected);
    }

    /**
     * This method will test a diagonal flip with size 3 on the first and only ring.
     */
    @Test
    public void testMainDiagonalFlipSize3With1Ring() {

        final int[][] expected = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        final int localSize = 3;
        final int ring = 1;
        Squarelotron actualSquare = new Squarelotron(localSize);
        actualSquare = actualSquare.mainDiagonalFlip(ring);
        assert Arrays.deepEquals(actualSquare.getTwoDimentionalSquarelotron(), expected);
    }

    /**
     * This method will test a diagonal flip with size 5 on the first ring.
     */
    @Test
    public void testMainDiagonalFlipSize5With1Ring() {

        final int[][] expected = {{1, 6, 11, 16, 21}, {2, 7, 8, 9, 22}, {3, 12, 13, 14, 23},
                {4, 17, 18, 19, 24}, {5, 10, 15, 20, 25}};
        final int localSize = 5;
        final int ring = 1;
        Squarelotron actualSquare = new Squarelotron(localSize);
        actualSquare = actualSquare.mainDiagonalFlip(ring);
        assert Arrays.deepEquals(actualSquare.getTwoDimentionalSquarelotron(), expected);
    }

    /**
     * verify the rotation clockwise.
     */
    @Test
    public void testRotateRightClockWise2Times() {

        final int[][] expected = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        final int localSize = 3;
        final int times = 2;
        Squarelotron actualSquare = new Squarelotron(localSize);
        actualSquare.rotateRight(times);
        assert Arrays.deepEquals(actualSquare.getTwoDimentionalSquarelotron(), expected);
    }

    /**
     * verify rotation counter clockwise.
     */
    @Test
    public void testRotateRightCounterClockWiseMinus3Times() {

        final int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        final int localSize = 3;
        final int times = -3;
        Squarelotron actualSquare = new Squarelotron(localSize);
        actualSquare.rotateRight(times);
        assert Arrays.deepEquals(actualSquare.getTwoDimentionalSquarelotron(), expected);
    }

    /**
     * This test rotate one time to right.
     */
    @Test
    public void testRotateRight1() {
        final int localSize = 3;
        final int times = 1;
        final int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        Squarelotron actualSquare = new Squarelotron(localSize);
        actualSquare.rotateRight(times);
        assert Arrays.deepEquals(actualSquare.getTwoDimentionalSquarelotron(), expected);
    }

    /**
     * This test rotate 2 times to the right.
     */
    @Test
    public void testRotateRight2() {

        final int localSize = 2;
        final int times = 1;
        final int[][] expected = {{3, 1}, {4, 2}};
        Squarelotron actualSquare = new Squarelotron(localSize);
        actualSquare.rotateRight(times);
        assert Arrays.deepEquals(actualSquare.getTwoDimentionalSquarelotron(), expected);
    }

    /**
     * This test will verify rotation of zero times.
     */
    @Test
    public void testRotateRightWithZeroMoves() {

        final int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        final int localSize = 3;
        final int times = 0;
        Squarelotron actualSquare = new Squarelotron(localSize);
        actualSquare.rotateRight(times);
        assert Arrays.deepEquals(actualSquare.getTwoDimentionalSquarelotron(), expected);
    }

    /**
     * This test flip the 3rd ring of a 5x5 squarelotron in a main diagonal.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingThree() {

        final int[][] expected = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        final int localSize = 5;
        final int ring = 3;
        Squarelotron actualSquare = new Squarelotron(localSize);
        actualSquare = actualSquare.mainDiagonalFlip(ring);
        assert Arrays.deepEquals(actualSquare.getTwoDimentionalSquarelotron(), expected);
    }

    /**
     * This test flip upside down a 3x3 squarelotron of dimension three.
     */
    @Test
    public void testUpsideDownFlip3x31Ring() {

        final int[][] expected = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        final int localSize = 3;
        final int ring = 1;
        Squarelotron actualSquare = new Squarelotron(localSize);
        actualSquare = actualSquare.upsideDownFlip(ring);
        assert Arrays.deepEquals(actualSquare.getTwoDimentionalSquarelotron(), expected);
    }

    /**
     * this test flip a matrix with 4x4 and rign 2.
     */
    @Test
    public void testMainDiagonalFlip4X4Ring2() {

        final int[][] expected = {{1, 2, 3, 4}, {5, 6, 10, 8}, {9, 7, 11, 12}, {13, 14, 15, 16}};
        final int localSize = 4;
        final int ring = 2;
        Squarelotron actualSquare = new Squarelotron(localSize);
        actualSquare = actualSquare.mainDiagonalFlip(ring);
        assert Arrays.deepEquals(actualSquare.getTwoDimentionalSquarelotron(), expected);
    }

    /**
     * This test flip upside down a matrix of dimension three for a negative ring.
     */
    @Test
    public void testUpsideDownFlip3x3AndNegativeRing() {

        final int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        final int localSize = 3;
        final int ring = -1;
        Squarelotron actualSquare = new Squarelotron(localSize);
        actualSquare = actualSquare.upsideDownFlip(ring);
        assert Arrays.deepEquals(actualSquare.getTwoDimentionalSquarelotron(), expected);
    }
}
