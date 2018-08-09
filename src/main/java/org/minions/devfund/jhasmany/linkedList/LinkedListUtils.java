package org.minions.devfund.jhasmany.linkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class LinkedListUtils {

    /**
     * Method that inserts an item neatly into the list.
     *
     * @param list that will contain the new element.
     * @param value is the element to be inserted.
     */
    public static void insertSorted(LinkedList<Integer> list, int value) {
        if (list != null) {
            if (list.isEmpty()) {
                list.add(value);
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) >= value) {
                        list.add(i, value);
                        break;
                    }

                    if (i == list.size() - 1) {
                        list.add(value);
                        break;
                    }
                }
            }
        }
    }

    /**
     * Method that removes n items from the list in descending order.
     *
     * @param list contains the all elements.
     * @param N indicate the number of elements that will deleted.
     */
    public static void removeMaximumValues(LinkedList<String> list, int N) {

        if (list != null && !list.isEmpty()) {
            if (list.size() <= N) {
                list.removeAll(list);
                return;
            }

            for (int i = 0; i < N; i++) {
                LinkedList<String> sortedList = new LinkedList<>(list);
                sortedList.sort(Collections.reverseOrder());
                list.removeAll(Arrays.asList(sortedList.get(0)));
            }
        }

    }

    /**
     * Method that checks if one list is inside the other list.
     *
     * @param one is the list that will contain the other list.
     * @param two is the list that should be inside the other list.
     * @return true if list one contains list two, otherwise false.
     */
    public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

        if (one == null || two == null || one.isEmpty() || two.isEmpty()) {
            return false;
        }

        for (int i = 0; i <= one.size() - two.size(); i++) {
            boolean result = true;
            for (int j = 0; j < two.size(); j++) {
                if (one.get(i + j) != two.get(j)) {
                    result = false;
                    break;
                }
            }

            if (result) {
                return true;
            }
        }

        return false;
    }
}