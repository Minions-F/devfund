package org.minions.devfund.reinaldo;

/**
 * This classes handle all function WhackAMoleTest.
 */
public class WhackAMole {

    public static final int USERSCORE = 10;
    private int attemptsLeft;
    private int gridDimension;
    private int score;
    private int molesLeft;
    private char[][] moleGrid;
    private static final String NEWLINE = "\n";
    private static final String SPACES = "  ";

    /***
     * This is the construtor to WhackAMole.
     * @param numAttempts attemps.
     * @param gridDimension dimension.
     */
    WhackAMole(final int numAttempts, int gridDimension) {
        score = 0;
        attemptsLeft = numAttempts;
        molesLeft = gridDimension;
        this.gridDimension = gridDimension;
        moleGrid = new char[gridDimension][gridDimension];
        getFillWhackAMole();
    }

    /***
     * Methods to fill the grid with character *.
     */
    public void fillWhackAMole() {
        for (int row = 0; row < moleGrid.length; row++) {
            for (int column = 0; column < moleGrid[row].length; column++) {
                moleGrid[row][column] = '*';
            }
        }
    }

    /**
     * verifies the mole in the position.
     * @param postX value
     * @param postY value
     * @return boolean
     */
    public boolean place(int postX, int postY) {
        if (isMoleInTheCell(postX, postY)) {
            moleGrid[postX][postY] = 'M';
            return true;
        }
        return false;
    }

    /**
     *
     * verifies the mole in the position.
     * @param posX value
     * @param posY value
     * @return boolean
     */

    public boolean isMoleInTheCell(final int posX, final int posY) {
        return moleGrid[posX][posY] != 'M';
    }

    /**
     * Updates the datas for whack.
     * @param postX location
     * @param postY location
     */
    public void whack(int postX, int postY) {
        if (moleGrid[postX][postY] == 'M') {
            score += USERSCORE;
            molesLeft--;
        }
        moleGrid[postX][postY] = 'W';
        attemptsLeft--;

    }

    /**
     * Methods that print the grid.
     *
     * @return grid string.
     */
    public String printGrid() {
        StringBuilder grid = new StringBuilder();
        for (int column = 0; column < gridDimension; column++) {
            for (int row = 0; row < gridDimension; row++) {
                grid.append(String.valueOf(moleGrid[column][row]).concat(SPACES));
            }
            grid.append(NEWLINE);
        }
        return grid.toString();
    }

    /**
     * Method that print to user.
     *
     * @return user grid string.
     */
    public String printGridToUser() {
        StringBuilder userGrid = new StringBuilder();
        for (int column = 0; column < gridDimension; column++) {
            for (int row = 0; row < gridDimension; row++) {
                if (moleGrid[column][row] == 'M') {
                    userGrid.append(String.valueOf("*").concat(SPACES));
                } else {
                    userGrid.append(String.valueOf(moleGrid[column][row]).concat(SPACES));
                }
            }
            userGrid.append(NEWLINE);
        }
        return userGrid.toString();
    }

    /**
     * Gets the score value.
     * @return int
     */
    public int getScore() {
        return  score;
    }

    /**
     * Gets the AttemptsLeft.
     * @return int
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * Gets the MolesLeftt.
     * @return int
     */
    public int getMolesLeft() {
        return molesLeft;
    }
}
