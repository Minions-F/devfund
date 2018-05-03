package org.minions.devfund.marylin;

import java.util.Arrays;

/**
 * Squarelotron class.
 */
public class Squarelotron {
    private int[][] squarelotron;
    private int size;
    private int numberOfRings;

    /**
     * Constructor of the matrix n x n initialized with consecutive values from 1 to m.
     *
     * @param n size of the matrix
     */
    public Squarelotron(int n) {
        this.size = n;
        this.numberOfRings = this.size - (this.size / 2);
        this.squarelotron = new int[n][n];
        int number = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.squarelotron[i][j] = number;
                number++;
            }
        }
    }

    /**
     * Constructs an Squarelotron from an array of array.
     *
     * @param squarelotron instance of an Squarelotron.
     */
    public Squarelotron(final int[][] squarelotron) {
        this.size = squarelotron.length;
        this.numberOfRings = this.size - (this.size / 2);
        this.squarelotron = new int[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.squarelotron[i][j] = squarelotron[i][j];
                this.squarelotron[i][j] = squarelotron[i][j];
            }
        }
    }


    @Override
    public int hashCode() {
        return Arrays.hashCode(squarelotron);
    }

    /**
     * Compare two Squarelotron.
     *
     * @param object Squarelotron instance.
     * @return Squarelotron instance.
     */
    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof Squarelotron)) {
            return false;
        }

        Squarelotron squarelotronTemp = (Squarelotron) object;
        for (int i = 0; i < this.squarelotron.length; i++) {
            for (int j = 0; j < this.squarelotron.length; j++) {
                if (this.squarelotron[i][j] != squarelotronTemp.squarelotron[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Duplicates an array of arrays.
     *
     * @param original array of array.
     * @return the duplicated array.
     */
    private int[][] duplicateGrid(final int[][] original) {
        int size = original.length;
        int[][] backupGrid = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                backupGrid[i][j] = original[i][j];
            }
        }
        return backupGrid;
    }

    /**
     * Prints the Squarelotron.
     */
    void printSquarelotron() {
        for (int i = 0; i < squarelotron.length; i++) {
            for (int j = 0; j < squarelotron.length; j++) {
                System.out.print(" " + squarelotron[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * upsideDownFlipCompleteMatrix without check rings.
     *
     * @param matrix array.
     * @return the matrix that is upside down flip completely.
     */
    int[][] upsideDownFlipCompleteMatrix(final int[][] matrix) {
        int[][] resultGrid = duplicateGrid(matrix);
        int size = matrix.length;
        int temp = 0;
        for (int i = size - 1; i >= size / 2; i--) {
            for (int j = 0; j < size; j++) {
                resultGrid[i][j] = matrix[temp][j];
                resultGrid[temp][j] = matrix[i][j];
            }
            temp++;
        }
        return resultGrid;
    }

    /**
     * upsideDownFlipInternalMatrix distinc to ring #1.
     *
     * @param matrix to be upside down flip the internal matrix.
     * @return the matrix result-
     */
    int[][] upsideDownFlipInternalMatrix(final int[][] matrix) {
        int[][] resultGrid = duplicateGrid(matrix);
        int size = matrix.length;
        int temp = 1;
        for (int i = size - 2; i >= size / 2; i--) {
            for (int j = 1; j < size - 1; j++) {
                resultGrid[i][j] = matrix[temp][j];
                resultGrid[temp][j] = matrix[i][j];
            }
            temp++;
        }
        return resultGrid;
    }

    /**
     * Upside Down Flip.
     *
     * @param ring number.
     * @return an instance of Squarelotron.
     */
    Squarelotron upsideDownFlip(int ring) {
        int[][] resultGrid = duplicateGrid(this.squarelotron);
        int size = resultGrid.length;

        //Returns the same squarelotron if the ring number is equal to the number of rings of a matrix n x n.
        if (size % 2 == 1 && ring == this.numberOfRings) {
            return this;
        }

        //If the ring is the internal rings.
        if (ring != 1) {
            resultGrid = upsideDownFlipInternalMatrix(this.squarelotron);
        } else {
            //complete Upside Down Flip.
            resultGrid = upsideDownFlipCompleteMatrix(this.squarelotron);

            // Restore values of the internal rings if there are.
            for (int i = 1; i < size - 1; i++) {
                for (int j = 1; j < size - 1; j++) {
                    resultGrid[i][j] = this.squarelotron[i][j];
                }
            }
        }
        return new Squarelotron(resultGrid);
    }

    /**
     * flipExternalRing.
     *
     * @param matrix to be flip.
     * @return the matrix result.
     */
    private int[][] flipExternalRing(final int[][] matrix) {
        int[][] resultGrid = duplicateGrid(matrix);
        int size = matrix.length;
        int tempJ = 0;
        for (int i = 1; i < size; i++) {
            resultGrid[i][tempJ] = matrix[tempJ][i];
            resultGrid[tempJ][i] = matrix[i][tempJ];
        }

        int tempI = size - 1;
        for (int j = 1; j < size - 1; j++) {
            resultGrid[tempI][j] = matrix[j][tempI];
            resultGrid[j][tempI] = matrix[tempI][j];
        }
        return resultGrid;
    }

    /**
     * flipInternalRing.
     *
     * @param matrix to be flip.
     * @return matrix result
     */
    private int[][] flipInternalRing(final int[][] matrix) {
        int[][] resultGrid = duplicateGrid(matrix);
        int size = matrix.length;
        int tempJ = 1;
        for (int i = 1; i < size - 1; i++) {
            resultGrid[i][tempJ] = matrix[tempJ][i];
            resultGrid[tempJ][i] = matrix[i][tempJ];
        }

        int tempI = size - 2;
        for (int j = 1; j < size - 2; j++) {
            resultGrid[tempI][j] = matrix[j][tempI];
            resultGrid[j][tempI] = matrix[tempI][j];
        }
        return resultGrid;
    }

    /**
     * mainDiagonalFlip.
     *
     * @param ring number.
     * @return the Squarelotron.
     */
    Squarelotron mainDiagonalFlip(int ring) {
        int[][] resultGrid = null;
        if (this.size % 2 == 1 && ring == this.numberOfRings) {
            return this; // returns the same squarelotron if the ring number is equal to the number of rings.
        }
        if (ring != 1) {
            resultGrid = flipInternalRing(this.squarelotron);
        } else {
            resultGrid = flipExternalRing(this.squarelotron);
        }
        return new Squarelotron(resultGrid);
    }

    /**
     * Rotates the matrix.
     *
     * @param numberOfTurns number.
     */
    void rotateRight(int numberOfTurns) {
        final int zeroNumberOfTurns = 0;
        final int maxNumberOfTurns = 4;
        if (numberOfTurns < maxNumberOfTurns && numberOfTurns != 0) {
            int[][] resultGrid = null;
            Squarelotron squarelotron = new Squarelotron(this.squarelotron);
            while (numberOfTurns > 0) {
                for (int i = 1; i <= squarelotron.size; i++) {
                    squarelotron = squarelotron.upsideDownFlip(i);
                }
                for (int i = 1; i <= squarelotron.size; i++) {
                    squarelotron = squarelotron.mainDiagonalFlip(i);
                }
                resultGrid = squarelotron.squarelotron;
                numberOfTurns--;
            }
            this.squarelotron = resultGrid;
        }
    }
}
