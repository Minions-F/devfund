import org.junit.Before;
import org.junit.Test;
import org.minions.devfund.chelo.WhackAMole;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

/**
 * Test class.
 */
public class WhackAMoleTest {
    private WhackAMole whackAMole;

    /**
     * Setup.
     */
    @Before
    public void setup() {
        final int attempts = 50;
        final int dimension = 10;
        whackAMole = new WhackAMole(attempts, dimension);
    }

    /**
     * Method that validates attempts value.
     */
    @Test
    public void testNumAttemptsValue() {
        final int attempts = 5;
        final int dimension = 6;
        whackAMole = new WhackAMole(attempts, dimension);
        assertEquals(whackAMole.getAttemptsLeft(), attempts);
    }

    /**
     * Method that validates grid dimension value.
     */
    @Test
    public void testConstructorGrid() {
        final int numAttempts = 5;
        final int gridDimension = 6;
        whackAMole = new WhackAMole(numAttempts, gridDimension);
        assertEquals(whackAMole.getMoleGridLength(), gridDimension);
    }

    /**
     * Method to validate a mole is placed in the given position.
     */
    @Test
    public void testPlaceSucceed() {
        final int positionX = 2;
        final int positionY = 3;
        assertTrue(whackAMole.place(positionX, positionY));
    }

    /**
     * Method to validate place fail.
     */
    @Test
    public void testPlaceFail() {
        final int positionX = 2;
        final int positionY = 2;
        whackAMole.place(positionX, positionY);
        assertFalse(whackAMole.place(positionX, positionY));
    }

    /**
     * Method to validate a whack.
     */
    @Test
    public void testWhackAMole() {
        final int positionX = 2;
        final int positionY = 2;
        whackAMole.place(positionX, positionY);
        whackAMole.whack(positionX, positionY);
        assertEquals(whackAMole.getMoleGridValue(positionX, positionY), 'W');
    }

    /**
     * Method to validate moles left value is decreased when a whack is done.
     */
    @Test
    public void testWhackSucceedMolesLeft() {
        final int positionX = 2;
        final int positionY = 2;
        final int molesLeft = whackAMole.getMolesLeft();
        whackAMole.place(positionX, positionY);
        whackAMole.whack(positionX, positionY);
        assertEquals(whackAMole.getMolesLeft(), molesLeft);
    }

    /**
     * Method to validate moles left value is not decreased when a whack is done.
     */
    @Test
    public void testWhackFailMolesLeft() {
        final int positionX = 2;
        final int positionY = 2;
        final int molesLeft = whackAMole.getMolesLeft();
        whackAMole.place(positionX, positionY);
        whackAMole.whack(positionX, positionY - 1);
        assertNotEquals(whackAMole.getMolesLeft(), molesLeft);
    }


    /**
     * Method to validate attempts value is decreased when a whack is done.
     */
    @Test
    public void testWhackSucceedAttempts() {
        final int positionX = 2;
        final int positionY = 2;
        final int attempts = whackAMole.getAttemptsLeft();
        whackAMole.place(positionX, positionY);
        whackAMole.whack(positionX, positionY);
        assertEquals(whackAMole.getAttemptsLeft(), attempts - 1);
    }

    /**
     * Method to validate attempts value is updated when a whack is not done.
     */
    @Test
    public void testWhackFailAttempts() {
        final int positionX = 2;
        final int positionY = 2;
        final int attempts = whackAMole.getAttemptsLeft();
        whackAMole.place(positionX, positionY);
        whackAMole.whack(positionX, positionY - 1);
        assertEquals(whackAMole.getAttemptsLeft(), attempts - 1);
    }

    /**
     * Method to validate the score is incremented.
     */
    @Test
    public void testScoreAfterAWack() {
        final int positionX = 2;
        final int positionY = 2;
        int score = whackAMole.getScore();
        whackAMole.place(positionX, positionY);
        whackAMole.whack(positionX, positionY);
        assertEquals(whackAMole.getScore(), ++score);
    }
}
