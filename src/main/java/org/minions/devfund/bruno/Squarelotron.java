package org.minions.devfund.bruno;

/**
 * this class is in charged to manage of the squarelotron moves.
 */
public class Squarelotron {
    private int[][] squarelotron;
    private int size;

    /**
     * Constructs a new Squarelotron 2D int array with dimensions n x n.
     *
     * @param sizeSquare is the dimension of the 2D array.  There are n rows and n columns.
     */
    public Squarelotron(final int sizeSquare) {
        this.size = sizeSquare;
        this.squarelotron = new int[size][size];
        generateSquarelotron();
    }

    /**
     * Generates the original squarelotron.
     */
    private void generateSquarelotron() {
        int count = 1;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                squarelotron[row][col] = count;
                count++;
            }
        }
    }

    /**
     * Performs the Upside-Down Flip of the squarelotron, as described above, and returns the new squarelotron.
     *
     * @param ring is a number to represent what square move.
     * @return a new Squarelotron.
     */
    public Squarelotron upsideDownFlip(final int ring) {
        Squarelotron flip = new Squarelotron(size);
        moveTopRowToBottomRow(ring, flip);
        moveLeftSideRightSide(ring, flip);
        return flip;
    }

    /**
     * Moves the top row to boton row.
     *
     * @param ring is a number to represent what square move.
     * @param flip is the new squareltron.
     */
    private void moveTopRowToBottomRow(final int ring, final Squarelotron flip) {
        for (int index = ring - 1; index <= size - ring; index++) {
            flip.squarelotron[ring - 1][index] = squarelotron[size - ring][index];
            flip.squarelotron[size - ring][index] = squarelotron[ring - 1][index];
        }
    }

    /**
     * Moves the left side and the right side.
     *
     * @param ring is a number to represent what square move.
     * @param flip is the new squareltron.
     */
    private void moveLeftSideRightSide(final int ring, final Squarelotron flip) {
        for (int index = ring; index < size / (ring + 1); index++) {
            //left side
            flip.squarelotron[index][ring - 1] = squarelotron[size - index - 1][ring - 1];
            flip.squarelotron[size - index - 1][ring - 1] = squarelotron[index][ring - 1];
            //right side
            flip.squarelotron[index][size - ring] = squarelotron[size - index - 1][size - ring];
            flip.squarelotron[size - index - 1][size - ring] = squarelotron[index][size - ring];
        }
    }

    /**
     * Performs the Main Diagonal Flip of the squarelotron.
     *
     * @param ring is a number to represent what square move.
     * @return the new squarelotron
     */
    public Squarelotron mainDiagonalFlip(int ring) {
        Squarelotron flipped = new Squarelotron(size);
        moveTopRowToSideColumn(ring, flipped);
        moveSideColumnToBottomRow(ring, flipped);
        return flipped;
    }

    /**
     * Moves the side column to bottom row.
     *
     * @param ring is a number to represent what square move.
     * @param flip is the new squareltron.
     */
    private void moveSideColumnToBottomRow(final int ring, final Squarelotron flip) {
        for (int i = ring; i <= size - ring - 1; i++) {
            flip.squarelotron[size - ring][i] = squarelotron[i][size - ring];
            flip.squarelotron[i][size - ring] = squarelotron[size - ring][i];
        }
    }

    /**
     * Moves the top row to side column.
     *
     * @param ring is a number to represent what square move.
     * @param flip is the new squareltron.
     */
    private void moveTopRowToSideColumn(final int ring, final Squarelotron flip) {
        for (int j = ring - 1; j <= size - ring; j++) {
            flip.squarelotron[ring - 1][j] = squarelotron[j][ring - 1];
            flip.squarelotron[j][ring - 1] = squarelotron[ring - 1][j];
        }
    }

    /**
     * Rotates the squarelotron to the right.
     *
     * @param numberOfTurns Integer that represent the moves number.
     */
    public void rotateRight(final int numberOfTurns) {
        int actualTurns = getActualTurns(numberOfTurns);

        while (actualTurns != 0) {
            // copy array
            int[][] copy = getCopySquarelotron();

            // update squarelotron
            for (int row = 0; row < size; row++) {
                updateSquarelotron(copy, row);
            }
            actualTurns--;
        }
    }

    /**
     * Gets a squarelotron copy.
     *
     * @return a squarelotron matrix copy.
     */
    private int[][] getCopySquarelotron() {
        int[][] copy = new int[size][size];
        for (int index = 0; index < size; index++) {
            System.arraycopy(squarelotron[index], 0, copy[index], 0, size);
        }
        return copy;
    }

    /**
     * Update the index row with respective values.
     *
     * @param copy squarelotron matrix copy
     * @param row  index row.
     */
    private void updateSquarelotron(final int[][] copy, final int row) {
        final int colZero = 0;
        final int colOne = 1;
        final int colTwo = 2;
        final int colThree = 3;
        final int colFour = 4;
        final int colFive = 5;
        final int colSix = 6;
        final int colSeven = 7;
        final int rowThree = 3;
        final int rowFour = 4;
        final int rowFive = 5;
        final int rowSix = 6;
        final int rowSeven = 7;
        int count = size - 1;
        for (int col = 0; col < size; col++) {
            switch (row) {
                case 0:
                    squarelotron[row][col] = copy[count][colZero];
                    count--;
                    break;
                case 1:
                    squarelotron[row][col] = copy[count][colOne];
                    count--;
                    break;
                case 2:
                    squarelotron[row][col] = copy[count][colTwo];
                    count--;
                    break;
                case rowThree:
                    squarelotron[row][col] = copy[count][colThree];
                    count--;
                    break;
                case rowFour:
                    squarelotron[row][col] = copy[count][colFour];
                    count--;
                    break;
                case rowFive:
                    squarelotron[row][col] = copy[count][colFive];
                    count--;
                    break;
                case rowSix:
                    squarelotron[row][col] = copy[count][colSix];
                    count--;
                    break;
                case rowSeven:
                    squarelotron[row][col] = copy[count][colSeven];
                    count--;
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        }
    }

    /**
     * Gets the actual turns.
     *
     * @param numberOfTurns Integer that represent the moves number.
     * @return the necessary turns.
     */
    private int getActualTurns(int numberOfTurns) {
        final int squareSize = 4;
        return numberOfTurns > 0 ? numberOfTurns % squareSize : squareSize - ((numberOfTurns % squareSize) * (-1));
    }

    /**
     * Gets the squarelotron size.
     *
     * @return the squarelotron size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets the squarelotron data.
     *
     * @return a sqarelotron matrix.
     */
    public int[][] getSquarelotron() {
        final int[][] squarelotronCopy = squarelotron;
        return squarelotronCopy;
    }
}
