package org.minions.devfund.reinaldo;

/**
 * Class the handle the squarelotron logic.
 */
public class Squarelotron {
    private int[][] squarelotronVariable;
    private int size;

    /**
     * @param n size to squarelotron.
     */
    public Squarelotron(final int n) {
        size = n;
        squarelotronVariable = new int[n][n];
        fillSquarelotron();
    }

    /**
     * Gets the squarelotron left.
     *
     * @return current squarelotron value.
     */
    public int[][] getSquarelotron() {
        return squarelotronVariable.clone();
    }

    /**
     * This method filling the squarelotron.
     */
    public void fillSquarelotron() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                squarelotronVariable[i][j] = size * i + j + 1;
            }
        }
    }

    /**
     * The methods get the size.
     *
     * @return size.
     */
    public int getSizeSquare() {
        return size % 2 == 0 ? size / 2 : (size - 1) / 2;
    }

    /**
     * The methodos swap to last and first column on the matrix.
     *
     * @param squarelotronCopy matrix copy.
     * @param j                position column.
     * @param ring             the ring.
     */
    public void moveTheFirstAndLasColummn(final Squarelotron squarelotronCopy, final int j, final int ring) {
        for (int i = ring - 1; i < getSizeSquare(); i++) {

            int temp = squarelotronCopy.squarelotronVariable[i][j];
            squarelotronCopy.squarelotronVariable[i][j] = squarelotronCopy.squarelotronVariable[size - 1 - i][j];
            squarelotronCopy.squarelotronVariable[size - 1 - i][j] = temp;
        }
    }

    /**
     * The methodos swap to distints last and first column on the matrix.
     *
     * @param squarelotronCopy matrix copy.
     * @param j                position column.
     * @param ring             the ring.
     */
    public void moveTheDistintSFirstAndLasColummn(final Squarelotron squarelotronCopy, final int j, final int ring) {
        squarelotronCopy.squarelotronVariable[ring - 1][j] = squarelotronVariable[size - ring][j];
        squarelotronCopy.squarelotronVariable[size - ring][j] = squarelotronVariable[ring - 1][j];
    }

    /**
     * Method up side down flip.
     *
     * @param ring ring.
     * @return squarelotron matrix.
     */
    public Squarelotron upsideDownFlip(final int ring) {
        Squarelotron squarelotronCopy = new Squarelotron(size);
        for (int columnJ = ring - 1; columnJ <= size - ring; columnJ++) {

            isColumfirstAndColumnlast(ring, squarelotronCopy, columnJ);
        }

        return squarelotronCopy;
    }

    /**
     * Methods tha execute moveTheFirstAndLasColumm and moveTheDistintSFirstAndLasColummn.
     *
     * @param ring             rign.
     * @param squarelotronCopy matrix copy.
     * @param columnJ          columns.
     */
    private void isColumfirstAndColumnlast(int ring, final Squarelotron squarelotronCopy, int columnJ) {
        if (columnJ == ring - 1 || columnJ == size - ring) {
            moveTheFirstAndLasColummn(squarelotronCopy, columnJ, ring);
        } else {
            moveTheDistintSFirstAndLasColummn(squarelotronCopy, columnJ, ring);
        }
    }

    /**
     * methods move diagonal right.
     *
     * @param squarelotronCopy matrix copy.
     * @param j                position column.
     * @param ring             move the ring.
     */
    public void moveDiagonalRight(final Squarelotron squarelotronCopy, final int j, final int ring) {
        for (int i = ring - 1; i <= size - ring; i++) {
            isTheDiagonalCenterValues(squarelotronCopy, j, i);
        }
    }

    /**
     * Methods tha verife the values centers.
     *
     * @param squarelotronCopy squarelotronCopy.
     * @param j                columns.
     * @param i                rows.
     */
    private void isTheDiagonalCenterValues(final Squarelotron squarelotronCopy, int j, int i) {
        if (j != i) {
            squarelotronCopy.squarelotronVariable[i][j] = squarelotronVariable[j][i];
            squarelotronCopy.squarelotronVariable[j][i] = squarelotronVariable[i][j];
        }
    }

    /**
     * methods move diagonal Left.
     *
     * @param squarelotronCopy matrix copy.
     * @param j                position column.
     * @param ring             move the Left.
     */
    public void moveDiagonalLeft(final Squarelotron squarelotronCopy, final int j, final int ring) {
        for (int i = size - ring; i >= ring; i--) {
            isTheDiagonalCenterValues(squarelotronCopy, j, i);
        }

    }

    /**
     * Diagonals Flip of the squarelotron.
     *
     * @param ring for move.
     * @return squarelotron.
     */
    public Squarelotron mainDiagonalFlip(final int ring) {
        Squarelotron squarelotronCopy = new Squarelotron(size);
        moveDiagonalRight(squarelotronCopy, ring - 1, ring);
        moveDiagonalLeft(squarelotronCopy, size - ring, ring);
        return squarelotronCopy;
    }

    /**
     * Rotates the squarelotron.
     *
     * @param numberOfTurns Integer that represent the moves number.
     */
    public void rotateRight(int numberOfTurns) {
        while (numberOfTurns != 0) {
            if (numberOfTurns > 0) {
                rotateRightClockWise();
                numberOfTurns--;
            } else {
                rotateLeftClockWise();
                numberOfTurns++;
            }
        }
    }

    /**
     * Methods that rotateRightClockWise.
     */
    public void rotateRightClockWise() {

        final int[][] squarelotronClone = new int[size][getSquarelotron()[0].length];

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                squarelotronClone[i][j] = squarelotronVariable[(size - 1) - j][i];
            }
        }
        squarelotronVariable = squarelotronClone.clone();
    }

    /**
     * Methods that rotateLeftClockWise.
     */
    public void rotateLeftClockWise() {

        final int[][] squarelotronClone = new int[getSquarelotron()[0].length][size];

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                squarelotronClone[i][j] = squarelotronVariable[j][(size - 1) - i];
            }
        }

        squarelotronVariable = squarelotronClone.clone();
    }
}
