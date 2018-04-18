package org.minions.devfund.dennis;

/**
 * Game methods and engine the game.
 */
public class WhackAMole {
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

    public WhackAMole(int numAttempts, int gridDimension) {
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
    public boolean place(int x, int y) {
        if (moleGrid[x][y] == '*') {
            moleGrid[x][y] = 'M';
            molesLeft++;
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
    public void whack(int x, int y) {
        if (place(x, y)) {
            moleGrid[x][y] = 'W';
            molesLeft--;
            score++;
        }
        attemptsLeft--;
    }

    /**
     * This method print the first grid for user.
     * @return the grid to user
     */
    public String printGridToUser() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                gridInString.append("*");
            }
            gridInString.append('\n');
        }
        return gridInString.toString();
    }

    /**
     * This method print the last grid for user.
     * @return the last grid to user
     */
    public String printGrid() {
        gridInString.setLength(0);
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                gridInString.append(moleGrid[i][j]);
            }
            gridInString.append('\n');
        }
        return gridInString.toString();
    }

    /**
     * This method start the grid with "*".
     */
    public void startGrid() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                moleGrid[i][j] = '*';
            }
        }
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

    /**
     * This method return the molesLeft.
     * @return Score
     */
    public int getMolesLeft() {
        return molesLeft;
    }

    /**
     * This method return the molesLeft.
     * @return Score
     */
    public char[][] getGrid() {
        return moleGrid.clone();
    }


}
