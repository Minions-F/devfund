package org.minions.devfund.dennis;

/**
 * Game methods and engine the game.
 */
public class WhackAMole {
    private static final int MOLES_LEFT = 10;
    private int score = 0;
    private int molesLeft = MOLES_LEFT;
    private int attemptsLeft;
    private char[][] moleGrid;

    /**
     *
     * @param numAttempts number of attempts that a user have
     * @param gridDimension grid size in this case is 10
     */
    public WhackAMole(int numAttempts, int gridDimension) {
        attemptsLeft = numAttempts;
        moleGrid = new char[gridDimension][gridDimension];
        starGrid();
        molesInGrid();
    }

    /**
     * This method return if this a whackamole.
     * @param x position of the whackamole in X
     * @param y position of the whackamole in Y
     * @return true if was whackamole
     */
    public boolean place(int x, int y) {
        if (moleGrid[x][y] == 'M') {
            return true;
        }
        return false;
    }

    /**
     * This method change to "W" if this a wackamole.
     * decrease the moles.
     * increases the score.
     * decrease the attemps.
     * @param x position of the whackamole in X
     * @param y position of the whackamole in Y
     */
    public void whack(int x, int y) {
        if (place(x, y)) {
            moleGrid[x][y] = 'W';
            molesLeft--;
            score += 1;
        }
        attemptsLeft--;
    }

    /**
     * This method print the initial game to user.
     */
    public void printGridToUser() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                System.out.print("\t * ");
            }
            System.out.println();
        }
    }

    /**
     * This method Print the final grid with the results.
     */
    public void printGrid() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                System.out.print(moleGrid[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * This method return a radom value to set the wacks in the grid.
     * @return value int
     */
    public int randomPosition() {
        final int randomMole = 10;
        double value = Math.random() * randomMole;
        return (int) value;
    }

    /**
     * This method set the wackamoles in the grid with the random position.
     */
    public void molesInGrid() {
        int molePositionX;
        int molePositionY;
        for (int i = 0; i < molesLeft; i++) {
            molePositionX = randomPosition();
            molePositionY = randomPosition();
            moleGrid[molePositionX][molePositionY] = 'M';
        }
    }

    /**
     * This method fill the grid with values *.
     */
    public void starGrid() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                moleGrid[i][j] = '*';
            }
        }
    }

    /**
     * This method print the actual results in each attempt.
     */
    public void results() {
        System.out.println("Attempts available: " + attemptsLeft + "   " + "Moles available: "
                + molesLeft + "   " + "Score: " + score);
    }

    /**
     * This method return the attempts.
     * @return attempts
     */
    public int getAttempts() {
        return attemptsLeft;
    }

    /**
     * This method return the Score in each attempts.
     * @return Score
     */
    public int getScore() {
        return score;
    }

}
