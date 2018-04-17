package org.minions.devfund.dennis;

/**
 * Game methods and engine the game.
 */
class WhackAMole {
    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;
    private StringBuilder gridInString = new StringBuilder();

    /**
     * Constructor.
     * @param numAttempts allow the number of attempts user
     * @param gridDimension grid size
     */

    WhackAMole(int numAttempts, int gridDimension) {
        attemptsLeft = numAttempts;
        moleGrid = new char[gridDimension][gridDimension];
        startGrid();
    }

    /**
     * This method return is a mole is added.
     * @param x position of a mole in the grid for coordinate x
     * @param y position of a mole in the grid for coordinate y
     * @return this return if the mole is added
     */
    boolean place(int x, int y) {
        if (moleGrid[x][y] != 'M') {
            moleGrid[x][y] = 'M';
            molesLeft ++;
            return true;
        }
        return false;
    }

    /**
     * This method change to "W" if this a wackamole.
     * decrease the moles.
     * increases the score.
     * decrease the attempts.
     * @param x position of user in x
     * @param y position of user in y
     */
    void whack(int x, int y) {
        if (moleGrid[x][y] == 'M') {
            moleGrid[x][y] = 'W';
            molesLeft --;
            score ++;
        }
        attemptsLeft--;
    }

    /**
     * This method print the first grid for user.
     */
    void printGridToUser() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                moleGrid[i][j] = '*';
                gridInString.append(moleGrid[i][j] + "\t");
            }
            gridInString.append("\n");
        }
        System.out.print(gridInString);
    }

    /**
     * This method print the last grid for user.
     */
    void printGrid() {
        gridInString.setLength(0);
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                gridInString.append(moleGrid[i][j] + "\t");
            }
            gridInString.append("\n");
        }
        System.out.print(gridInString);
    }

    /**
     * This method start the grid with "*".
     */
    void startGrid() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                moleGrid[i][j] = '*';
            }
        }
    }

    /**
     * This method print the actual results in each attempt.
     */
    void results() {
        String result = String.format("--Attempts available: %1$d  --Moles available: %2$d  --Score: %3$d",
                attemptsLeft, molesLeft, score);
        System.out.println(result);
    }

    /**
     * This method return the attempts.
     * @return attempts
     */
    int getAttempts() {
        return attemptsLeft;
    }

    /**
     * This method return the Score in each attempts.
     * @return Score
     */
    int getScore() {
        return score;
    }

    /**
     * This method return the molesLeft.
     * @return Score
     */
    int getMolesLeft() {
        return molesLeft;
    }


}
