package org.minions.devfund.alejandro;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * This class contain the test cases for WhackAMole class.
 */

public class WhackAMoleTest {

    private static final int NUM_ATTEMPTS = 10;
    private static final int GRID_DIMENSION = 4;
    private static int xPosition = 2;
    private static int yPosition = 2;
    private static final String EXPECTED_CHAR = "****\n****\n****\n****\n";
    private static final String EXPECTED_CHAR_MOLES = "****\n****\n**M*\n****\n";
    private static final String EXPECTED_CHAR_WHACKS = "****\n****\n**W*\n****\n";
    private WhackAMole whackAMole;


    /**
     * This method initialize the whackamole class.
     */
    @Before
    public void setUp() {
        whackAMole = new WhackAMole(NUM_ATTEMPTS, GRID_DIMENSION);
    }

    /**
     * This test will verify that the instance of WhackAMole is created.
     */
    @Test
    public void testWhackAMoleConstructor() {
        assertThat(whackAMole, instanceOf(WhackAMole.class));
    }

    /**
     * This test will verify that moles can be placed.
     */
    @Test
    public void testPlaceValidLocationMoles() {

        boolean actual = whackAMole.place(xPosition, yPosition);
        assert actual;
    }

    /**
     * This test will verify that moles can not be placed in the same place.
     */
    @Test
    public void testPlaceInvalidLocationMoles() {

        whackAMole.place(xPosition, yPosition);
        boolean actual = whackAMole.place(xPosition, yPosition);
        assert !actual;
    }

    /**
     * This test will verify that moles are placed in moleGrid.
     */
    @Test
    public void testMoleIsPlacedInMoleGrid() {

        whackAMole.place(xPosition, yPosition);
        String actual = whackAMole.printGrid();
        assert actual.equals(EXPECTED_CHAR_MOLES);
    }

    /**
     * This test will verify that place method add a moleLeft.
     */
    @Test
    public void testMolesLeftAreUpdated() {

        whackAMole.place(xPosition, yPosition);
        int moleLefts = whackAMole.getMolesLeft();
        assert moleLefts == 1;
    }

    /**
     * This test will verify that a whack is placed.
     */
    @Test
    public void testMakeAValidWhack() {

        whackAMole.place(xPosition, yPosition);
        whackAMole.whack(xPosition, yPosition);
        String actual = whackAMole.printGrid();
        assert EXPECTED_CHAR_WHACKS.equals(actual);
    }

    /**
     * This test will verify that a whack is not placed for an invalid place.
     */
    @Test
    public void testMakeAnInvalidWhack() {

        whackAMole.whack(xPosition, yPosition);
        String actual = whackAMole.printGrid();
        assert EXPECTED_CHAR.equals(actual);
    }

    /**
     * This test will verify that a whack update the score.
     */
    @Test
    public void testWhackUpdatesScore() {

        whackAMole.place(xPosition, yPosition);
        whackAMole.whack(xPosition, yPosition);
        int actual = whackAMole.getScore();
        assert actual == 1;
    }

    /**
     * This test will verify that a whack update the attemptsLeft.
     */
    @Test
    public void testWhackUpdatesAttemptsLefts() {

        whackAMole.place(xPosition, yPosition);
        whackAMole.whack(xPosition, yPosition);
        int actual = whackAMole.getAttemptsLeft();
        assert actual == NUM_ATTEMPTS - 1;
    }

    /**
     * This method will test the print of the grid for the user,
     * using a default position where a mole be placed.
     */
    @Test
    public void testPrintGridForUsers() {

        assert EXPECTED_CHAR.equals(whackAMole.printGridToUser());
    }

    /**
     * This method will test the print of the grid,
     * using a default position where a mole be placed.
     */
    @Test
    public void testPrintGridWithMoles() {

        whackAMole.place(xPosition, yPosition);
        assert EXPECTED_CHAR_MOLES.equals(whackAMole.printGrid());
    }

    /**
     * This method will test the print of the grid,
     * using a default position where a whack is placed.
     */
    @Test
    public void testPrintGridWithWhacks() {

        whackAMole.place(xPosition, yPosition);
        whackAMole.whack(xPosition, yPosition);
        assert EXPECTED_CHAR_WHACKS.equals(whackAMole.printGrid());
    }
}
