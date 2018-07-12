package org.minions.devfund.mauricioz.Battleship;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * test class for Ocean.
 */
public class OceanTest {
    private static final int OCEAN_SIZE = 20;
    private Ocean ocean;

    /**
     * initial setup.
     */
    @Before
    public void setUp() {
        ocean = new Ocean();
    }

    /**
     * verify the object is created correctly.
     */
    @Test
    public void testEmptySeaIsAShipObject() {
        assertThat(ocean, instanceOf(Ocean.class));
    }

    /**
     * verify ocean is empty at the begining of the game.
     */
    @Test
    public void testOceanIsEmptyAtStart() {
        boolean isEmpty = false;
        for (int i = 0; i < OCEAN_SIZE; i++) {
            for (int j = 0; j < OCEAN_SIZE; j++) {
                if (ocean.getShips()[i][j].getShipType() == "empty") {
                    isEmpty = true;
                } else {
                    isEmpty = false;
                }
            }
        }
        assertTrue(isEmpty);
    }

}
