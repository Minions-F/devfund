package org.minions.devfund.mauricioz;
/**
 * class in charge to provide game functionality.
 */
public class WhackAMole {
    private int score = 0;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;

    /**
     * constructor.
     * @param numAttempts number of attempts for the game.
     * @param gridDimension grid size.
     */
    public WhackAMole(int numAttempts, int gridDimension) {
        attemptsLeft = numAttempts;
        moleGrid = new char[gridDimension][gridDimension];
        molesLeft = 0;
        initializeMoleGrid();
    }

    /**
     * method to verify if whack was over a mole or not.
     * @param x coordinate in x.
     * @param y coordinate in y.
     * @return true if mole was whacked.
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
     * Whack over a mole.
     * @param x coordinate in x.
     * @param y coordinate in y.
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
     * fill the initial grid.
     */
    private void initializeMoleGrid() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                moleGrid[i][j] = '*';
            }
        }
    }

    /**
     * print final grid.
     * @return sbuilder string
     */
    public String printGrid() {
        StringBuilder sbuilder = new StringBuilder();
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                sbuilder.append(moleGrid[i][j]);
            }
            sbuilder.append('\n');
        }
        return sbuilder.toString();
    }

    /**
     * print the initial grid.
     * @return sbuilder to string.
     */
    public String printGridToUSer() {
        StringBuilder sbuilder = new StringBuilder();
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                sbuilder.append("*");
            }
            sbuilder.append('\n');
        }
        return sbuilder.toString();
    }

    /**
     * get the value for a given position.
     * @param x position
     * @param y position
     * @return return value into a position
     */
    public char getMolePosition(int x, int y) {
        return moleGrid[x][y];
    }

    /**
     * get moles left.
     * @return moles left
     */
    public int getMolesLeft() {
        return molesLeft;
    }

    /**
     * get attempts left.
     * @return attempts left
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * get score.
     * @return score
     */
    public int getScore() {
        return score;
    }
}

