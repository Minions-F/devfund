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
   * Gets the center information for a matrix.
   *
   * @return <code>true</code> if the matrix has center element;
   * <code>false</code> if it is not.
   */
  public boolean hasCenterElement() {
    return size % 2 == 1;
  }

  /**
   * Gets an specific ring of a matrix.
   * @param ringNumber the ring number.
   * @return an array that contains the elements of the ring.
   */
  public int[] getRing(final int ringNumber) {
    return new int[]{};
  }
}
