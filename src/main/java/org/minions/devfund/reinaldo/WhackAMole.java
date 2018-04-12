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
    private int cantMoles;
    private char[][] moleGrid;

    /***
     * This is the construtor to WhackAMole.
     * @param numAttempts attemps.
     * @param gridDimension dimension.
     */
    WhackAMole(final int numAttempts, int gridDimension) {
        score = 0;
        attemptsLeft = numAttempts;
        cantMoles = gridDimension;
        molesLeft = gridDimension;
        this.gridDimension = gridDimension;
        moleGrid = getFillWhackAMole();
    }

    /***
     * Methods to fill the grid with character *.
     * @return char[][].
     */
    public char[][] getFillWhackAMole() {
        char[][] moleGridNew = new char[gridDimension ][gridDimension ];
        for (int column = 0; column < gridDimension; column++) {
            for (int row = 0; row < gridDimension; row++) {
                moleGridNew[column][row] = '*';
            }
        }
        return moleGridNew;
    }

    /**
     * verifies the mole in the position.
     * @param postX value
     * @param postY value
     * @return boolean
     */
    public boolean place(int postX, int postY) {
        if (moleGrid[postX][postY] == '*' && cantMoles > 0) {
            moleGrid[postX][postY] = 'M';
            cantMoles--;
            return true;
        }
        return false;
    }

    /**
     * Updates the datas for whack.
     * @param postX location
     * @param postY location
     */
    public void whack(int postX, int postY) {
        if (moleGrid[postX][postY] == 'M') {
            score += USERSCORE;
            attemptsLeft--;
            molesLeft--;
            moleGrid[postX][postY] = 'W';
        } else {
            attemptsLeft--;
        }
    }

    /**
     * Methods that print the grid.
     */
    public void printGrid() {
        for (int column = 0; column < gridDimension; column++) {
            for (int row = 0; row < gridDimension; row++) {
                System.out.print(moleGrid[column][row]);
            }
            System.out.println();
        }
    }

    /**
     * Method that print to user.
     */
    public void printGridToUser() {
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
