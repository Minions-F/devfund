package org.minions.devfund.yuri;

import java.util.Random;

/**
 * This Class represents the mole grid.
 */
public class MoleGrid {
    public static final char MOLE = 'M';
    public static final char WACKED = 'W';
    public static final char EMPTYCELL = '*';
    private int dimension;
    private char[][] grid;

    public MoleGrid(final int dimension) {
        grid = new char[dimension][dimension];
        this.dimension = dimension;
    }

    public boolean place(final int posX, final int posY) {
        return true;
    }

    /**
     * 
     * @param posX
     * @param posY
     * @return
     */
    public boolean isEmptyCell(final int posX, final int posY) {
        return grid[posX][posY]== EMPTYCELL;
    }

    /**
     * This method initialize the grid with empty values.
     */
    public void fillGrid() {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                grid[row][column] = EMPTYCELL;
            }
        }
    }

    /**
     * Get a a random value in range from 0 to dimension value configured.
     * @return the random value.
     */
    public int getRandomNumber() {
        return new Random().nextInt(dimension);
    }

    /**
     * Print the Grid without showing where the moles are.
     */
    public void printGridToUser() {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == 'M') {
                    System.out.print(String.format("%c ",EMPTYCELL));
                }
                System.out.print(String.format("%c ", grid[row][column]));
            }
        }
    }

    /**
     * Prints the grid completely.
     */
    public void printGrid() {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                System.out.print(String.format("%c ", grid[row][column]));
            }
        }
    }

    public void insertMoles(int amountMoles) {
        int accumulator = 0;
        while (accumulator < amountMoles) {
            if (grid[getRandomNumber()][getRandomNumber()] != MOLE) {
                grid[getRandomNumber()][getRandomNumber()] = MOLE;
                accumulator++;
            }
        }
    }
}
