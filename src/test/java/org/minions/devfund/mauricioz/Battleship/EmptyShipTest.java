package org.minions.devfund.mauricioz.Battleship;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * test class for emptyShip.
 */
public class EmptyShipTest {

    private Ship emptySea;
    private static final int FINAL_VALUE = 1;

    /**
     * initial setup.
     */
    @Before
    public void setUp() {
        emptySea = new EmptySea();
    }

    /**
     * verify the object is created correctly.
     */
    @Test
    public void testEmptySeaIsAShipObject() {
        assertThat(emptySea, instanceOf(EmptySea.class));
        assertThat(emptySea, instanceOf(Ship.class));
    }

    /**
     * test that shot in empty sea is always false.
     */
    @Test
    public void testShotInEmptySeaIsAlwaysFalse() {
        assertFalse(emptySea.shootAt(FINAL_VALUE, FINAL_VALUE));
    }

    /**
     * test that nothing is sunk if shot is on empty sea.
     */
    @Test
    public void testNothingIsSunkInEmptySea() {
        assertFalse(emptySea.isSunk());
    }

    /**
     *  test emptySea type is "empty".
     */
    @Test
    public void testEmptySeaTypeIsEmpty() {
        String emptySeaType = "empty";
        assertEquals(emptySeaType, emptySea.getShipType());
    }

    /**
     * test Empty Sea Prints "e" Character.
     */
    @Test
    public void testEmptySeaPrintsECharacter() {
        String emptySeaPrint = "e";
        assertEquals(emptySeaPrint, emptySea.toString());
    }


}
