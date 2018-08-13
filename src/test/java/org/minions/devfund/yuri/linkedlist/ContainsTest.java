package org.minions.devfund.yuri.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
/**
 Source code recreated from a .class file by IntelliJ IDEA.
 (powered by Fernflower decompiler)
 */
public class ContainsTest {
    private static final int LIST1FIRSTVALUE = 4;
    private static final int LIST1SECONDVALUE = 8;
    private static final int LIST1THIRDVALUE = 3;
    private static final int LIST1FOURTHVALUE = 12;
    private static final int LIST1FIFTHVALUE = 6;
    private static final int LIST2EXTRAVALUE1 = 5;
    private static final int LIST2EXTRAVALUE2 = 7;
    private static final int LIST2EXTRAVALUE3 = 9;
    private static final int LIST2EXTRAVALUE4 = 2;
    private static final String MSG1 = "containsSubsequence returns true when first LinkedList contains all elements";
    private static final String MSG2 = "when first LinkedList contains second";
    private static final String MSG3 = "containsSubsequence throws";

    /**
     * test.
     */
    @Test
    public void testContainsMiddle() {
        LinkedList var1 = new LinkedList();
        LinkedList var2 = new LinkedList();
        var1.add(LIST1FIRSTVALUE);
        var1.addLast(LIST1SECONDVALUE);
        var1.addLast(LIST1THIRDVALUE);
        var1.addLast(LIST1FOURTHVALUE);
        var1.addLast(LIST1FIFTHVALUE);
        var2.add(LIST1FIRSTVALUE);
        var2.add(LIST1SECONDVALUE);
        var2.add(LIST1THIRDVALUE);

        try {
            boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
            Assert.assertTrue("containsSubsequence returns false " + MSG2 + " in "
                    + "middle of list", var3);
        } catch (Exception var4) {
            Assert.fail(MSG3 + var4 + MSG2 + " in middle of list");
        }

    }

    /**
     * test.
     */
    @Test
    public void testContainsFront() {
        LinkedList var1 = new LinkedList();
        LinkedList var2 = new LinkedList();
        var1.add(LIST1FIRSTVALUE);
        var1.addLast(LIST1SECONDVALUE);
        var1.addLast(LIST1THIRDVALUE);
        var1.addLast(LIST1FOURTHVALUE);
        var1.addLast(LIST1FIFTHVALUE);
        var2.add(LIST1FIRSTVALUE);
        var2.add(LIST1SECONDVALUE);
        var2.add(LIST1THIRDVALUE);

        try {
            boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
            Assert.assertTrue("containsSubsequence returns false " + MSG2 + " at front of list", var3);
        } catch (Exception var4) {
            Assert.fail(MSG3 + var4 + MSG2 + "at front of list");
        }

    }

    /**
     * test.
     */
    @Test
    public void testContainsRear() {
        LinkedList var1 = new LinkedList();
        LinkedList var2 = new LinkedList();
        var1.add(LIST1FIRSTVALUE);
        var1.addLast(LIST1SECONDVALUE);
        var1.addLast(LIST1THIRDVALUE);
        var1.addLast(LIST1FOURTHVALUE);
        var1.addLast(LIST1FIFTHVALUE);
        var2.add(LIST1THIRDVALUE);
        var2.add(LIST1FOURTHVALUE);
        var2.add(LIST1FIFTHVALUE);

        try {
            boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
            Assert.assertTrue("containsSubsequence returns false " + MSG2 + " at rear of list", var3);
        } catch (Exception var4) {
            Assert.fail(MSG3 + var4 + MSG2 + " at rear of list");
        }

    }

    /**
     * test.
     */
    @Test
    public void testNoOverlap() {
        LinkedList var1 = new LinkedList();
        LinkedList var2 = new LinkedList();
        var1.add(LIST1FIRSTVALUE);
        var1.addLast(LIST1SECONDVALUE);
        var1.addLast(LIST1THIRDVALUE);
        var1.addLast(LIST1FOURTHVALUE);
        var1.addLast(LIST1FIFTHVALUE);
        var2.add(LIST2EXTRAVALUE1);
        var2.add(LIST2EXTRAVALUE3);
        var2.add(LIST2EXTRAVALUE4);

        try {
            boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
            Assert.assertFalse("containsSubsequence returns true when lists have no overlapping elements",
                    var3);
        } catch (Exception var4) {
            Assert.fail(MSG3 + var4 + " when lists have no overlapping elements");
        }

    }

    /**
     * test.
     */
    @Test
    public void testSomeOverlap() {
        LinkedList var1 = new LinkedList();
        LinkedList var2 = new LinkedList();
        var1.add(LIST1FIRSTVALUE);
        var1.addLast(LIST1SECONDVALUE);
        var1.addLast(LIST1THIRDVALUE);
        var1.addLast(LIST1FOURTHVALUE);
        var1.addLast(LIST1FIFTHVALUE);
        var2.add(LIST1SECONDVALUE);
        var2.add(LIST1THIRDVALUE);
        var2.add(LIST2EXTRAVALUE3);

        try {
            boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
            Assert.assertFalse("containsSubsequence returns true when lists have some overlapping elements "
                    + "but first does not contain all elements of second", var3);
        } catch (Exception var4) {
            Assert.fail(MSG3 + var4 + " when lists have some overlapping elements but first does not contain all "
                    + "elements of second");
        }

    }

    /**
     * test.
     */
    @Test
    public void testOverlapWrongOrder() {
        LinkedList var1 = new LinkedList();
        LinkedList var2 = new LinkedList();
        var1.add(LIST1FIRSTVALUE);
        var1.addLast(LIST1SECONDVALUE);
        var1.addLast(LIST1THIRDVALUE);
        var1.addLast(LIST1FOURTHVALUE);
        var1.addLast(LIST1FIFTHVALUE);
        var2.add(LIST1FOURTHVALUE);
        var2.add(LIST1SECONDVALUE);
        var2.add(LIST1FIFTHVALUE);

        try {
            boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
            Assert.assertFalse(MSG1 + "of second but not in same order", var3);
        } catch (Exception var4) {
            Assert.fail(MSG3 + var4 + " when first LinkedList contains all elements of second but not in same order");
        }

    }

    /**
     * test.
     */
    @Test
    public void testOverlapOtherElementsInSequenceInOne() {
        LinkedList var1 = new LinkedList();
        LinkedList var2 = new LinkedList();
        var1.add(LIST1FIRSTVALUE);
        var1.addLast(LIST1SECONDVALUE);
        var1.addLast(LIST1THIRDVALUE);
        var1.addLast(LIST1FOURTHVALUE);
        var1.addLast(LIST1FIFTHVALUE);
        var2.add(LIST1SECONDVALUE);
        var2.add(LIST1THIRDVALUE);
        var2.add(LIST1FIFTHVALUE);

        try {
            boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
            Assert.assertFalse(MSG1 + "of second but with other elements in sequence", var3);
        } catch (Exception var4) {
            Assert.fail(MSG3 + var4 + " when first LinkedList contains all elements of second but with other "
                    + "elements in sequence");
        }

    }

    /**
     * test.
     */
    @Test
    public void testOverlapOtherElementsInSequenceInTwo() {
        LinkedList var1 = new LinkedList();
        LinkedList var2 = new LinkedList();
        var1.add(LIST1FIRSTVALUE);
        var1.addLast(LIST1SECONDVALUE);
        var1.addLast(LIST1THIRDVALUE);
        var1.addLast(LIST1FOURTHVALUE);
        var1.addLast(LIST1FIFTHVALUE);
        var2.add(LIST1SECONDVALUE);
        var2.add(LIST1THIRDVALUE);
        var2.add(LIST2EXTRAVALUE3);
        var2.add(LIST1FOURTHVALUE);

        try {
            boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
            Assert.assertFalse(MSG1 + "of second but with other elements in sequence", var3);
        } catch (Exception var4) {
            Assert.fail(MSG3 + var4 + " when first LinkedList contains all elements of second but with other "
                    + "elements in sequence");
        }

    }

    /**
     * test.
     */
    @Test
    public void testOverlapAtEndOfOne() {
        LinkedList var1 = new LinkedList();
        LinkedList var2 = new LinkedList();
        var1.add(LIST1FIRSTVALUE);
        var1.addLast(LIST1SECONDVALUE);
        var1.addLast(LIST1THIRDVALUE);
        var1.addLast(LIST1FOURTHVALUE);
        var1.addLast(LIST1FIFTHVALUE);
        var2.add(LIST1FOURTHVALUE);
        var2.add(LIST1FIFTHVALUE);
        var2.add(LIST2EXTRAVALUE2);

        try {
            boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
            Assert.assertFalse("containsSubsequence returns true when lists overlap at end of first "
                    + "LinkedList but it does not contain all elements of second", var3);
        } catch (Exception var4) {
            Assert.fail(MSG3 + var4 + " when lists overlap at end of first LinkedList but it does not contain all "
                    + "elements of second");
        }

    }

    /**
     * test.
     */
    @Test
    public void testFirstNull() {
        LinkedList var2 = new LinkedList();
        var2.add(LIST1FOURTHVALUE);
        var2.add(LIST1FIFTHVALUE);
        var2.add(LIST2EXTRAVALUE2);

        try {
            boolean var3 = LinkedListUtils.containsSubsequence((LinkedList) null, var2);
            Assert.assertFalse("containsSubsequence returns true when first input is null",
                    var3);
        } catch (Exception var4) {
            Assert.fail(MSG3 + var4 + " when first input is null");
        }

    }

    /**
     * test.
     */
    @Test
    public void testSecondNull() {
        LinkedList var1 = new LinkedList();
        var1.add(LIST1FIRSTVALUE);
        var1.addLast(LIST1SECONDVALUE);
        var1.addLast(LIST1THIRDVALUE);
        var1.addLast(LIST1FOURTHVALUE);
        var1.addLast(LIST1FIFTHVALUE);

        try {
            boolean var3 = LinkedListUtils.containsSubsequence(var1, (LinkedList) null);
            Assert.assertFalse("containsSubsequence returns true when second input is null",
                    var3);
        } catch (Exception var4) {
            Assert.fail(MSG3 + var4 + " when second input is null");
        }

    }

    /**
     * test.
     */
    @Test
    public void testFirstEmpty() {
        LinkedList var1 = new LinkedList();
        LinkedList var2 = new LinkedList();
        var2.add(LIST1FOURTHVALUE);
        var2.add(LIST1FIFTHVALUE);
        var2.add(LIST2EXTRAVALUE2);

        try {
            boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
            Assert.assertFalse("containsSubsequence returns true when first input is empty",
                    var3);
        } catch (Exception var4) {
            Assert.fail(MSG3 + var4 + " when first input is empty");
        }

    }

    /**
     * test.
     */
    @Test
    public void testSecondEmpty() {
        LinkedList var1 = new LinkedList();
        LinkedList var2 = new LinkedList();
        var1.add(LIST1FIRSTVALUE);
        var1.addLast(LIST1SECONDVALUE);
        var1.addLast(LIST1THIRDVALUE);
        var1.addLast(LIST1FOURTHVALUE);
        var1.addLast(LIST1FIFTHVALUE);

        try {
            boolean var3 = LinkedListUtils.containsSubsequence(var1, var2);
            Assert.assertFalse("containsSubsequence returns true when second input is empty",
                    var3);
        } catch (Exception var4) {
            Assert.fail(MSG3 + var4 + " when second input is empty");
        }

    }
}
