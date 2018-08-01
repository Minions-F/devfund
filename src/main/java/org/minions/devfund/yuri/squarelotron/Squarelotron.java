package org.minions.devfund.yuri.squarelotron;

/**
 * Represents the matrix with all functionality.
 */
public class Squarelotron {
  public static final int COMPLETE_TURN = 4;
  private int[][] matrix;
  private int size;

  /**
   * Constructor Method.
   *
   * @param size matrix size.
   */
  public Squarelotron(final int size) {
    matrix = new int[size][size];
    this.size = size;
    fillSquarelotron(matrix);
  }

  /**
   * Gets the matrix matrix.
   *
   * @return matrix matrix.
   */
  public int[][] getMatrix() {
    return matrix.clone();
  }
  /**
   * Fills a matrix with values.
   * @param matrix the matrix to be populated.
   */
  public void fillSquarelotron(final int[][] matrix) {
    int accumalator = 1;
    for (int row = 0; row < size; row++) {
      for (int column = 0; column < size; column++) {
        matrix[row][column] = accumalator++;
      }
    }
  }
  /**
   * Gets an specific ring of a matrix.
   *
   * @param ringNumber the ring number.
   * @return an array that contains the elements of the ring.
   */
  public int[][] maskedSpecificRing(final int ringNumber) {
    int[][] squarelotronMasked = new int[size][size];
    fillSquarelotron(squarelotronMasked);
    for (int i = ringNumber - 1; i <= size - ringNumber; i++) {
      squarelotronMasked[i][ringNumber - 1] = 0;
      squarelotronMasked[ringNumber - 1][i] = 0;
      squarelotronMasked[size - ringNumber][i] = 0;
      squarelotronMasked[i][size - ringNumber] = 0;
    }
    return squarelotronMasked;
  }
  /**
   * Exchanges the rows of a matrix.
   *
   * @param matrix matrix to be exchanged.
   * @return matrix with exchanged rows.
   */
  public int[][] exchangeRows(final int[][] matrix) {
    int[][] exchanged = new int[size][size];
    for (int row = 0; row <= size / 2; row++) {
      exchanged[row] = matrix[size - 1 - row];
      exchanged[size - 1 - row] = matrix[row];
    }
    return exchanged;
  }

  /**
   * Performs the upsideDownFlip operation.
   * @param ring the ring number.
   * @return a new matrix.
   */
  public Squarelotron upsideDownFlip(final int ring) {
    Squarelotron newSquarelotron = new Squarelotron(size);
    int[][] exchangedMatrix = newSquarelotron.exchangeRows(this.matrix);
    int[][] maskedMatrix = newSquarelotron.maskedSpecificRing(ring);
    newSquarelotron.setMatrix(replaceValuesInMatrix(maskedMatrix, exchangedMatrix));
    return newSquarelotron;
  }
  /**
   * Transposes a matrix using the main diagonal.
   *
   * @param matrix matrix to be transposed.
   * @return transposed matrix.
   */
  public int[][] diagonalChangeMatrix(final int[][] matrix) {
    int[][] diagonalChanged = new int[size][size];
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        diagonalChanged[row][col] = matrix[col][row];
      }
    }
    return diagonalChanged;
  }
  /**
   * Performs the Up Main Diagonal Flip operation.
   *
   * @param ring matrix ring value.
   * @return {@link Squarelotron}.
   */
  public Squarelotron mainDiagonalFlip(final int ring) {
    Squarelotron newSquarelotron = new Squarelotron(size);
    int[][] diagonalMatrix = newSquarelotron.diagonalChangeMatrix(this.matrix);
    int[][] maskedMatrix = newSquarelotron.maskedSpecificRing(ring);
    newSquarelotron.setMatrix(replaceValuesInMatrix(maskedMatrix, diagonalMatrix));
    return newSquarelotron;
  }

  /**
   * Replaces values on masked matrix.
   * @param maskedMatrix the matrix with ring values.
   * @param matrix the matrix with elements changed according operations.
   * @return matrix.
   */
  public int[][] replaceValuesInMatrix(final int[][] maskedMatrix, final int[][] matrix) {
    for (int row = 0; row < size; row++) {
      for (int column = 0; column < size; column++) {
        if (maskedMatrix[row][column] == 0) {
          maskedMatrix[row][column] = matrix[row][column];
        }
      }
    }
    return maskedMatrix;
  }

  /**
   * Rotates the square matrix elements 90 degrees according the number of turns.
   *
   * @param numberOfTurns number of turns value.
   */
  public void rotateRight(final int numberOfTurns) {
    int totalTurns = numberOfTurns % COMPLETE_TURN;
    if (totalTurns >= 0) {
      rotateClockWise(totalTurns);
      return;
    }
    rotateCounterClockWise(totalTurns);
  }
  /**
   * Rotates the matrix 90 degrees clockwise direction.
   *
   * @param numberOfTurns number of turns value.
   */
  public void rotateClockWise(final int numberOfTurns) {
    int turns = numberOfTurns;
    while (turns-- > 0) {
      this.matrix = exchangeRows(this.matrix);
      this.matrix = diagonalChangeMatrix(this.matrix);
    }
  }

  /**
   * Rotates the matrix 90 degrees in the counterclockwise direction.
   *
   * @param numberOfTurns number of turns value.
   */
  public  void rotateCounterClockWise(final int numberOfTurns) {
    int attempts = numberOfTurns;
    while (attempts++ < 0) {
      this.matrix = diagonalChangeMatrix(this.matrix);
      this.matrix = exchangeRows(this.matrix);
    }
  }
  /**
   * Sets the matrix matrix.
   *
   * @param matrix the integer matrix.
   */
  public void setMatrix(final int[][] matrix) {
    this.matrix = matrix.clone();
  }
}
