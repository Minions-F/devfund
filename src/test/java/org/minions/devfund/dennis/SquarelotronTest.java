package org.minions.devfund.dennis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit Test class for Squarelotron for all methods.
 */
public class SquarelotronTest {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;
    private static final int NINE = 9;
    private static final int TEN = 10;
    private static final int ELEVEN = 11;
    private static final int THIRTEEN = 13;
    private static final int FIFTEEN = 15;
    private static final int NINETEEN = 19;
    private static final int TWENTYONE = 21;

    /**
     * Unit test for constructor where n = 2.
     */
    @Test
    public void testConstructor1() {
        Squarelotron se = new Squarelotron(TWO);
        assertEquals(TWO, se.getSize());
        assertEquals(ONE, se.getMatrix()[ZERO][ZERO]);
        assertEquals(TWO, se.getMatrix()[ZERO][ONE]);
        assertEquals(THREE, se.getMatrix()[ONE][ZERO]);
        assertEquals(FOUR, se.getMatrix()[ONE][ONE]);
    }

    /**
     * Unit test for constructor where n = 5.
     */
    @Test
    public void testConstructor2() {
        Squarelotron se = new Squarelotron(FIVE);
        assertEquals(FIVE, se.getSize());
        assertEquals(TWENTYONE, se.getMatrix()[FOUR][ZERO]);
        assertEquals(NINETEEN, se.getMatrix()[THREE][THREE]);
    }

    /**
     * Unit test for testRotateRight where n = 2 and numberOfTurns = 1.
     */
    @Test
    public void testRotateRight1() {
        Squarelotron se = new Squarelotron(TWO);
        se.rotateRight(ONE);
        assertEquals(THREE, se.getMatrix()[ZERO][ZERO]);
        assertEquals(ONE, se.getMatrix()[ZERO][ONE]);
        assertEquals(FOUR, se.getMatrix()[ONE][ZERO]);
        assertEquals(TWO, se.getMatrix()[ONE][ONE]);
    }

    /**
     * Unit test for testRotateRight where n = 2 and numberOfTurns = -1.
     */
    @Test
    public void testRotateRight2() {
        Squarelotron se = new Squarelotron(TWO);
        se.rotateRight(-1);
        assertEquals(TWO, se.getMatrix()[ZERO][ZERO]);
        assertEquals(FOUR, se.getMatrix()[ZERO][ONE]);
        assertEquals(ONE, se.getMatrix()[ONE][ZERO]);
        assertEquals(THREE, se.getMatrix()[ONE][ONE]);
    }

    /**
     * Unit test for testRotateRight where n = 2 and numberOfTurns = 2.
     */
    @Test
    public void testRotateRight3() {
        Squarelotron se = new Squarelotron(TWO);
        se.rotateRight(TWO);
        assertEquals(FOUR, se.getMatrix()[ZERO][ZERO]);
        assertEquals(THREE, se.getMatrix()[ZERO][ONE]);
        assertEquals(TWO, se.getMatrix()[ONE][ZERO]);
        assertEquals(ONE, se.getMatrix()[ONE][ONE]);
    }

    /**
     * Unit test for testRotateRight where n = 3 and numberOfTurns = 1.
     */
    @Test
    public void testRotateRight4() {
        Squarelotron se = new Squarelotron(THREE);
        se.rotateRight(ONE);
        assertEquals(ONE, se.getMatrix()[ZERO][TWO]);
        assertEquals(TWO, se.getMatrix()[ONE][TWO]);
        assertEquals(THREE, se.getMatrix()[TWO][TWO]);
        assertEquals(FOUR, se.getMatrix()[ZERO][ONE]);
        assertEquals(FIVE, se.getMatrix()[ONE][ONE]);
    }

    /**
     * Unit test for numbersInRing where n = 4 true.
     */
    @Test
    public void testIsOnRing() {
        Squarelotron se = new Squarelotron(FOUR);
        assertTrue(se.numbersInRing(ZERO, ZERO, ONE));
        assertTrue(se.numbersInRing(ONE, ZERO, ONE));
        assertTrue(se.numbersInRing(THREE, ZERO, ONE));
        assertTrue(se.numbersInRing(ZERO, THREE, ONE));
        assertTrue(se.numbersInRing(ONE, ONE, TWO));
        assertTrue(se.numbersInRing(TWO, TWO, TWO));
    }

    /**
     * Unit test for numbersInRing where n = 4 false.
     */
    @Test
    public void testIsOnRing2() {
        Squarelotron se = new Squarelotron(FOUR);
        assertFalse(se.numbersInRing(ZERO, ZERO, TWO));
        assertFalse(se.numbersInRing(ZERO, ONE, TWO));
        assertFalse(se.numbersInRing(THREE, ZERO, TWO));
        assertFalse(se.numbersInRing(ONE, ONE, ONE));
        assertFalse(se.numbersInRing(ONE, TWO, ONE));
    }

    /**
     * Unit test for UpsideDownFlip where n = 4 ring = 1.
     */
    @Test
    public void testUpsideDownFlip1() {
        Squarelotron se = new Squarelotron(FOUR);
        se = se.upsideDownFlip(ONE);
        assertEquals(THIRTEEN, se.getMatrix()[ZERO][ZERO]);
        assertEquals(FIFTEEN, se.getMatrix()[ZERO][TWO]);
        assertEquals(NINE, se.getMatrix()[ONE][ZERO]);
        assertEquals(SIX, se.getMatrix()[ONE][ONE]);
        assertEquals(EIGHT, se.getMatrix()[TWO][THREE]);
        assertEquals(FOUR, se.getMatrix()[THREE][THREE]);
    }

    /**
     * Unit test for UpsideDownFlip where n = 4 ring = 2.
     */
    @Test
    public void testUpsideDownFlip2() {
        Squarelotron se = new Squarelotron(FOUR);
        se = se.upsideDownFlip(TWO);
        assertEquals(THIRTEEN, se.getMatrix()[THREE][ZERO]);
        assertEquals(FIFTEEN, se.getMatrix()[THREE][TWO]);
        assertEquals(SIX, se.getMatrix()[TWO][ONE]);
        assertEquals(SEVEN, se.getMatrix()[TWO][TWO]);
        assertEquals(ELEVEN, se.getMatrix()[ONE][TWO]);
    }

    /**
     * Unit test for MainDiagonalFlip where n = 2 ring = 1.
     */
    @Test
    public void testMainDiagonalFlip1() {
        Squarelotron se = new Squarelotron(TWO);
        se = se.mainDiagonalFlip(ONE);
        assertEquals(ONE, se.getMatrix()[ZERO][ZERO]);
        assertEquals(THREE, se.getMatrix()[ZERO][ONE]);
        assertEquals(TWO, se.getMatrix()[ONE][ZERO]);
        assertEquals(FOUR, se.getMatrix()[ONE][ONE]);
    }

    /**
     * Unit test for MainDiagonalFlip where n = 3 ring = 1.
     */
    @Test
    public void testMainDiagonalFlip2() {
        Squarelotron se = new Squarelotron(THREE);
        se = se.mainDiagonalFlip(ONE);
        assertEquals(FOUR, se.getMatrix()[ZERO][ONE]);
        assertEquals(TWO, se.getMatrix()[ONE][ZERO]);
        assertEquals(EIGHT, se.getMatrix()[ONE][TWO]);
        assertEquals(SIX, se.getMatrix()[TWO][ONE]);
    }

    /**
     * Unit test for MainDiagonalFlip where n = 4 ring = 2.
     */
    @Test
    public void testMainDiagonalFlip3() {
        Squarelotron se = new Squarelotron(FOUR);
        se = se.mainDiagonalFlip(TWO);
        assertEquals(FOUR, se.getMatrix()[ZERO][THREE]);
        assertEquals(FIVE, se.getMatrix()[ONE][ZERO]);
        assertEquals(SIX, se.getMatrix()[ONE][ONE]);
        assertEquals(TEN, se.getMatrix()[ONE][TWO]);
        assertEquals(FIFTEEN, se.getMatrix()[THREE][TWO]);
    }
}
