package org.minions.devfund.yuri;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public static final int EXPECTED_MOLES = 9;
    private WhackAMole game;

    /**
     * Method setup.
     */
    @Before
    public void setUp() {
        game = new WhackAMole(NUM_ATTEMPTS, GRID_DIMENSION);
    }

    /**
     * Verifies that a mole is placed in specific cell.
     */
    @Test
    public void testMoleIsPlacedInSpecificCell() {
        game.place(POS_X, POS_Y);
        assertEquals(MOLE, game.getGrid()[POS_X][POS_Y]);
    }

    /**
     * Verifies that an specific cell is empty.
     */
    @Test
    public void testAnSpecificCellIsEmpty() {
        game.getGrid()[POS_X][POS_Y] = EMPTYCELL;
        assertTrue(game.isEmptyCell(POS_X, POS_Y));
    }

    /**
     * Verifies that an specific cell is a mole.
     */
    @Test
    public void testAnSpecificCellIsMole() {
        game.getGrid()[POS_X][POS_Y] = MOLE;
        assertTrue(game.isMole(POS_X, POS_Y));
    }

    /**
     * Verifies the number attempts configured is correct.
     */
    @Test
    public void testNumberAttemptsIsCorrect() {
        assertEquals(NUM_ATTEMPTS, game.getAttemptsLeft());
    }

    /**
     *
     */
    @Test
    public void testMolesAmountInsertedInGridIsCorrect() {
        int accumulator = 0;
        for (int row = 0; row < game.getDimension(); row++) {
            for (int column = 0; column < game.getGrid()[row].length; column++) {
                if (game.getGrid()[row][column] == MOLE) {
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
        game.whack(POS_X, POS_Y);
        assertEquals(WACKED, game.getGrid()[POS_X][POS_Y]);
    }

    /**
     * Verifies that the moles left decrease when a moles is hit.
     */
    @Test
    public void testMolesLeftDecreaseWhenAMoleIsWhacked() {
        game.place(POS_X, POS_Y);
        game.whack(POS_X, POS_Y);
        assertEquals(EXPECTED_MOLES, game.getMolesLeft());
    }

    /**
     * Verifies that the cells grid are filled.
     */
    @Test
    public void testAllCellsGridAreFilled() {
        int accumulator = 0;
        for (int row = 0; row < game.getDimension(); row++) {
            for (int column = 0; column < game.getGrid()[row].length; column++) {
                if (!Character.isWhitespace(game.getGrid()[row][column])) {
                    accumulator++;
                }
            }
        }
        assertEquals(CELLS_AMOUNT, accumulator);
    }
}
