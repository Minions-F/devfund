package org.minions.devfund.bruno.linkedlist;

import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * Three methods that perform functions on a linked list, using the java.util.LinkedList class from
 * the Java Collections API.
 */
public final class LinkedListUtils {

    /**
     * Linked List Utils constructor private.
     */
    private LinkedListUtils() {
    }

    /**
     * Assumes the input LinkedList is already sorted in non-descending order.
     *
     * @param list  list integer.
     * @param value value into the correct location of the list.
     */
    public static void insertSorted(final LinkedList<Integer> list, final int value) {
        if (list != null) {
            int index = Math.toIntExact(IntStream.range(0, list.size()).filter(i -> list.get(i) < value).count());
            list.add(index, value);
        }
    }

    /**
     * Removes all instances of the N largest values in the LinkedList.
     *
     * @param list         list.
     * @param numberValues N largest values in the LinkedList
     */
    public static void removeMaximumValues(final LinkedList<String> list, final int numberValues) {
        if (list != null && !list.isEmpty() && numberValues >= 0) {
            int removed = 0;
            while (removed < numberValues && !list.isEmpty()) {
                String big = Collections.max(list);
                while (list.contains(big)) {
                    list.remove(big);
                }
                removed++;
            }
        }
    }

    /**
     * Determines whether any part of the first LinkedList contains all elements of the second in the same order with
     * no other elements in the sequence.
     *
     * @param oneList contains all elements of the second in the same order with no other elements in the sequence.
     * @param twoList contains all elements.
     * @return false if either input is null or empty
     */
    public static boolean containsSubsequence(final LinkedList<Integer> oneList, final LinkedList<Integer> twoList) {
        if (oneList == null || twoList == null || oneList.isEmpty() || twoList.isEmpty()) {
            return false;
        }
        int start = oneList.indexOf(twoList.getFirst());
        if (start < 0) {
            return false;
        }
        for (int index = 0; index < twoList.size(); index++) {
            if (start + index >= oneList.size()) {
                return false;
            }
            if (!(oneList.get(start + index).equals(twoList.get(index)))) {
                return false;
            }
        }
        return true;
    }
}
