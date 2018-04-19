package org.minions.devfund.angela;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Test for {@link Squarelotron} .
 */
public class SquarelotronTest {

    private Squarelotron squarelotron;

    /**
     * Enumerable for numbers.
     */
    public enum Numbers {
        ONE(1),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        ELEVEN(11),
        TWELVE(12),
        THIRTEEN(13),
        FOURTEEN(14),
        FIFTEEN(15),
        SIXTEEN(16);

        private int number;

        /**
         * Constructor for enum.
         *
         * @param value int numeral.
         */
        Numbers(final int value) {
            number = value;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return String.valueOf(number);
        }

        /**
         * Gets the number.
         *
         * @return int number value.
         */
        public int getNumber() {
            return number;
        }
    }

    /**
     * Preconditions.
     */
    @Before
    public void setup() {
        int size = Numbers.FOUR.getNumber();
        squarelotron = new Squarelotron(size);
    }

    /**
     * Test if Upside Down Flip is working.
     */
    @Test
    public void testUpsideDownFlip() {
        final Squarelotron squareResult = squarelotron.upsideDownFlip(2);
        assertEquals(Numbers.TEN.getNumber(), squareResult.getSquarematrix()[1][1]);
        assertEquals(Numbers.ELEVEN.getNumber(), squareResult.getSquarematrix()[1][2]);
        assertEquals(Numbers.SIX.getNumber(), squareResult.getSquarematrix()[2][1]);
        assertEquals(Numbers.SEVEN.getNumber(), squareResult.getSquarematrix()[2][2]);
    }

    /**
     * Test if Main Diagonal Flip is working.
     */
    @Test
    public void testMainDiagonalFlip() {
        final Squarelotron squareResult = squarelotron.mainDiagonalFlip(2);
        assertEquals(Numbers.SIX.getNumber(), squareResult.getSquarematrix()[1][1]);
        assertEquals(Numbers.TEN.getNumber(), squareResult.getSquarematrix()[1][2]);
        assertEquals(Numbers.SEVEN.getNumber(), squareResult.getSquarematrix()[2][1]);
        assertEquals(Numbers.ELEVEN.getNumber(), squareResult.getSquarematrix()[2][2]);

    }

    /**
     * Tests to rotate the matrix right.
     */
    @Test
    public void rotateRight() {
        squarelotron.rotateRight(Numbers.ONE.getNumber());
        int[] array1 = {Numbers.THIRTEEN.getNumber(), Numbers.NINE.getNumber(), Numbers.FIVE.getNumber(),
                Numbers.ONE.getNumber()};
        int[] array2 = {Numbers.FOURTEEN.getNumber(), Numbers.TEN.getNumber(), Numbers.SIX.getNumber(),
                Numbers.TWO.getNumber()};
        int[] array3 = {Numbers.FIFTEEN.getNumber(), Numbers.ELEVEN.getNumber(), Numbers.SEVEN.getNumber(),
                Numbers.THREE.getNumber()};
        int[] array4 = {Numbers.SIXTEEN.getNumber(), Numbers.TWELVE.getNumber(), Numbers.EIGHT.getNumber(),
                Numbers.FOUR.getNumber()};

        assertArrayEquals(array1, squarelotron.getSquarematrix()[0]);
        assertArrayEquals(array2, squarelotron.getSquarematrix()[1]);
        assertArrayEquals(array3, squarelotron.getSquarematrix()[2]);
        assertArrayEquals(array4, squarelotron.getSquarematrix()[Numbers.THREE.getNumber()]);
    }

    /**
     * Tests to rotate the matrix left.
     */
    @Test
    public void rotateLeft() {
        final int numberOfTurns = -1;
        squarelotron.rotateRight(numberOfTurns);
        int[] array1 = {Numbers.FOUR.getNumber(), Numbers.EIGHT.getNumber(), Numbers.TWELVE.getNumber(),
                Numbers.SIXTEEN.getNumber()};
        int[] array2 = {Numbers.THREE.getNumber(), Numbers.SEVEN.getNumber(), Numbers.ELEVEN.getNumber(),
                Numbers.FIFTEEN.getNumber()};
        int[] array3 = {Numbers.TWO.getNumber(), Numbers.SIX.getNumber(),  Numbers.TEN.getNumber(),
                Numbers.FOURTEEN.getNumber()};
        int[] array4 = {Numbers.ONE.getNumber(), Numbers.FIVE.getNumber(), Numbers.NINE.getNumber(),
                Numbers.THIRTEEN.getNumber()};

        assertArrayEquals(array1, squarelotron.getSquarematrix()[0]);
        assertArrayEquals(array2, squarelotron.getSquarematrix()[1]);
        assertArrayEquals(array3, squarelotron.getSquarematrix()[2]);
        assertArrayEquals(array4, squarelotron.getSquarematrix()[Numbers.THREE.getNumber()]);
    }

    /**
     * Tests to rotate the matrix left twice.
     */
    @Test
    public void rotateTwiceLeft() {
        final int numberOfTurns = -2;
        squarelotron.rotateRight(numberOfTurns);
        int[] array1 = {Numbers.SIXTEEN.getNumber(), Numbers.FIFTEEN.getNumber(), Numbers.FOURTEEN.getNumber(),
                Numbers.THIRTEEN.getNumber()};
        int[] array2 = {Numbers.TWELVE.getNumber(), Numbers.ELEVEN.getNumber(), Numbers.TEN.getNumber(),
                Numbers.NINE.getNumber()};
        int[] array3 = {Numbers.EIGHT.getNumber(), Numbers.SEVEN.getNumber(), Numbers.SIX.getNumber(),
                Numbers.FIVE.getNumber()};
        int[] array4 = {Numbers.FOUR.getNumber(), Numbers.THREE.getNumber(), Numbers.TWO.getNumber(),
                Numbers.ONE.getNumber()};

        assertArrayEquals(array1, squarelotron.getSquarematrix()[0]);
        assertArrayEquals(array2, squarelotron.getSquarematrix()[1]);
        assertArrayEquals(array3, squarelotron.getSquarematrix()[2]);
        assertArrayEquals(array4, squarelotron.getSquarematrix()[Numbers.THREE.getNumber()]);
    }

    /**
     * Tests to rotate the matrix left three times.
     */
    @Test
    public void rotateThreeTimesLeft() {
        final int numberOfTurns = -3;
        squarelotron.rotateRight(numberOfTurns);
        int[] array1 = {Numbers.THIRTEEN.getNumber(), Numbers.NINE.getNumber(), Numbers.FIVE.getNumber(),
                Numbers.ONE.getNumber()};
        int[] array2 = {Numbers.FOURTEEN.getNumber(), Numbers.TEN.getNumber(), Numbers.SIX.getNumber(),
                Numbers.TWO.getNumber()};
        int[] array3 = {Numbers.FIFTEEN.getNumber(), Numbers.ELEVEN.getNumber(), Numbers.SEVEN.getNumber(),
                Numbers.THREE.getNumber()};
        int[] array4 = {Numbers.SIXTEEN.getNumber(), Numbers.TWELVE.getNumber(), Numbers.EIGHT.getNumber(),
                Numbers.FOUR.getNumber()};

        assertArrayEquals(array1, squarelotron.getSquarematrix()[0]);
        assertArrayEquals(array2, squarelotron.getSquarematrix()[1]);
        assertArrayEquals(array3, squarelotron.getSquarematrix()[2]);
        assertArrayEquals(array4, squarelotron.getSquarematrix()[Numbers.THREE.getNumber()]);
    }

    /**
     * Tests to rotate the matrix twice.
     */
    @Test
    public void rotateRightTwice() {
        squarelotron.rotateRight(Numbers.TWO.getNumber());
        int[] array1 = {Numbers.SIXTEEN.getNumber(), Numbers.FIFTEEN.getNumber(), Numbers.FOURTEEN.getNumber(),
                Numbers.THIRTEEN.getNumber()};
        int[] array2 = {Numbers.TWELVE.getNumber(), Numbers.ELEVEN.getNumber(), Numbers.TEN.getNumber(),
                Numbers.NINE.getNumber()};
        int[] array3 = {Numbers.EIGHT.getNumber(), Numbers.SEVEN.getNumber(), Numbers.SIX.getNumber(),
                Numbers.FIVE.getNumber()};
        int[] array4 = {Numbers.FOUR.getNumber(), Numbers.THREE.getNumber(), Numbers.TWO.getNumber(),
                Numbers.ONE.getNumber()};

        assertArrayEquals(array1, squarelotron.getSquarematrix()[0]);
        assertArrayEquals(array2, squarelotron.getSquarematrix()[1]);
        assertArrayEquals(array3, squarelotron.getSquarematrix()[2]);
        assertArrayEquals(array4, squarelotron.getSquarematrix()[Numbers.THREE.getNumber()]);
    }

    /**
     * Tests to rotate the matrix three times.
     */
    @Test
    public void rotateRightThreeTimes() {
        squarelotron.rotateRight(Numbers.THREE.getNumber());
        int[] array1 = {Numbers.FOUR.getNumber(), Numbers.EIGHT.getNumber(), Numbers.TWELVE.getNumber(),
                Numbers.SIXTEEN.getNumber()};
        int[] array2 = {Numbers.THREE.getNumber(), Numbers.SEVEN.getNumber(), Numbers.ELEVEN.getNumber(),
                Numbers.FIFTEEN.getNumber()};
        int[] array3 = {Numbers.TWO.getNumber(), Numbers.SIX.getNumber(),  Numbers.TEN.getNumber(),
                Numbers.FOURTEEN.getNumber()};
        int[] array4 = {Numbers.ONE.getNumber(), Numbers.FIVE.getNumber(), Numbers.NINE.getNumber(),
                Numbers.THIRTEEN.getNumber()};

        assertArrayEquals(array1, squarelotron.getSquarematrix()[0]);
        assertArrayEquals(array2, squarelotron.getSquarematrix()[1]);
        assertArrayEquals(array3, squarelotron.getSquarematrix()[2]);
        assertArrayEquals(array4, squarelotron.getSquarematrix()[Numbers.THREE.getNumber()]);
    }
}
