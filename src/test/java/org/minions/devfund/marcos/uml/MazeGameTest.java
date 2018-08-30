package org.minions.devfund.marcos.uml;

import org.junit.Test;

import static org.junit.Assert.assertNull;

/**
 * It is in charged to define the Maze Game class unit tests.
 */
public class MazeGameTest {

    /**
     * Test create maze.
     */
    @Test
    public void testCreateMaze() {
        MazeGame mazeGame = new MazeGame();
        assertNull(mazeGame.createMaze());
    }
}
