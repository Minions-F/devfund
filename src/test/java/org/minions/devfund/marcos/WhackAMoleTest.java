package org.minions.devfund.marcos;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * It is in charged to define the unit tests for WhackAMole class.
 */
public class WhackAMoleTest {

    private static final int ATTEMPTS_NUMBER = 10;
    private static final int DIMENSION_LENGTH = 10;

    private WhackAMole whackAMole;

    /**
     * Before tests setup.
     */
    @Before
    public void setUp() {
        whackAMole = new WhackAMole(ATTEMPTS_NUMBER, DIMENSION_LENGTH);
    }

    /**
     * Get score new game test.
     */
    @Test
    public void getScoreNewGameTest() {
        final int expectedScore = 0;
        assertEquals(expectedScore, whackAMole.getScore());
    }

    /**
     * Get moles left new game test.
     */
    @Test
    public void getMolesLeftNewGameTest() {
        final int expectedMolesLeft = 0;
        assertEquals(expectedMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Get moles left with one mole in the game grid test.
     */
    @Test
    public void getMolesLeftWithOneMoleTest() {
        final int rowPlacement = 0;
        final int columnPlacement = 0;
        final int expectedMolesLeft = 1;
        whackAMole.place(rowPlacement, columnPlacement);
        assertEquals(expectedMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Place mole in row and column that is already taken test.
     */
    @Test
    public void placeMoleInPlaceAlreadyTakenTest() {
        final int rowPlacement = 1;
        final int columnPlacement = 1;
        whackAMole.place(rowPlacement, columnPlacement);
        assertFalse(whackAMole.place(rowPlacement, columnPlacement));
    }

    /**
     * Get attempts left in new game test.
     */
    @Test
    public void getAttemptsLeftNewGameTest() {
        assertEquals(ATTEMPTS_NUMBER, whackAMole.getAttemptsLeft());
    }

    /**
     * Get attempts left after first whack test.
     */
    @Test
    public void getAttemptsLeftAfterFirstWhackTest() {
        final int rowPlacement = 2;
        final int columnPlacement = 2;
        final int expectedAttempts = ATTEMPTS_NUMBER - 1;
        whackAMole.whack(rowPlacement, columnPlacement);
        assertEquals(expectedAttempts, whackAMole.getAttemptsLeft());
    }

    /**
     * Whack a place that contains a mole test.
     */
    @Test
    public void whackAMoleTest() {
        final int rowPlacement = 3;
        final int columnPlacement = 3;
        final int expectedMolesLeft = 0;
        whackAMole.place(rowPlacement, columnPlacement);
        whackAMole.whack(rowPlacement, columnPlacement);
        assertEquals(expectedMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Whack a game grid with invalid row and column test.
     */
    @Test
    public void whackInPlaceThatDoesNotExistOneTest() {
        final int rowPlacement = 5;
        final int columnPlacement = 7;
        final int whackRow = -1;
        final int whackColumn = -1;
        final int expectedMolesLeft = 1;
        whackAMole.place(rowPlacement, columnPlacement);
        whackAMole.whack(whackRow, whackColumn);
        assertEquals(expectedMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Whack a game grid with invalid row and valid column test.
     */
    @Test
    public void whackInPlaceThatDoesNotExistTwoTest() {
        final int rowPlacement = 9;
        final int columnPlacement = 1;
        final int whackRow = -1;
        final int whackColumn = 1;
        final int expectedMolesLeft = 1;
        whackAMole.place(rowPlacement, columnPlacement);
        whackAMole.whack(whackRow, whackColumn);
        assertEquals(expectedMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Whack a game grid with valid row and invalid column test.
     */
    @Test
    public void whackInPlaceThatDoesNotExistThreeTest() {
        final int rowPlacement = 8;
        final int columnPlacement = 5;
        final int whackRow = 1;
        final int whackColumn = -1;
        final int expectedMolesLeft = 1;
        whackAMole.place(rowPlacement, columnPlacement);
        whackAMole.whack(whackRow, whackColumn);
        assertEquals(expectedMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Whack a game grid with invalid exceeded row and invalid column test.
     */
    @Test
    public void whackInPlaceThatDoesNotExistFourTest() {
        final int rowPlacement = 4;
        final int columnPlacement = 6;
        final int whackRow = 100;
        final int whackColumn = -1;
        final int expectedMolesLeft = 1;
        whackAMole.place(rowPlacement, columnPlacement);
        whackAMole.whack(whackRow, whackColumn);
        assertEquals(expectedMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Whack a game grid with valid row and invalid exceeded column test.
     */
    @Test
    public void whackInPlaceThatDoesNotExistFiveTest() {
        final int rowPlacement = 4;
        final int columnPlacement = 6;
        final int whackRow = 1;
        final int whackColumn = 100;
        final int expectedMolesLeft = 1;
        whackAMole.place(rowPlacement, columnPlacement);
        whackAMole.whack(whackRow, whackColumn);
        assertEquals(expectedMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Whack in a place that exist inside the game grid test.
     */
    @Test
    public void whackInPlaceThatExistTest() {
        final int rowPlacement = 0;
        final int columnPlacement = 7;
        final int whackRow = 1;
        final int whackColumn = 1;
        final int expectedMolesLeft = 1;
        whackAMole.place(rowPlacement, columnPlacement);
        whackAMole.whack(whackRow, whackColumn);
        assertEquals(expectedMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Fill grid with moles test.
     */
    @Test
    public void fillGridTest() {
        final int molesNumber = 2;
        final int expectedMolesLeft = 2;
        whackAMole.fillGrid(molesNumber);
        assertEquals(expectedMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Fill grid with moles in places that are already take test.
     */
    @Test
    public void fillGridRepeatingPlaceTest() {
        final int gridDimension = 3;
        final int molesNumber = 7;
        final int expectedMolesLeft = 7;
        whackAMole = new WhackAMole(ATTEMPTS_NUMBER, gridDimension);
        whackAMole.fillGrid(molesNumber);
        assertEquals(expectedMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Print empty grid to user test.
     */
    @Test
    public void printEmptyGridToUserTest() {
        final String expectedGrid = "*  *  *  \n*  *  *  \n*  *  *  \n";
        final int gridDimension = 3;
        whackAMole = new WhackAMole(ATTEMPTS_NUMBER, gridDimension);
        assertEquals(expectedGrid, whackAMole.printGridToUser());
    }

    /**
     * Print grid to user with whack test.
     */
    @Test
    public void printGridWhackToUserTest() {
        final int gridDimension = 3;
        final int whackRow = 0;
        final int whackColumn = 0;
        final String expectedGrid = "W  *  *  \n*  *  *  \n*  *  *  \n";
        whackAMole = new WhackAMole(ATTEMPTS_NUMBER, gridDimension);
        whackAMole.whack(whackRow, whackColumn);
        assertEquals(expectedGrid, whackAMole.printGridToUser());
    }

    /**
     * Print the entire grid with moles and whacks.
     */
    @Test
    public void printGridTest() {
        final int gridDimension = 3;
        final int rowPlacement = 0;
        final int columnPlacement = 1;
        final int whackRow = 0;
        final int whackColumn = 0;
        final String expectedGrid = "W  M  *  \n*  *  *  \n*  *  *  \n";
        whackAMole = new WhackAMole(ATTEMPTS_NUMBER, gridDimension);
        whackAMole.whack(whackRow, whackColumn);
        whackAMole.place(rowPlacement, columnPlacement);
        assertEquals(expectedGrid, whackAMole.printGrid());
    }
}
