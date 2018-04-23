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
    public void verifyTheLastElementOfSquarelotronIsCorrect() {
        final int size = 4;
        final int[][] expectedResult = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
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
