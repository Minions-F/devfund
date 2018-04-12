package org.minions.devfund.aldo;

import org.junit.Assert;
import org.junit.Test;

public class WhackAMoleTest {
    WhackAMole whackAMole;

    public WhackAMoleTest() {
        whackAMole = new WhackAMole(2, 3);
    }

    @Test
    public void printGridTest() {
        whackAMole.place(0, 0);
        whackAMole.place(1, 1);
        whackAMole.place(2, 2);
        whackAMole.whack(0, 0);
        whackAMole.whack(1, 1);
        whackAMole.printGrid();
    }

    @Test
    public void printGridToUser(){
        whackAMole.place(0, 0);
        whackAMole.place(1, 1);
        whackAMole.place(2, 2);
        whackAMole.whack(0, 0);
        whackAMole.whack(1, 1);
        whackAMole.printGridToUser();
    }

    @Test
    public void placeTest() {
        Assert.assertTrue(whackAMole.place(0, 0));
        Assert.assertFalse(whackAMole.place(0, 0));
    }

    @Test
    public void placeMoleDecrement() {
        whackAMole.place(0, 0);
        whackAMole.place(1, 1);
        whackAMole.place(2, 2);
        Assert.assertFalse(whackAMole.place(1, 0));
    }

    @Test
    public void whackTest1() {
        whackAMole.place(0, 0);
        whackAMole.place(1, 1);
        whackAMole.place(2, 2);
        whackAMole.whack(0, 0);
        Assert.assertEquals(10, whackAMole.getScore());
        Assert.assertEquals(1, whackAMole.getAttemptsLeft());
        Assert.assertEquals(2, whackAMole.getMolesLeft());
    }
    @Test
    public void whackTest2() {
        whackAMole.place(0, 0);
        whackAMole.place(1, 1);
        whackAMole.place(2, 2);
        whackAMole.whack(0, 0);
        whackAMole.whack(1, 1);
        Assert.assertEquals(20, whackAMole.getScore());
        Assert.assertEquals(0, whackAMole.getAttemptsLeft());
        Assert.assertEquals(1, whackAMole.getMolesLeft());
    }
}
