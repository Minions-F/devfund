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
     * @param array the unidimensional array to fill the squarematrix.
     */
    public Squarelotron(final int[] array) {
        size = (int) Math.sqrt(array.length);
        squarematrix = new int[size][size];
        int counter = 0;
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                getSquarematrix()[i][j] = array[counter];
                counter++;
            }
        }
    }

    /**
     * Changes the matrix to unidimensional array.
     *
     * @return an array of ints.
     */
    private int[] changeToUnidimensionalArray() {
        int[] numberArray = new int[getSize() * getSize()];
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {

                numberArray[i * getSize() + j] = getSquarematrix()[i][j];
            }
        }
        return numberArray;
    }

    /**
     * Performs the Upside-Down Flip of the squarematrix.
     *
     * @param ring int ring number to perform the Upside-Down Flip.
     * @return {@link Squarelotron}.
     */
    Squarelotron upsideDownFlip(final int ring) {
        int[] numbers = changeToUnidimensionalArray();
        int[] newNumbers = new int[getSize() * getSize()];
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                if (i == ring - 1 || i == getSize() - ring || j == ring - 1 || j == getSize() - ring) {
                    newNumbers[i * getSize() + j] = numbers[(getSize() - i - 1) * getSize() + j];
                } else {
                    newNumbers[i * getSize() + j] = numbers[i * getSize() + j];
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
    public Squarelotron mainDiagonalFlip(final int ring) {
        int[] numbers = changeToUnidimensionalArray();
        int[] newNumbers = new int[getSize() * getSize()];
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                if (i == ring - 1 || i == getSize() - ring || j == ring - 1 || j == getSize() - ring) {
                    newNumbers[i * getSize() + j] = numbers[j * getSize() + i];
                } else {
                    newNumbers[i * getSize() + j] = numbers[i * getSize() + j];
                }
            }
        }
        return new Squarelotron(newNumbers);
    }

    /**
     * Rotates the squarematrix to right.
     *
     * @param numberOfTurns indicates the number of times the entire
     *                      squarematrix should be rotated 90° clockwise .
     */
    public void rotateRight(final int numberOfTurns) {
        final int squareSides = 4;
        final int oneRotateRight = 1;
        final int oneRotateLeft = -1;
        final int twoRotateRight = 2;
        final int twoRotateLeft = -2;
        final int threeRotateRight = 3;
        final int threeRotateLeft = -3;
        if (numberOfTurns % squareSides == oneRotateRight || numberOfTurns % squareSides == threeRotateLeft) {
            rotate();

        } else if (numberOfTurns % squareSides == twoRotateRight || numberOfTurns % squareSides == twoRotateLeft) {
            rotate();
            rotate();

        } else if (numberOfTurns % squareSides == threeRotateRight || numberOfTurns % squareSides == oneRotateLeft) {
            rotate();
            rotate();
            rotate();
        }
    }

    /**
     * Rotates the squarematrix 90 degrees.
     */
    private void rotate() {
        for (int k = 0; k < getSize() / 2; k++) {
            int[] savedArray = new int[getSize() - 2 * k];
            int n = 0;
            for (int j = k; j < getSize() - k; j++) {
                savedArray[n] = getSquarematrix()[k][j];
                n++;
            }
            for (int j = k; j < getSize() - k; j++) {
                getSquarematrix()[k][j] = getSquarematrix()[getSize() - 1 - j][k];
            }
            for (int i = k; i < getSize() - k; i++) {
                getSquarematrix()[i][k] = getSquarematrix()[getSize() - 1 - k][i];
            }
            for (int j = k; j < getSize() - k; j++) {
                getSquarematrix()[getSize() - 1 - k][j] = getSquarematrix()[getSize() - 1 - j][getSize() - 1 - k];
            }
            n = 0;
            for (int i = k; i < getSize() - k; i++) {
                getSquarematrix()[i][getSize() - 1 - k] = savedArray[n];
                n++;
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

    /**
     * Gets the squalotron size.
     *
     * @return int with the size value.
     */
    public int getSize() {
        return size;
    }

}
