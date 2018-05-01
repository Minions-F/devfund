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
   * Gets the matrix with all values.
   *
   * @return matrix.
   */
  public String showMatrix() {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        builder.append(squarelotron[i][j] + " ");
      }
      builder.append("\n");
    }
    return builder.toString();
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
    for (int row = 0; row < size; row++) {
      for (int column = 0; column < size; column++) {
        if (maskedMatrix[row][column] == 0) {
          maskedMatrix[row][column] = exchangedMatrix[row][column];
        }
      }
    }
    newSquarelotron.setSquarelotron(maskedMatrix);
    return newSquarelotron;
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
