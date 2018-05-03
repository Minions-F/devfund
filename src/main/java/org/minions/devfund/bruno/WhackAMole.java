package org.minions.devfund.bruno;

import java.util.Random;

/**
 * This Class in charge to manage the whack a mole game.
 */
public class WhackAMole {

    private static final String BLANK_SPACE = " ";
    private static final int ZERO = 0;
    private Random random;
    private String[][] moleGrid;
    private boolean quitGame;
    private int score;
    private int molesLeft;
    private int attemptsLeft;

    /**
     * Initializes the constructor for WhackAMole game.
     *
     * @param numAttempts   Integer attempts number.
     * @param gridDimension Integer Dimension grid.
     */
    public WhackAMole(final int numAttempts, final int gridDimension) {
        attemptsLeft = numAttempts;
        moleGrid = new String[gridDimension][gridDimension];
        random = new Random();
        quitGame = false;
        generateGrid();
    }

    /**
     * Generates the grid initial.
     */
    private void generateGrid() {
        int gridLength = moleGrid.length;
        for (int row = 0; row < gridLength; row++) {
            for (int col = 0; col < gridLength; col++) {
                moleGrid[row][col] = "*";
            }
        }
    }

    /**
     * Prints the grid without showing where the moles are.
     *
     * @return a string to print grid to user.
     */
    public String printGridToUser() {
        StringBuilder userGrid = new StringBuilder();
        for (String[] row : moleGrid) {
            for (String place : row) {
                userGrid.append(hideMole(place));
            }
            userGrid.append('\n');
        }
        return userGrid.toString();
    }

    /**
     * Hides the mole for the user cannot see them if is necessary.
     *
     * @param moleGrid to hide.
     * @return the place with the mole hide if is necessary.
     */
    public String hideMole(final String moleGrid) {
        return moleGrid.equals("M") ? BLANK_SPACE.concat("*").concat(BLANK_SPACE)
                : BLANK_SPACE.concat(moleGrid).concat(BLANK_SPACE);
    }

    /**
     * It places a mole at that location.
     *
     * @param xMole Integer X coordinate of the mole place.
     * @param yMole Integer Y coordinate of the mole place.
     * @return true if you can place a mole at that location.
     */
    public boolean place(final int xMole, final int yMole) {
        boolean isPlaceMole = !moleGrid[xMole][yMole].equals("M");
        moleGrid[xMole][yMole] = isPlaceMole ? "M" : "*";
        molesLeft += 1;
        return isPlaceMole;
    }

    /**
     * Places the moles randomly.
     *
     * @param numMoles moles number to placing.
     * @return number moles placed.
     */
    public int placeAllMoles(int numMoles) {
        molesLeft = numMoles;
        int gridLength = moleGrid.length;
        int moles = numMoles;
        while (moles > ZERO) {
            if (place(random.nextInt(gridLength), random.nextInt(gridLength))) {
                moles--;
            }
        }
        return moles;
    }

    /**
     * It makes a whack at that location.
     *
     * @param xWhack Integer X coordinate of the whack place.
     * @param yWhack Integer Y coordinate of the whack place.
     * @return true id the mole and whack has the same location.
     */
    public boolean whack(final int xWhack, final int yWhack) {
        boolean isWhackMole = false;
        if (exitGame(xWhack, yWhack)) {
            quitGame = true;
            System.out.println("Exiting Game!\n");
        } else if (validCordinates(xWhack, yWhack)) {
            isWhackMole = checkTheMoleInTheGrid(xWhack, yWhack);
        } else {
            System.out.println("Hmmmm. It seems you put in an invalid entry.");
            System.out.println("Please enter values from 1 to " + moleGrid.length + ".\n");
        }
        return isWhackMole;
    }

    /**
     * It checks if the mole is in this coordinates.
     *
     * @param xWhack Integer X coordinate of the whack place.
     * @param yWhack Integer Y coordinate of the whack place.
     * @return true id the mole and whack has the same location.
     */
    public boolean checkTheMoleInTheGrid(final int xWhack, final int yWhack) {
        boolean isWhackAMole = false;
        if (moleGrid[xWhack][yWhack].equals("M")) {
            moleGrid[xWhack][yWhack] = "M";
            molesLeft--;
            score++;
            isWhackAMole = true;
            System.out.println("You hit a mole!\n");
        } else {
            moleGrid[xWhack][yWhack] = "W";
            System.out.println("Oops! No mole there!\n");
        }
        attemptsLeft--;
        return isWhackAMole;
    }

    /**
     * Verifies the coordinates to exiting of the game.
     *
     * @param x coordinates.
     * @param y coordinates.
     * @return true to end the game false to continue.
     */
    public boolean exitGame(final int x, final int y) {
        return validCoordinateToExit(x) && validCoordinateToExit(y);
    }

    /**
     * Verifies the coordinates if is the correct.
     *
     * @param coordinate Integer coordinate number
     * @return true if is the coorrect.
     */
    public boolean validCoordinateToExit(final int coordinate) {
        return coordinate == -1;
    }

    /**
     * Validates the coordinates.
     *
     * @param x coordinates.
     * @param y coordinates.
     * @return true if the coordinates are inside the size grid.
     */
    public boolean validCordinates(final int x, final int y) {
        return validateRange(x) && validateRange(y);
    }

    /**
     * Validates the range.
     *
     * @param coordinate Integer number.
     * @return true if the coordinate is in range.
     */
    public boolean validateRange(final int coordinate) {
        return coordinate >= 0 && coordinate <= moleGrid.length;
    }

    /**
     * Manages the game states.
     *
     * @return bolean true for finishing and false to continue.
     */
    boolean gameOver() {
        if (quitGame) {
            System.out.println("You have quit the game.");
            System.out.println("Here is how far you got!");
            System.out.println("Thanks for playing");
            return true;
        }
        if (molesLeft == 0) {
            System.out.println("There are no moles left!");
            System.out.println("You won the game!");
            return true;
        } else if (attemptsLeft == 0) {
            System.out.println("You have no tries left!");
            System.out.println("You lost the game!");
            return true;
        } else {
            System.out.println("You actual score ".concat(String.valueOf(score)));
            return false;
        }
    }

    /**
     * Sets the number moles.
     *
     * @param numberMoles number moles.
     */
    public void setMolesLeft(int numberMoles) {
        molesLeft = numberMoles;
    }

    /**
     * Sets the attempts.
     *
     * @param attempts number attempts.
     */
    public void setAttemptsLeft(int attempts) {
        attemptsLeft = attempts;
    }
}
