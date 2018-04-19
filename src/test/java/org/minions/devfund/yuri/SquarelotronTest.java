package org.minions.devfund.yuri;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Class in charge to test the functionality of squarelotron.
 */
public class SquarelotronTest {

    public static final int THIRD = 3;
    public static final int SECOND = 2;
    public static final int FIRST = 1;
    public static final int CERO = 0;

    /**
     * Verifies that the squarelotron matrix was filled correctly.
     */
    @Test
    public void verifyTheLastElementOfSquarelotronIsCorrect() {
        final int size = 4;
        int[][] expectedResult = new int[size][size];
        final int[] firstRow = {1, 2, 3, 4};
        final int[] secondRow = {5, 6, 7, 8};
        final int[] thirdRow = {9, 10, 11, 12};
        final int[] fourthRow = {13, 14, 15, 16};
        expectedResult[CERO] = firstRow;
        expectedResult[FIRST] = secondRow;
        expectedResult[SECOND] = thirdRow;
        expectedResult[THIRD] = fourthRow;
        Squarelotron squarelotron = new Squarelotron(size);
        int[][] actualResult = squarelotron.getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Verifies squarelotron size configured is correct.
     */
    @Test
    public void verifySquarelotronSizeIsCorrect() {
        final int expectedResult = 5;
        Squarelotron squarelotron = new Squarelotron(expectedResult);
        final int actualResult = squarelotron.getSize();
        assertEquals(expectedResult, actualResult);
    }
}
