import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Test;
/**
 * Test contains.
 * @author root
 */
public class ContainsTest {

  /**
   * default constructor.
   */
  public ContainsTest() { }

  /**
   * Set up.
   */
  @org.junit.Before
  public void setUp() { }

  /**
   * Test when subsequence start in the middle.
   */
  @Test
  public void testContainsMiddle() {
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localLinkedList1.add(Integer.valueOf(4));
    localLinkedList1.addLast(Integer.valueOf(8));
    localLinkedList1.addLast(Integer.valueOf(3));
    localLinkedList1.addLast(Integer.valueOf(12));
    localLinkedList1.addLast(Integer.valueOf(6));
    localLinkedList2.add(Integer.valueOf(8));
    localLinkedList2.add(Integer.valueOf(3));
    localLinkedList2.add(Integer.valueOf(12));
    boolean bool = LinkedListUtils.containsSubsequence(localLinkedList1, localLinkedList2);
    Assert.assertTrue(
            "containsSubsequence returns false when first LinkedList contains second in middle of list", bool
    );
  }

  /**
   * Test when subsequence start in front.
   */
  @Test
  public void testContainsFront() {
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localLinkedList1.add(Integer.valueOf(4));
    localLinkedList1.addLast(Integer.valueOf(8));
    localLinkedList1.addLast(Integer.valueOf(3));
    localLinkedList1.addLast(Integer.valueOf(12));
    localLinkedList1.addLast(Integer.valueOf(6));
    localLinkedList2.add(Integer.valueOf(4));
    localLinkedList2.add(Integer.valueOf(8));
    localLinkedList2.add(Integer.valueOf(3));
    boolean bool = LinkedListUtils.containsSubsequence(localLinkedList1, localLinkedList2);
    Assert.assertTrue("containsSubsequence returns false when first LinkedList contains second at front of list", bool);
  }

  /**
   * Test when subsequence is in rear of the list.
   */
  @Test
  public void testContainsRear() {
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localLinkedList1.add(Integer.valueOf(4));
    localLinkedList1.addLast(Integer.valueOf(8));
    localLinkedList1.addLast(Integer.valueOf(3));
    localLinkedList1.addLast(Integer.valueOf(12));
    localLinkedList1.addLast(Integer.valueOf(6));
    localLinkedList2.add(Integer.valueOf(3));
    localLinkedList2.add(Integer.valueOf(12));
    localLinkedList2.add(Integer.valueOf(6));
    boolean bool = LinkedListUtils.containsSubsequence(localLinkedList1, localLinkedList2);
    Assert.assertTrue("containsSubsequence returns false when first LinkedList contains second at rear of list", bool);
  }

  /**
   * Test when the subsequence no exist in the list.
   */
  @Test
  public void testNoOverlap() {
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localLinkedList1.add(Integer.valueOf(4));
    localLinkedList1.addLast(Integer.valueOf(8));
    localLinkedList1.addLast(Integer.valueOf(3));
    localLinkedList1.addLast(Integer.valueOf(12));
    localLinkedList1.addLast(Integer.valueOf(6));
    localLinkedList2.add(Integer.valueOf(5));
    localLinkedList2.add(Integer.valueOf(9));
    localLinkedList2.add(Integer.valueOf(2));
    boolean bool = LinkedListUtils.containsSubsequence(localLinkedList1, localLinkedList2);
    Assert.assertFalse("containsSubsequence returns true when lists have no overlapping elements", bool);
  }

  /**
   * Test when the subsequence no exist in the list.
   */
  @Test
  public void testSomeOverlap() {
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localLinkedList1.add(Integer.valueOf(4));
    localLinkedList1.addLast(Integer.valueOf(8));
    localLinkedList1.addLast(Integer.valueOf(3));
    localLinkedList1.addLast(Integer.valueOf(12));
    localLinkedList1.addLast(Integer.valueOf(6));
    localLinkedList2.add(Integer.valueOf(8));
    localLinkedList2.add(Integer.valueOf(3));
    localLinkedList2.add(Integer.valueOf(9));
    boolean bool = LinkedListUtils.containsSubsequence(localLinkedList1, localLinkedList2);
    Assert.assertFalse("containsSubsequence returns true when lists have some "
            + "overlapping elements but first does not contain all elements of second", bool
    );
  }

  /**
   * Test when the subsequence no exist in the list.
   */
  @Test
  public void testOverlapWrongOrder() {
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localLinkedList1.add(Integer.valueOf(4));
    localLinkedList1.addLast(Integer.valueOf(8));
    localLinkedList1.addLast(Integer.valueOf(3));
    localLinkedList1.addLast(Integer.valueOf(12));
    localLinkedList1.addLast(Integer.valueOf(6));
    localLinkedList2.add(Integer.valueOf(12));
    localLinkedList2.add(Integer.valueOf(8));
    localLinkedList2.add(Integer.valueOf(6));
    boolean bool = LinkedListUtils.containsSubsequence(localLinkedList1, localLinkedList2);
    Assert.assertFalse("containsSubsequence returns true when first LinkedList "
            + "contains all elements of second but not in same order", bool
    );
  }

  /**
   * Test when the subsequence no exist in the list.
   */
  @Test
  public void testOverlapOtherElementsInSequenceInOne() {
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localLinkedList1.add(Integer.valueOf(4));
    localLinkedList1.addLast(Integer.valueOf(8));
    localLinkedList1.addLast(Integer.valueOf(3));
    localLinkedList1.addLast(Integer.valueOf(12));
    localLinkedList1.addLast(Integer.valueOf(6));
    localLinkedList2.add(Integer.valueOf(8));
    localLinkedList2.add(Integer.valueOf(3));
    localLinkedList2.add(Integer.valueOf(6));
    boolean bool = LinkedListUtils.containsSubsequence(localLinkedList1, localLinkedList2);
    Assert.assertFalse("containsSubsequence returns true when first LinkedList "
            + "contains all elements of second but with other elements in sequence", bool
    );
  }

  /**
   * Test when the subsequence no exist in the list.
   */
  @Test
  public void testOverlapOtherElementsInSequenceInTwo() {
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localLinkedList1.add(Integer.valueOf(4));
    localLinkedList1.addLast(Integer.valueOf(8));
    localLinkedList1.addLast(Integer.valueOf(3));
    localLinkedList1.addLast(Integer.valueOf(12));
    localLinkedList1.addLast(Integer.valueOf(6));
    localLinkedList2.add(Integer.valueOf(8));
    localLinkedList2.add(Integer.valueOf(3));
    localLinkedList2.add(Integer.valueOf(9));
    localLinkedList2.add(Integer.valueOf(12));
    boolean bool = LinkedListUtils.containsSubsequence(localLinkedList1, localLinkedList2);
    Assert.assertFalse("containsSubsequence returns true when first LinkedList "
            + "contains all elements of second but with other elements in sequence", bool
    );
  }

  /**
   * Test when the subsequence no exist in the list.
   */
  @Test
  public void testOverlapAtEndOfOne() {
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localLinkedList1.add(Integer.valueOf(4));
    localLinkedList1.addLast(Integer.valueOf(8));
    localLinkedList1.addLast(Integer.valueOf(3));
    localLinkedList1.addLast(Integer.valueOf(12));
    localLinkedList1.addLast(Integer.valueOf(6));
    localLinkedList2.add(Integer.valueOf(12));
    localLinkedList2.add(Integer.valueOf(6));
    localLinkedList2.add(Integer.valueOf(7));
    boolean bool = LinkedListUtils.containsSubsequence(localLinkedList1, localLinkedList2);
    Assert.assertFalse("containsSubsequence returns true when lists overlap at "
            + "end of first LinkedList but it does not contain all elements of second", bool
    );
  }

  /**
   * Test when the subsequence no exist in the list.
   */
  @Test
  public void testFirstNull() {
    LinkedList localLinkedList2 = new LinkedList();
    boolean bool = LinkedListUtils.containsSubsequence(null, localLinkedList2);
    Assert.assertFalse("containsSubsequence returns true when first input is null", bool);
  }

  /**
   * Test when second list is null.
   */
  @Test
  public void testSecondNull() {
    LinkedList localLinkedList1 = new LinkedList();
    boolean bool = LinkedListUtils.containsSubsequence(localLinkedList1, null);
    Assert.assertFalse("containsSubsequence returns true when second input is null", bool);
  }

  /**
   * Test when the first list is empty.
   */
  @Test
  public void testFirstEmpty() {
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localLinkedList2.add(Integer.valueOf(12));
    localLinkedList2.add(Integer.valueOf(6));
    localLinkedList2.add(Integer.valueOf(7));
    boolean bool = LinkedListUtils.containsSubsequence(localLinkedList1, localLinkedList2);
    Assert.assertFalse("containsSubsequence returns true when first input is empty", bool);
  }

  /**
   * Test when second list is empty.
   */
  @Test
  public void testSecondEmpty() {
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    localLinkedList1.add(Integer.valueOf(4));
    localLinkedList1.addLast(Integer.valueOf(8));
    localLinkedList1.addLast(Integer.valueOf(3));
    localLinkedList1.addLast(Integer.valueOf(12));
    localLinkedList1.addLast(Integer.valueOf(6));
    boolean bool = LinkedListUtils.containsSubsequence(localLinkedList1, localLinkedList2);
    Assert.assertFalse("containsSubsequence returns true when second input is empty", bool);
  }
}
