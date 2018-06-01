package org.minions.devfund.sergio;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Handles the test for game Whack a Mole.
 *
 * @author Sergio Navarro
 * @since 4/12/2018
 */
public class WhackAMoleTest {

    private static final int ATTEMPTS = 50;
    private static final int GRID_DIMENSION = 10;
    private static final int SCORE = 0;
    private static final int TOTAL_MOLES = 10;
    private WhackAMole whackAMole;


    /**
     * Constructor for WhackAMoleTest.
     */
    public WhackAMoleTest() {
        this.whackAMole = new WhackAMole(ATTEMPTS, GRID_DIMENSION, TOTAL_MOLES);
    }

    /**
     * Verifies if the place method works fine.
     */
    @Test
    public void verifyPlaceAMoleWorks() {
        final int posX = 1;
        final int posY = 5;
        assertTrue(whackAMole.place(posX, posY));
    }

    /**
     * Verifies if it not possible place a mole in a mole already created.
     */
    @Test
    public void verifyIsAlreadyAMole() {
        final int posX = 1;
        final int posY = 1;
        whackAMole.place(posX, posY);
        assertFalse(whackAMole.place(posX, posY));
    }

    /**
     * Verifies if whack works in the mole position.
     */
    @Test
    public void verifyWhackAMoleWorks() {
        final int posX = 3;
        final int posY = 3;
        whackAMole.place(posX, posY);
        whackAMole.whack(posX,  posY);
        assertEquals('W', whackAMole.getStatusPosition(posX,  posY));
    }

    /**
     * Verifies if whack miss is no change of grid.
     */
    @Test
    public void verifyWhackMissWorks() {
        final int posX = 2;
        final int posY = 1;
        whackAMole.whack(posX, posY);
        assertEquals('*', whackAMole.getStatusPosition(posX, posY));
    }

    /**
     * Verifies that the number of attempts id changed after a try.
     */
    @Test
    public void verifyAttemptsIsChangeAfterAWhack() {
        final int posX = 4;
        final int posY = 2;
        whackAMole.whack(posX, posY);
        assertEquals(ATTEMPTS - 1, whackAMole.getAttemptsLeft());
    }

    /**
     * Verifies that the score is changed after a whack hit.
     */
    @Test
    public void verifyScoreIsWorking() {
        final int posX = 1;
        final int posY = 2;
        whackAMole.place(posX, posY);
        whackAMole.whack(posX,  posY);
        assertEquals(SCORE + 1, whackAMole.getScore());
    }

    /**
     * Verifies if the grid for user no show the moles.
     */
    @Test
    public void verifyUserGridShowCorrectly() {
        final int posX = 4;
        final int posY = 5;
        whackAMole.place(posX, posY);
        StringBuilder test = new StringBuilder();
        for (int i = 0; i < GRID_DIMENSION; i++) {
            for (int j = 0; j < GRID_DIMENSION; j++) {
                test.append('*');
            }
            test.append("\n");
        }
        assertEquals(test.toString().trim(), whackAMole.getUserGrid().toString().trim());
    }

    /**
     * Verifies that get grid is working.
     */
    @Test
    public void verifyGetGridIsWorking() {
        final int posX = 2;
        final int posY = 2;
        whackAMole.place(posX, posY);
        StringBuilder test = new StringBuilder();
        for (int i = 0; i < GRID_DIMENSION; i++) {
            for (int j = 0; j < GRID_DIMENSION; j++) {
                boolean positionFound = i == posX && j == posY;
                if (positionFound) {
                    test.append('M');
                } else {
                    test.append('*');
                }
            }
            test.append("\n");
        }
        assertEquals(test.toString().trim(), whackAMole.getGrid().toString().trim());
    }

    /**
     * Verifies id the load mole is working in the Game.
     */
    @Test
    public void verifyLoadMoleIsWorking() {
        whackAMole.loadMole();
        assertEquals(whackAMole.getMolesLeft(), TOTAL_MOLES);
    }

    /**
     * Verifies that the load module jump an already mole in the grid.
     */
    @Test
    public void verifyLoadMoleJumpAMole() {
        final int totalMoles = 4;
        String test = "MM\nMM".trim();
        WhackAMole whackAMoleTest = new WhackAMole(1, 2, totalMoles);
        whackAMoleTest.loadMole();
        assertEquals(test, whackAMoleTest.getGrid().toString().trim());
    }
}
