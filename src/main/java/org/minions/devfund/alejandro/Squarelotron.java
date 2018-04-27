package org.minions.devfund.alejandro;

/**
 * Squareotron class.
 */
public class Squarelotron {

    private int[][] squarelotronMatrix;
    private int size;

    /**
     * It fills the 2-dimensional array with the numbers 1 to n squared, in order.
     * It also sets the size instance variable to be n.
     * @param n The size for the matrix
     */
    public Squarelotron(int n) {
        this.size = n;
        n = 1;
        squarelotronMatrix = new int[this.size][this.size];
        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                squarelotronMatrix[x][y] = n++;
            }
        }
    }

    /**
     * This method performs the Upside-Down Flip of the squarelotronMatrix,
     * and returns the new squarelotronMatrix. The original squarelotronMatrix should not be modified.
     * @param ring the ring that will be flipped.
     * @return A modified instance of a new Squarelotron.
     */
    public Squarelotron upsideDownFlip(int ring) {
        Squarelotron resultSquare = new Squarelotron(this.size);
        if (ring > 0 && ring <= this.size / 2) {
            resultSquare.squarelotronMatrix = flipSquarelotron(ring, resultSquare.getSquarelotronMatrix());
        }
        return resultSquare;
    }

    /**
     * This method will flip a matrix in a determined ring.
     * @param ring the ring that will be flipped in the square.
     * @param squarelotronMatrix is the matrix that will be flipped.
     * @return the flipped matrix.
     */
    private int[][] flipSquarelotron(int ring, final int[][] squarelotronMatrix) {
        int[][] swappedMatrix = swapMatrix(this.squarelotronMatrix);
        for (int i = ring - 1; i <= this.size - ring; i++) {
            for (int j = ring - 1; j <= this.size - ring; j++) {
                if (isPositionInRing(ring, i, j)) {
                    squarelotronMatrix[i][j] = swappedMatrix[i][j];
                }
            }
        }
        return squarelotronMatrix;
    }

    /**
     * This method will swap a matrix.
     * @param matrix The matrix that will be swapped.
     * @return the same matrix but swapped.
     */
    private int[][] swapMatrix(final int[][] matrix) {
        int controlSize = this.size - 1;
        for (int i = 0; i < this.size / 2; i++) {
            int[] rowUpside = matrix[i];
            int[] rowDown = matrix[controlSize];
            matrix[i] = rowDown;
            matrix[controlSize] = rowUpside;
            controlSize--;
        }
        return matrix;
    }

    /**
     * This method will verify that the position does not belong to ring's position.
     * @param ring the ring we are looking in the matrix.
     * @param i position x in the matrix.
     * @param j position y in the matrix.
     * @return true if the position belong to the ring and false otherwise.
     */
    private boolean isPositionInRing(int ring, int i, int j) {
        return i == ring - 1 || j == ring - 1 || i == this.size - ring || j == this.size - ring;
    }

    /**
     * This method performs the Main Diagonal Flip of the squarelotronMatrix,
     * and returns the new squarelotronMatrix. The original squarelotronMatrix should not be modified.
     * @param ring the ring that will be flipped.
     * @return A modified instance of a new Squarelotron.
     */
    public Squarelotron mainDiagonalFlip(int ring) {
        Squarelotron resultSquare = new Squarelotron(this.size);

        if (ring > 0 && ring <= this.size / 2) {
            for (int i = ring - 1; i <= this.size - ring; i++) {
                for (int j = ring - 1; j <= this.size - ring; j++) {
                    if (isPositionInRing(ring, i, j)) {
                        resultSquare.squarelotronMatrix[i][j] = this.squarelotronMatrix[j][i];
                    }
                }
            }
        }
        return resultSquare;
    }

    /**
     * The argument numberOfTurns indicates the number of times the entire squarelotronMatrix should be rotated 90°
     * clockwise.
     * Any integer, including zero and negative integers, is allowable as the argument.
     * A value of -1 indicates a 90° counterclockwise rotation.
     * This method modifies the internal representation of the squarelotronMatrix; it does not create a new
     * squarelotronMatrix.
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
     * @param numberOfTurns the amount of times that will be rotated.
     */
    private void rotateClockWise(int numberOfTurns) {

        int length = this.size - 1;
        while (numberOfTurns > 0) {
            for (int i = 0; i <= (length) / 2; i++) {
                for (int j = i; j < length - i; j++) {

                    int temp = this.squarelotronMatrix[i][j];

                    this.squarelotronMatrix[i][j] = this.squarelotronMatrix[length - j][i];
                    this.squarelotronMatrix[length - j][i] = this.squarelotronMatrix[length - i][length - j];
                    this.squarelotronMatrix[length - i][length - j] = this.squarelotronMatrix[j][length - i];
                    this.squarelotronMatrix[j][length - i] = temp;
                }
            }
            numberOfTurns--;
        }
    }

    /**
     * This method will rotate the matrix to the left.
     * @param numberOfTurns the amount of times that will be rotated.
     */
    private void rotateCounterClockWise(int numberOfTurns) {

        int length = this.size - 1;
        while (numberOfTurns < 0) {
            for (int i = 0; i <= (length) / 2; i++) {
                for (int j = i; j < length - i; j++) {

                    int temp = this.squarelotronMatrix[i][j];

                    this.squarelotronMatrix[i][j] = this.squarelotronMatrix[j][length - i];
                    this.squarelotronMatrix[j][length - i] = this.squarelotronMatrix[length - i][length - j];
                    this.squarelotronMatrix[length - i][length - j] = this.squarelotronMatrix[length - j][i];
                    this.squarelotronMatrix[length - j][i] = temp;
                }
            }
            numberOfTurns++;
        }
    }

    /**
     * This method return the squarelotronMatrix matrix.
     * @return a bi dimensional array.
     */
    public int[][] getSquarelotronMatrix() {
        return this.squarelotronMatrix.clone();
    }
}
