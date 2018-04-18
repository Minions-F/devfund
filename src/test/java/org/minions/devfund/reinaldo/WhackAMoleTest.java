package org.minions.devfund.reinaldo;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

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
     * test score.
     */
    @Test
    public void testWhenScoreIsCer() {
        final int expectedScore = 0;
        assertEquals(expectedScore, whackAMole.getScore());
    }

    /**
     * Test mole left.
     */
    @Test
    public void testWhenMolesLeftIsCer() {
        final int expectedMolesLeft = 3;
        assertEquals(expectedMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Test attempts left.
     */
    @Test
    public void testWhenAttemptsLeft() {
        assertEquals(NUM_ATTEMPTS, whackAMole.getAttemptsLeft());
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

    /**
     * Print the grid with M and W.
     */
    @Test
    public void printGridTest() {
        final int gridDimension = 3;
        final int placementX = 0;
        final int placementY = 1;
        final int whackRow = 0;
        final int whackColumn = 0;
        final String expectedGrid = "W  M  *  \n*  *  *  \n*  *  *  \n";
        whackAMole = new WhackAMole(NUM_ATTEMPTS, gridDimension);
        whackAMole.whack(whackRow, whackColumn);
        whackAMole.place(placementX, placementY);
        assertEquals(expectedGrid, whackAMole.printGrid());
    }

    /**
     * Print grid to user .
     */
    @Test
    public void testPrintGridWhackToUser() {
        final int gridDimension = 3;
        final int whackRow = 0;
        final int whackColumn = 0;
        final String expectedGrid = "W  *  *  \n*  *  *  \n*  *  *  \n";
        whackAMole = new WhackAMole(NUM_ATTEMPTS, gridDimension);
        whackAMole.whack(whackRow, whackColumn);
        assertEquals(expectedGrid, whackAMole.printGridToUser());
    }
}
