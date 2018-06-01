import org.junit.Before;
import org.junit.Test;
import org.minions.devfund.chelo.WhackAMole;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

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
    public void testGridValue() {
        final int numAttempts = 5;
        final int gridDimension = 6;
        whackAMole = new WhackAMole(numAttempts, gridDimension);
        assertEquals(whackAMole.getMoleGridLength(), gridDimension);
    }

    /**
     * Method to validate a mole is placed in the given position.
     */
    @Test
    public void testAWackPlaced() {
        final int positionX = 2;
        final int positionY = 3;
        assertTrue(whackAMole.place(positionX, positionY));
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
    public void testMolesLeftAfterAWack() {
        final int positionX = 2;
        final int positionY = 2;
        final int molesLeft = whackAMole.getMolesLeft();
        whackAMole.place(positionX, positionY);
        whackAMole.whack(positionX, positionY);
        assertEquals(whackAMole.getMolesLeft(), molesLeft);
    }

    /**
     * Method to validate attempts value is decreased when a whack is done.
     */
    @Test
    public void testNumAttemptsAfterAWack() {
        final int positionX = 2;
        final int positionY = 2;
        final int attempts = whackAMole.getAttemptsLeft();
        whackAMole.place(positionX, positionY);
        whackAMole.whack(positionX, positionY);
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
