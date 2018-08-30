package org.minions.devfund.marcos.uml;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * It is in charged to define the Room class unit tests.
 */
public class RoomTest {

    private static final int FIRST_SIDE_INDEX = 1;

    private Room room;

    /**
     * Tests preconditions.
     */
    @Before
    public void preconditions() {
        room = new Room();
    }

    /**
     * Test set side.
     */
    @Test
    public void testSetSide() {
        room.setSide(FIRST_SIDE_INDEX, new Wall());
        assertNull(room.getSide(FIRST_SIDE_INDEX));
    }

    /**
     * Test set room number.
     */
    @Test
    public void testSetRoomNumber() {
        room.setRoomNumber(FIRST_SIDE_INDEX);
        assertEquals(room.getRoomNumber(), FIRST_SIDE_INDEX);
    }

    /**
     * Test set map sites.
     */
    @Test
    public void testSetMapsites() {
        room.setMapsites(new MapSite[]{new Room()});
        assertTrue(room.getMapsites().getClass().isArray());
    }

    /**
     * Test set sides.
     */
    @Test
    public void testSetSides() {
        room.setSides(new Wall[]{new Wall()});
        assertTrue(room.getSides().getClass().isArray());
    }
}
