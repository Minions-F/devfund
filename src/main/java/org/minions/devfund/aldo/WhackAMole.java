package org.minions.devfund.aldo;

/**
 * This class handle the WhackAMole game.
 */
class WhackAMole {
    private static final int SCORE = 10;
    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private int gridDimension;
    private int moles;
    private char[][] moleGrid;

    /**
     * Constructor a new instance.
     *
     * @param numAttempts   the number Attempts.
     * @param gridDimension the grid Dimension.
     */
    WhackAMole(final int numAttempts, final int gridDimension) {
        score = 0;
        moles = gridDimension;
        molesLeft = gridDimension;
        attemptsLeft = numAttempts;
        this.gridDimension = gridDimension;
        moleGrid = new char[gridDimension][gridDimension];
        fillGrid();
    }

    /**
     * Fills the grid.
     */
    private void fillGrid() {
        for (int column = 0; column < gridDimension; column++) {
            for (int row = 0; row < gridDimension; row++) {
                moleGrid[column][row] = '*';
            }
        }
    }

    /**
     * Prints the grid to user.
     */
    void printGridToUser() {
        for (int column = 0; column < gridDimension; column++) {
            for (int row = 0; row < gridDimension; row++) {
                if (moleGrid[column][row] == 'M') {
                    System.out.print("*");
                } else {
                    System.out.print(moleGrid[column][row]);
                }
            }
            System.out.println();
        }
    }

    /**
     * Prints the grid.
     */
    void printGrid() {
        for (int column = 0; column < gridDimension; column++) {
            for (int row = 0; row < gridDimension; row++) {
                System.out.print(moleGrid[column][row]);
            }
            System.out.println();
        }
    }

    /**
     * Places the moles.
     *
     * @param x position x in molesGrid.
     * @param y position y in molesGrid.
     * @return true if it doesn't exist the moles in the point.
     */
    boolean place(final int x, final int y) {
        if (moleGrid[x][y] == '*' && moles > 0) {
            moleGrid[x][y] = 'M';
            moles--;
            return true;
        }
        return false;
    }

    /**
     * User hit.
     *
     * @param x position x in molesGrid.
     * @param y position y in molesGrid.
     */
    void whack(final int x, final int y) {
        if (moleGrid[x][y] == 'M') {
            score += SCORE;
            attemptsLeft--;
            molesLeft--;
            moleGrid[x][y] = 'W';
        } else {
            attemptsLeft--;
        }

    }

    /**
     * Gets Score.
     *
     * @return Score.
     */
    int getScore() {
        return score;
    }

    /**
     * Gets MolesLeft.
     *
     * @return MolesLeft.
     */
    int getMolesLeft() {
        return molesLeft;
    }

    /**
     * Gets AttemptsLeft.
     *
     * @return AttemptsLeft.
     */
    int getAttemptsLeft() {
        return attemptsLeft;
    }
}
