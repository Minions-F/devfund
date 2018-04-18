package org.minions.devfund.yuri;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * It is in charge to test the WackAMole class functionality.
 */
public class WackAMoleTest {
    public static final int POS_X = 1;
    public static final int POS_Y = 3;
    public static final int GRID_DIMENSION = 10;
    public static final int MOLES_AMOUNT = 10;
    public static final int CELLS_AMOUNT = 100;
    public static final int NUM_ATTEMPTS = 50;
    public static final char MOLE = 'M';
    public static final char WACKED = 'W';
    public static final char EMPTYCELL = '*';
    private WhackAMole wackamole;

    /**
     * Method setup.
     */
    @Before
    public void setUp() {
        wackamole = new WhackAMole(NUM_ATTEMPTS, GRID_DIMENSION);
        wackamole.insertMoles(GRID_DIMENSION);
    }

    /**
     * Verifies that a mole is placed in specific cell.
     */
    @Test
    public void testMoleIsPlacedInSpecificCell() {
        wackamole.place(POS_X, POS_Y);
        assertEquals(MOLE, wackamole.getMoleGrid()[POS_X][POS_Y]);
    }

    /**
     * Verifies that an specific cell is empty.
     */
    @Test
    public void testAnSpecificCellIsEmpty() {
        wackamole.getMoleGrid()[POS_X][POS_Y] = EMPTYCELL;
        assertTrue(wackamole.isEmptyCell(POS_X, POS_Y));
    }

    /**
     * Verifies that an specific cell is a mole.
     */
    @Test
    public void testAnSpecificCellIsMole() {
        wackamole.getMoleGrid()[POS_X][POS_Y] = MOLE;
        assertTrue(wackamole.isMole(POS_X, POS_Y));
    }

    /**
     * Verifies the number attempts configured is correct.
     */
    @Test
    public void testNumberAttemptsIsCorrect() {
        assertEquals(NUM_ATTEMPTS, wackamole.getAttemptsLeft());
    }

    /**
     *
     */
    @Test
    public void testMolesAmountInsertedInGridIsCorrect() {
        wackamole.insertMoles(MOLES_AMOUNT);
        int accumulator = 0;
        for (int row = 0; row < wackamole.getDimension(); row++) {
            for (int column = 0; column < wackamole.getMoleGrid()[row].length; column++) {
                if (wackamole.getMoleGrid()[row][column] == MOLE) {
                    accumulator++;
                }
            }
        }
        assertEquals(MOLES_AMOUNT, accumulator);
    }

    /**
     * Verifies that a wack is inserted in the grid.
     */
    @Test
    public void testWackInsertedInGridIsCorrect() {
        wackamole.whack(POS_X, POS_Y);
        assertEquals(WACKED, wackamole.getMoleGrid()[POS_X][POS_Y]);
    }

    /**
     * Verifies that the moles left decrease when a moles is hit.
     */
    @Test
    public void testMolesLeftDecreaseWhenAMoleIsWhacked() {
        final int attempts = 5;
        final int dimension = 10;
        WhackAMole game = new WhackAMole(attempts, dimension);
        game.place(POS_X, POS_Y);
        game.whack(POS_X, POS_Y);
        assertEquals(0, game.getMolesLeft());
    }

    /**
     * Verifies that the cells grid are filled.
     */
    @Test
    public void testAllCellsGridAreFilled() {
        final int attempts = 5;
        final int dimension = 10;
        WhackAMole game = new WhackAMole(attempts, dimension);
        int accumulator = 0;
        for (int row = 0; row < game.getDimension(); row++) {
            for (int column = 0; column < game.getMoleGrid()[row].length; column++) {
                if (!Character.isWhitespace(game.getMoleGrid()[row][column])) {
                    accumulator++;
                }
            }
        }
        assertEquals(CELLS_AMOUNT, accumulator);
    }

    /**
     * Verifies that  grid for user is not empty.
     */
    @Test
    public void testPrintGridToUser() {
        String expectedResult = " ";
        assertNotEquals("The grid is empty", expectedResult, wackamole.printGridToUser());
    }

    /**
     * Verifies that  grid is not empty.
     */
    @Test
    public void testPrintGrid() {
        String expectedResult = " ";
        assertNotEquals("The grid is empty", expectedResult, wackamole.printGrid());
    }

    /**
     * Verifies that initial score for a player is  cero.
     */
    @Test
    public  void testInitialScore() {
        int expectedResult = 0;
        assertEquals(expectedResult, wackamole.getScore());
    }

    /**
     * Verifies that is possible to hit to empty cell.
     */
    @Test
    public void testWhackToEmptyCell() {
        int posX = 0;
        int posY = 0;
        wackamole.getMoleGrid()[posX][posY] = '*';
        wackamole.whack(posX, posY);
        assertEquals('W', wackamole.getMoleGrid()[posX][posY]);
    }

    /**
     * Verifies that a cell contains a mole.
     */
    @Test
    public void testTheCellIsMole() {
        int posX = 0;
        int posY = 0;
        wackamole.place(posX, posY);
        char expectedResult = 'M';
        assertEquals(expectedResult, wackamole.getMoleGrid()[posX][posY]);
    }

    /**
     * Verifies that a player is able to win.
     */
    @Test
    public void testPlayerWin() {
        final int attempts = 5;
        final int dimension = 10;
        WhackAMole game = new WhackAMole(attempts, dimension);
        game.place(0, 0);
        game.whack(0, 0);
        assertTrue(game.playerWin());
    }

    /**
     * Verifies that a player is able to win.
     */
    @Test
    public void testPlayerLose() {
        final int attempts = 5;
        final int dimension = 10;
        WhackAMole game = new WhackAMole(attempts, dimension);
        game.place(0, 0);
        game.whack(1, 1);
        assertFalse(game.playerWin());
    }
    /**
     * Verifies that a player does not have attempts.
     */
    @Test
    public void testPlayerNoAttempts() {
        final int attempts = 1;
        final int dimension = 10;
        WhackAMole game = new WhackAMole(attempts, dimension);
        game.place(0, 0);
        game.whack(1, 1);
        assertTrue(game.noAttempts());
    }

    /**
     * Verifies that a player has attempts.
     */
    @Test
    public void testPlayerWithAttempts() {
        final int attempts = 2;
        final int dimension = 10;
        WhackAMole game = new WhackAMole(attempts, dimension);
        game.place(0, 0);
        game.whack(1, 1);
        assertFalse(game.noAttempts());
    }
}
