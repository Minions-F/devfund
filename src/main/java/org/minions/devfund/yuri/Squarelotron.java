package org.minions.devfund.yuri;

/**
 * Represents the squarelotron with all functionality.
 */
public class Squarelotron {
  private int[][] squarelotron;
  private int size;

  /**
   * Constructor Method.
   *
   * @param size matrix size.
   */
  public Squarelotron(final int size) {
    squarelotron = new int[size][size];
    this.size = size;
    fillSquarelotron();
  }

  /**
   * Gets the squarelotron matrix.
   *
   * @return squarelotron matrix.
   */
  public int[][] getSquarelotron() {
    return squarelotron.clone();
  }

  /**
   * Gets the squarelotron size.
   *
   * @return size.
   */
  public int getSize() {
    return size;
  }

  /**
   * Fills the squarelotron elements.
   */
  public void fillSquarelotron() {
    int accumalator = 1;
    for (int row = 0; row < size; row++) {
      for (int column = 0; column < size; column++) {
        squarelotron[row][column] = accumalator++;
      }
    }
  }

  /**
   * Gets the rings amount of a matrix.
   *
   * @return the rings amount;
   */
  public int getRingsAmount() {
    return size / 2;
  }
  /**
   * Gets an specific ring of a matrix.
   *
   * @param ringNumber the ring number.
   * @return an array that contains the elements of the ring.
   */
  public int[][] maskedSpecificRing(final int ringNumber) {
    int[][] squarelotronMasked = new Squarelotron(size).getSquarelotron();
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
   * @return a new squarelotron.
   */
  public Squarelotron upsideDownFlip(final int ring) {
    Squarelotron newSquarelotron = new Squarelotron(size);
    int[][] exchangedMatrix = newSquarelotron.exchangeRows(newSquarelotron.getSquarelotron());
    int[][] maskedMatrix = newSquarelotron.maskedSpecificRing(ring);
    newSquarelotron.setSquarelotron(replaceValuesInMatrix(maskedMatrix, exchangedMatrix));
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
    int[][] diagonalMatrix = newSquarelotron.diagonalChangeMatrix(newSquarelotron.getSquarelotron());
    int[][] maskedMatrix = newSquarelotron.maskedSpecificRing(ring);
    newSquarelotron.setSquarelotron(replaceValuesInMatrix(maskedMatrix, diagonalMatrix));
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
   * Rotates the matrix 90 degrees clockwise direction.
   *
   * @param numberOfTurns number of turns value.
   */
  public void rotateClockWise(final int numberOfTurns) {
    int turns = numberOfTurns;
    while (turns-- > 0) {
      this.squarelotron = exchangeRows(this.squarelotron);
      this.squarelotron = diagonalChangeMatrix(this.squarelotron);
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
      this.squarelotron = diagonalChangeMatrix(this.squarelotron);
      this.squarelotron = exchangeRows(this.squarelotron);
    }
  }
  /**
   * Sets the squarelotron matrix.
   *
   * @param matrix the integer matrix.
   */
  public void setSquarelotron(final int[][] matrix) {
    squarelotron = matrix.clone();
  }
}
