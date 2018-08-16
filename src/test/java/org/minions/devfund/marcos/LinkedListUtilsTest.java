package org.minions.devfund.marcos;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * It is in charged to define the unit tests for {@link LinkedListUtils} class.
 */
public class LinkedListUtilsTest {

    private static final String ONE_A_LETTER = "a";
    private static final String TWO_B_LETTERS = "bb";
    private static final String THREE_C_LETTERS = "ccc";
    private static final String FOUR_D_LETTERS = "dddd";
    private static final int ZERO_NUM = 0;
    private static final int ONE_NUM = 1;
    private static final int TWO_NUM = 2;
    private static final int THREE_NUM = 3;
    private static final int FOUR_NUM = 4;
    private static final int TEN_NUM = 10;

    /**
     * This test assert the modifier of the Linked List Utils private constructor class.
     *
     * @throws NoSuchMethodException     throw when no private constructor is defined.
     * @throws IllegalAccessException    throw when can not access to the constructor.
     * @throws InvocationTargetException throw when can not be perform a invocation.
     * @throws InstantiationException    throw when a instantiation can not be performed.
     */
    @Test
    public void privateConstructorTest() throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Constructor<LinkedListUtils> constructor = LinkedListUtils.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

    /**
     * Checks expected result for Add Inner Sorted At The End Of Sequence test.
     */
    @Test
    public void testAddInnerSortedAtTheEndOfSequence() {
        Integer[] originalSequence = new Integer[]{ONE_NUM, TWO_NUM, THREE_NUM};
        Integer[] expectedSequence = new Integer[]{ONE_NUM, TWO_NUM, THREE_NUM, TEN_NUM};
        LinkedList<Integer> actual = Stream.of(originalSequence).collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> expected = Stream.of(expectedSequence).collect(Collectors.toCollection(LinkedList::new));
        LinkedListUtils.insertSorted(actual, TEN_NUM);
        assertThat(actual, is(expected));
    }

    /**
     * Checks expected result for Add Inner Sorted At The Beginning Of Sequence test.
     */
    @Test
    public void testAddInnerSortedAtTheBeginningOfSequence() {
        Integer[] originalSequence = new Integer[]{TWO_NUM, THREE_NUM, FOUR_NUM};
        Integer[] expectedSequence = new Integer[]{ONE_NUM, TWO_NUM, THREE_NUM, FOUR_NUM};
        LinkedList<Integer> actual = Stream.of(originalSequence).collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> expected = Stream.of(expectedSequence).collect(Collectors.toCollection(LinkedList::new));
        LinkedListUtils.insertSorted(actual, ONE_NUM);
        assertThat(actual, is(expected));
    }

    /**
     * Checks expected result for Add Inner Sorted At The Middle Of Sequence test.
     */
    @Test
    public void testAddInnerSortedAtTheMiddleOfSequence() {
        Integer[] originalSequence = new Integer[]{TWO_NUM, FOUR_NUM};
        Integer[] expectedSequence = new Integer[]{TWO_NUM, THREE_NUM, FOUR_NUM};
        LinkedList<Integer> actual = Stream.of(originalSequence).collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> expected = Stream.of(expectedSequence).collect(Collectors.toCollection(LinkedList::new));
        LinkedListUtils.insertSorted(actual, THREE_NUM);
        assertThat(actual, is(expected));
    }

    /**
     * Checks expected result for Add To A Null Sequence test.
     */
    @Test
    public void testAddToANullSequence() {
        LinkedList<Integer> sequence = null;
        LinkedListUtils.insertSorted(sequence, THREE_NUM);
        assertNull(sequence);
    }

    /**
     * Checks expected result for Remove Two Maximum Values From List test.
     */
    @Test
    public void testRemoveTwoMaximumValuesFromList() {
        String[] originalSequence = new String[]{ONE_A_LETTER, TWO_B_LETTERS, THREE_C_LETTERS, FOUR_D_LETTERS};
        String[] expectedSequence = new String[]{ONE_A_LETTER, TWO_B_LETTERS};
        LinkedList<String> actual = Stream.of(originalSequence).collect(Collectors.toCollection(LinkedList::new));
        LinkedList<String> expected = Stream.of(expectedSequence).collect(Collectors.toCollection(LinkedList::new));
        LinkedListUtils.removeMaximumValues(actual, TWO_NUM);
        assertThat(actual, is(expected));
    }

    /**
     * Checks expected result for Remove Zero Maximum Values From List test.
     */
    @Test
    public void testRemoveZeroMaximumValuesFromList() {
        String[] originalSequence = new String[]{ONE_A_LETTER, TWO_B_LETTERS};
        String[] expectedSequence = new String[]{ONE_A_LETTER, TWO_B_LETTERS};
        LinkedList<String> actual = Stream.of(originalSequence).collect(Collectors.toCollection(LinkedList::new));
        LinkedList<String> expected = Stream.of(expectedSequence).collect(Collectors.toCollection(LinkedList::new));
        LinkedListUtils.removeMaximumValues(actual, ZERO_NUM);
        assertThat(actual, is(expected));
    }

    /**
     * Checks expected result for Remove One Maximum Value From Null List test.
     */
    @Test
    public void testRemoveOneMaximumValueFromNullList() {
        LinkedList<String> actual = null;
        LinkedListUtils.removeMaximumValues(actual, ONE_NUM);
        assertNull(actual);
    }

    /**
     * Checks expected result for Remove Zero Maximum Value From Null List test.
     */
    @Test
    public void testRemoveZeroMaximumValueFromNullList() {
        LinkedList<String> actual = null;
        LinkedListUtils.removeMaximumValues(actual, ZERO_NUM);
        assertNull(actual);
    }

    /**
     * Checks expected result for Contains Subsequence test.
     */
    @Test
    public void testContainsSubsequence() {
        Integer[] mainArray = new Integer[]{ONE_NUM, TWO_NUM, THREE_NUM, FOUR_NUM};
        Integer[] secondArray = new Integer[]{TWO_NUM, THREE_NUM};
        LinkedList<Integer> mainSeq = Stream.of(mainArray).collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> secondSeq = Stream.of(secondArray).collect(Collectors.toCollection(LinkedList::new));
        assertTrue(LinkedListUtils.containsSubsequence(mainSeq, secondSeq));
    }

    /**
     * Checks expected result for Contains Subsequence with Null Second Sequence test.
     */
    @Test
    public void testContainsSubsequenceNullSecondSequence() {
        Integer[] mainArray = new Integer[]{ONE_NUM, TWO_NUM, THREE_NUM, FOUR_NUM};
        LinkedList<Integer> mainSeq = Stream.of(mainArray).collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> secondSeq = null;
        assertFalse(LinkedListUtils.containsSubsequence(mainSeq, secondSeq));
    }

    /**
     * Checks expected result for Contains Subsequence with Null Main Sequence test.
     */
    @Test
    public void testContainsSubsequenceNullMainSequence() {
        Integer[] expectedSequence = new Integer[]{TWO_NUM, THREE_NUM};
        LinkedList<Integer> mainSeq = null;
        LinkedList<Integer> secondSeq = Stream.of(expectedSequence).collect(Collectors.toCollection(LinkedList::new));
        assertFalse(LinkedListUtils.containsSubsequence(mainSeq, secondSeq));
    }

    /**
     * Checks expected result for Contains Subsequence with Null Sequences test.
     */
    @Test
    public void testContainsSubsequenceNullSequences() {
        LinkedList<Integer> mainSeq = null;
        LinkedList<Integer> secondSeq = null;
        assertFalse(LinkedListUtils.containsSubsequence(mainSeq, secondSeq));
    }

    /**
     * Checks expected result for Contains Subsequence with Empty Second Sequence test.
     */
    @Test
    public void testContainsSubsequenceEmptySecondSequence() {
        Integer[] mainArray = new Integer[]{ONE_NUM, TWO_NUM, THREE_NUM, FOUR_NUM};
        LinkedList<Integer> mainSeq = Stream.of(mainArray).collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> secondSeq = new LinkedList<>();
        assertFalse(LinkedListUtils.containsSubsequence(mainSeq, secondSeq));
    }

    /**
     * Checks expected result for Contains Subsequence with Empty Main Sequence test.
     */
    @Test
    public void testContainsSubsequenceEmptyMainSequence() {
        Integer[] secondArray = new Integer[]{TWO_NUM, THREE_NUM};
        LinkedList<Integer> mainSeq = new LinkedList<>();
        LinkedList<Integer> secondSeq = Stream.of(secondArray).collect(Collectors.toCollection(LinkedList::new));
        assertFalse(LinkedListUtils.containsSubsequence(mainSeq, secondSeq));
    }
}
