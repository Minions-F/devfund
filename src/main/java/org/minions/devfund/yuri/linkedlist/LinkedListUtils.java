package org.minions.devfund.yuri.linkedlist;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListUtils {

    public static void insertSorted(LinkedList<Integer> list, int value) {
        if (list != null) {
            list.add(value);
            Collections.sort(list);
        }
    }


    public static void removeMaximumValues(LinkedList<String> list, int N) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++){
                list.subList()
            }
        }

    }

    public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

		/* IMPLEMENT THIS METHOD! */

        return true; // this line is here only so this code will compile if you don't modify it
    }
}
