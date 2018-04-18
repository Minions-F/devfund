package org.minions.devfund.dennis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;

/**
 * Unit Test class for WhackAMole game for all methods.
 */
public class WhackAMoleTest {
    private static final int ATTEMPTS = 50;
    private static final int DIMENSION = 10;
    private static final int POSITION_X = 3;
    private static final int POSITION_Y = 3;
    private static final int WPOSITION_X = 3;
    private static final int WPOSITION_Y = 8;
    private static final char MOLES = 'M';
    private static final char WHACK = 'W';
    private static final char EMPTY = '*';
    private String gridToUser = "**********\n**********\n**********\n**********\n**********\n**********\n**********"
            + "\n**********\n**********\n**********\n";
    private String finalGridToUser = "**********\n**********\n**********\n***W****M*\n**********\n**********"
            + "\n**********\n**********\n**********\n**********\n";
    private WhackAMole whackamole;

    /**
     * Unit Test for WhackAMole game for all methods.
     */
    @Before
    public void setUp() {
        whackamole = new WhackAMole(ATTEMPTS, DIMENSION);
    }

    /**
     * Test Set Mole in a specific Position.
     */
    @Test
    public void testPlaceMolesInSpecificPosition() {
        whackamole.place(POSITION_X, POSITION_Y);
        assertEquals(MOLES, whackamole.getGrid()[POSITION_X][POSITION_Y]);
    }

    /**
     * Test Set Whack in a specific Position.
     */
    @Test
    public void testSetWhackInSpecificPosition() {
        whackamole.whack(POSITION_X, POSITION_Y);
        assertEquals(WHACK, whackamole.getGrid()[POSITION_X][POSITION_Y]);
    }

    /**
     * Test Set Empty grid to user.
     */
    @Test
    public void testStartGridWithAsEmpty() {
        whackamole.getGrid()[POSITION_X][POSITION_Y] = EMPTY;
        whackamole.startGrid();
        assertEquals(EMPTY, whackamole.getGrid()[POSITION_X][POSITION_Y]);
    }

    /**
     * Test initial grid print to user.
     */
    @Test
    public void testPrintGridToUser() {
        assertEquals(gridToUser, whackamole.printGridToUser());
    }

    /**
     * Test grid with a mole and a whack to user.
     */
    @Test
    public void testPrintGridWithAMoleAndAWhackToUser() {
        whackamole.place(WPOSITION_X, WPOSITION_Y);
        whackamole.whack(POSITION_X, POSITION_Y);
        assertEquals(finalGridToUser, whackamole.printGrid());
    }

    /**
     * Test grid, this should not be empty to user.
     */
    @Test
    public void testPrintGridToUserAsEmpty() {
        String result = " ";
        assertNotEquals("Empty Grid", result, whackamole.printGridToUser());
    }

    /**
     * Test grid, this should not be empty to user.
     */
    @Test
    public void testPrintGridAsEmpty() {
        String result = " ";
        assertNotEquals("Empty Grid", result, whackamole.printGrid());
    }

    /**
     * Test initial amount of moles is 0.
     */
    @Test
    public void testInitialAmountOfMolesIs0() {
        assertEquals(0, whackamole.getMolesLeft());
    }

    /**
     * Test initial amount of attempts is 50.
     */
    @Test
    public void testInitialAmountOfAttemptsIs50() {
        assertEquals(ATTEMPTS, whackamole.getAttempts());
    }

    /**
     * Test initial score is 0.
     */
    @Test
    public void testInitialScoreIs0() {
        assertEquals(0, whackamole.getScore());
    }

    /**
     * Test if the mole already added.
     */
    @Test
    public void testReturnFalseIfTheMoleAlreadyAdded() {
        whackamole.place(POSITION_X, POSITION_Y);
        assertFalse(whackamole.place(POSITION_X, POSITION_Y));

    }
}
