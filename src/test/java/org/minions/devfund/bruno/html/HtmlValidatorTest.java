package org.minions.devfund.bruno.html;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Queue;
import java.util.Stack;

import static org.junit.Assert.assertTrue;
import static org.minions.devfund.bruno.html.HtmlValidator.isValidHtml;

/**
 * Tests for html validator.
 */
public class HtmlValidatorTest {

    /**
     * Test file 1.
     */
    @Test
    public void testFile1() {
        try {
            Stack<HtmlTag> var1 = this.validateTestFile("test1.html");
            if (var1 == null) {
                Assert.fail("isValidHtml returns null for a valid HTML file input.");
            }
            assertTrue("isValidHtml should return an empty stack for a valid HTML file input.",
                    var1.isEmpty());
        } catch (Exception var2) {
            Assert.fail("isValidHtml throws " + var2 + " for valid HTML file input");
        }
    }

    /**
     * Test file 2.
     */
    @Test
    public void testFile2() {
        try {
            Stack<HtmlTag> var1 = this.validateTestFile("test2.html");
            if (var1 == null) {
                Assert.fail("isValidHtml returns null when file ends without closing tags");
            }
            Stack<HtmlTag> var2 = new Stack<>();
            var2.push(new HtmlTag("html", true));
            var2.push(new HtmlTag("b", true));
            Assert.assertEquals(
                    "Should return Stack with unmatched elements when file ends without closing tags",
                    var2, var1);
        } catch (Exception var3) {
            Assert.fail("isValidHtml throws " + var3 + " when file ends without closing tags");
        }
    }

    /**
     * Test file 3.
     */
    @Test
    public void testFile3() {
        try {
            Stack<HtmlTag> var1 = this.validateTestFile("test3.html");
            if (var1 == null) {
                Assert.fail("isValidHtml returns null when tags are closed in incorrect order");
            }
            Stack<HtmlTag> var2 = new Stack<>();
            var2.push(new HtmlTag("b", true));
            var2.push(new HtmlTag("i", true));
            Assert.assertEquals(
                    "Should return Stack with unmatched elements when tags are closed in incorrect order",
                    var2, var1);
        } catch (Exception var3) {
            Assert.fail("isValidHtml throws " + var3 + " when tags are closed in incorrect order");
        }

    }

    /**
     * Test file 4.
     */
    @Test
    public void testFile4() {
        try {
            Stack<HtmlTag> var1 = this.validateTestFile("test4.html");
            Assert.assertNull("Should return null when encountering closing tag without matching opening tag", var1);
        } catch (Exception var2) {
            Assert.fail("isValidHtml throws " + var2 + " when encountering closing tag without matching opening tag");
        }
    }

    /**
     * Test file 5.
     */
    @Test
    public void testFile5() {
        try {
            Stack<HtmlTag> var1 = this.validateTestFile("test5.html");
            if (var1 == null) {
                Assert.fail("isValidHtml returns null for a valid HTML file input.");
            }
            assertTrue("isValidHtml should return an empty stack for a valid HTML file input.",
                    var1.isEmpty());
        } catch (Exception var2) {
            Assert.fail("isValidHtml throws " + var2 + " for a valid HTML file input.");
        }
    }

    /**
     * Test file 6.
     */
    @Test
    public void testFile6() {
        try {
            Stack<HtmlTag> var1 = this.validateTestFile("test6.html");
            if (var1 == null) {
                Assert.fail("isValidHtml returns null when some tags are not closed");
            }
            Stack<HtmlTag> var2 = new Stack<>();
            var2.push(new HtmlTag("html", true));
            var2.push(new HtmlTag("head", true));
            var2.push(new HtmlTag("title", true));
            var2.push(new HtmlTag("p", true));
            Assert.assertEquals(
                    "isValidHtml should return Stack with unmatched elements when some tags are not closed",
                    var2, var1);
        } catch (Exception var3) {
            Assert.fail("isValidHtml throws " + var3 + " when some tags are not closed");
        }

    }

    /**
     * Test file 7.
     */
    @Test
    public void testFile7() {
        try {
            Stack<HtmlTag> var1 = this.validateTestFile("test7.html");
            Assert.assertNull(
                    "isValidHtml should return null for HTML file containing only closing tag", var1);
        } catch (Exception var2) {
            Assert.fail("isValidHtml throws " + var2 + " for HTML file containing only closing tag");
        }

    }

    /**
     * Validates the files.
     *
     * @param var1 name file.
     * @return Stack tags.
     */
    private Stack<HtmlTag> validateTestFile(final String var1) {
        String pathToTestFiles = "src/test/java/org/minions/devfund/bruno/html/";
        Queue<HtmlTag> var2 = HtmlReader.getTagsFromHtmlFile(pathToTestFiles.concat(var1));
        return isValidHtml(var2);
    }

    /**
     * Verifies constructor private.
     *
     * @throws NoSuchMethodException     throw when no private constructor is defined.
     * @throws IllegalAccessException    throw when can not access to the constructor.
     * @throws InvocationTargetException throw when can not be perform a invocation.
     * @throws InstantiationException    throw when a instantiation can not be performed.
     */
    @Test
    public void privateConstructorTest() throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Constructor<HtmlReader> constructor = HtmlReader.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }


    /**
     * Verifies HtmlValidator constructor private.
     *
     * @throws NoSuchMethodException     throw when no private constructor is defined.
     * @throws IllegalAccessException    throw when can not access to the constructor.
     * @throws InvocationTargetException throw when can not be perform a invocation.
     * @throws InstantiationException    throw when a instantiation can not be performed.
     */
    @Test

    public void privateConstructorHtmlValidatorTest() throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Constructor<HtmlValidator> constructor = HtmlValidator.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }
}
