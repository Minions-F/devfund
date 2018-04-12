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
    private int molesLeft = 0;
    private int score = 0;
    private int attemptsLeft = 0;
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
     * @param posX - Represent the X coordinate.
     * @param posY -Represent the Y coordinate.
     * @return The current status.
     */
    char getStatusPosition(int posX, int posY) {
        return moleGrid[posX][posY];
    }

    /**
     * Gets the score.
     * @return The score.
     */
    int getScore() {
        return score;
    }

    /**
     * Gets the number of current attempts.
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
            attemptsLeft--;
        } else {
            attemptsLeft--;
        }
        printGridToUser();
    }

    /**
     * Prints the current grid for user.
     */
    private void printGridToUser() {
        for (int i = 0; i < this.gridDimension; i++) {
            for (int j = 0; j < this.gridDimension; j++) {
                switch (moleGrid[i][j]) {
                    case 'M':
                        System.out.print(GRID_WHITE_SPACE);
                        break;
                    case 'W':
                        System.out.print("W");
                        break;
                    default:
                        System.out.print(GRID_WHITE_SPACE);
                        break;
                }

            }
            System.out.println("");
        }
    }

    /**
     * Prints the grid.
     */
    public void printGrid() {
        for (int i = 0; i < this.gridDimension; i++) {
            for (int j = 0; j < this.gridDimension; j++) {
                System.out.print(moleGrid[i][j]);
            }
            System.out.println("");
        }
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
