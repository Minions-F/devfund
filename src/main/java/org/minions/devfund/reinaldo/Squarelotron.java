package org.minions.devfund.reinaldo;

/**
 * Class the handle the squarelotron logic.
 */
public class Squarelotron {
    private int[][] squarelotron;
    private int size;

    /**
     * @param n size to squarelotron.
     */
    public Squarelotron(final int n) {
        size = n;
        squarelotron = new int[n][n];
        fillSquarelotron();
    }

    /**
     * Gets the squarelotron left.
     *
     * @return current squarelotron value.
     */
    public int[][] getSquarelotron() {
        return squarelotron.clone();
    }

    /**
     * This method filling the squarelotron.
     */
    public void fillSquarelotron() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                squarelotron[i][j] = size * i + j + 1;
            }
        }
    }

    /**
     * The Methods returna a new matrix.
     * @param ring ring.
     * @return squarelotron.
     */
    public Squarelotron upsideDownFlip(int ring) {
        Squarelotron squarelotronCopy = new Squarelotron(size);
        int sizeMatrix = size - 1;
        for (int i = 0; i <= sizeMatrix; i++) {
            getFirstAndLastColumns(squarelotronCopy, ring - 1, size - ring, i, sizeMatrix);
        }
        return squarelotronCopy;
    }

    /**
     * This Method hadle the logic for upside down flip in the matrix copy.
     * @param squarelotronCopy squarelotroncopy.
     * @param first firstPosition.
     * @param last lastPosition.
     * @param i currencyRow.
     * @param sizeMatrix size.
     */
    private void getFirstAndLastColumns(final Squarelotron squarelotronCopy, int first,
                                        int last, int i, int sizeMatrix) {
        for (int j = 0; j <= sizeMatrix; j++) {
            if (i == first || i == last) {
                if (j >= first && j <= last) {
                    squarelotronCopy.squarelotron[i][j] = squarelotron[sizeMatrix - i][j];
                }
            } else {
                if (i > first && i < last && (j == first || j == last)) {
                    squarelotronCopy.squarelotron[i][j] = squarelotron[sizeMatrix - i][j];
                }
            }
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
            squarelotronCopy.squarelotron[i][j] = squarelotron[j][i];
            squarelotronCopy.squarelotron[j][i] = squarelotron[i][j];
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
                squarelotronClone[i][j] = squarelotron[(size - 1) - j][i];
            }
        }
        squarelotron = squarelotronClone.clone();
    }

    /**
     * Methods that rotateLeftClockWise.
     */
    public void rotateLeftClockWise() {

        final int[][] squarelotronClone = new int[getSquarelotron()[0].length][size];

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                squarelotronClone[i][j] = squarelotron[j][(size - 1) - i];
            }
        }

        squarelotron = squarelotronClone.clone();
    }
}
