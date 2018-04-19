package org.minions.devfund.marcos;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * It is in charge to represent a square matrix and it is operations.
 */
public class Squarelotron {

    private int[][] squarelotron;
    private int size;

    /**
     * Initializes an instance of {@link Squarelotron}.
     *
     * @param n square matrix dimension.
     */
    public Squarelotron(final int n) {
        this.size = n;
        squarelotron = new int[n][n];
        fillMatrix();
    }

    /**
     * Gets the Squarelotron matrix.
     *
     * @return square matrix.
     */
    public int[][] getSquarelotron() {
        return Arrays.copyOf(squarelotron, size);
    }

    /**
     * Performs the Up Side Down Flip operation.
     *
     * @param ring matrix ring number.
     * @return {@link Squarelotron}.
     */
    public Squarelotron upsideDownFlip(final int ring) {
        Squarelotron squarelotron = new Squarelotron(this.size);
        squarelotron.squarelotron = squarelotron.swapRows(this.squarelotron);
        squarelotron.squarelotron = replaceMaskValues(squarelotron.squarelotron, this.squarelotron, ring);
        return squarelotron;
    }

    /**
     * Performs the Up Main Diagonal Flip operation.
     *
     * @param ring matrix ring value.
     * @return {@link Squarelotron}.
     */
    public Squarelotron mainDiagonalFlip(final int ring) {
        Squarelotron squarelotron = new Squarelotron(this.size);
        squarelotron.squarelotron = squarelotron.transposeMatrix(this.squarelotron);
        squarelotron.squarelotron = replaceMaskValues(squarelotron.squarelotron, this.squarelotron, ring);
        return squarelotron;
    }

    /**
     * Rotates the square matrix elements 90 degrees according the number of turns parameter.
     *
     * @param numberOfTurns number of turns value.
     */
    public void rotateRight(final int numberOfTurns) {
        if (numberOfTurns >= 0) {
            rotateClockWise(numberOfTurns);
            return;
        }
        rotateCounterClockWise(numberOfTurns);
    }

    /**
     * Fills the square matrix with numbers consecutive numbers.
     */
    private void fillMatrix() {
        int accumulator = 1;
        for (int i = 0; i < this.size; i++) {
            squarelotron[i] = IntStream.range(accumulator, accumulator + size).toArray();
            accumulator += size;
        }
    }

    /**
     * Generates the ring mask matrix.
     *
     * @param ring matrix ring value.
     * @return ring mask matrix.
     */
    private int[][] generateRingMask(final int ring) {
        int[][] ringMask = new int[this.size][this.size];
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                ringMask[row][col] = isInsideRing(ring, row, col) ? 1 : 0;
            }
        }
        return ringMask;
    }

    /**
     * Verifies of a matrix element is contained inside the matrix ring.
     *
     * @param ring matrix ring value.
     * @param row  matrix row value.
     * @param col  matrix column value.
     * @return true if the matrix element is inside the ring.
     */
    private boolean isInsideRing(final int ring, final int row, final int col) {
        int upperBound = ring - 1;
        int lowerBound = this.size - ring;
        int inBound = upperBound - 1;
        int outBound = lowerBound + 1;
        boolean insideRing = row == upperBound || row == lowerBound || col == upperBound || col == lowerBound;
        boolean outsideRing = !(row <= inBound || row >= outBound || col <= inBound || col >= outBound);
        return insideRing && outsideRing;
    }

    /**
     * Rotates the matrix 90 degrees clockwise direction.
     *
     * @param numberOfTurns number of turns value.
     */
    private void rotateClockWise(final int numberOfTurns) {
        int turns = numberOfTurns;
        while (turns-- > 0) {
            this.squarelotron = swapRows(this.squarelotron);
            this.squarelotron = transposeMatrix(this.squarelotron);
        }
    }

    /**
     * Rotates the matrix 90 degrees in the counterclockwise direction.
     *
     * @param numberOfTurns number of turns value.
     */
    private void rotateCounterClockWise(final int numberOfTurns) {
        int turns = numberOfTurns;
        while (turns++ < 0) {
            this.squarelotron = transposeMatrix(this.squarelotron);
            this.squarelotron = swapRows(this.squarelotron);
        }
    }

    /**
     * Swaps the rows of square matrix.
     *
     * @param matrix matrix to be swapped.
     * @return matrix with swap rows.
     */
    private int[][] swapRows(final int[][] matrix) {
        int[][] swapped = new int[this.size][this.size];
        for (int row = 0; row <= this.size / 2; row++) {
            swapped[row] = matrix[this.size - 1 - row];
            swapped[this.size - 1 - row] = matrix[row];
        }
        return swapped;
    }

    /**
     * Transposes a matrix using the main diagonal.
     *
     * @param matrix matrix to be transposed.
     * @return transposed matrix.
     */
    private int[][] transposeMatrix(final int[][] matrix) {
        int[][] transposed = new int[this.size][this.size];
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                transposed[row][col] = matrix[col][row];
            }
        }
        return transposed;
    }

    /**
     * Replaces just the mod matrix elements according to the ring mask.
     *
     * @param modMatrix  modified matrix.
     * @param origMatrix original matrix data.
     * @param ring       matrix ring value.
     * @return matrix with replaced values.
     */
    private int[][] replaceMaskValues(final int[][] modMatrix, final int[][] origMatrix, final int ring) {
        int[][] maskMatrix = generateRingMask(ring);
        int[][] replacedMatrix = new int[this.size][this.size];
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                replacedMatrix[row][col] = maskMatrix[row][col] == 0 ? origMatrix[row][col] : modMatrix[row][col];
            }
        }
        return replacedMatrix;
    }
}
