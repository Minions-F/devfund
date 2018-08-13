package org.minions.devfund.yuri.linkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */
public final class LinkedListUtils {

    /**
     * constructor.
     */
    private LinkedListUtils() {

    }

    /**
     * This method will add an element on a sorted list.
     *
     * @param list  a list.
     * @param value a value.
     */
    public static void insertSorted(final LinkedList<Integer> list, final int value) {
        if (list != null) {
            if (list.isEmpty() || value <= list.getFirst()) {
                list.addFirst(value);
                return;
            }
            if (value >= list.getLast()) {
                list.addLast(value);
                return;
            }
            for (int i = 1; i < list.size(); i++) {
                if (value <= list.get(i)) {
                    list.add(i, value);
                    return;
                }
            }
        }
    }

    /**
     * this method will remove a max value from a list.
     *
     * @param list a list.
     * @param n    index
     */
    public static void removeMaximumValues(final LinkedList<String> list, final int n) {
        if (list != null && n > 0) {
            for (int j = n; j > 0; j--) {
                if (!list.isEmpty()) {
                    removeElementOfTheList(list);
                }
            }
        }

    }

    /**
     * remove an element of the list.
     *
     * @param list a list.
     */
    private static void removeElementOfTheList(final LinkedList<String> list) {
        String maximumValue = getMaximumValue(list);
        for (int i = 0; i < list.size(); i++) {
            if (maximumValue.compareTo(list.get(i)) == 0) {
                list.remove(i);
            }
        }
    }

    /**
     * method to compare all the strings on a list and return the maximum value.
     *
     * @param list a list.
     * @return largest string on the list.
     */
    private static String getMaximumValue(final LinkedList<String> list) {
        String maxValue = list.getFirst();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(maxValue) > 0) {
                maxValue = list.get(i);
            }
        }
        return maxValue;
    }

    /**
     * verify if second list is part of first list.
     *
     * @param one list.
     * @param two list.
     * @return true or false.
     */
    public static boolean containsSubsequence(final LinkedList<Integer> one, final LinkedList<Integer> two) {
        if (one != null && two != null && !one.isEmpty() && !two.isEmpty()) {
            for (int i = 0; i + two.size() - 1 < one.size(); i++) {
                List<Integer> oneSublist = one.subList(i, i + two.size());
                if (oneSublist.equals(two)) {
                    return true;
                }
            }
        }
        return false;
    }
}
