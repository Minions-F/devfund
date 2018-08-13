package org.minions.devfund.yuri.linkedlist;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**
 * // Source code recreated from a .class file by IntelliJ IDEA.
 * // (powered by Fernflower decompiler)
 */
public class RemoveMaximumValuesTest {

    private static final int LISTSIZE1 = 3;
    private static final int LISTSIZE2 = 4;
    public static final String REMOVE_MAXIMUM_VALUES = "removeMaximumValues does not have "
            + "elements in correct order when number of ";
    public static final String ELEMENTS_TO_REMOVE = "elements to remove is less than size of "
            + "input and maximum elements appear more than once";
    public static final String KANGAROO = "kangaroo";
    public static final String REMOVE_MAXIMUM_VALUES_THROWS = "removeMaximumValues throws ";
    public static final String KOALA = "koala";
    public static final String ELEMENTS_TO_REMOVE_IS_LESS = "elements to remove is less than size of input";

    /**
     * test.
     */
    @Test
    public void testNull() {
        try {
            LinkedListUtils.removeMaximumValues((LinkedList) null, 2);
        } catch (Exception var2) {
            Assert.fail(REMOVE_MAXIMUM_VALUES_THROWS + var2 + " when input LinkedList is null");
        }

    }

    /**
     * test.
     */
    @Test
    public void testNegativeSize() {
        LinkedList var1 = new LinkedList();
        var1.add("doge");
        var1.add("cat");

        try {
            LinkedListUtils.removeMaximumValues(var1, -1);
        } catch (Exception var3) {
            Assert.fail(REMOVE_MAXIMUM_VALUES_THROWS + var3 + " when number of elements to remove is negative");
        }

        if (var1.size() < 2) {
            Assert.fail("removeMaximumValues removes elements from LinkedList when number of elenents to remove is "
                    + "negative");
        }

        if (var1.size() > 2) {
            Assert.fail("removeMaximumValues adds elements to LinkedList when number of elenents to remove is "
                    + "negative");
        }

    }

    /**
     * test.
     */
    @Test
    public void testInsertEmpty() {
        LinkedList var1 = new LinkedList();

        try {
            LinkedListUtils.removeMaximumValues(var1, 1);
        } catch (Exception var3) {
            Assert.fail(REMOVE_MAXIMUM_VALUES_THROWS + var3 + " when input LinkedList is empty");
        }

        Assert.assertTrue("removeMaximumValues adds elements to list when input LinkedList is empty",
                var1.isEmpty());
    }

    /**
     * test.
     */
    @Test
    public void testRemoveGreaterThanSize() {
        LinkedList var1 = new LinkedList();
        var1.add("doge");

        try {
            LinkedListUtils.removeMaximumValues(var1, 2);
        } catch (Exception var3) {
            Assert.fail(REMOVE_MAXIMUM_VALUES_THROWS + var3 + " when number of elements to remove is greater than "
                    + "size of input LinkedList");
        }

        Assert.assertTrue("removeMaximumValues does not remove all elements when number of elements to "
                + "remove is greater than size of input LinkedList", var1.isEmpty());
    }

    /**
     * test.
     */
    @Test
    public void testRemoveEqualsSize() {
        LinkedList var1 = new LinkedList();
        var1.add("doge");

        try {
            LinkedListUtils.removeMaximumValues(var1, 1);
        } catch (Exception var3) {
            Assert.fail(REMOVE_MAXIMUM_VALUES_THROWS + var3 + " when number of elements to remove equals size of "
                    + "input LinkedList");
        }

        Assert.assertTrue("removeMaximumValues does not remove all elements when number of elements to "
                + "remove equals size of input LinkedList", var1.isEmpty());
    }

    /**
     * test.
     */
    @Test
    public void testEachMaxAppearsOnce() {
        LinkedList var1 = new LinkedList();
        var1.add("doge");
        var1.add("cat");
        var1.add(KANGAROO);
        var1.add(KOALA);
        var1.add("bear");

        try {
            LinkedListUtils.removeMaximumValues(var1, 2);
        } catch (Exception var3) {
            Assert.fail(REMOVE_MAXIMUM_VALUES_THROWS + var3 + " when number of elements to remove is less than size "
                    + "of input");
        }

        if (var1.size() < LISTSIZE1) {
            Assert.fail("removeMaximumValues removes too many elements from LinkedList when number of elements to "
                    + "remove is less than size of input");
        }

        if (var1.size() > LISTSIZE1) {
            Assert.fail("removeMaximumValues does not remove enough elements from LinkedList when number of elements "
                    + "to remove is less than size of input");
        }

        if (var1.contains(KANGAROO) || var1.contains(KOALA)) {
            Assert.fail("removeMaximumValues does not remove correct elements from LinkedList when number of "
                    + ELEMENTS_TO_REMOVE_IS_LESS);
        }

        Assert.assertTrue(REMOVE_MAXIMUM_VALUES
                + ELEMENTS_TO_REMOVE_IS_LESS, ((String) var1.get(0)).equals("doge"));
        Assert.assertTrue(REMOVE_MAXIMUM_VALUES
                + ELEMENTS_TO_REMOVE_IS_LESS, ((String) var1.get(1)).equals("cat"));
        Assert.assertTrue(REMOVE_MAXIMUM_VALUES
                + ELEMENTS_TO_REMOVE_IS_LESS, ((String) var1.get(2)).equals("bear"));
    }

    /**
     * test.
     */
    @Test
    public void testMaxValuesAppearMoreThanOnce() {
        LinkedList var1 = new LinkedList();
        var1.add("doge");
        var1.add(KANGAROO);
        var1.add("cat");
        var1.add(KANGAROO);
        var1.add(KOALA);
        var1.add("bear");
        var1.add("doge");
        var1.add(KOALA);
        var1.add(KANGAROO);

        try {
            LinkedListUtils.removeMaximumValues(var1, 2);
        } catch (Exception var3) {
            Assert.fail(REMOVE_MAXIMUM_VALUES_THROWS + var3 + " when number of elements to remove is less than "
                    + "size of input and maximum elements appear more than once");
        }

        if (var1.size() < LISTSIZE2) {
            Assert.fail("removeMaximumValues removes too many elements from LinkedList when number of elements to "
                    + "remove is less than size of input and maximum elements appear more than once");
        }

        if (var1.contains(KANGAROO) || var1.contains(KOALA)) {
            Assert.fail("removeMaximumValues does not remove all instances of max elements from LinkedList when "
                    + "number of elements to remove is less than size of input and maximum elements appear more "
                    + "than once");
        }

        if (var1.size() > LISTSIZE2) {
            Assert.fail("removeMaximumValues does not remove enough elements from LinkedList when number of elements "
                    + "to remove is less than size of input and maximum elements appear more than once");
        }

        Assert.assertTrue(REMOVE_MAXIMUM_VALUES
                        + ELEMENTS_TO_REMOVE,
                ((String) var1.get(0)).equals("doge"));
        Assert.assertTrue(REMOVE_MAXIMUM_VALUES
                        + ELEMENTS_TO_REMOVE,
                ((String) var1.get(1)).equals("cat"));
        Assert.assertTrue(REMOVE_MAXIMUM_VALUES
                        + ELEMENTS_TO_REMOVE,
                ((String) var1.get(2)).equals("bear"));
        Assert.assertTrue(REMOVE_MAXIMUM_VALUES
                        + ELEMENTS_TO_REMOVE,
                ((String) var1.get(LISTSIZE1)).equals("doge"));
    }
}
