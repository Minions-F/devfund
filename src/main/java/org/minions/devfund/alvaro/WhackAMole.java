package org.minions.devfund.alvaro;


/**
 * This class is teh abstraction of the whack-a-mole game.
 */
class WhackAMole {
    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private int gridDimension;
    private int moles;
    private char[][] moleGrid;

    /**
     * Constructor.
     *
     * @param numAttempts   int    number of attempts.
     * @param gridDimension int    grid dimensions.
     */
    WhackAMole(int numAttempts, int gridDimension) {
        score = 0;
        moles = gridDimension;
        molesLeft = gridDimension;
        attemptsLeft = numAttempts;
        this.gridDimension = gridDimension;
        moleGrid = new char[gridDimension][gridDimension];
        fillGrid();
    }

    /**
     * this method fills the matrix with '*'.
     */
    private void fillGrid() {
        for (int column = 0; column < gridDimension; column++) {
            for (int row = 0; row < gridDimension; row++) {
                moleGrid[column][row] = '*';
            }
        }
    }

    /**
     * this method prints the grid.
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
     * this method prints the grid.
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
     * this method denifes qhere the moles will be placed.
     *
     * @param x int  row.
     * @param y int  column.
     * @return boolean if the place was successful.
     */
    boolean place(int x, int y) {
        if (moleGrid[x][y] == '*' && moles > 0) {
            moleGrid[x][y] = 'M';
            moles--;
            return true;
        }
        return false;
    }

    /**
     * this method defines where the whack will be executed.
     *
     * @param x int row.
     * @param y int column.
     */
    void whack(int x, int y) {
        final int scorePerMole = 10;
        if (moleGrid[x][y] == 'M') {
            score += scorePerMole;
            attemptsLeft--;
            molesLeft--;
            moleGrid[x][y] = 'W';
        } else {
            attemptsLeft--;
        }

    }


    /**
     * This method gets the score.
     *
     * @return int score.
     */
    public int getScore() {
        return score;
    }

    /**
     * this method gets the remaining moles.
     *
     * @return int molest left.
     */
    public int getMolesLeft() {
        return molesLeft;
    }

    /**
     * this method gets the attemps left.
     *
     * @return int attempts left.
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }
}
