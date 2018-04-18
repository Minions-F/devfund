package org.minions.devfund.marcos;

import java.util.Arrays;
import java.util.Random;

/**
 * It is in charge to simulate a variant of the classic whack-a-mole game.
 */
public class WhackAMole {

    private static final char VOID_PLACE = '*';
    private static final char MOLE_PLACE = 'M';
    private static final char WHACKED_PLACE = 'W';
    private static final String LF_STRING = "\n";
    private static final String SPACE_STRING = "  ";

    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;

    /**
     * Initializes an instance of {@link WhackAMole} class.
     *
     * @param numAttempts   max number of attempts.
     * @param gridDimension grid dimension value.
     */
    public WhackAMole(final int numAttempts, final int gridDimension) {
        this.score = 0;
        this.molesLeft = 0;
        this.attemptsLeft = numAttempts;
        this.moleGrid = new char[gridDimension][gridDimension];
        for (char[] row : moleGrid) {
            Arrays.fill(row, VOID_PLACE);
        }
    }

    /**
     * Gets the score.
     *
     * @return current score value.
     */
    public int getScore() {
        return score;
    }

    /**
     * Gets the moles left.
     *
     * @return current moles left value.
     */
    public int getMolesLeft() {
        return molesLeft;
    }

    /**
     * Gets the attempts left.
     *
     * @return current attempts left value.
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * Places a mole in the game grid.
     *
     * @param row    mole row position.
     * @param column mole column position.
     * @return true if the value was placed successfully.
     */
    public boolean place(final int row, final int column) {
        if (moleGrid[row][column] != MOLE_PLACE) {
            moleGrid[row][column] = MOLE_PLACE;
            molesLeft++;
            return true;
        }
        return false;
    }

    /**
     * Whacks place in the game grid.
     *
     * @param row    whack row position.
     * @param column whack column position.
     */
    public void whack(final int row, final int column) {
        if (placeExists(row, column)) {
            whackMole(row, column);
            moleGrid[row][column] = WHACKED_PLACE;
            attemptsLeft--;
        }
    }

    /**
     * Whacks mole in the game grid.
     *
     * @param row    whack row position.
     * @param column whack column position.
     */
    private void whackMole(final int row, final int column) {
        if (moleGrid[row][column] == MOLE_PLACE) {
            molesLeft--;
            score++;
        }
    }

    /**
     * Fills the grid randomly with a specific number of moles.
     *
     * @param molesNumber moles number value.
     */
    public void fillGrid(final int molesNumber) {
        int totalMoles = molesNumber;
        while (totalMoles-- > 0) {
            int row;
            int column;
            do {
                row = getRandomPlace();
                column = getRandomPlace();
            }
            while (!place(row, column));
        }
    }

    /**
     * Prints representation of the game grid for the user.
     *
     * @return user grid string representation.
     */
    public String printGridToUser() {
        StringBuilder userGrid = new StringBuilder();
        for (char[] row : moleGrid) {
            for (char place : row) {
                char currentPlace = place == WHACKED_PLACE ? WHACKED_PLACE : VOID_PLACE;
                userGrid.append(String.valueOf(currentPlace).concat(SPACE_STRING));
            }
            userGrid.append(LF_STRING);
        }
        return userGrid.toString();
    }

    /**
     * Prints representation of the game grid.
     *
     * @return grid string representation.
     */
    public String printGrid() {
        StringBuilder grid = new StringBuilder();
        for (char[] row : moleGrid) {
            for (char place : row) {
                grid.append(String.valueOf(place).concat(SPACE_STRING));
            }
            grid.append(LF_STRING);
        }
        return grid.toString();
    }

    /**
     * Gets random place for moles.
     *
     * @return random place value.
     */
    private int getRandomPlace() {
        return new Random().nextInt(moleGrid.length);
    }

    /**
     * Verifies if a place exists.
     *
     * @param row    row position to be evaluated.
     * @param column column position to be evaluated.
     * @return true of place exists.
     */
    private boolean placeExists(final int row, final int column) {
        return row < moleGrid.length && row >= 0
                && column < moleGrid.length && column >= 0;
    }
}
