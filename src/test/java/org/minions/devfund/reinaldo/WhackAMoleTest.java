package org.minions.devfund.reinaldo;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertArrayEquals;

/***
 * Created by reinaldo on 4/12/2018.
 */
public class WhackAMoleTest {
    public static final int NUM_ATTEMPTS = 2;
    public static final int GRID_DIMENSION = 3;
    public static final int EXPECTED = 10;
    public static final int EXPECTED1 = 1;
    public static final int EXPECTED2 = 2;
    private WhackAMole whackAMole;

    /**
     * This inicialize the whackAMole.
     */
    @Before
    public  void setup() {
        whackAMole = new WhackAMole(NUM_ATTEMPTS, GRID_DIMENSION);
    }

    /**
     *Test when.
     */
    @Test
    public void testWhackMoleWhenTheFillMoleGrid() {

        //when
        final char[][] moleGriActualResult = {{'*', '*', '*'}, {'*', '*', '*'}, {'*', '*', '*'}};

        //then
        final char[][] moleGridExpectedResult = whackAMole.getFillWhackAMole();

        assertArrayEquals(moleGridExpectedResult, moleGriActualResult);
    }

    /**
     *Test When The Mole IsNot Exist In Location..
     */
    @Test
    public void testWhenTheMoleIsNotExistInLocation() {
        Assert.assertTrue(whackAMole.place(0, 0));
        Assert.assertTrue(whackAMole.place(1, 0));
    }

    /**
     *Test When The Mole Is Exist In Location..
     */
    @Test
    public void testWhenTheMoleIsExistInLocation() {
        Assert.assertTrue(whackAMole.place(0, 0));
        Assert.assertFalse(whackAMole.place(0, 0));
    }

    /**
     *Test score.
     */
    @Test
    public void testWhackScore() {
        whackAMole.place(0, 0);
        whackAMole.place(1, 1);
        whackAMole.place(2, 2);
        whackAMole.whack(0, 0);
        Assert.assertEquals(EXPECTED, whackAMole.getScore());
    }

    /**
     *Test for AttemptsLeft.
     */
    @Test
    public void testWhackAttemptsLeft() {
        whackAMole.place(0, 0);
        whackAMole.place(1, 1);
        whackAMole.place(2, 2);
        whackAMole.whack(0, 0);
        Assert.assertEquals(EXPECTED1, whackAMole.getAttemptsLeft());
    }

    /**
     *Test MolesLeft.
     */
    @Test
    public void testWhackMolesLeft() {
        whackAMole.place(0, 0);
        whackAMole.place(1, 1);
        whackAMole.place(2, 2);
        whackAMole.whack(0, 0);
        Assert.assertEquals(EXPECTED2, whackAMole.getMolesLeft());
    }
}
