import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Test insert sorted.
 * @author Denis Parra
 */
public class InsertSortedTest {
  /**
   * Default constructor.
   */
  public InsertSortedTest() { }

  /**
   * Set up.
   */
  @Before
  public void setUp() { }

  /**
   * Test insert in the middle list.
   */
  @Test
  public void testInsertMiddle() {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(3));
    localLinkedList.addLast(Integer.valueOf(8));
    localLinkedList.addLast(Integer.valueOf(11));
    LinkedListUtils.insertSorted(localLinkedList, 10);
    Assert.assertTrue("insertSorted creates LinkedList of incorrect size when "
            + "placing value in middle of list", localLinkedList.size() == 4);
    Assert.assertTrue("insertSorted does not correctly insert element when "
            + "placing value in middle of list", ((Integer) localLinkedList.get(0)).intValue() == 3);
    Assert.assertTrue("insertSorted does not correctly insert element when "
            + "placing value in middle of list", ((Integer) localLinkedList.get(1)).intValue() == 8);
    Assert.assertTrue("insertSorted does not correctly insert element when "
            + "placing value in middle of list", ((Integer) localLinkedList.get(2)).intValue() == 10);
    Assert.assertTrue("insertSorted does not correctly insert element when "
            + "placing value in middle of list", ((Integer) localLinkedList.get(3)).intValue() == 11);
  }

  /**
   * Test insert in the end of the list.
   */
  @Test
  public void testInsertEnd() {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(3));
    localLinkedList.addLast(Integer.valueOf(8));
    localLinkedList.addLast(Integer.valueOf(11));
    LinkedListUtils.insertSorted(localLinkedList, 14);
    Assert.assertTrue("insertSorted creates LinkedList of incorrect size when "
            + "placing value at end of list", localLinkedList.size() == 4);
    Assert.assertTrue("insertSorted does not correctly insert element when "
            + "placing value at end of list", ((Integer) localLinkedList.get(0)).intValue() == 3);
    Assert.assertTrue("insertSorted does not correctly insert element when "
            + "placing value at end of list", ((Integer) localLinkedList.get(1)).intValue() == 8);
    Assert.assertTrue("insertSorted does not correctly insert element when "
            + "placing value at end of list", ((Integer) localLinkedList.get(2)).intValue() == 11);
    Assert.assertTrue("insertSorted does not correctly insert element when "
            + "placing value at end of list", ((Integer) localLinkedList.get(3)).intValue() == 14);
  }

  /**
   * Test to insert in the front of the list.
   */
  @Test
  public void testInsertFront() {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(3));
    localLinkedList.addLast(Integer.valueOf(8));
    localLinkedList.addLast(Integer.valueOf(11));
    LinkedListUtils.insertSorted(localLinkedList, 1);
    Assert.assertTrue("insertSorted creates LinkedList of incorrect size when "
            + "placing value at front of list", localLinkedList.size() == 4);
    Assert.assertTrue("insertSorted does not correctly insert element when "
            + "placing value at front of list", ((Integer) localLinkedList.get(0)).intValue() == 1);
    Assert.assertTrue("insertSorted does not correctly insert element when "
            + "placing value at front of list", ((Integer) localLinkedList.get(1)).intValue() == 3);
    Assert.assertTrue("insertSorted does not correctly insert element when "
            + "placing value at front of list", ((Integer) localLinkedList.get(2)).intValue() == 8);
    Assert.assertTrue("insertSorted does not correctly insert element when "
            + "placing value at front of list", ((Integer) localLinkedList.get(3)).intValue() == 11);
  }

  /**
   * Test to insert in the middle of the list when element exist.
   */
  @Test
  public void testInsertMiddleEqualToExistingElement() {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(3));
    localLinkedList.addLast(Integer.valueOf(8));
    localLinkedList.addLast(Integer.valueOf(11));
    LinkedListUtils.insertSorted(localLinkedList, 8);
    Assert.assertTrue("insertSorted creates LinkedList of incorrect size when placing value "
            + "that is equal to value already in list", localLinkedList.size() == 4);
    Assert.assertTrue("insertSorted does not correctly insert element when placing value that "
            + "is equal to value already in list", ((Integer) localLinkedList.get(0)).intValue() == 3);
    Assert.assertTrue("insertSorted does not correctly insert element when placing value that "
            + "is equal to value already in list", ((Integer) localLinkedList.get(1)).intValue() == 8);
    Assert.assertTrue("insertSorted does not correctly insert element when placing value "
            + "that is equal to value already in list", ((Integer) localLinkedList.get(2)).intValue() == 8);
    Assert.assertTrue("insertSorted does not correctly insert element when placing value that "
            + "is equal to value already in list", ((Integer) localLinkedList.get(3)).intValue() == 11);
  }

  /**
   * Test when list is null.
   */
  @Test
  public void testNull() {
    LinkedListUtils.insertSorted(null, 0);
  }

  /**
   * Test when the list is empty.
   */
  @Test
  public void testInsertEmpty() {
    LinkedList localLinkedList = new LinkedList();
    LinkedListUtils.insertSorted(localLinkedList, 10);
    Assert.assertTrue("insertSorted creates LinkedList of incorrect size when "
            + "inserting into empty list", localLinkedList.size() == 1);
    Assert.assertTrue("insertSorted does not correctly insert element into "
            + "empty list", ((Integer) localLinkedList.get(0)).intValue() == 10);
  }
}
