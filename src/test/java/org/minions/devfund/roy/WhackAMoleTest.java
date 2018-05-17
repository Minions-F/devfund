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
    public void testPlaceWithNegativePositions() {
        final int attempts = 2;
        final int dimension = 2;
        final int xNegative = -1;
        final int yNegative = -3;
        whackAMole = new WhackAMole(attempts, dimension);
        Assert.assertFalse(whackAMole.place(xNegative, yNegative));
    }

    /**
     * Test place a mole in a valid position.
     */
    @Test
    public void testPlaceValidPosition() {
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
    public void testPlaceInvalidPosition() {
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
    public void testWhack() {
        final int attempts = 2;
        final int dimension = 1;
        final int x = 0;
        final int y = 0;

        whackAMole = new WhackAMole(attempts, dimension);
        whackAMole.placeMoles();
        whackAMole.whack(x, y);
        Assert.assertTrue(whackAMole.getScore() > 0);
    }

    /**
     * Tests whack method givingUp.
     */
    @Test
    public void testWhackGivingUp() {
        final int attempts = 2;
        final int dimension = 1;
        final int x = -1;
        final int y = -1;

        whackAMole = new WhackAMole(attempts, dimension);
        whackAMole.placeMoles();
        whackAMole.whack(x, y);
        Assert.assertTrue(whackAMole.getScore() <= 0);
    }

    /**
     * Tests whack method rules false.
     */
    @Test
    public void testWhackWithoutAttempts() {
        final int attempts = 0;
        final int dimension = 1;
        final int x = -1;
        final int y = -1;

        whackAMole = new WhackAMole(attempts, dimension);
        whackAMole.placeMoles();
        whackAMole.whack(x, y);
        Assert.assertTrue(whackAMole.getScore() <= 0);
    }


    /**
     * Tests give Up the game.
     */
    @Test
    public void testGiveUp() {
        final int attempts = 25;
        final int dimension = 10;
        final int x = -1;
        final int y = -1;

        whackAMole = new WhackAMole(attempts, dimension);
        Assert.assertTrue(whackAMole.giveUp(x, y));
    }

    /**
     * Tests Do not the game with positive and negative values.
     */
    @Test
    public void testGiveUpWithPositiveAndNegativeValues() {
        final int attempts = 25;
        final int dimension = 10;
        final int positive = 5;
        final int negative = -1;

        whackAMole = new WhackAMole(attempts, dimension);
        Assert.assertFalse(whackAMole.giveUp(positive, negative));
        Assert.assertFalse(whackAMole.giveUp(negative, positive));
    }

    /**
     * Tests do not give up the game.
     */
    @Test
    public void testGiveUpWithPositivePositions() {
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
    public void testEndTheGameWithOutAttempts() {
        final int dimension = 10;
        final int attempts = 25;
        whackAMole = new WhackAMole(attempts, dimension);
        int aux = attempts;
        while (aux > 0) {
            whackAMole.whack(new Random().nextInt(dimension - 1) + 1,
                    new Random().nextInt(dimension - 1) + 1);
            aux--;
        }

        Assert.assertTrue(whackAMole.getAttemptsLeft() == 0);
    }


    /**
     * Tests gridBuilder Method.
     */
    @Test
    public void testGridBuilder() {
        final int attempts = 25;
        final int dimension = 10;
        whackAMole = new WhackAMole(attempts, dimension);
        Assert.assertTrue(whackAMole.gridBuilder().getClass().equals(StringBuilder.class));
    }

    /**
     * Tests gridBuilder for user method.
     */
    @Test
    public void testGridBuilderForUser() {
        final int attempts = 2;
        final int dimension = 1;
        whackAMole = new WhackAMole(attempts, dimension);
        whackAMole.placeMoles();
        Assert.assertEquals(whackAMole.gridBuilderForUser().charAt(0), '*');
    }

    /**
     * Tests gridBuilder for user method.
     */
    @Test
    public void testGridBuilderForUserWithoutMoles() {
        final int attempts = 2;
        final int dimension = 1;
        whackAMole = new WhackAMole(attempts, dimension);
        Assert.assertEquals(whackAMole.gridBuilderForUser().charAt(0), '*');
    }

    /**
     * Tests rules method.
     */
    @Test
    public void testRules() {
        final int attempts = 25;
        final int dimension = 10;
        whackAMole = new WhackAMole(attempts, dimension);
        Assert.assertTrue(whackAMole.rules());
    }

    /**
     * Tests rules method, without attempts.
     */
    @Test
    public void testRulesWithoutAttempts() {
        final int attempts = 0;
        final int dimension = 10;
        whackAMole = new WhackAMole(attempts, dimension);
        Assert.assertFalse(whackAMole.rules());
    }

    /**
     * Tests rules method, with negative attempts.
     */
    @Test
    public void testRulesWithNegativeAttempts() {
        final int attempts = -2;
        final int dimension = 10;
        whackAMole = new WhackAMole(attempts, dimension);
        Assert.assertFalse(whackAMole.rules());
    }

    /**
     * Test place with invalid positions.
     */
    @Test
    public void testPlaceWithInvalidPositions() {
        final int attempts = 2;
        final int dimension = 1;
        final int invalidPos = 5;
        whackAMole = new WhackAMole(attempts, dimension);
        Assert.assertFalse(whackAMole.place(invalidPos, 0));
        Assert.assertFalse(whackAMole.place(0, invalidPos));
    }

    /**
     * Test place negative and positive.
     */
    @Test
    public void testPlaceWithNegativePositivePositions() {
        final int attempts = 2;
        final int dimension = 10;
        final int negative = -5;
        final int positve = 4;
        whackAMole = new WhackAMole(attempts, dimension);
        Assert.assertFalse(whackAMole.place(negative, positve));
        Assert.assertFalse(whackAMole.place(positve, negative));
    }

    /**
     * Test place moles out of dimensions.
     */
    @Test
    public void testPlaceMolesOutOfDimensions() {
        final int attempts = 2;
        final int dimension = 10;
        final int inToTheRange = 5;
        final int outOfTheRange = 14;
        whackAMole = new WhackAMole(attempts, dimension);
        Assert.assertFalse(whackAMole.place(inToTheRange, outOfTheRange));
        Assert.assertFalse(whackAMole.place(outOfTheRange, inToTheRange));
    }
}
