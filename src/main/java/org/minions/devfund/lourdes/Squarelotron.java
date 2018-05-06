package org.minions.devfund.lourdes;

import java.util.Arrays;

/**
 * Class that consists basically of a matrix of numbers.
 * This matrix can be decomposed as square rings which can flip independently in two different ways:
 * Upside-Down and through the Main Diagonal.
 */
public class Squarelotron {
    private int size;
    private int[][] matrixSquarelotron;

    /**
     * Squareletron's constructor.
     *
     * @param n represents the size of the matrix.
     */
    public Squarelotron(int n) {
        size = n;
        matrixSquarelotron = new int[n][n];
        int num = 1;
        for (int i = 0; i < matrixSquarelotron.length; i++) {
            for (int j = 0; j < matrixSquarelotron[i].length; j++) {
                matrixSquarelotron[i][j] = num++;
            }
        }
    }

    /**
     * Method that Flip upside down a matrix given a ring.
     *
     * @param ring Represents the ring to be flip down.
     * @return a new Squarelotron.
     */
    public Squarelotron upsideDownFlip(int ring) {
        Squarelotron resultSquarelotron = new Squarelotron(size);
        resultSquarelotron.matrixSquarelotron = upsideDownFlipHelper(this.matrixSquarelotron, ring);
        return resultSquarelotron;
    }

    /**
     * Method that process the information to flip down the matrixSquarelotron.
     *
     * @param squareMatrix Represents the matrixSquarelotron matrix to flip down.
     * @param ring         the ring position to be flipped.
     * @return the matrix flipped down.
     */
    public int[][] upsideDownFlipHelper(final int[][] squareMatrix, int ring) {
        int[][] copyMatrix = copyMatrix(squareMatrix);
        int ringPointer = ring - 1;
        int lastColumnPosition = size - 1 - (ring - 1);
        int lastRowPosition = size - 1 - (ring - 1);
        for (int i = ringPointer; i < size / 2; i++) {
            if (ringPointer == i) {
                copyMatrix = swapCompleteRows(this.matrixSquarelotron, i, lastColumnPosition, ringPointer);
            } else {
                copyMatrix = swapRingColumns(copyMatrix, i, ringPointer, lastRowPosition, lastColumnPosition);
            }
            lastRowPosition--;
        }
        return copyMatrix;
    }

    /**
     * Method to swap ring columns of the matrixSquarelotron.
     *
     * @param squareMatrix       the Squarelotron matrix.
     * @param rowPosition        row position that will be swapped.
     * @param ringPointer        Represents the ring pointer.
     * @param lastRowPosition    Represents the last row position.
     * @param lastColumnPosition it is the last column position.
     * @return return the matrixSquarelotron matrix swapped.
     */
    public int[][] swapRingColumns(final int[][] squareMatrix, int rowPosition,
                                   int ringPointer, int lastRowPosition, int lastColumnPosition) {
        int[][] copyMatrix = copyMatrix(squareMatrix);
        int copyOfArrayValue = copyMatrix[rowPosition][ringPointer];
        copyMatrix[rowPosition][ringPointer] = copyMatrix[lastRowPosition][ringPointer];
        copyMatrix[lastRowPosition][ringPointer] = copyOfArrayValue;

        copyOfArrayValue = copyMatrix[rowPosition][lastColumnPosition];
        copyMatrix[rowPosition][lastColumnPosition] = copyMatrix[lastRowPosition][lastColumnPosition];
        copyMatrix[lastRowPosition][lastColumnPosition] = copyOfArrayValue;
        return copyMatrix;
    }

    /**
     * Method that make a swap for a complete row of the Squarelotron matrix.
     *
     * @param squareMatrix       Squarelotron matrix.
     * @param rowPosition        Represents the row position.
     * @param lastColumnPosition it is the last column position from the matrix.
     * @param ringPointer        Represents the ring pointer.
     * @return return the matrixSquarelotron matrix columns swapped.
     */
    public int[][] swapCompleteRows(final int[][] squareMatrix, int rowPosition,
                                    int lastColumnPosition, int ringPointer) {
        int[][] copyMatrix = copyMatrix(squareMatrix);
        int[] targetSuperior = copyMatrix[rowPosition];
        int[] sourceSuperior = Arrays.copyOfRange(targetSuperior, rowPosition, lastColumnPosition + 1);
        int[] targetInferior = copyMatrix[lastColumnPosition];
        int[] sourceInferior = Arrays.copyOfRange(targetInferior, rowPosition, lastColumnPosition + 1);
        System.arraycopy(sourceInferior, 0, targetSuperior, ringPointer, sourceInferior.length);
        System.arraycopy(sourceSuperior, 0, targetInferior, ringPointer, sourceSuperior.length);
        return copyMatrix;
    }

    /**
     * Method to make a copy of a matrix.
     *
     * @param originMatrix Origin matrix to be copied.
     * @return a copy of the given matrix.
     */
    public int[][] copyMatrix(final int[][] originMatrix) {
        int[][] copyMatrix = new int[originMatrix.length][originMatrix.length];
        for (int i = 0; i < copyMatrix.length; i++) {
            copyMatrix[i] = Arrays.copyOf(originMatrix[i], originMatrix.length);
        }
        return copyMatrix;
    }

    /**
     * Method that flip the main diagonal from matrixSquarelotron matrix.
     *
     * @param ring represents the ring limit.
     * @return a Squarelotron object with the matrix flipped.
     */
    public Squarelotron mainDiagonalFlip(int ring) {
        Squarelotron resultSquarelotron = new Squarelotron(size);
        resultSquarelotron.matrixSquarelotron = mainDiagonalFlipHelper(this.matrixSquarelotron, ring);
        return resultSquarelotron;
    }

    /**
     * Method that make the operations to flip the main diagonal of the Squarelotron matrix.
     *
     * @param squareMatrix Squarelotron matrix.
     * @param ring         it is the ring limit.
     * @return the matrix maind diagonal flipped.
     */
    public int[][] mainDiagonalFlipHelper(final int[][] squareMatrix, int ring) {
        int startX = ring - 1;
        int sizeMatrix = squareMatrix.length - ring;
        int pivote;
        for (int i = startX; i < sizeMatrix; i++) {
            for (int j = ring; j <= sizeMatrix; j++) {
                pivote = squareMatrix[i][j];
                squareMatrix[i][j] = squareMatrix[j][i];
                squareMatrix[j][i] = pivote;
            }
        }
        return squareMatrix;
    }

    /**
     * Method that rotate a matrixSquarelotron matrix.
     *
     * @param numberOfTurns Represents the number of turns.
     */
    public void rotateRight(int numberOfTurns) {
        final int maxNumberToRotate = 4;
        int numberOfTurnsAbs = Math.abs(numberOfTurns);
        while (numberOfTurnsAbs % maxNumberToRotate > 0) {
            for (int i = 0; i < matrixSquarelotron.length / 2; i++) {
                if (numberOfTurns > 0) {
                    matrixSquarelotron = upsideDownFlipHelper(matrixSquarelotron, i + 1);
                    matrixSquarelotron = mainDiagonalFlipHelper(matrixSquarelotron, i + 1);
                } else {
                    matrixSquarelotron = mainDiagonalFlipHelper(matrixSquarelotron, i + 1);
                    matrixSquarelotron = upsideDownFlipHelper(matrixSquarelotron, i + 1);
                }
            }
            numberOfTurnsAbs--;
        }
    }

    /**
     * Method to return the matrix.
     *
     * @return matrixSquarelotron matrix.
     */
    public int[][] getMatrixSquarelotron() {
        return matrixSquarelotron.clone();
    }
}
