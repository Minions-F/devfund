package org.minions.devfund.marcos.uml;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * It is in charged to define the Maze class unit tests.
 */
public class MazeTest {

    /**
     * Test set rooms.
     */
    @Test
    public void testSetRooms() {
        Maze maze = new Maze();
        maze.setRooms(new Room[]{new Room()});
        assertTrue(maze.getRooms().getClass().isArray());
    }
}
