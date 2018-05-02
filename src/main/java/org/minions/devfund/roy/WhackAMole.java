package org.minions.devfund.roy;

import java.util.Random;

/**
 * WhackAMole game.
 */
public class WhackAMole {

    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;
    private static final char MOLE = 'M';
    private static final char WHACKED_MOLE = 'W';
    private static final char EMPTY_PLACE = '*';

    /**
     * Constructor.
     *
     * @param numAttempts   to start the game.
     * @param gridDimension to create the moleGrid for the game.
     */
    public WhackAMole(int numAttempts, int gridDimension) {
        this.moleGrid = new char[gridDimension][gridDimension];
        attemptsLeft = numAttempts;
        this.molesLeft = 0;
        initializeGrid();
    }

    /**
     * Verifies if a place is empty or not.
     *
     * @param x axis position.
     * @param y axis position.
     * @return true if the place is empty otherwise false.
     */
    public boolean place(int x, int y) {
        if (x >= 0 && y >= 0 && x < moleGrid.length && y < moleGrid.length
                && moleGrid[x][y] == EMPTY_PLACE) {
            moleGrid[x][y] = MOLE;
            molesLeft++;
            return true;
        }
        return false;
    }

    /**
     * Whacks a received position.
     *
     * @param x axis position.
     * @param y axis position.
     */
    public void whack(int x, int y) {
        if (rules() && !giveUp(x, y)) {
            if (moleGrid[x][y] == MOLE) {
                moleGrid[x][y] = WHACKED_MOLE;
                score++;
                molesLeft--;
            }
            attemptsLeft--;
        }
    }

    /**
     * Verifies if the player gives up.
     *
     * @param x axis.
     * @param y axis.
     * @return true if the player insert (-1, -1) otherwise false.
     */
    public boolean giveUp(int x, int y) {
        return x == -1 && y == -1;
    }

    /**
     * Starts the moleGrid with the moles.
     */
    private void initializeGrid() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                moleGrid[i][j] = EMPTY_PLACE;
            }
        }
    }

    /**
     * Generates random positions to place Moles.
     */
    public void placeMoles() {
        while (molesLeft < moleGrid.length) {
            int xRandomValue = new Random().nextInt(moleGrid.length);
            int yRandomValue = new Random().nextInt(moleGrid.length);
            place(xRandomValue, yRandomValue);
        }
    }

    /**
     * Builds the string of the entire grid.
     *
     * @return StringBuilder with the entire grid.
     */
    public StringBuilder gridBuilder() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                stringBuilder.append(moleGrid[i][j]);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder;
    }

    /**
     * Builds the string of the entire grid for the user.
     *
     * @return StringBuilder with the entire grid for the user.
     */
    public StringBuilder gridBuilderForUser() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                if (moleGrid[i][j] == MOLE) {
                    stringBuilder.append(EMPTY_PLACE);
                } else {
                    stringBuilder.append(moleGrid[i][j]);
                }
            }
            stringBuilder.append("\n");
        }

        return stringBuilder;
    }


    /**
     * Verifies if the rules are applied.
     *
     * @return true if the rules are applied otherwise false.
     */
    public boolean rules() {
        return attemptsLeft > 0 && molesLeft >= 0;
    }

    /**
     * Gets score.
     *
     * @return actual score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Gets attempts left.
     *
     * @return number of attempts left.
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }
}
