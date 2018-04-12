package org.minions.devfund.angela;

/**
 * Manages whack a mole game.
 */
public class WhackAMole {
    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;

    /**
     * Constructor of whack a mole game.
     *
     * @param numAttempts   int total of attempts to whack a mole.
     * @param gridDimension int the grid dimension where to locate the moles.
     */
    public WhackAMole(int numAttempts, int gridDimension) {
        molesLeft = 0;
        score = 0;
        attemptsLeft = numAttempts;
        moleGrid = new char[gridDimension][gridDimension];
        for (int i = 0; i < gridDimension; i++) {
            for (int j = 0; j < gridDimension; j++) {
                moleGrid[i][j] = '*';
            }
        }

    }

    /**
     * Locates a mole in a grid.
     *
     * @param x int x position to locate a mole.
     * @param y int y position to locate a mole.
     * @return true if placement was successful.
     */
    public boolean place(int x, int y) {
        if (moleGrid[x][y] != 'M') {
            moleGrid[x][y] = 'M';
            molesLeft++;
            return true;
        }
        return false;
    }

    /**
     * Whacks in the position to try to hit a mole.
     *
     * @param x int x position to whack a mole.
     * @param y int y position to whack a mole.
     */
    public void whack(int x, int y) {
        attemptsLeft--;
        if (moleGrid[y][x] == 'M') {
            score++;
            molesLeft--;
        }
        moleGrid[y][x] = 'W';
    }

    /**
     * Prints the grid to the user to show where he/she whacked.
     */
    public void printGridToUser() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                if (moleGrid[i][j] == 'M') {
                    System.out.print("* ");
                } else {

                    System.out.print(moleGrid[i][j] + " ");
                }
            }
            System.out.println("\n");
        }
    }

    /**
     * Prints all grid with moles.
     */
    public void printGrid() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                System.out.print(moleGrid[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    /**
     * Gets the moles left.
     *
     * @return int the moles left value.
     */
    public int getMolesLeft() {
        return molesLeft;
    }

    /**
     * Gets the attempts left.
     *
     * @return int the attempts left value.
     */
    public int getAttempts() {
        return attemptsLeft;
    }

    /**
     * Gets the score.
     *
     * @return int hte score value.
     */
    public int getScore() {
        return score;
    }
}
