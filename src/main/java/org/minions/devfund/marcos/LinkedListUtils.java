package org.minions.devfund.marcos;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;

/**
 * It is in charged to define utility methods for Linked Lists objects.
 */
public final class LinkedListUtils {

    private static final String EMPTY_STRING = "";

    /**
     * Private constructor for {@link LinkedListUtils} utility class.
     */
    private LinkedListUtils() {
        // Default constructor.
    }

    /**
     * Inserts an element to linked list and preserves elements order.
     *
     * @param list  list of integers.
     * @param value integer value to be inserted.
     */
    public static void insertSorted(final LinkedList<Integer> list, final int value) {
        if (!Objects.isNull(list)) {
            list.add(findIndex(list, value), value);
        }
    }

    /**
     * Finds insert index to be used to insert integer vale.
     *
     * @param list  list of integers.
     * @param value integer value to be inserted.
     * @return insert index value.
     */
    private static int findIndex(final LinkedList<Integer> list, final int value) {
        int index = 0;
        for (Integer number : list) {
            if (number >= value) {
                break;
            }
            index++;
        }
        return index;
    }

    /**
     * Removes the maximum values according to a number parameter.
     *
     * @param list list of integers.
     * @param n    number of maximum values to be removed.
     */
    public static void removeMaximumValues(final LinkedList<String> list, final int n) {
        int counter = n;
        if (!Objects.isNull(list) && n > 0) {
            while (counter-- > 0) {
                String longest = list.stream().max(Comparator.comparingInt(String::length)).orElse(EMPTY_STRING);
                list.removeIf(val -> val.equalsIgnoreCase(longest));
            }
        }
    }

    /**
     * Checks if the list received contains the another list received as sub sequence.
     *
     * @param one main list.
     * @param two list to verify if it is a sub sequence of main list.
     * @return true of the second list is a sub sequence of main list.
     */
    public static boolean containsSubsequence(final LinkedList<Integer> one, final LinkedList<Integer> two) {
        if (areValidSequences(one) && areValidSequences(two)) {
            return Collections.indexOfSubList(one, two) >= 0;
        }
        return false;
    }

    /**
     * Checks if the given sequence of numbers is valid.
     *
     * @param sequence list of numbers.
     * @return true if the given sequence is valid.
     */
    private static boolean areValidSequences(final LinkedList<Integer> sequence) {
        if (!Objects.isNull(sequence)) {
            return !sequence.isEmpty();
        }
        return false;
    }
}
