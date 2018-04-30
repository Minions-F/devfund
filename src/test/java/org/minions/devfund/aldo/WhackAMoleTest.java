package org.minions.devfund.aldo;

import org.junit.Assert;
import org.junit.Test;

/**
 * WhackAMole Test.
 */
public class WhackAMoleTest {
    private WhackAMole whackAMole;

    /**
     * Constructor.
     */
    public WhackAMoleTest() {
        final int numAttempts = 2;
        final int gridDimension = 3;
        whackAMole = new WhackAMole(numAttempts, gridDimension);
        final int positionX = 0;
        final int positionY = 0;
        final int positionX1 = 1;
        final int positionY1 = 1;
        final int positionX2 = 2;
        final int positionY2 = 2;
        whackAMole.place(positionX, positionY);
        whackAMole.place(positionX1, positionY1);
        whackAMole.place(positionX2, positionY2);
    }

    /**
     * printGridTest.
     */
    @Test
    public void printGridTest() {
        final int positionX = 0;
        final int positionY = 0;
        final int positionX1 = 1;
        final int positionY1 = 1;
        whackAMole.whack(positionX, positionY);
        whackAMole.whack(positionX1, positionY1);
        whackAMole.printGrid();
    }

    /**
     * printGridToUser.
     */
    @Test
    public void printGridToUser() {
        final int positionX = 0;
        final int positionY = 0;
        final int positionX1 = 1;
        final int positionY1 = 1;
        whackAMole.whack(positionX, positionY);
        whackAMole.whack(positionX1, positionY1);
        whackAMole.printGridToUser();
    }

    /**
     * placeTest.
     */
    @Test
    public void placeTest() {
        final int positionX = 0;
        final int positionY = 0;
        Assert.assertFalse(whackAMole.place(positionX, positionY));
    }

    /**
     * placeMoleDecrement.
     */
    @Test
    public void placeMoleDecrement() {
        final int positionX = 1;
        final int positionY = 0;
        Assert.assertFalse(whackAMole.place(positionX, positionY));
    }

    /**
     * whackTest1.
     */
    @Test
    public void whackTest1() {
        final int positionX = 0;
        final int positionY = 0;
        final int expectedScore = 10;
        final int expectedAttemptsLeft = 1;
        final int expectedMolesLeft = 2;
        whackAMole.whack(positionX, positionY);
        Assert.assertEquals(expectedScore, whackAMole.getScore());
        Assert.assertEquals(expectedAttemptsLeft, whackAMole.getAttemptsLeft());
        Assert.assertEquals(expectedMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * whackTest2.
     */
    @Test
    public void whackTest2() {
        final int positionX = 0;
        final int positionY = 0;
        final int positionX1 = 1;
        final int positionY1 = 1;
        final int expectedScore = 20;
        final int expectedAttemptsLeft = 0;
        final int expectedMolesLeft = 1;
        whackAMole.whack(positionX, positionY);
        whackAMole.whack(positionX1, positionY1);
        Assert.assertEquals(expectedScore, whackAMole.getScore());
        Assert.assertEquals(expectedAttemptsLeft, whackAMole.getAttemptsLeft());
        Assert.assertEquals(expectedMolesLeft, whackAMole.getMolesLeft());
    }
}
