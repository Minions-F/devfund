package org.minions.devfund.sergio;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
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
    private static final int POS_5 = 5;
    private static final int POS_3 = 3;
    private static final int POS_2 = 2;
    private static final int POS_1 = 1;
    private static final int POS_4 = 4;
    private WhackAMole whackAMole;

    /**
     * Constructor for WhackAMoleTest.
     */
    public WhackAMoleTest() {
         this.whackAMole = new WhackAMole(ATTEMPTS, GRID_DIMENSION);
    }

    /**
     * Verifies if the place method works fine.
     */
    @Test
    public void verifyPlaceAMoleWorks() {


        assertTrue(whackAMole.place(1, POS_5));
    }

    /**
     * Verifies if whack works in the mole position.
     */
    @Test
    public void verifyWhackAMoleWorks() {
        whackAMole.place(POS_3, POS_3);
        whackAMole.whack(POS_3,  POS_3);
        assertEquals('W', whackAMole.getStatusPosition(POS_3,  POS_3));
    }

    /**
     * Verifies if whack miss is no change of grid.
     */
    @Test
    public void verifyWhackMissWorks() {
        whackAMole.whack(POS_2, POS_1);
        assertEquals('*', whackAMole.getStatusPosition(POS_2, POS_1));
    }

    /**
     * Verifies that the number of attempts id changed after a try.
     */
    @Test
    public void verifyAttemptsIsChangeAfterAWhack() {
        whackAMole.whack(POS_4, POS_2);
        assertEquals(ATTEMPTS - 1, whackAMole.getAttemptsLeft());
    }

    /**
     * Verifies that the score is changed after a whack hit.
     */
    @Test
    public void verifyScoreIsWorking() {
        whackAMole.place(POS_1, POS_2);
        whackAMole.whack(POS_1,  POS_2);
        assertEquals(SCORE + 1, whackAMole.getScore());
    }
}
