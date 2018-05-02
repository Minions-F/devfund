package org.minions.devfund.dennis;

/**
 * This is the methods for Squarelotron test.
 */
public class Squarelotron {
    private int[][] squarelotronMain;
    private int size;

    /**
     * Constructor for squarelotron, filling the matrix.
     * @param n dimension of matrix
     */
    public Squarelotron(int n) {
        this.size = n;
        int numbers = 1;
        squarelotronMain = new int[n][n];
        for (int fil = 0; fil < n; fil++) {
            for (int col = 0; col < n; col++) {
                this.squarelotronMain[fil][col] = numbers;
                numbers++;
            }
        }
    }

    /**
     * This method found numbers in the the ring or not in ring.
     * @param fil all files of the matrix
     * @param col all columns of the matrix
     * @param ring what ring you select
     * @return this return numbers in the ring and not in the ring
     */
    private boolean numbersInRing(int fil, int col, int ring) {
        boolean isInRing = fil == ring - 1 || col == ring - 1
                || fil == size - ring || col == size - ring;
        boolean notInRing = fil <= ring - 2 || col <= ring - 2
                || fil >= size + 1 - ring || col >= size + 1 - ring;
        return isInRing && !notInRing;
    }

    /**
     * This method performs the Upside-Down Flip of the squarelotron.
     * @param ring that you need to Upside-Down Flip of the matrix
     * @return the new matrix Upside-Down Flip
     */
    public Squarelotron upsideDownFlip(int ring) {
        Squarelotron newSquarelotron = new Squarelotron(size);
        for (int fil = 0; fil < size; fil++) {
            for (int col = 0; col < size; col++) {
                if (numbersInRing(fil, col, ring)) {
                    newSquarelotron.squarelotronMain[fil][col] = this.squarelotronMain[size - 1 - fil][col];
                }
            }
        }
        return newSquarelotron;
    }

    /**
     * This method performs the Main Diagonal Flip of the squarelotron.
     * @param ring that you need to Main Diagonal Flip of the matrix
     * @return the new matrix Main Diagonal Flip
     */
    public Squarelotron mainDiagonalFlip(int ring) {
        Squarelotron newSquarelotron = new Squarelotron(size);
        for (int fil = 0; fil < size; fil++) {
            for (int col = 0; col < size; col++) {
                if (numbersInRing(fil, col, ring)) {
                    newSquarelotron.squarelotronMain[fil][col] = this.squarelotronMain[col][fil];
                }
            }
        }
        return newSquarelotron;
    }

    /**
     * This method rotated 90° clockwise of the matrix.
     * @param numberOfTurns indicates the number of times the entire squarelotron should be rotated 90° clockwise
     */
    public void rotateRight(int numberOfTurns) {
        final int magicNumber = 4;
        numberOfTurns = (numberOfTurns % magicNumber + magicNumber) % magicNumber;
        for (int n = 0; n < numberOfTurns; n++) {
            Squarelotron newSquarelotron = new Squarelotron(size);
            for (int fil = 0; fil < size; fil++) {
                for (int col = 0; col < size; col++) {
                    newSquarelotron.squarelotronMain[col][size - 1 - fil] = squarelotronMain[fil][col];
                }
            }
            this.squarelotronMain = newSquarelotron.squarelotronMain;
        }
    }

    /**
     *  This method return Size of the Matrix..
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * This method return the final Matrix.
     * @return the matrix
     */
    public int[][] getMatrix() {
        return squarelotronMain.clone();
    }
}
