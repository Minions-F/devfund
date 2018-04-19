package org.minions.devfund.mauricioz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;


/**
 * This class is a set of unit tests for Whackamole class methods.
 *
 * @author Mauricio Zelaya
 * @version 1.0
 */
public class WhackAMoleTest {

    private WhackAMole whackamole;
    private static final int ATTEMPTS_NUMBER = 50;
    private static final int BOARD_DIMENSION = 10;
    private static final int WHACK_POSITION = 9;
    private String initialGrid = "**********\n**********\n**********\n**********\n**********\n**********\n**********"
            + "\n**********\n**********\n**********\n";
    private String endGrid = "**********\n*M********\n**********\n**********\n**********\n**********\n**********"
            + "\n**********\n**********\n*********W\n";

    /**
     * Initialization of the whackamole board.
     */
    @Before
    public void setUp() {

        whackamole = new WhackAMole(ATTEMPTS_NUMBER, BOARD_DIMENSION);

    }

    /**
     * Test is possible set a mole in the board.
     */
    @Test
    public void testSetAMoleInBoard() {

        assertTrue(whackamole.place(1, 1));
        assertEquals(1, whackamole.getMolesLeft());

    }

    /**
     * Test is not possible set a mole in the board when a mole exists.
     */
    @Test
    public void testIsNotPossibleSetAMoleInBoardOverAnother() {
        whackamole.place(1, 1);

        assertFalse(whackamole.place(1, 1));

    }

    /**
     * Test is possible whack a mole.
     */
    @Test
    public void testIsPossibleWhackAMole() {
        whackamole.whack(1, 1);

        assertEquals('W', whackamole.getMolePosition(1, 1));
        assertEquals(1, whackamole.getScore());
        assertEquals(ATTEMPTS_NUMBER - 1, whackamole.getAttemptsLeft());
        assertEquals(0, whackamole.getMolesLeft());
    }

    /**
     * Test is possible miss the whack.
     */
    @Test
    public void testIsPossibleMissTheWhack() {
        whackamole.place(1, 1);
        whackamole.whack(1, 1);

        assertNotEquals('W', whackamole.getMolePosition(1, 1));
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

        assertEquals(ATTEMPTS_NUMBER, whackamole.getAttemptsLeft());
    }

    /**
     * Test initial score is 0.
     */
    @Test
    public void testInitialScoreIs0() {

        assertEquals(0, whackamole.getScore());
    }

    /**
     * Test initial grid print.
     */
    @Test
    public void testPrintGridToUser() {

        assertEquals(initialGrid, whackamole.printGridToUSer());
    }

    /**
     * Test grid with a mole and a whack print.
     */
    @Test
    public void testPrintGridWithAMoleAndAWhackToUser() {
        whackamole.place(1, 1);
        whackamole.whack(WHACK_POSITION, WHACK_POSITION);

        assertEquals(endGrid, whackamole.printGrid());
    }
}
