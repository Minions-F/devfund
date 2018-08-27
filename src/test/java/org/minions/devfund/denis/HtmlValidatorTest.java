
import java.io.IOException;
import java.util.Queue;
import java.util.Stack;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test to validate HtmlValidator class.
 * @author Denis Parra
 */
public class HtmlValidatorTest {

    /**
     * Default path to files.
     */
    private String pathToTestFiles = "./homework2-files/";

    /**
     * Default constructor.
     */
    public HtmlValidatorTest() {
    }

    /**
     * Method to parse HTML's tags form file.
     * @param paramString path to parse.
     * @return a stack of a valid sequence of tags.
     */
    private Stack<HtmlTag> validateTestFile(final String paramString) {
        try {
            Queue localQueue = HtmlReader.getTagsFromHtmlFile(pathToTestFiles + paramString);
            return HtmlValidator.isValidHtml(localQueue);
        } catch (IOException localIOException) {
            System.out.println(
              "An exception (" + localIOException + ") occurred while trying to read " + paramString
              + ". Be sure it is in the root directory of your project or in the directory where you ran Java."
            );
        }
        return null;
    }

    /**
     * Test a valid HTML file.
     */
    @Test
    public void testFile1() {
        Stack localStack = validateTestFile("test1.html");
        Assert.assertTrue(
                "isValidHtml should return an empty stack for a valid HTML file input.", localStack.isEmpty()
        );
    }

    /**
     * Test file HTML ends without closing tags.
     */
    @Test
    public void testFile2() {
        Stack localStack1 = validateTestFile("test2.html");
        Stack localStack2 = new Stack();
        localStack2.push(new HtmlTag("html", true));
        localStack2.push(new HtmlTag("b", true));
        Assert.assertTrue(
                "isValidHtml should return Stack with unmatched elements when file ends without closing tags",
                localStack2.equals(localStack1)
        );
    }

    /**
     * Test a HTML file with incorrect closed tags.
     */
    @Test
    public void testFile3() {
        Stack localStack1 = validateTestFile("test3.html");
        Stack localStack2 = new Stack();
        localStack2.push(new HtmlTag("b", true));
        localStack2.push(new HtmlTag("i", true));
        Assert.assertTrue(
                "isValidHtml should return Stack with unmatched elements when tags are closed in incorrect order",
                localStack2.equals(localStack1)
        );
    }

    /**
     * Test HTML file with closing tags before opened.
     */
    @Test
    public void testFile4() {
        Stack localStack = validateTestFile("test4.html");
        Assert.assertNull(
                "isValidHtml should return null when encountering closing tag without matching opening tag", localStack
        );
    }

    /**
     * Test a valid HTML file.
     */
    @Test
    public void testFile5() {
        Stack localStack = validateTestFile("test5.html");
        Assert.assertTrue(
                "isValidHtml should return an empty stack for a valid HTML file input.", localStack.isEmpty()
        );
    }

    /**
     * Test HTML file with some tags are not closed.
     */
    @Test
    public void testFile6() {
        Stack localStack1 = validateTestFile("test6.html");
        Stack localStack2 = new Stack();
        localStack2.push(new HtmlTag("html", true));
        localStack2.push(new HtmlTag("head", true));
        localStack2.push(new HtmlTag("title", true));
        localStack2.push(new HtmlTag("p", true));
        Assert.assertTrue(
                "isValidHtml should return Stack with unmatched elements when some tags are not closed",
                localStack2.equals(localStack1)
        );
    }

    /**
     * Test a HTML file that containing only closing tags.
     */
    @Test
    public void testFile7() {
        Stack localStack = validateTestFile("test7.html");
        Assert.assertNull("isValidHtml should return null for HTML file containing only closing tag",
                localStack);
    }
}
