package org.minions.devfund.mauricioz.linkedList;

import java.util.LinkedList;

/**
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */
public final  class LinkedListUtils {
    /**
     * constructor.
     */
    private LinkedListUtils() {

    }
    /**
     * This method will add an element on a sorted list.
     * @param list a list.
     * @param value a value.
     */
    public static void insertSorted(final LinkedList<Integer> list, int value) {
        if (list == null) {
            return;
        }
        if (list.isEmpty()) {
            list.addFirst(value);
            return;
        }
        int index = list.size();
        if (value <= list.getFirst()) {
            list.addFirst(value);
            return;
        }
        if (value >= list.getLast()) {
            list.addLast(value);
        }
        for (int i = 1; i < index; i++) {
            if (value <= list.get(i)) {
                list.add(i, value);
                return;
            }
        }
    }

    /**
     * this method will remove a max value from a list.
     * @param list a list.
     * @param n index
     */
    public static void removeMaximumValues(final LinkedList<String> list, int n) {
        if (n < 0 || list == null) {
            return;
        }
        for (int j = n; j > 0; j--) {
            if (!list.isEmpty()) {
                removeElementOfTheList(list);
            }
        }
    }

    /**
     * remove an element of the list.
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
     * method.
     * @param one one.
     * @param two two.
     * @return return.
     */
    public static boolean containsSubsequence(final LinkedList<Integer> one, final LinkedList<Integer> two) {
        boolean inList;
        if (one == null || two == null || one.isEmpty() || two.isEmpty()) {
            return false;
        }
        if (!secondHeadInList(two.getFirst(), one)) {
            inList = false;
        } else {
            int index = getIndexOnFirstList(one, two.getFirst());
            inList = isInFirstSinceIndex(one, two, index);
        }
        return inList; // this line is here only so this code will compile if you don't modify it
    }

    /**
     *verify if second list is part of first list.
     * @param one list.
     * @param two list.
     * @param index from which position in list one we should start.
     * @return true or false.
     */
    private static boolean isInFirstSinceIndex(final LinkedList<Integer> one, final LinkedList<Integer> two,
                                               int index) {
        boolean inList = false;
        if (index + two.size() > one.size()) {
            return inList;
        }
        for (int i = 0; i < two.size(); i++) {
            if (one.get(index + i) == two.get(i)) {
                inList = true;
            } else {
                inList = false;
            }
        }
        return inList;
    }

    /**
     * get the index where first element of second list appear in the first list.
     * @param one list.
     * @param first element of the second list
     * @return index.
     */
    private static int getIndexOnFirstList(final LinkedList<Integer> one, final Integer first) {
        int index = 0;
        for (int i = 0; i < one.size(); i++) {
            if (first.equals(one.get(i))) {
                index = i;
            }
        }
        return  index;
    }

    /**
     * review if first element of second list appears in some point in list one.
     * @param first value of second list.
     * @param one first list.
     * @return true or false.
     */
    private static boolean secondHeadInList(final Integer first, final LinkedList<Integer> one) {
        for (int i = 0; i < one.size(); i++) {
            if (first.equals(one.get(i))) {
                return true;
            }
        }
        return false;
    }
}
