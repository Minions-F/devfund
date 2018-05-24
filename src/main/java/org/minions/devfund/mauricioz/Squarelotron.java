package org.minions.devfund.mauricioz;
/**
 * Squareotron class.
 */
public class Squarelotron {

    private int[][] twoDimentionalSquarelotron;
    private int size;

    /**
     * It fills the 2-dimensional array with the numbers 1 to n squared, in order.
     * It also sets the size instance variable to be n.
     * @param n The size for the matrix
     */
    public Squarelotron(int n) {
        this.size = n;
        twoDimentionalSquarelotron = new int[this.size][this.size];
        initializeSquarelotron();
    }

    /**
     * Populate twoDimentionalSquarelotron with initial values.
     */
    private void initializeSquarelotron() {
        int n = 1;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                twoDimentionalSquarelotron[x][y] = n++;
            }
        }
    }

    /**
     * Upside-Down Flip of the twoDimentionalSquarelotron,
     * and returns the new twoDimentionalSquarelotron. The original twoDimentionalSquarelotron should not be modified.
     * @param ring the ring that will be flipped.
     * @return A upside-down flipped squrelotron on a new instance.
     */
    public Squarelotron upsideDownFlip(int ring) {
        Squarelotron flippedSquarelotron = new Squarelotron(size);
        if (ring > 0 && ring <= size / 2) {
            for (int fil = 0; fil < size; fil++) {
                for (int col = 0; col < size; col++) {
                    if (isPositionInRing(ring, fil, col)) {
                        flippedSquarelotron.twoDimentionalSquarelotron[fil][col] =
                                this.twoDimentionalSquarelotron[size - 1 - fil][col];
                    }
                }
            }
        }
        return flippedSquarelotron;
    }

    /**
     * This method will verify that given value on given position doesn't belong to the ring.
     * @param ring the ring we are looking in the matrix.
     * @param x position x in the matrix.
     * @param y position y in the matrix.
     * @return true if the position belong to the ring and false otherwise.
     */
    private boolean isPositionInRing(int ring, int x, int y) {
        return x == ring - 1 || y == ring - 1 || x == size - ring || y == size - ring;
    }

    /**
     * This method performs the Main Diagonal Flip of the twoDimentionalSquarelotron into a
     * new instance of Squarelotron.
     * @param ring the ring that will be flipped.
     * @return A modified instance of a new Squarelotron.
     */
    public Squarelotron mainDiagonalFlip(int ring) {
        Squarelotron squarelotronResultant = new Squarelotron(size);

        if (ring > 0 && ring <= size / 2) {
            for (int i = ring - 1; i <= size - ring; i++) {
                for (int j = ring - 1; j <= size - ring; j++) {
                    if (isPositionInRing(ring, i, j)) {
                        squarelotronResultant.twoDimentionalSquarelotron[i][j] = this.twoDimentionalSquarelotron[j][i];
                    }
                }
            }
        }
        return squarelotronResultant;
    }

    /**
     * The argument numberOfTurns indicates the number of times the entire twoDimentionalSquarelotron
     * should be rotated 90° clockwise.
     * Any integer, including zero and negative integers, is allowable as the argument.
     * A value of -1 indicates a 90° counterclockwise rotation.
     * This method modifies the internal representation of the twoDimentionalSquarelotron; it does not create a new
     * twoDimentionalSquarelotron.
     * @param numberOfTurns the amount of times that will be rotated.
     */
    public void rotateRight(int numberOfTurns) {

        if (numberOfTurns >= 0) {
            rotateClockWise(numberOfTurns);
        } else {
            rotateCounterClockWise(numberOfTurns);
        }
    }

    /**
     * This method will rotate the matrix to the right.
     * @param numberOfTurns the amount of times that will be rotated to the right.
     */
    private void rotateClockWise(int numberOfTurns) {

        int length = this.size - 1;
        while (numberOfTurns > 0) {
            for (int i = 0; i <= (length) / 2; i++) {
                for (int j = i; j < length - i; j++) {

                    int temp = this.twoDimentionalSquarelotron[i][j];

                    this.twoDimentionalSquarelotron[i][j] = this.twoDimentionalSquarelotron[length - j][i];
                    this.twoDimentionalSquarelotron[length - j][i] =
                            this.twoDimentionalSquarelotron[length - i][length - j];
                    this.twoDimentionalSquarelotron[length - i][length - j] =
                            this.twoDimentionalSquarelotron[j][length - i];
                    this.twoDimentionalSquarelotron[j][length - i] = temp;
                }
            }
            numberOfTurns--;
        }
    }

    /**
     * This method will rotate the twoDimentionalSquarelotron to the left.
     * @param numberOfTurns the amount of times that twoDimentionalSquarelotron will be rotated to the left.
     */
    private void rotateCounterClockWise(int numberOfTurns) {

        int length = this.size - 1;
        while (numberOfTurns < 0) {
            for (int i = 0; i <= (length) / 2; i++) {
                for (int j = i; j < length - i; j++) {

                    int temp = this.twoDimentionalSquarelotron[i][j];

                    this.twoDimentionalSquarelotron[i][j] = this.twoDimentionalSquarelotron[j][length - i];
                    this.twoDimentionalSquarelotron[j][length - i] =
                            this.twoDimentionalSquarelotron[length - i][length - j];
                    this.twoDimentionalSquarelotron[length - i][length - j] =
                            this.twoDimentionalSquarelotron[length - j][i];
                    this.twoDimentionalSquarelotron[length - j][i] = temp;
                }
            }
            numberOfTurns++;
        }
    }

    /**
     * This method return the twoDimentionalSquarelotron matrix.
     * @return a bi dimensional array.
     */
    public int[][] getTwoDimentionalSquarelotron() {
        return this.twoDimentionalSquarelotron.clone();
    }
}
