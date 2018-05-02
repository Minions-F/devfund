package org.minions.devfund.lourdes;

import java.util.Arrays;

/**
 * Class that consists basically of a matrix of numbers.
 * This matrix can be decomposed as square rings which can flip independently in two different ways:
 * Upside-Down and through the Main Diagonal.
 */
public class Squarelotron {
    private int size;
    private int[][] squarelotron;

    /**
     * Squareletron's constructor.
     *
     * @param n represents the size of the matrix.
     */
    public Squarelotron(int n) {
        size = n;
        squarelotron = new int[n][n];
        int num = 1;
        for (int i = 0; i < squarelotron.length; i++) {
            for (int j = 0; j < squarelotron[i].length; j++) {
                squarelotron[i][j] = num++;
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
        upsideDownFlipHelper(resultSquarelotron, ring);
        return resultSquarelotron;
    }

    /**
     * Method that process the information to flip down the squarelotron.
     *
     * @param newSquarelotron Represents the squarelotron object to flip down.
     * @param ring            the ring position to be flipped.
     */
    public void upsideDownFlipHelper(final Squarelotron newSquarelotron, int ring) {
        int ringPointer = ring - 1;
        int lastColumnPosition = size - 1 - (ring - 1);
        int lastRowPosition = size - 1 - (ring - 1);
        for (int i = ringPointer; i < size / 2; i++) {
            if (ringPointer == i) {
                swapCompleteRows(newSquarelotron, i, lastColumnPosition, ringPointer);
            } else {
                swapRingColumns(newSquarelotron, i, ringPointer, lastRowPosition, lastColumnPosition);

            }
            lastRowPosition--;
        }
    }

    /**
     * Method to swap ring columns of the squarelotron.
     *
     * @param newSquarelotron the Squarelotron object.
     * @param rowPosition        row position that will be swapped.
     * @param ringPointer        Represents the ring pointer.
     * @param lastRowPosition    Represents the last row position.
     * @param lastColumnPosition it is the last column position.
     */
    private void swapRingColumns(final Squarelotron newSquarelotron, int rowPosition,
                                         int ringPointer, int lastRowPosition, int lastColumnPosition) {
        int copyOfArrayValue = newSquarelotron.squarelotron[rowPosition][ringPointer];
        newSquarelotron.squarelotron[rowPosition][ringPointer] =
                newSquarelotron.squarelotron[lastRowPosition][ringPointer];
        newSquarelotron.squarelotron[lastRowPosition][ringPointer] = copyOfArrayValue;

        copyOfArrayValue = newSquarelotron.squarelotron[rowPosition][lastColumnPosition];
        newSquarelotron.squarelotron[rowPosition][lastColumnPosition] =
                newSquarelotron.squarelotron[lastRowPosition][lastColumnPosition];
        newSquarelotron.squarelotron[lastRowPosition][lastColumnPosition] = copyOfArrayValue;
    }

    /**
     * Method that make a swap for a complete row of the Squarelotron matrix.
     *
     * @param resultSquarelotron Squarelotron object.
     * @param rowPosition        Represents the row position.
     * @param lastColumnPosition it is the last column position from the matrix.
     * @param ringPointer        Represents the ring pointer.
     */
    public void swapCompleteRows(final Squarelotron resultSquarelotron, int rowPosition,
                                         int lastColumnPosition, int ringPointer) {
        int[] targetSuperior = resultSquarelotron.squarelotron[rowPosition];
        int[] sourceSuperior = Arrays.copyOfRange(targetSuperior, rowPosition, lastColumnPosition + 1);
        int[] targetInferior = resultSquarelotron.squarelotron[lastColumnPosition];
        int[] sourceInferior = Arrays.copyOfRange(targetInferior, rowPosition, lastColumnPosition + 1);
        System.arraycopy(sourceInferior, 0, targetSuperior, ringPointer, sourceInferior.length);
        System.arraycopy(sourceSuperior, 0, targetInferior, ringPointer, sourceSuperior.length);
    }

    /**
     * Method that flip the main diagonal from squarelotron matrix.
     *
     * @param ring represents the ring limit.
     * @return a Squarelotron object with the matrix flipped.
     */
    public Squarelotron mainDiagonalFlip(int ring) {
        Squarelotron resultSquarelotron = new Squarelotron(size);
        mainDiagonalFlipHelper(resultSquarelotron, ring);
        return resultSquarelotron;
    }

    /**
     * Method that make the operations to flip the main diagonal of the Squarelotron matrix.
     * @param resultSquarelotron Squarelotron object.
     * @param ring it is the ring limit.
     */
    public void mainDiagonalFlipHelper(final Squarelotron resultSquarelotron, int ring) {
        int startX = ring - 1;
        int sizeMatrix = resultSquarelotron.size - ring;
        int pivote = 0;
        for (int i = startX; i < sizeMatrix; i++) {
            for (int j = ring; j <= sizeMatrix; j++) {
                pivote = resultSquarelotron.squarelotron[i][j];
                resultSquarelotron.squarelotron[i][j] = resultSquarelotron.squarelotron[j][i];
                resultSquarelotron.squarelotron[j][i] = pivote;
            }
        }
    }

    /**
     * Method that rotate a squarelotron matrix.
     * @param numberOfTurns Represents the number of turns.
     */
    public void rotateRight(int numberOfTurns) {
        final int maxNumberToRotate = 4;
        int numberOfTurnsAbs = Math.abs(numberOfTurns);
        while (numberOfTurnsAbs % maxNumberToRotate > 0) {
            for (int i = 0; i < squarelotron.length; i++) {
                if (numberOfTurns > 0) {
                    upsideDownFlipHelper(this, i + 1);
                    mainDiagonalFlipHelper(this, i + 1);
                } else {
                    mainDiagonalFlipHelper(this, i + 1);
                    upsideDownFlipHelper(this, i + 1);
                }
            }
            numberOfTurnsAbs--;
        }
    }

    /**
     * Method to return the size of the Squarelotron matrix.
     * @return  the size of the matrix.
     */
    public int getSize() {
        return size;
    }

    /**
     * Method to return the matrix.
     * @return  squarelotron matrix.
     */
    public int[][] getSquarelotron() {
        return squarelotron.clone();
    }

}
