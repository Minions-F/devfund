package org.minions.devfund.bruno;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * This class in charged of testing the squarelotron moves.
 */
public class SquarelotronTest {

    private static final int ROW_ZERO = 0;
    private static final int COL_ZERO = 0;
    private static final int ROW_ONE = 1;
    private static final int COL_ONE = 1;
    private static final int ROW_TWO = 2;
    private static final int COL_TWO = 2;
    private static final int ROW_THREE = 3;
    private static final int COL_THREE = 3;
    private static final int ROW_FOUR = 4;
    private static final int COL_FOUR = 4;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;
    private static final int NINE = 9;
    private static final int TEN = 10;
    private static final int ELEVEN = 11;
    private static final int TWELVE = 12;
    private static final int THIRTEEN = 13;
    private static final int FOURTEEN = 14;
    private static final int FIFTEEN = 15;
    private static final int SIXTEEN = 16;

    private Squarelotron square;

    /**
     * Sets the preconditions before the test.
     */
    @Before
    public void setUp() {
        final int sizeSquare = 4;
        square = new Squarelotron(sizeSquare);
    }

    /**
     * Tests if the squarelotron object is initialized as expected.
     */
    @Test
    public void testSquarelotron() {
        final int[][] squarelotron = square.getSquarelotron();
        final int actualSize = square.getSize();
        final int expectedSize = 4;
        assertTrue(squarelotron[ROW_ZERO][COL_ZERO] == 1);
        assertTrue(squarelotron[ROW_ZERO][COL_ONE] == 2);
        assertTrue(squarelotron[ROW_ZERO][COL_TWO] == THREE);
        assertTrue(squarelotron[ROW_ZERO][COL_THREE] == FOUR);
        assertTrue(squarelotron[ROW_ONE][COL_ZERO] == FIVE);
        assertTrue(squarelotron[ROW_ONE][COL_ONE] == SIX);
        assertTrue(squarelotron[ROW_ONE][COL_TWO] == SEVEN);
        assertTrue(squarelotron[ROW_ONE][COL_THREE] == EIGHT);
        assertTrue(squarelotron[ROW_TWO][COL_ZERO] == NINE);
        assertTrue(squarelotron[ROW_TWO][COL_ONE] == TEN);
        assertTrue(squarelotron[ROW_TWO][COL_TWO] == ELEVEN);
        assertTrue(squarelotron[ROW_TWO][COL_THREE] == TWELVE);
        assertTrue(squarelotron[ROW_THREE][COL_ZERO] == THIRTEEN);
        assertTrue(squarelotron[ROW_THREE][COL_ONE] == FOURTEEN);
        assertTrue(squarelotron[ROW_THREE][COL_TWO] == FIFTEEN);
        assertTrue(squarelotron[ROW_THREE][COL_THREE] == SIXTEEN);
        assertTrue(actualSize == expectedSize);
    }

    /**
     * Tests if the new squarelotron object makes the moves correctly.
     */
    @Test
    public void testUpsideDownFlip() {
        final int[][] squarelotronOrigin = square.getSquarelotron();
        final Squarelotron firstFlip = square.upsideDownFlip(1);
        final int[][] firstSquarelotron = firstFlip.getSquarelotron();
        final Squarelotron secondFlip = firstFlip.upsideDownFlip(1);
        final int[][] secondSquarelotron = secondFlip.getSquarelotron();
        assertTrue(firstSquarelotron[ROW_ZERO][COL_ZERO] == THIRTEEN);
        assertTrue(firstSquarelotron[ROW_ZERO][COL_ONE] == FOURTEEN);
        assertTrue(firstSquarelotron[ROW_ZERO][COL_TWO] == FIFTEEN);
        assertTrue(firstSquarelotron[ROW_ZERO][COL_THREE] == SIXTEEN);
        assertTrue(firstSquarelotron[ROW_ONE][COL_ZERO] == NINE);
        assertTrue(firstSquarelotron[ROW_ONE][COL_ONE] == SIX);
        assertTrue(firstSquarelotron[ROW_ONE][COL_TWO] == SEVEN);
        assertTrue(firstSquarelotron[ROW_ONE][COL_THREE] == TWELVE);
        assertTrue(firstSquarelotron[ROW_TWO][COL_ZERO] == FIVE);
        assertTrue(firstSquarelotron[ROW_TWO][COL_ONE] == TEN);
        assertTrue(firstSquarelotron[ROW_TWO][COL_TWO] == ELEVEN);
        assertTrue(firstSquarelotron[ROW_TWO][COL_THREE] == EIGHT);
        assertTrue(firstSquarelotron[ROW_THREE][COL_ZERO] == 1);
        assertTrue(firstSquarelotron[ROW_THREE][COL_ONE] == 2);
        assertTrue(firstSquarelotron[ROW_THREE][COL_TWO] == THREE);
        assertTrue(firstSquarelotron[ROW_THREE][COL_THREE] == FOUR);
        assertTrue(squarelotronOrigin[ROW_ZERO][COL_ZERO] == secondSquarelotron[ROW_ZERO][COL_ZERO]);
        assertTrue(squarelotronOrigin[ROW_TWO][COL_TWO] == secondSquarelotron[ROW_TWO][COL_TWO]);
    }

    /**
     * Tests if the new squarelotron object makes the moves correctly.
     */
    @Test
    public void testMainDiagonalFlip() {
        final int[][] squarelotronOrigin = square.getSquarelotron();
        final Squarelotron firstFlip = square.mainDiagonalFlip(1);
        final int[][] firstSquarelotron = firstFlip.getSquarelotron();
        final Squarelotron secondFlip = firstFlip.mainDiagonalFlip(1);
        final int[][] secondSquarelotron = secondFlip.getSquarelotron();
        assertTrue(firstSquarelotron[ROW_ZERO][COL_ZERO] == 1);
        assertTrue(firstSquarelotron[ROW_ZERO][COL_ONE] == FIVE);
        assertTrue(firstSquarelotron[ROW_ZERO][COL_TWO] == NINE);
        assertTrue(firstSquarelotron[ROW_ZERO][COL_THREE] == THIRTEEN);
        assertTrue(firstSquarelotron[ROW_ONE][COL_ZERO] == 2);
        assertTrue(firstSquarelotron[ROW_ONE][COL_ONE] == SIX);
        assertTrue(firstSquarelotron[ROW_ONE][COL_TWO] == SEVEN);
        assertTrue(firstSquarelotron[ROW_ONE][COL_THREE] == FOURTEEN);
        assertTrue(firstSquarelotron[ROW_TWO][COL_ZERO] == THREE);
        assertTrue(firstSquarelotron[ROW_TWO][COL_ONE] == TEN);
        assertTrue(firstSquarelotron[ROW_TWO][COL_TWO] == ELEVEN);
        assertTrue(firstSquarelotron[ROW_TWO][COL_THREE] == FIFTEEN);
        assertTrue(firstSquarelotron[ROW_THREE][COL_ZERO] == FOUR);
        assertTrue(firstSquarelotron[ROW_THREE][COL_ONE] == EIGHT);
        assertTrue(firstSquarelotron[ROW_THREE][COL_TWO] == TWELVE);
        assertTrue(firstSquarelotron[ROW_THREE][COL_THREE] == SIXTEEN);
        assertTrue(squarelotronOrigin[ROW_ZERO][COL_ZERO] == secondSquarelotron[ROW_ZERO][COL_ZERO]);
        assertTrue(squarelotronOrigin[ROW_TWO][COL_TWO] == secondSquarelotron[ROW_TWO][COL_TWO]);
    }

    /**
     * Tests if the new squarelotron object rotates to the right correctly.
     */
    @Test
    public void testRotateRight() {
        final int[][] squarelotronOrigin = square.getSquarelotron();
        final int squareSize = 5;
        final int numberOfTurns = 5;
        final int negativeRotateTwo = -2;
        final int negativeRotate0ne = -1;
        final int negativeRotateFive = -5;
        square.rotateRight(1);
        square.rotateRight(negativeRotate0ne);
        assertTrue(squarelotronOrigin[ ROW_ZERO][COL_ZERO] == 1);
        square.rotateRight(negativeRotateTwo);
        assertTrue(squarelotronOrigin[ROW_ZERO][COL_ZERO] == SIXTEEN);

        final Squarelotron positive = new Squarelotron(squareSize);
        final Squarelotron negative = new Squarelotron(squareSize);
        final int[][] squarelotronPositive = positive.getSquarelotron();
        final int[][] squarelotronNegative = negative.getSquarelotron();
        negative.rotateRight(negativeRotateFive);
        negative.rotateRight(numberOfTurns);
        assertEquals(squarelotronPositive[ROW_THREE][COL_FOUR], squarelotronNegative[ROW_THREE][COL_FOUR]);
        negative.rotateRight(negativeRotate0ne);
        assertEquals(squarelotronPositive[ROW_ZERO][COL_ZERO], squarelotronNegative[ROW_FOUR][COL_ZERO]);
    }

    /**
     * Tests if the new squarelotron object rotates to the right correctly.
     */
    @Test
    public void testRotateRightZizeEigth() {
        final int squareSize = 8;
        final int negativeRotateTwo = -2;
        final int positiveRotate0ne = 2;
        final Squarelotron neutro = new Squarelotron(squareSize);
        final int[][] squarelotronNeutro = neutro.getSquarelotron();
        neutro.rotateRight(positiveRotate0ne);
        neutro.rotateRight(negativeRotateTwo);
        assertTrue(squarelotronNeutro[ROW_ZERO][COL_ZERO] == 1);
    }
}

