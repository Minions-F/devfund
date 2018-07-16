package org.minions.devfund.mauricioz.linkedList;

import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Test;

/**
// Source code recreated from a .class file by IntelliJ IDEA.
// (powered by Fernflower decompiler)
*/
public class InsertSortedTest {
    private static final int LISTFIRSTVALUE = 3;
    private static final int LISTSECONDVALUE = 8;
    private static final int LISTTHIRDVALUE = 11;

    private static final int LISTSIZE1 = 4;
    private static final int LISTSIZE2 = 3;

    private static final int LISTNEWVALUE1 = 10;
    private static final int LISTNEWVALUE2 = 14;
    private static final int LISTNEWVALUE3 = 1;

    private static final int LISTPOSITION3 = 3;

    /**
     * test.
     */
    @Test
    public void testInsertMiddle() {
        LinkedList var1 = new LinkedList();
        var1.add(LISTFIRSTVALUE);
        var1.addLast(LISTSECONDVALUE);
        var1.addLast(LISTTHIRDVALUE);

        try {
            LinkedListUtils.insertSorted(var1, LISTNEWVALUE1);
        } catch (Exception var3) {
            Assert.fail("insertSorted throws " + var3 + " when placing value in middle of list");
        }

        Assert.assertTrue("insertSorted creates LinkedList of incorrect size when placing value in middle "
                + "of list", var1.size() == LISTSIZE1);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value in middle of "
                + "list", (Integer) var1.get(0) == LISTFIRSTVALUE);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value in middle of "
                + "list", (Integer) var1.get(1) == LISTSECONDVALUE);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value in middle of "
                + "list", (Integer) var1.get(2) == LISTNEWVALUE1);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value in middle of "
                + "list", (Integer) var1.get(LISTPOSITION3) == LISTTHIRDVALUE);
    }

    /**
     * test.
     */
    @Test
    public void testInsertEnd() {
        LinkedList var1 = new LinkedList();
        var1.add(LISTFIRSTVALUE);
        var1.addLast(LISTSECONDVALUE);
        var1.addLast(LISTTHIRDVALUE);

        try {
            LinkedListUtils.insertSorted(var1, LISTNEWVALUE2);
        } catch (Exception var3) {
            Assert.fail("insertSorted throws " + var3 + " when placing value at end of list");
        }

        Assert.assertTrue("insertSorted creates LinkedList of incorrect size when placing value at end of "
                + "list", var1.size() == LISTSIZE1);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at end of list",
                (Integer) var1.get(0) == LISTFIRSTVALUE);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at end of list",
                (Integer) var1.get(1) == LISTSECONDVALUE);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at end of list",
                (Integer) var1.get(2) == LISTTHIRDVALUE);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at end of list",
                (Integer) var1.get(LISTFIRSTVALUE) == LISTNEWVALUE2);
    }

    /**
     * test.
     */
    @Test
    public void testInsertFront() {
        LinkedList var1 = new LinkedList();
        var1.add(LISTFIRSTVALUE);
        var1.addLast(LISTSECONDVALUE);
        var1.addLast(LISTTHIRDVALUE);

        try {
            LinkedListUtils.insertSorted(var1, LISTNEWVALUE3);
        } catch (Exception var3) {
            Assert.fail("insertSorted throws " + var3 + " when placing value at front of list");
        }

        Assert.assertTrue("insertSorted creates LinkedList of incorrect size when placing value at front of "
                + "list", var1.size() == LISTSIZE1);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at front of "
                + "list", (Integer) var1.get(0) == LISTNEWVALUE3);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at front of "
                + "list", (Integer) var1.get(1) == LISTFIRSTVALUE);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at front of "
               + "list", (Integer) var1.get(2) == LISTSECONDVALUE);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value at front of "
                + "list", (Integer) var1.get(LISTSIZE2) == LISTTHIRDVALUE);
    }

    /**
     * test.
     */
    @Test
    public void testInsertMiddleEqualToExistingElement() {
        LinkedList var1 = new LinkedList();
        var1.add(LISTFIRSTVALUE);
        var1.addLast(LISTSECONDVALUE);
        var1.addLast(LISTTHIRDVALUE);

        try {
            LinkedListUtils.insertSorted(var1, LISTSECONDVALUE);
        } catch (Exception var3) {
            Assert.fail("insertSorted throws " + var3 + " when placing value that is equal to value already in list");
        }

        Assert.assertTrue("insertSorted creates LinkedList of incorrect size when placing value that is "
                + "equal to value already in list", var1.size() == LISTSIZE1);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value that is equal "
                + "to value already in list", (Integer) var1.get(0) == LISTFIRSTVALUE);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value that is equal "
                + "to value already in list", (Integer) var1.get(1) == LISTSECONDVALUE);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value that is equal "
                + "to value already in list", (Integer) var1.get(2) == LISTSECONDVALUE);
        Assert.assertTrue("insertSorted does not correctly insert element when placing value that is equal "
                + "to value already in list", (Integer) var1.get(LISTSIZE2) == LISTTHIRDVALUE);
    }

    /**
     * test.
     */
    @Test
    public void testNull() {
        try {
            LinkedListUtils.insertSorted((LinkedList) null, 0);
        } catch (Exception var2) {
            Assert.fail("insertSorted throws " + var2 + " when input LinkedList is null");
        }

    }

    /**
     * test.
     */
    @Test
    public void testInsertEmpty() {
        LinkedList var1 = new LinkedList();

        try {
            LinkedListUtils.insertSorted(var1, LISTNEWVALUE1);
        } catch (Exception var3) {
            Assert.fail("insertSorted throws " + var3 + " when inserting into empty list");
        }

        Assert.assertTrue("insertSorted creates LinkedList of incorrect size when inserting into empty list",
                var1.size() == 1);
        Assert.assertTrue("insertSorted does not correctly insert element into empty list",
                (Integer) var1.get(0) == LISTNEWVALUE1);
    }
}
