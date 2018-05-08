package org.minions.devfund.reinaldo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by reinaldo on 19-04-18.
 */
public class SquarelotronTest {

    public static final int SIZEMATRIXFOURT = 4;
    public static final int SIZEMATRIXTHREE = 3;
    public static final int SIZEMATRIXFIVE = 5;
    public static final int SIZEMATRIXTWO = 2;

    private Squarelotron squarelotron;

    /**
     * Before tests setup.
     */
    @Before
    public void setUp() {
        squarelotron = new Squarelotron(SIZEMATRIXFOURT);
    }

    /**
     * Test for optainer the testwhenUpsideDownFlipOneRing.
     */
    @Test
    public void testwhenUpsideDownFlipOneRing() {

        final int[][] expectedResult = new int[][]{{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
        int[][] actualResult = squarelotron.upsideDownFlip(1).getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test for optainer the testwhenUpsideDownFlipThreeRing.
     */
    @Test
    public void testwhenUpsideDownFlipThreeRing() {
        squarelotron = new Squarelotron(SIZEMATRIXTHREE);
        final int ring = 2;
        final int[][] expectedResult = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] actualResult = squarelotron.upsideDownFlip(ring).getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test for optainer the testwhenUpsideDownFlipfiveRingtwo.
     */
    @Test
    public void testwhenUpsideDownFlipfiveRingtwo() {
        squarelotron = new Squarelotron(SIZEMATRIXFIVE);
        final int ring = 2;
        final int[][] expectedResult = new int[][]{{1, 2, 3, 4, 5}, {6, 17, 18, 19, 10},
                {11, 12, 13, 14, 15}, {16, 7, 8, 9, 20}, {21, 22, 23, 24, 25}};
        int[][] actualResult = squarelotron.upsideDownFlip(ring).getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }


    /**
     * Test for optainer the upside down flip two ring.
     */
    @Test
    public void testwhenUpsideDownFlipTwoRing() {

        final int ring = 2;
        final int[][] expectedResult = new int[][]{{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
        int[][] actualResult = squarelotron.upsideDownFlip(ring).getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test for optainer the upside down flip two ring.
     */
    @Test
    public void testWhenmainDiagonalFlipOneRing() {
        squarelotron = new Squarelotron(SIZEMATRIXTWO);
        final int ring = 1;
        final int[][] expectedResult = new int[][]{{1, 3}, {2, 4}};
        int[][] actualResult = squarelotron.mainDiagonalFlip(ring).getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }


    /**
     * Test testMainDiagonalFlipDimensionFiveRingTwo.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingTwo() {

        squarelotron = new Squarelotron(SIZEMATRIXFIVE);
        final int ring = 2;
        final int[][] expectedResult = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 12, 17, 10},
                {11, 8, 13, 18, 15}, {16, 9, 14, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] actualResult = squarelotron.mainDiagonalFlip(ring).getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test for optainer the testMainDiagonalFlipDimensionFiveRingThree.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingThree() {

        squarelotron = new Squarelotron(SIZEMATRIXFIVE);
        final int ring = 3;
        final int[][] expectedResult = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] actualResult = squarelotron.mainDiagonalFlip(ring).getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test for optainer the testMainDiagonalFlipDimensionthreeRing2.
     */
    @Test
    public void testMainDiagonalFlipDimensionthreeRing2() {

        squarelotron = new Squarelotron(SIZEMATRIXTHREE);
        final int ring = 2;
        final int[][] expectedResult = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] actualResult = squarelotron.mainDiagonalFlip(ring).getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test for optainer the testWhenmainDiagonalFlipTwoRing.
     */
    @Test
    public void testWhenmainDiagonalFlipTwoRing() {
        squarelotron = new Squarelotron(SIZEMATRIXTHREE);
        final int ring = 1;
        final int[][] expectedResult = new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[][] actualResult = squarelotron.mainDiagonalFlip(ring).getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test for optainer the testWhenmainDiagonalFlipFourRing.
     */
    @Test
    public void testWhenmainDiagonalFlipFourRing() {
        final int ring = 1;
        final int[][] expectedResult = new int[][]{{1, 5, 9, 13}, {2, 6, 7, 14}, {3, 10, 11, 15}, {4, 8, 12, 16}};
        int[][] actualResult = squarelotron.mainDiagonalFlip(ring).getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test for optainer the upside down flip two ring.
     */
    @Test
    public void testWhenRouteRight() {

        squarelotron = new Squarelotron(SIZEMATRIXTWO);
        final int[][] expectedResult = new int[][]{{3, 1}, {4, 2}};
        squarelotron.rotateRight(1);
        int[][] actualResult = squarelotron.getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test for optainer testWhenRouteRighttwoTurns.
     */
    @Test
    public void testWhenRouteRighttwoTurns() {

        squarelotron = new Squarelotron(SIZEMATRIXTHREE);
        final int[][] expectedResult = new int[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        squarelotron.rotateRight(2);
        int[][] actualResult = squarelotron.getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test Route left.
     */
    @Test
    public void testWhenRouteLefttwoTurns() {

        squarelotron = new Squarelotron(SIZEMATRIXTHREE);
        final int[][] expectedResult = new int[][]{{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
        squarelotron.rotateRight(-1);
        int[][] actualResult = squarelotron.getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }
}
