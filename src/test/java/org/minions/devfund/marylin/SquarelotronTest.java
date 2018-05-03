package org.minions.devfund.marylin;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * SquarelotronTest class.
 */
public class SquarelotronTest {
    final static public int ZERO = 0;
    final static public int ONE = 1;
    final static public int TWO = 2;
    final static public int THREE = 3;
    final static public int FOUR = 4;
    final static public int FIVE = 5;

    /**********************************************************
     **********************upsideDownFlip**********************
     *********************************************************/

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testUpsideDownFlipTwoByTwoGridFirstRing() {
        Squarelotron initialSquarelotron = new Squarelotron(TWO);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{3, 4}, {1, 2}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(ONE);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testUpsideDownFlipThreeByThreeGridFirstRing() {
        Squarelotron initialSquarelotron = new Squarelotron(THREE);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(ONE);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testUpsideDownFlipThreeByThreeGridSecondRing() {
        System.out.println("========INITIAL=========");
        Squarelotron initialSquarelotron = new Squarelotron(THREE);
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(TWO);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testUpsideDownFlipFourByFourGridFirstRing() {
        Squarelotron initialSquarelotron = new Squarelotron(FOUR);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(ONE);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }


    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testUpsideDownFlipFourByFourGridSecondRing() {
        Squarelotron initialSquarelotron = new Squarelotron(FOUR);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(TWO);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testUpsideDownFlipFiveByFiveGridFirstRing() {
        Squarelotron initialSquarelotron = new Squarelotron(FIVE);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{21, 22, 23, 24, 25}, {16, 7, 8, 9, 20},
                {11, 12, 13, 14, 15}, {6, 17, 18, 19, 10}, {1, 2, 3, 4, 5}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(ONE);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testUpsideDownFlipFiveByFiveGridSecondRing() {
        Squarelotron initialSquarelotron = new Squarelotron(FIVE);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 17, 18, 19, 10},
                {11, 12, 13, 14, 15}, {16, 7, 8, 9, 20}, {21, 22, 23, 24, 25}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(TWO);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));

    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testUpsideDownFlipFiveByFiveGridThirdRing() {
        Squarelotron initialSquarelotron = new Squarelotron(FIVE);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.upsideDownFlip(THREE);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    /**********************************************************
     *********************mainDiagonalFlip*********************
     *********************************************************/

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testMainDiagonalFlipTwoByTwoGridFirstRing() {
        Squarelotron initialSquarelotron = new Squarelotron(TWO);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{1, 3}, {2, 4}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.mainDiagonalFlip(ONE);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testMainDiagonalFlipThreeByThreeGridFirstRing() {
        System.out.println("========INITIAL=========");
        Squarelotron initialSquarelotron = new Squarelotron(THREE);
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.mainDiagonalFlip(ONE);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testMainDiagonalFlipThreeByThreeGridSecondRing() {
        System.out.println("========INITIAL=========");
        Squarelotron initialSquarelotron = new Squarelotron(THREE);
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.mainDiagonalFlip(TWO);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testMainDiagonalFlipFourByFourGridFirstRing() {
        Squarelotron initialSquarelotron = new Squarelotron(FOUR);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{1, 5, 9, 13}, {2, 6, 7, 14}, {3, 10, 11, 15}, {4, 8, 12, 16}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.mainDiagonalFlip(ONE);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }


    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testMainDiagonalFlipFourByFourGridSecondRing() {
        Squarelotron initialSquarelotron = new Squarelotron(FOUR);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{1, 2, 3, 4}, {5, 6, 10, 8}, {9, 7, 11, 12}, {13, 14, 15, 16}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.mainDiagonalFlip(TWO);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testMainDiagonalFlipFiveByFiveGridFirstRing() {
        Squarelotron initialSquarelotron = new Squarelotron(FIVE);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{1, 6, 11, 16, 21}, {2, 7, 8, 9, 22},
                {3, 12, 13, 14, 23}, {4, 17, 18, 19, 24}, {5, 10, 15, 20, 25}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.mainDiagonalFlip(ONE);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testMainDiagonalFlipFiveByFiveGridSecondRing() {
        Squarelotron initialSquarelotron = new Squarelotron(FIVE);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 12, 17, 10},
                {11, 8, 13, 18, 15}, {16, 9, 14, 19, 20}, {21, 22, 23, 24, 25}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.mainDiagonalFlip(TWO);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));

    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testMainDiagonalFlipFiveByFiveGridThirdRing() {
        Squarelotron initialSquarelotron = new Squarelotron(FIVE);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        Squarelotron actualSquarelotron = initialSquarelotron.mainDiagonalFlip(THREE);
        System.out.println("*******ACTUAL**********");
        actualSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(actualSquarelotron));
    }

    /*********************************************************
     ************************rotateRight***********************
     *********************************************************/

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testRotateRightTwoByTwoGridFirstRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(TWO);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{3, 1}, {4, 2}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        initialSquarelotron.rotateRight(ONE);
        System.out.println("*******ACTUAL**********");
        initialSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(initialSquarelotron));
    }

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testRotateRightTwoByTwoGridSecondRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(TWO);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{4, 3}, {2, 1}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        initialSquarelotron.rotateRight(TWO);
        System.out.println("*******ACTUAL**********");
        initialSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(initialSquarelotron));
    }

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testRotateRightTwoByTwoGridThirdRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(TWO);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{2, 4}, {1, 3}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        initialSquarelotron.rotateRight(THREE);
        System.out.println("*******ACTUAL**********");
        initialSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(initialSquarelotron));
    }

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testRotateRightTwoByTwoGridFourthRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(TWO);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{1, 2}, {3, 4}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        initialSquarelotron.rotateRight(FOUR);
        System.out.println("*******ACTUAL**********");
        initialSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(initialSquarelotron));
    }

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testRotateRightTwoByTwoGridZerothRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(TWO);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{1, 2}, {3, 4}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        initialSquarelotron.rotateRight(ZERO);
        System.out.println("*******ACTUAL**********");
        initialSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(initialSquarelotron));
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testRotateRightThreeByThreeGridFirstRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(THREE);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        initialSquarelotron.rotateRight(ONE);
        System.out.println("*******ACTUAL**********");
        initialSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(initialSquarelotron));
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testRotateRightThreeByThreeGridSecondRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(THREE);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        initialSquarelotron.rotateRight(TWO);
        System.out.println("*******ACTUAL**********");
        initialSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(initialSquarelotron));
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testRotateRightThreeByThreeGridThirdRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(THREE);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        initialSquarelotron.rotateRight(THREE);
        System.out.println("*******ACTUAL**********");
        initialSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(initialSquarelotron));
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testRotateRightThreeByThreeGridFourthRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(THREE);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        initialSquarelotron.rotateRight(FOUR);
        System.out.println("*******ACTUAL**********");
        initialSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(initialSquarelotron));
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testRotateRightThreeByThreeGridZeroRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(THREE);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        initialSquarelotron.rotateRight(ZERO);
        System.out.println("*******ACTUAL**********");
        initialSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(initialSquarelotron));
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testRotateRightFourByFourGridFirstRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(FOUR);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        initialSquarelotron.rotateRight(ONE);
        System.out.println("*******ACTUAL**********");
        initialSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(initialSquarelotron));
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testRotateRightFourByFourGridSecondRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(FOUR);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        initialSquarelotron.rotateRight(TWO);
        System.out.println("*******ACTUAL**********");
        initialSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(initialSquarelotron));
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testRotateRightFourByFourGridThirdRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(FOUR);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{4, 8, 12, 16}, {3, 7, 11, 15}, {2, 6, 10, 14}, {1, 5, 9, 13}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        initialSquarelotron.rotateRight(THREE);
        System.out.println("*******ACTUAL**********");
        initialSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(initialSquarelotron));
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testRotateRightFourByFourGridFourthRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(FOUR);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        initialSquarelotron.rotateRight(FOUR);
        System.out.println("*******ACTUAL**********");
        initialSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(initialSquarelotron));
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testRotateRightFourByFourGridZeroRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(FOUR);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        initialSquarelotron.rotateRight(ZERO);
        System.out.println("*******ACTUAL**********");
        initialSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(initialSquarelotron));
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateRightFiveByFiveGridFirstRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(FIVE);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{21, 16, 11, 6, 1}, {22, 17, 12, 7, 2},
                {23, 18, 13, 8, 3}, {24, 19, 14, 9, 4}, {25, 20, 15, 10, 5}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        initialSquarelotron.rotateRight(ONE);
        System.out.println("*******ACTUAL**********");
        initialSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(initialSquarelotron));
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateRightFiveByFiveGridSecondRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(FIVE);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{25, 24, 23, 22, 21}, {20, 19, 18, 17, 16},
                {15, 14, 13, 12, 11}, {10, 9, 8, 7, 6}, {5, 4, 3, 2, 1}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        initialSquarelotron.rotateRight(TWO);
        System.out.println("*******ACTUAL**********");
        initialSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(initialSquarelotron));
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateRightFiveByFiveGridThirdRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(FIVE);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{5, 10, 15, 20, 25}, {4, 9, 14, 19, 24},
                {3, 8, 13, 18, 23}, {2, 7, 12, 17, 22}, {1, 6, 11, 16, 21}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        initialSquarelotron.rotateRight(THREE);
        System.out.println("*******ACTUAL**********");
        initialSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(initialSquarelotron));
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateRightFiveByFiveGridFourRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(FIVE);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        initialSquarelotron.rotateRight(FOUR);
        System.out.println("*******ACTUAL**********");
        initialSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(initialSquarelotron));
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateRightFiveByFiveGridZeroRotate() {
        Squarelotron initialSquarelotron = new Squarelotron(FIVE);
        System.out.println("========INITIAL=========");
        initialSquarelotron.printSquarelotron();
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Squarelotron expectedSquarelotron = new Squarelotron(expectedGrid);
        System.out.println("-------EXPECTED---------");
        expectedSquarelotron.printSquarelotron();
        initialSquarelotron.rotateRight(ZERO);
        System.out.println("*******ACTUAL**********");
        initialSquarelotron.printSquarelotron();
        assertTrue("Grid is not the expected.", expectedSquarelotron.equals(initialSquarelotron));
    }
}
