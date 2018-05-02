package org.minions.devfund.roy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * Test for WhackAMole class.
 */
public class WhackAMoleTest {
    private WhackAMole whackAMole;

    /**
     * Test negative positions for place method.
     */
    @Test
    public void placeNegativePosition() {
        final int attempts = 2;
        final int dimension = 2;
        final int xNegative = -1;
        final int yNegative = -3;
        whackAMole = new WhackAMole(attempts, dimension);
        Assert.assertFalse(whackAMole.place(xNegative, yNegative));
    }

    /**
     * Test place a mole in a invalid position.
     */
    @Test
    public void placeAMoleInAValidPosition() {
        final int attempts = 20;
        final int dimension = 10;

        whackAMole = new WhackAMole(attempts, dimension);
        boolean result;

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                result = whackAMole.place(i, j);
                if (result) {
                    Assert.assertTrue(result);
                    break;
                }
            }
        }
    }

    /**
     * Test place method for an invalid position.
     */
    @Test
    public void placeAMoleInAnInvalidPosition() {
        final int attempts = 30;
        final int dimension = 10;

        whackAMole = new WhackAMole(attempts, dimension);
        boolean result = true;

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                result = whackAMole.place(i, j);
                if (!result) {
                    Assert.assertFalse(result);
                    break;
                }
            }
        }
    }

    /**
     * Tests whack method.
     */
    @Test
    public void whack() {
        final int attempts = 25;
        final int dimension = 10;
        final int x = 2;
        final int y = 3;

        whackAMole = new WhackAMole(attempts, dimension);
        whackAMole.whack(x, y);
    }

    /**
     * Second test for whack Method.
     */
    @Test
    public void whackTwo() {
        final int attempts = 4;
        final int dimension = 2;

        whackAMole = new WhackAMole(attempts, dimension);
        whackAMole.placeMoles();
        whackAMole.whack(0, 1);
        whackAMole.printGrid();
    }

    /**
     * Tests give Up the game.
     */
    @Test
    public void giveUpTheGame() {
        final int attempts = 25;
        final int dimension = 10;
        final int x = -1;
        final int y = -1;

        whackAMole = new WhackAMole(attempts, dimension);
        whackAMole.whack(x, y);
    }

    /**
     * Tests do not give up the game.
     */
    @Test
    public void doNotGiveUp() {
        final int attempts = 25;
        final int dimension = 10;
        final int x = 1;
        final int y = 3;

        whackAMole = new WhackAMole(attempts, dimension);
        Assert.assertFalse(whackAMole.giveUp(x, y));
    }

    /**
     * Tests the end of the game.
     */
    @Test
    public void endGameWhenTheAttemptsAreEmpty() {
        final int dimension = 10;
        final int attempts = 25;
        whackAMole = new WhackAMole(attempts, dimension);
        int aux = attempts;
        while (aux > 0) {
            whackAMole.whack(new Random().nextInt(dimension - 1) + 1,
                    new Random().nextInt(dimension - 1) + 1);
            aux--;
        }
    }

    /**
     * Tests printGrid method.
     */
    @Test
    public void printGrid() {
        final int attempts = 25;
        final int dimension = 10;
        whackAMole = new WhackAMole(attempts, dimension);
        whackAMole.placeMoles();
        whackAMole.printGrid();
    }

    /**
     * Tests printGridForUser method.
     */
    @Test
    public void printGridForUser() {
        final int attempts = 25;
        final int dimension = 10;
        whackAMole = new WhackAMole(attempts, dimension);
        whackAMole.placeMoles();
        whackAMole.printGridForUser();
    }

    /**
     * Tests gridBuilder Method.
     */
    @Test
    public void gridBuilder() {
        final int attempts = 25;
        final int dimension = 10;
        whackAMole = new WhackAMole(attempts, dimension);
        Assert.assertTrue(whackAMole.gridBuilder().getClass().equals(StringBuilder.class));
    }

    /**
     * Tests gridBuilder for user method.
     */
    @Test
    public void gridBuilderForUser() {
        final int attempts = 25;
        final int dimension = 10;
        whackAMole = new WhackAMole(attempts, dimension);
        Assert.assertTrue(whackAMole.gridBuilderForUser().getClass().equals(StringBuilder.class));
    }

    /**
     * Tests whack method for negative positions.
     */
    @Test
    public void whackInANegativePosition() {
        final int attempts = 25;
        final int dimension = 10;
        final int x = -5;
        final int y = -3;
        whackAMole = new WhackAMole(attempts, dimension);
        whackAMole.whack(x, y);
    }

    /**
     * Tests initialize grid method.
     */
    @Test
    public void initializeGrid() {
        final int attempts = 25;
        final int dimension = 10;
        whackAMole = new WhackAMole(attempts, dimension);
        whackAMole.initializeGrid();
    }

    /**
     * Tests rules method.
     */
    @Test
    public void rules() {
        final int attempts = 25;
        final int dimension = 10;
        whackAMole = new WhackAMole(attempts, dimension);
        Assert.assertTrue(whackAMole.rules());
    }

    /**
     * Tests rules method, without attempts.
     */
    @Test
    public void rulesWithOutAttempts() {
        final int attempts = 0;
        final int dimension = 10;
        whackAMole = new WhackAMole(attempts, dimension);
        Assert.assertFalse(whackAMole.rules());
    }

    /**
     * Tests rules method without moles.
     */
    @Test
    public void rulesWithOutMoles() {
        final int attempts = 4;
        final int dimension = 2;
        whackAMole = new WhackAMole(attempts, dimension);

        for (int i = 1; i <= dimension; i++) {
            for (int j = 1; j <= dimension; j++) {
                whackAMole.whack(i, j);
            }
        }
        Assert.assertFalse(whackAMole.rules());
    }
}
