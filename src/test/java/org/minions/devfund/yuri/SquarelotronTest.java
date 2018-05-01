package org.minions.devfund.yuri;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


/**
 * Class in charge to test the functionality of squarelotron.
 */
public class SquarelotronTest {

  /**
   * Verifies that the squarelotron matrix was filled correctly.
   */
  @Test
  public void testTheElementsOfSquarelotron() {
    final int size = 4;
    final int[][] expectedResult = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    Squarelotron squarelotron = new Squarelotron(size);
    int[][] actualResult = squarelotron.getSquarelotron();
    assertArrayEquals(expectedResult, actualResult);
  }

  /**
   * Verifies squarelotron size configured is correct.
   */
  @Test
  public void testSquarelotronSize() {
    final int expectedResult = 5;
    Squarelotron squarelotron = new Squarelotron(expectedResult);
    final int actualResult = squarelotron.getSize();
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Verifies the rings amount for a matrix size two.
   */
  @Test
  public void testGetRingsFromMatrixSizeTwo() {
    final int expectedResult = 1;
    final int size = 2;
    Squarelotron squarelotron = new Squarelotron(size);
    final int actualResult = squarelotron.getRingsAmount();
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Verifies the rings amount for a matrix size two.
   */
  @Test
  public void testGetRingsFromMatrixSizeSeven() {
    final int expectedResult = 3;
    final int size = 7;
    Squarelotron squarelotron = new Squarelotron(size);
    final int actualResult = squarelotron.getRingsAmount();
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Verifies that the values of First Ring is correct from a Matrix size four.
   */
  @Test
  public void testSwapRowsMatrixSize4() {
    final int size = 4;
    final int[][] expectedResult = new int[][] {{13, 14, 15, 16}, {9, 10, 11, 12}, {5, 6, 7, 8}, {1, 2, 3, 4}};
    Squarelotron squarelotron = new Squarelotron(size);
    int[][] actualResult = squarelotron.exchangeRows(squarelotron.getSquarelotron());
    assertArrayEquals(expectedResult, actualResult);
  }

  /**
   * Verifies the upsidedown method with a matrix size 5.
   */
  @Test
  public void testUpSideDownMatrixSize5Ring1() {
    final int size = 5;
    final int[][] expectedResult = new int[][] {{21, 22, 23, 24, 25}, {16, 7, 8, 9, 20},
        {11, 12, 13, 14, 15}, {6, 17, 18, 19, 10}, {1, 2, 3, 4, 5}};
    Squarelotron squarelotron = new Squarelotron(size);
    Squarelotron newSquarelotron = squarelotron.upsideDownFlip(1);
    int[][] actualResult = newSquarelotron.getSquarelotron();
    assertArrayEquals(expectedResult, actualResult);
  }

  /**
   * Verifies the upsidedown method with a matrix size 4.
   */
  @Test
  public void testUpSideDownMatrixSize4Ring1() {
    final int size = 4;
    final int[][] expectedResult = new int[][] {{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
    Squarelotron squarelotron = new Squarelotron(size);
    Squarelotron actualResult = squarelotron.upsideDownFlip(1);
    assertArrayEquals(expectedResult, actualResult.getSquarelotron());
  }

  /**
   * Verifies the upsidedown method with a matrix size 4 and ring 2.
   */
  @Test
  public void testUpSideDownMatrixSize4Ring2() {
    final int size = 4;
    final int[][] expectedResult = new int[][] {{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
    Squarelotron squarelotron = new Squarelotron(size);
    Squarelotron actualResult = squarelotron.upsideDownFlip(2);
    assertArrayEquals(expectedResult, actualResult.getSquarelotron());
  }

  /**
   * Main Diagonal Flip Test using Squarelotron with size 4 ring 1.
   */
  @Test
  public void testMainDiagonalFlipTestSize4Ring1() {
    final int ring = 1;
    final int size = 4;
    final Squarelotron squarelotron = new Squarelotron(size);
    final int[][] expectedResult = new int[][]{{1, 5, 9, 13}, {2, 6, 7, 14}, {3, 10, 11, 15}, {4, 8, 12, 16}};
    Squarelotron result = squarelotron.mainDiagonalFlip(ring);
    assertArrayEquals(expectedResult, result.getSquarelotron());
  }

  /**
   * Main Diagonal Flip Test using Squarelotron with size 4 ring 2.
   */
  @Test
  public void testMainDiagonalFlipTestSize4Ring2() {
    final int ring = 2;
    final int dimension = 4;
    final Squarelotron squarelotron = new Squarelotron(dimension);
    final int[][] expectedResult = new int[][]{{1, 2, 3, 4}, {5, 6, 10, 8}, {9, 7, 11, 12}, {13, 14, 15, 16}};
    Squarelotron result = squarelotron.mainDiagonalFlip(ring);
    assertArrayEquals(expectedResult, result.getSquarelotron());
  }
}
