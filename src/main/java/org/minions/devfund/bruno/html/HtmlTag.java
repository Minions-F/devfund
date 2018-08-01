package org.minions.devfund.bruno.html;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Represents information about a single HTML tag.
 */
public class HtmlTag {

    private static final Set<String> SELF_CLOSING_TAGS = new HashSet<>(Arrays.asList("!doctype", "!--", "?xml",
            "xml", "area", "base", "basefont", "br", "col", "frame", "hr", "img", "input", "link", "meta", "param"));
    protected static final String WHITESPACE = " \f\n\r\t";
    protected final String element;
    protected final boolean openTag;

    /**
     * Initializes an instance of {@link HtmlTag}.
     *
     * @param element   element name.
     * @param isOpenTag boolean value.
     */
    public HtmlTag(final String element, final boolean isOpenTag) {
        this.element = element.toLowerCase();
        openTag = isOpenTag;
    }

    /**
     * Checks whether this is the opening tag.
     *
     * @return false if is open the tag.
     */
    public boolean isOpenTag() {
        return openTag && !isSelfClosing();
    }

    /**
     * Checks whether an HtmlTag other is the matching open/close tag to itself.
     *
     * @param other Htmltag object.
     * @return boolean.
     */
    public boolean matches(final HtmlTag other) {
        return other != null
                && element.equalsIgnoreCase(other.element)
                && openTag != other.openTag;
    }

    /**
     * Checks whether a tag is self-closing.
     *
     * @return if is self closing return true.
     */
    public boolean isSelfClosing() {
        return SELF_CLOSING_TAGS.contains(element);
    }

    /**
     * Checks if the Html tag object are equals.
     *
     * @param obj Html tag Object.
     * @return a boolean value.
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof HtmlTag) {
            HtmlTag other = (HtmlTag) obj;
            return element.equals(other.element)
                    && openTag == other.openTag;
        }
        return false;
    }

    /**
     * Overrides hash code.
     *
     * @return element.
     */
    @Override
    public int hashCode() {
        return element.hashCode();
    }

    /**
     * Builds tag according the element.
     *
     * @return a string.
     */
    public String toString() {
        return "<".concat(openTag ? "" : "/")
                .concat(element.equals("!--") ? "!-- --" : element).concat(">");
    }

    /**
     * Checks the text parameter is a tag and put in queue.
     *
     * @param text text from html file.
     * @return a queue.
     */
    public static Queue<HtmlTag> tokenize(final String text) {
        StringBuffer buf = new StringBuffer(text);
        Queue<HtmlTag> queue = new LinkedList<>();
        HtmlTag nextTag = nextTag(buf);
        while (nextTag != null) {
            queue.add(nextTag);
            nextTag = nextTag(buf);
        }
        return queue;
    }

    /**
     * Checks the buf parameter.
     *
     * @param buf text from html file.
     * @return a html tag.
     */
    protected static HtmlTag nextTag(final StringBuffer buf) {
        int openBracket = buf.indexOf("<");
        int closeBracket = buf.indexOf(">");
        if (openBracket >= 0 && closeBracket > openBracket) {
            // check for HTML comments: <!-- -->
            int commentIndex = openBracket + 4;
            if (commentIndex <= buf.length() && buf.substring(openBracket + 1, commentIndex).equals("!--")) {
                // look for closing comment tag -->
                closeBracket = buf.indexOf("-->", commentIndex);
                if (closeBracket < 0) {
                    return null;
                } else {
                    buf.insert(commentIndex, " ");
                    closeBracket += 3;    // advance to the closing bracket >
                }
            }
            String element = buf.substring(openBracket + 1, closeBracket).trim();

            // remove attributes
            for (int i = 0; i < WHITESPACE.length(); i++) {
                int attributeIndex = element.indexOf(WHITESPACE.charAt(i));
                if (attributeIndex >= 0) {
                    element = element.substring(0, attributeIndex);
                }
            }

            // determine whether opening or closing tag
            boolean isOpenTag = true;
            int checkForClosing = element.indexOf("/");
            if (checkForClosing == 0) {
                isOpenTag = false;
                element = element.substring(1);
            }
            element = element.replaceAll("[^a-zA-Z0-9!-]+", "");

            buf.delete(0, closeBracket + 1);
            return new HtmlTag(element, isOpenTag);
        } else {
            return null;
        }
    }
}
