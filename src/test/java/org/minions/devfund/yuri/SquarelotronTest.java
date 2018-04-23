package org.minions.devfund.yuri;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


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
   * Verifies that the matrix size 3 has a center element.
   */
  @Test
  public void testMatrixSizeTreeHasCenterElement() {
    final int size = 3;
    Squarelotron squarelotron = new Squarelotron(size);
    assertTrue(squarelotron.hasCenterElement());
  }

  /**
   * Verifies that the matrix size 3 has a center element.
   */
  @Test
  public void testMatrixSizeFourHasCenterElement() {
    final int size = 4;
    Squarelotron squarelotron = new Squarelotron(size);
    assertFalse(squarelotron.hasCenterElement());
  }

  /**
   * Verifies that the values of First Ring is correct from a Matrix size four.
   */
  @Test
  public void testGetRingOneOfMatrixSize4() {
    final int size = 4;
    final int ringNumber = 1;
    final int[] expectedResult = new int[] {1, 2, 3, 4, 5, 8, 12, 16, 15, 14, 13, 9, 5};
    Squarelotron squarelotron = new Squarelotron(size);
    int[] actualResult = squarelotron.getRing(ringNumber);
    assertArrayEquals(expectedResult, actualResult);
  }
}
