package org.minions.devfund.alvaro;

import org.junit.Assert;
import org.junit.Test;

/**
 * test for whack a mole game.
 */
public class WhackAMoleTest {
    private WhackAMole whackAMole;

    /**
     * constructor .
     */
    public WhackAMoleTest() {
        final int gridDimension = 3;
        whackAMole = new WhackAMole(2, gridDimension);
    }

    /**
     * print whacks and moles.
     */
    @Test
    public void printGridTest() {
        whackAMole.place(0, 0);
        whackAMole.place(1, 1);
        whackAMole.place(2, 2);
        whackAMole.whack(0, 0);
        whackAMole.whack(1, 1);
        whackAMole.printGrid();
    }

    /**
     * print grid for user.
     */
    @Test
    public void printGridToUser() {
        whackAMole.place(0, 0);
        whackAMole.place(1, 1);
        whackAMole.place(2, 2);
        whackAMole.whack(0, 0);
        whackAMole.whack(1, 1);
        whackAMole.printGridToUser();
    }

    /**
     * This test verifies if a mole could be place en the same position returning false is the position is occupied .
     */
    @Test
    public void placeTest() {
        Assert.assertTrue(whackAMole.place(0, 0));
        Assert.assertFalse(whackAMole.place(0, 0));
    }

    /**
     * This test verifies if a mole is placed then the moles left variable should decrement.
     */
    @Test
    public void placeMoleDecrement() {
        whackAMole.place(0, 0);
        whackAMole.place(1, 1);
        whackAMole.place(2, 2);
        Assert.assertFalse(whackAMole.place(1, 0));
    }

    /**
     * This test verify that the whack hits in a mole the score , attempts and moles left variables should updated.
     */
    @Test
    public void whackTest1() {
        final int scoreWithAMoleWhacked = 10;
        whackAMole.place(0, 0);
        whackAMole.place(1, 1);
        whackAMole.place(2, 2);
        whackAMole.whack(0, 0);
        Assert.assertEquals(scoreWithAMoleWhacked, whackAMole.getScore());
        Assert.assertEquals(1, whackAMole.getAttemptsLeft());
        Assert.assertEquals(2, whackAMole.getMolesLeft());
    }

    /**
     * This test verify that the whack hits in a mole twice the score should increment twice to and also
     * the attempts and moles left variables should be updated.
     */
    @Test
    public void whackTest2() {
        final int scoreWithAMoleWhackedTwice = 20;
        whackAMole.place(0, 0);
        whackAMole.place(1, 1);
        whackAMole.place(2, 2);
        whackAMole.whack(0, 0);
        whackAMole.whack(1, 1);
        Assert.assertEquals(scoreWithAMoleWhackedTwice, whackAMole.getScore());
        Assert.assertEquals(0, whackAMole.getAttemptsLeft());
        Assert.assertEquals(1, whackAMole.getMolesLeft());
    }
}
