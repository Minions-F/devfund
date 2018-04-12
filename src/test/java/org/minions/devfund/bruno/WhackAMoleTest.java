package org.minions.devfund.bruno;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This class in charged of testing the whack a mole game.
 */
public class WhackAMoleTest {
    private static final int NUM_ATTEMPTS = 50;
    private static final int GRID_DIMENSION = 10;
    private static final int NUM_MOLES = 10;
    private WhackAMole game;


    /**
     * Before test.
     */
    @Before
    public void beforeTest() {
        game = new WhackAMole(NUM_ATTEMPTS, GRID_DIMENSION);
    }

    /**
     * Verifies if the method generate a grind to print.
     */
    @Test
    public void place() {
        final int positionX = 0;
        final int positionY = 0;
        assertTrue(game.place(positionX, positionY));
    }

    /**
     * Verifies if the all moles was placed.
     */
    @Test
    public void placeAllMoles() {
        int expectedNumMoles = 0;
        int actualNumMoles = game.placeAllMoles(NUM_MOLES);
        assertEquals(actualNumMoles, expectedNumMoles);
    }

    /**
     * Verifies if the whack is the same place to the mole.
     */
    @Test
    public void whackValid() {
        final int xWhackMole = 5;
        final int yWhackMole = 5;
        game.place(xWhackMole, yWhackMole);
        assertTrue(game.whack(xWhackMole, yWhackMole));
    }

    /**
     * Verifies if the whack is the same place to the mole.
     */
    @Test
    public void whackInvalid() {
        final int xWhackMole = 11;
        final int yWhackMole = 8;
        assertFalse(game.whack(xWhackMole, yWhackMole));
    }

    /**
     * Verifies if the coordinates to exiting of the game.
     */
    @Test
    public void exitGameShouldBeTrue() {
        final int xWhackMole = -1;
        final int yWhackMole = -1;
        assertTrue(game.exitGame(xWhackMole, yWhackMole));
    }

    /**
     * Verifies if the coordinates to exiting of the game.
     */
    @Test
    public void exitGameShouldBeFalse() {
        final int xWhackMole = 7;
        final int yWhackMole = 8;
        assertFalse(game.exitGame(xWhackMole, yWhackMole));
    }

    /**
     * Verifies if the coordinates are are inside the size grid.
     */
    @Test
    public void validTheTwoCordinates() {
        final int xWhackMole = 4;
        final int yWhackMole = 5;
        assertTrue(game.validCordinates(xWhackMole, yWhackMole));
    }

    /**
     * Verifies if the coordinates are are inside the size grid.
     */
    @Test
    public void inValidTheTwoCordinates() {
        final int xWhackMole = -1;
        final int yWhackMole = 11;
        assertFalse(game.validCordinates(xWhackMole, yWhackMole));
    }

    /**
     * Verifies if the coordinates are are inside the size grid.
     */
    @Test
    public void inValidTheXCordinates() {
        final int xWhackMole = -1;
        final int yWhackMole = 8;
        assertFalse(game.validCordinates(xWhackMole, yWhackMole));
    }

    /**
     * Verifies if the coordinates are are inside the size grid.
     */
    @Test
    public void inValidTheYCordinates() {
        final int xWhackMole = 4;
        final int yWhackMole = 11;
        assertFalse(game.validCordinates(xWhackMole, yWhackMole));
    }

    /**
     * Verifies if the game should continue.
     */
    @Test
    public void gameOverForRendition() {
        final int xWhackMole = -1;
        final int yWhackMole = -1;
        game.placeAllMoles(NUM_MOLES);
        game.whack(xWhackMole, yWhackMole);
        assertTrue(game.gameOver());
    }

    /**
     * Verifies if the game should continue.
     */
    @Test
    public void gameOverContinuePlaying() {
        final int xWhackMole = 7;
        final int yWhackMole = 8;
        game.placeAllMoles(NUM_MOLES);
        game.whack(xWhackMole, yWhackMole);
        assertFalse(game.gameOver());
    }

    /**
     * Verifies if the game should continue.
     */
    @Test
    public void gameOverWithoutAttempts() {
        game.placeAllMoles(NUM_MOLES);
        game.setAttemptsLeft(0);
        assertTrue(game.gameOver());
    }

    /**
     * Verifies if the game should continue.
     */
    @Test
    public void gameOverWin() {
        game.setMolesLeft(0);
        assertTrue(game.gameOver());
    }

    /**
     * Verifies if the method generate a grind to print.
     */
    @Test
    public void printGridToUser() {
        game.printGridToUser();
    }
}