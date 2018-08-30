package org.minions.devfund.marcos.uml;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * It is in charged to define the Door class unit tests.
 */
public class DoorTest {

    private static final boolean OPEN_FLAG = true;

    private Door door;

    /**
     * Test preconditions.
     */
    @Before
    public void preconditions() {
        door = new Door();
    }

    /**
     * Test set open.
     */
    @Test
    public void testSetOpen() {
        door.setOpen(OPEN_FLAG);
        assertTrue(door.isOpen());
    }

    /**
     * Test set room one.
     */
    @Test
    public void setRoomOne() {
        door.setRoom1(new Room());
        assertNotNull(door.getRoom1());
    }

    /**
     * Test set room two.
     */
    @Test
    public void setRoomTwo() {
        door.setRoom2(new Room());
        assertNotNull(door.getRoom2());
    }
}
