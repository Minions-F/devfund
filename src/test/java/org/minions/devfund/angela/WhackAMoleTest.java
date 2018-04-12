package org.minions.devfund.angela;

import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test for {@link WhackAMole}.
 */
public class WhackAMoleTest {

    private static final int ATTEMPTS = 2;
    private static final int GRID_DIMENSION = 10;
    private WhackAMole whackAMole;


    /**
     * Preconditions.
     */
    @Before
    public void setup() {
        whackAMole = new WhackAMole(ATTEMPTS, GRID_DIMENSION);
    }

    /**
     * Verify attempts reduced method.
     *
     * @throws FileNotFoundException {@link FileNotFoundException}.
     */
    @Test
    public void main() throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));
        Main.main(new String[0]);
    }

    /**
     * Verify attempts reduced method.
     */
    @Test
    public void testAttemptsReduced() {
        whackAMole.whack(0, 0);
        assertEquals(1, whackAMole.getAttempts());
    }

    /**
     * Verify score increased method.
     */
    @Test
    public void testScoreIncreased() {
        whackAMole.place(0, 0);
        whackAMole.whack(0, 0);
        assertEquals(1, whackAMole.getScore());
    }

    /**
     * Verify test place.
     */
    @Test
    public void testPlace() {
        assertTrue("Error placing.", whackAMole.place(1, 1));
        assertEquals(1, whackAMole.getMolesLeft());
    }

    /**
     * Verify test place.
     */
    @Test
    public void testErrorPlace() {
        whackAMole.place(1, 1);
        assertFalse("Placing shouldn't be allowed.", whackAMole.place(1, 1));
        assertEquals(1, whackAMole.getMolesLeft());
    }

    /**
     * Verify test place.
     */
    @Test
    public void prints() {
        whackAMole.printGrid();
        whackAMole.printGridToUser();
    }
}
