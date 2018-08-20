import java.util.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test remove maximum values.
 * @author Denis Parra
 */
public class RemoveMaximumValuesTest {
   /**
   * Default constructor.
   */
  public RemoveMaximumValuesTest() { }

  /**
   * set up.
   */
  @Before
  public void setUp() { }

  /**
   * Test when list is null.
   */
  @Test
  public void testNull() {
    LinkedListUtils.removeMaximumValues(null, 2);
  }

  /**
   * Test when amount value to remove is negative.
   */
  @Test
  public void testNegativeSize() {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("doge");
    localLinkedList.add("cat");
    LinkedListUtils.removeMaximumValues(localLinkedList, -1);
    Assert.assertFalse(localLinkedList.isEmpty());
  }

  /**
   * Test when list is empty.
   */
  @Test
  public void testInsertEmpty() {
    LinkedList localLinkedList = new LinkedList();
    LinkedListUtils.removeMaximumValues(localLinkedList, 1);
    Assert.assertTrue("removeMaximumValues adds elements to list when input "
            + "LinkedList is empty", localLinkedList.isEmpty());
  }

  /**
   * Test when amount values to remove is greater than list size.
   */
  @Test
  public void testRemoveGreaterThanSize() {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("doge");
    LinkedListUtils.removeMaximumValues(localLinkedList, 2);
    Assert.assertTrue("removeMaximumValues does not remove all elements when number of "
            + "elements to remove is greater than size of input LinkedList", localLinkedList.isEmpty());
  }

  /**
   * Test when amount values to remove is equals list size.
   */
  @Test
  public void testRemoveEqualsSize() {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("doge");
    LinkedListUtils.removeMaximumValues(localLinkedList, 1);
    Assert.assertTrue("removeMaximumValues does not remove all elements when number of elements "
            + "to remove equals size of input LinkedList", localLinkedList.isEmpty());
  }

  /**
   * Test when a element is not repeated more than once.
   */
  @Test
  public void testEachMaxAppearsOnce() {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("doge");
    localLinkedList.add("cat");
    localLinkedList.add("kangaroo");
    localLinkedList.add("koala");
    localLinkedList.add("bear");
    LinkedListUtils.removeMaximumValues(localLinkedList, 2);
    Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements "
            + "to remove is less than size of input", ((String) localLinkedList.get(0)).equals("doge"));
    Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements "
            + "to remove is less than size of input", ((String) localLinkedList.get(1)).equals("cat"));
    Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements "
            + "to remove is less than size of input", ((String) localLinkedList.get(2)).equals("bear"));
  }

  /**
   * Test when a element is repeated more than once.
   */
  @Test
  public void testMaxValuesAppearMoreThanOnce() {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add("doge");
    localLinkedList.add("kangaroo");
    localLinkedList.add("cat");
    localLinkedList.add("kangaroo");
    localLinkedList.add("koala");
    localLinkedList.add("bear");
    localLinkedList.add("doge");
    localLinkedList.add("koala");
    localLinkedList.add("kangaroo");
    LinkedListUtils.removeMaximumValues(localLinkedList, 2);
    Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements "
            + "to remove is less than size of input and maximum elements appear "
            + "more than once", ((String) localLinkedList.get(0)).equals("doge"));
    Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements "
            + "to remove is less than size of input and maximum elements appear "
            + "more than once", ((String) localLinkedList.get(1)).equals("cat"));
    Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements "
            + "to remove is less than size of input and maximum elements appear "
            + "more than once", ((String) localLinkedList.get(2)).equals("bear"));
    Assert.assertTrue("removeMaximumValues does not have elements in correct order when number of elements "
            + "to remove is less than size of input and maximum elements appear "
            + "more than once", ((String) localLinkedList.get(3)).equals("doge"));
  }
}
