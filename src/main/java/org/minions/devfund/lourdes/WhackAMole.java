package org.minions.devfund.lourdes;

/**
 * Class that simulate the Whackamole game.
 */
public class WhackAMole {
    private static final char MOLE = 'M';
    private static final char WHACK = 'W';
    private static final char ASTERISK = '*';
    private int score;
    private int molesLeft;
    private int attemptsLeft;

    private char[][] moleGrid;

    /**
     * Constructor.
     *
     * @param numAttempts   Specify the max number of attempt to be used in the game.
     * @param gridDimension Define the grid dimension.
     */
    public WhackAMole(int numAttempts, int gridDimension) {
        this.attemptsLeft = numAttempts;
        this.moleGrid = new char[gridDimension][gridDimension];
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid[i].length; j++) {
                moleGrid[i][j] = '*';
            }
        }
    }

    /**
     * Method to place a Mole into the Grid.
     *
     * @param x Represents the X axes position in the grid.
     * @param y Represents the Y axes position in the grid.
     * @return True if the mole was placed successfully.
     */
    public boolean place(int x, int y) {
        if (this.moleGrid[x][y] == ASTERISK) {
            this.moleGrid[x][y] = MOLE;
            this.molesLeft++;
            return true;
        }
        return false;
    }

    /**
     * Method that perform a whack in the grid.
     *
     * @param x Represents the X axes position in the grid.
     * @param y Represents the Y axes position in the grid.
     */
    public void whack(int x, int y) {
        if (moleGrid[x][y] == MOLE) {
            molesLeft--;
            score++;
            moleGrid[x][y] = WHACK;
        }
        attemptsLeft--;
    }

    /**
     * Method that print the grid without showing the moles.
     * @return a string that will be displayed to the user
     */
    public String printGridToUser() {
        StringBuilder printGridUser = new StringBuilder();
        for (char[] row : moleGrid) {
            for (char cellValue : row) {
                if (cellValue == MOLE || cellValue == ASTERISK) {
                    printGridUser.append(ASTERISK);
                } else {
                    printGridUser.append(WHACK);
                }
            }
            printGridUser.append("\n");
        }
        return printGridUser.toString();
    }

    /**
     * Method that print the whole grid in its current state.
     * @return a string that display the grid
     */
    public String printGrid() {
        StringBuilder printGrid = new StringBuilder();
        for (char[] row : moleGrid) {
            for (char cellValue : row) {
                printGrid.append(cellValue);
            }
            printGrid.append("\n");
        }
        return printGrid.toString();
    }

    /**
     * Method that return the score.
     *
     * @return score data.
     */
    public int getScore() {
        return score;
    }

    /**
     * Method tha return the moles left.
     *
     * @return moles left
     */
    public int getMolesLeft() {
        return molesLeft;
    }

    /**
     * Method that return the attempts left.
     *
     * @return attempts left
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * Method that return the grid.
     *
     * @return the mole grid.
     */
    public char[][] getMoleGrid() {
        return moleGrid.clone();
    }
}
