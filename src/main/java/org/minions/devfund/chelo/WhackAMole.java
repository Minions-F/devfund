package org.minions.devfund.chelo;

import java.util.Random;
import java.util.Scanner;

/**
 * A class for WackAMole task.
 */
public class WhackAMole {
    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;

    /**
     * Constructor for the game, specifies total number of whacks allowed, and the grid dimension.
     * @param numAttempts initial tries for the user.
     * @param gridDimension size of the grid.
     */
    public WhackAMole(int numAttempts, int gridDimension) {
        this.moleGrid = new char[gridDimension][gridDimension];
        this.attemptsLeft = numAttempts;
        this.score = 0;
        this.molesLeft = 0;
        initializeGrid();
    }

    /**
     * A method to initialize the grid with asterisks.
     */
    void initializeGrid() {
        for (int i = 0; i < this.moleGrid.length; i++) {
            for (int j = 0; j < this.moleGrid.length; j++) {
                this.moleGrid[i][j] = '*';
            }
        }
    }

    /**
     * A method to randomically put the moles in the grid.
     * @param molesLeft remaining moles
     * @param dimensionLimit dimension of the grid's limit
     */
    void placeTheMoles(int molesLeft, int dimensionLimit) {
        int x;
        int y;
        Random rand = new Random();

        while (molesLeft > 0) {
            x = rand.nextInt(dimensionLimit);
            y = rand.nextInt(dimensionLimit);
            if (place(x, y)) {
                this.moleGrid[x][y] = 'M';
                molesLeft--;
            }
        }
    }

    /**
     * Method given a location, returns if availability.
     * @param x coordinate
     * @param y coordinate
     * @return status of the coordinate
     */
    public boolean place(int x, int y) {
        if (this.moleGrid[x][y] != 'M') {
            this.moleGrid[x][y] = 'M';
            this.molesLeft++;
            return true;
        }
        return false;
    }

    /**
     * A method given a location, take a whack at that location.
     * If that location contains a mole, the score, number of attemptsLeft, and molesLeft is updated.
     * If that location does not contain a mole, only attemptsLeft is updated.
     * @param x coordinate
     * @param y coordinate
     */
    public void whack(int x, int y) {
        if (moleGrid[x][y] == 'M') {
            moleGrid[x][y] = 'W';
            score++;
            molesLeft--;
        }
        attemptsLeft--;
    }

    /***
     * A method to print the grid without showing where the moles are.
     * For every spot that has recorded a whacked mole, print out a W, or * otherwise.
     * @return string builder
     */
    String printGridToUser() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                if (moleGrid[i][j] == 'M') {
                    builder.append("[*]");
                } else {
                    builder.append("[" + moleGrid[i][j] + "]");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    /**
     * A method to print the grid without showing where the moles are.
     * For every spot that has recorded a whacked mole print out a W, or * otherwise.
     * @return string builder
     */
    String printGrid() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                builder.append("[" + moleGrid[i][j] + "]");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    /**\
     * A method to return Attempts Left value.
     * @return remaining attempts
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**\
     * A method to return mole Grid Length value.
     * @return moleGrid
     */
    public int getMoleGridLength() {
        return moleGrid.length;
    }

    /**
     * A method to return mole Grid value given x and y.
     * @param x row
     * @param y column
     * @return value
     */
    public int getMoleGridValue(int x, int y) {
        return moleGrid[x][y];
    }

    /**\
     * A method to return score value.
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * A method to return moles left value.
     * @return remaining moles
     */
    public int getMolesLeft() {
        return  molesLeft;
    }

    /**
     * A method to print the current status for.
     * Score,
     * Attempts Left,
     * Moles Left.
     */
    public void printStatus() {
        System.out.println("Score: " + this.score
                + ", Attempts left: " + this.attemptsLeft
                + ", Moles left: " + this.molesLeft);
    }

    /**
     * Main method to run the program.
     * @param args main method
     */
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println("Enter number of attempts:");
        int numAttempts = scanner.nextInt();
        System.out.println("Enter dimension for the grid:");
        int dimensionBegin = scanner.nextInt();

        WhackAMole whackAmole = new WhackAMole(numAttempts, dimensionBegin);

        System.out.println("Enter the amount of moles");
        int amountMoles = scanner.nextInt();
        whackAmole.placeTheMoles(amountMoles, dimensionBegin);

        // Printing the grid as first action to know where the moles were placed
        System.out.println(whackAmole.printGrid());

        int userInputX;
        int userInputY;

        // While the attempts left are greater than zero the user can submit coordinates
        while (numAttempts > 0) {
            if (whackAmole.getMolesLeft() == 0) {
                System.out.println("Whack-A-Mole CHAMP!!!");
                break;
            }

            // Reading user input
            System.out.println("Enter X: ");
            userInputX = scanner.nextInt();
            System.out.println("Enter Y: ");
            userInputY = scanner.nextInt();

            // Printing the coordinates submitted by the user
            System.out.println("User input: [X=" + userInputX + "][Y=" + userInputY + "]");

            // Conditional if the user wants to finish the game
            if (userInputX == -1 || userInputY == -1) {
                System.out.println(whackAmole.printGrid());
                whackAmole.printStatus();
                System.out.println("GAME OVER: User gave up");
                numAttempts = 0;
            } else {
                // Positioning the user's hit
                whackAmole.whack(userInputX, userInputY);
                System.out.println(whackAmole.printGridToUser());
                whackAmole.printStatus();
                numAttempts--;

                if (numAttempts == 0) {
                    System.out.println(whackAmole.printGrid());
                    System.out.println("GAME OVER! NO MORE ATTEMPTS");
                    numAttempts = 0;
                }
            }
        }
    }
}
