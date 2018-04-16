package org.minions.devfund.sergio;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Main methods for game Whack a Mole.
 *
 * @author Sergio Navarro
 * @since 4/12/2018
 */
public class WhackAMole {

    private static final char GRID_WHITE_SPACE = '*';
    private static final char MOLE = 'M';
    private int molesLeft;
    private int score;
    private int attemptsLeft;
    private char[][] moleGrid;
    private int gridDimension;

    /**
     * Constructor for WhackAMole.
     *
     * @param numAttempts   - The number of attempts for user.
     * @param gridDimension - The dimension of the grid.
     */
    WhackAMole(int numAttempts, int gridDimension) {
        attemptsLeft = numAttempts;
        this.gridDimension = gridDimension;
        moleGrid = new char[this.gridDimension][this.gridDimension];
        loadGrid();
    }

    /**
     * Return the current status of given position.
     *
     * @param posX - Represent the X coordinate.
     * @param posY -Represent the Y coordinate.
     * @return The current status.
     */
    char getStatusPosition(int posX, int posY) {
        return moleGrid[posX][posY];
    }

    /**
     * Gets the score.
     *
     * @return The score.
     */
    int getScore() {
        return score;
    }

    /**
     * Gets the number of current attempts.
     *
     * @return The number of attempts.
     */
    int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * Places a Mole.
     *
     * @param posX - Represent the X coordinate.
     * @param posY - Represent the Y coordinate.
     * @return True if the position (x,y) it is now a MOLE, false otherwise.
     */
    boolean place(int posX, int posY) {
        if (moleGrid[posX][posY] != MOLE) {
            moleGrid[posX][posY] = MOLE;
            molesLeft++;
            return true;
        }
        return false;
    }

    /**
     * Whacks the grid attempting to hit a mole.
     *
     * @param posX - Represent the X coordinate.
     * @param posY - Represent the Y coordinate.
     */
    void whack(int posX, int posY) {
        char whack = 'W';

        if (moleGrid[posX][posY] == MOLE) {
            moleGrid[posX][posY] = whack;
            molesLeft--;
            score++;
        }
        attemptsLeft--;
        printGridToUser();
    }

    /**
     * Prints the current grid for user.
     */
    private void printGridToUser() {
        System.out.println(getUserGrid());
    }

    /**
     * Builds the user grid.
     *
     * @return A grid for user.
     */
    private StringBuilder getUserGrid() {
        StringBuilder userGrid = new StringBuilder();
        for (int i = 0; i < this.gridDimension; i++) {
            for (int j = 0; j < this.gridDimension; j++) {
                if (moleGrid[i][j] == 'M') {
                    userGrid.append(GRID_WHITE_SPACE);
                } else if (moleGrid[i][j] == 'W') {
                    userGrid.append('W');
                } else {
                    userGrid.append(GRID_WHITE_SPACE);
                }
            }
            userGrid.append("\n");
        }
        return userGrid;
    }

    /**
     * Prints the grid.
     */
    public void printGrid() {
        System.out.println(getGrid());
    }

    /**
     * Build the Grid.
     *
     * @return The grid.
     */
    private StringBuilder getGrid() {
        StringBuilder grid = new StringBuilder();
        for (int i = 0; i < this.gridDimension; i++) {
            for (int j = 0; j < this.gridDimension; j++) {
                grid.append(moleGrid[i][j]);
            }
        }
        return grid;
    }

    /**
     * Creates the grid.
     */
    private void loadGrid() {
        for (int i = 0; i < this.gridDimension; i++) {
            for (int j = 0; j < this.gridDimension; j++) {
                moleGrid[i][j] = GRID_WHITE_SPACE;
            }
        }
        loadMole();
    }

    /**
     * Places a mole Randomly.
     */
    private void loadMole() {
        int complete = 0;
        while (complete < molesLeft) {
            int x = ThreadLocalRandom.current().nextInt(0, gridDimension);
            int y = ThreadLocalRandom.current().nextInt(0, gridDimension);
            if (moleGrid[x][y] != 'M') {
                place(x, y);
                complete++;
            }
        }
    }
}
