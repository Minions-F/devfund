package org.minions.devfund.marcos.uml;

import org.junit.Test;

import static org.junit.Assert.assertNull;

/**
 * It is in charged to define the Randomized Maze Game class unit tests.
 */
public class RandomizedMazeGameTest {

    private static final int NUMBER_RANDOMIZE_ZERO = 0;

    /**
     * Test randomize maze game.
     */
    @Test
    public void testRandomizeMazeGame() {
        RandomizedMazeGame randomizedMazeGame = new RandomizedMazeGame();
        assertNull(randomizedMazeGame.randomize(NUMBER_RANDOMIZE_ZERO));
    }
}
