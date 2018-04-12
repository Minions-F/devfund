package org.minions.devfund.marcos;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * It is in charged to define the unit tests for WhackAMole class.
 */
public class WhackAMoleTest {

    private static final int TEN_ATTEMPTS = 10;
    private static final int DIMENSION_TEN = 10;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;
    private static final int NINE = 9;
    private static final int ONE_HUNDRED = 100;

    private WhackAMole whackAMole;

    /**
     * Before tests setup.
     */
    @Before
    public void setUp() {
        whackAMole = new WhackAMole(TEN_ATTEMPTS, DIMENSION_TEN);
    }

    /**
     * Get score test.
     */
    @Test
    public void getScoreTest() {
        int expectedScore = 0;
        assertEquals(expectedScore, whackAMole.getScore());
    }

    /**
     * Get moles left test.
     */
    @Test
    public void getMolesLeftTest() {
        int expectedMolesLeft = 0;
        assertEquals(expectedMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Get moles left with one mole in the game grid test.
     */
    @Test
    public void getMolesLeftWithOneMoleTest() {
        int expectedMolesLeft = 1;
        whackAMole.place(ZERO, ZERO);
        assertEquals(expectedMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Place mole in invalid grid row and column test.
     */
    @Test
    public void placeMoleInInvalidRowAndColumnTest() {
        whackAMole.place(ONE, ONE);
        assertFalse(whackAMole.place(ONE, ONE));
    }

    /**
     * Get attempts left test.
     */
    @Test
    public void getAttemptsLeftTest() {
        assertEquals(TEN_ATTEMPTS, whackAMole.getAttemptsLeft());
    }

    /**
     * Get attempts left when all the attempts were used.
     */
    @Test
    public void getAttemptsLeftEmpty() {
        int expectedAttempts = TEN_ATTEMPTS - 1;
        whackAMole.whack(TWO, TWO);
        assertEquals(expectedAttempts, whackAMole.getAttemptsLeft());
    }

    /**
     * Whack a place that contains a mole test.
     */
    @Test
    public void whackAMoleTest() {
        whackAMole.place(THREE, THREE);
        whackAMole.whack(THREE, THREE);
        assertEquals(ZERO, whackAMole.getMolesLeft());
    }

    /**
     * Whack a game grid with invalid row and column test.
     */
    @Test
    public void whackInPlaceThatDoesNotExistOneTest() {
        int whackRow = -1;
        int whackColumn = -1;
        whackAMole.place(FIVE, SEVEN);
        whackAMole.whack(whackRow, whackColumn);
        assertEquals(ONE, whackAMole.getMolesLeft());
    }

    /**
     * Whack a game grid with invalid row and valid column test.
     */
    @Test
    public void whackInPlaceThatDoesNotExistTwoTest() {
        int whackRow = -1;
        int whackColumn = 1;
        whackAMole.place(NINE, ONE);
        whackAMole.whack(whackRow, whackColumn);
        assertEquals(ONE, whackAMole.getMolesLeft());
    }

    /**
     * Whack a game grid with valid row and invalid column test.
     */
    @Test
    public void whackInPlaceThatDoesNotExistThreeTest() {
        int whackRow = 1;
        int whackColumn = -1;
        whackAMole.place(EIGHT, FIVE);
        whackAMole.whack(whackRow, whackColumn);
        assertEquals(ONE, whackAMole.getMolesLeft());
    }

    /**
     * Whack a game grid with invalid exceeded row and invalid column test.
     */
    @Test
    public void whackInPlaceThatDoesNotExistFourTest() {
        int whackColumn = -1;
        whackAMole.place(FOUR, SIX);
        whackAMole.whack(ONE_HUNDRED, whackColumn);
        assertEquals(ONE, whackAMole.getMolesLeft());
    }

    /**
     * Whack a game grid with valid row and invalid exceeded column test.
     */
    @Test
    public void whackInPlaceThatDoesNotExistFiveTest() {
        whackAMole.place(FOUR, SIX);
        whackAMole.whack(ONE, ONE_HUNDRED);
        assertEquals(ONE, whackAMole.getMolesLeft());
    }

    /**
     * Whack in a place that exist inside the game grid test.
     */
    @Test
    public void whackInPlaceThatExistTest() {
        int whackRow = 1;
        int whackColumn = 1;
        whackAMole.place(ZERO, SEVEN);
        whackAMole.whack(whackRow, whackColumn);
        assertEquals(ONE, whackAMole.getMolesLeft());
    }

    /**
     * Fill grid with moles test.
     */
    @Test
    public void fillGridTest() {
        whackAMole.fillGrid(TWO);
        assertEquals(TWO, whackAMole.getMolesLeft());
    }

    /**
     * Fill grid with moles in places that are already take test.
     */
    @Test
    public void fillGridRepeatingPlaceTest() {
        whackAMole = new WhackAMole(TEN_ATTEMPTS, THREE);
        whackAMole.fillGrid(SEVEN);
        assertEquals(SEVEN, whackAMole.getMolesLeft());
    }

    /**
     * Print empty grid to user test.
     */
    @Test
    public void printEmptyGridToUserTest() {
        String expectedGrid = "*  *  *  \n*  *  *  \n*  *  *  \n";
        whackAMole = new WhackAMole(TEN_ATTEMPTS, THREE);
        assertEquals(expectedGrid, whackAMole.printGridToUser());
    }

    /**
     * Print grid to user with whack test.
     */
    @Test
    public void printGridWhackToUserTest() {
        String expectedGrid = "W  *  *  \n*  *  *  \n*  *  *  \n";
        whackAMole = new WhackAMole(TEN_ATTEMPTS, THREE);
        whackAMole.whack(ZERO, ZERO);
        assertEquals(expectedGrid, whackAMole.printGridToUser());
    }

    /**
     * Print the entire grid with moles and whacks.
     */
    @Test
    public void printGridTest() {
        String expectedGrid = "W  M  *  \n*  *  *  \n*  *  *  \n";
        whackAMole = new WhackAMole(TEN_ATTEMPTS, THREE);
        whackAMole.whack(ZERO, ZERO);
        whackAMole.place(ZERO, ONE);
        assertEquals(expectedGrid, whackAMole.printGrid());
    }
}
