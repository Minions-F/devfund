package org.minions.devfund.bruno.linkedlist;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Linked list util test.
 */
public class LinkedListUtilsTest {

    /**
     * Test to insert sorted.
     */
    @Test
    public void insertSorted() {
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        LinkedList<Integer> list = new LinkedList<>();
        LinkedListUtils.insertSorted(null, 9);
        list.add(2);
        list.add(4);
        LinkedListUtils.insertSorted(list, 1);
        LinkedListUtils.insertSorted(list, 3);
        LinkedListUtils.insertSorted(list, 5);
        assertEquals(expected, list);
    }

    /**
     * Test to remove maximum values.
     */
    @Test
    public void removeMaximumValues() {
        LinkedList<String> expected = new LinkedList<>();
        expected.add("aaa");
        expected.add("bbb");
        LinkedList<String> actual = new LinkedList<>();
        actual.add("aaa");
        actual.add("bbb");
        actual.add("ccc");
        actual.add("ccc");
        actual.add("ddd");
        actual.add("ddd");
        actual.add("ddd");
        LinkedListUtils.removeMaximumValues(actual, 2);
        assertEquals(expected, actual);
        LinkedListUtils.removeMaximumValues(actual, 0);
        LinkedListUtils.removeMaximumValues(actual, -1);
        assertEquals(expected, actual);
    }

    /**
     * Test to contains sub sequence.
     */
    @Test
    public void containsSubsequence() {
        LinkedList<Integer> actual = new LinkedList<>();
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.add(5);
        LinkedList<Integer> sub1 = new LinkedList<>();
        sub1.add(2);
        sub1.add(3);
        sub1.add(4);
        assertTrue(LinkedListUtils.containsSubsequence(actual, sub1));
        sub1.add(2);
        assertFalse(LinkedListUtils.containsSubsequence(actual, sub1));
        sub1.remove(3);
        sub1.add(5);
        assertTrue(LinkedListUtils.containsSubsequence(actual, sub1));
        sub1.add(6);
        assertFalse(LinkedListUtils.containsSubsequence(actual, sub1));
    }
}
