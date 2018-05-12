package org.minions.devfund.angela;

import java.util.Arrays;

/**
 * Manage squarematrix.
 */
public class Squarelotron {

    private int[][] squarematrix;
    private int size;

    /**
     * Constructor for {@link Squarelotron}.
     *
     * @param dimension the dimension to fill the squarematrix.
     */
    public Squarelotron(final int dimension) {
        size = dimension;
        squarematrix = new int[dimension][dimension];
        int counter = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                counter++;
                getSquarematrix()[i][j] = counter;
            }
        }
    }

    /**
     * Constructor for {@link Squarelotron}.
     *
     * @param matrix the matrix to fill the squarematrix.
     */
    private Squarelotron(final int[][] matrix) {
        size = matrix.length;
        squarematrix = matrix;
    }

    /**
     * Performs the Upside-Down Flip of the squarematrix.
     *
     * @param ring int ring number to perform the Upside-Down Flip.
     * @return {@link Squarelotron}.
     */
    Squarelotron upsideDownFlip(final int ring) {
        int[][] newNumbers = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isPartOfTheRing(ring, i, j)) {
                    newNumbers[size - 1 - i][j] = squarematrix[i][j];
                } else if (ring == 0) {
                    newNumbers[size - 1 - i][j] = squarematrix[i][j];
                } else {
                    newNumbers[i][j] = squarematrix[i][j];
                }
            }
        }
        return new Squarelotron(newNumbers);
    }

    /**
     * Performs the Main Diagonal Flip of the squarematrix.
     *
     * @param ring int ring number to perform the Main Diagonal Flip.
     * @return {@link Squarelotron}.
     */
    Squarelotron mainDiagonalFlip(final int ring) {
        int[][] newNumbers = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isPartOfTheRing(ring, i, j)) {
                    newNumbers[j][i] = squarematrix[i][j];
                } else if (ring == 0) {
                    newNumbers[j][i] = squarematrix[i][j];
                } else {
                    newNumbers[i][j] = squarematrix[i][j];
                }
            }
        }
        return new Squarelotron(newNumbers);
    }

    /**
     * Verifies if a position is part of the ring.
     *
     * @param ring int the number of the ring.
     * @param i    int the x position.
     * @param j    int the y position.
     * @return tru if position is part of the ring.
     */
    boolean isPartOfTheRing(int ring, int i, int j) {
        return (i == ring - 1 || i == size - ring) && j >= ring - 1 && j <= size - ring
                || (j == ring - 1 || j == size - ring) && i >= ring - 1 && i <= size - ring;
    }

    /**
     * Rotates the squarematrix to right.
     *
     * @param numberOfTurns indicates the number of times the entire
     *                      squarematrix should be rotated 90° clockwise .
     */
    public void rotate(final int numberOfTurns) {
        final int sidesNumber = 4;
        int turnsNumber = Math.abs(numberOfTurns) % sidesNumber;
        Squarelotron squarelotron;
        if (numberOfTurns > 0) {
            while (turnsNumber-- > 0) {
                squarelotron = upsideDownFlip(0).mainDiagonalFlip(0);
                squarematrix = squarelotron.getSquarematrix();
            }
        } else {
            while (turnsNumber-- > 0) {
                squarelotron = mainDiagonalFlip(0).upsideDownFlip(0);
                squarematrix = squarelotron.getSquarematrix();
            }
        }
    }

    /**
     * Gets the squalotron matrix.
     *
     * @return matrix.
     */
    public int[][] getSquarematrix() {
        return Arrays.copyOf(squarematrix, size);
    }
}
