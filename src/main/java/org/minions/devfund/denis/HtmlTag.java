
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * SD2x Homework #2 This class represents a single HTML tag. Please do not
 * change this code! Your solution will be evaluated using this version of the
 * class.
 */
public class HtmlTag {

    /**
     * Element name.
     */
    protected final String element;

    /**
     * Flag to check is open tag.
     */
    protected final boolean openTag;

    /**
     * Default constructor.
     * @param element element name.
     * @param isOpenTag value.
     */
    public HtmlTag(final String element, final boolean isOpenTag) {
        this.element = element.toLowerCase();
        openTag = isOpenTag;
    }

    /**
     * Method to get element name.
     * @return element name.
     */
    public String getElement() {
        return element;
    }

    /**
     * Method to check is open tag.
     * @return a boolean value.
     */
    public boolean isOpenTag() {
        return openTag && !isSelfClosing();
    }

    /**
     * Method to check if an object is equals to this.
     * @param other object to check.
     * @return boolean value.
     */
    public boolean matches(final HtmlTag other) {
        return other != null
                && element.equalsIgnoreCase(other.element)
                && openTag != other.openTag;
    }

    /**
     * Method to check if the current element is a self closing.
     * @return boolean value.
     */
    public boolean isSelfClosing() {
        return SELF_CLOSING_TAGS.contains(element);
    }

    /**
     * Equals method.
     * @param obj to compare.
     * @return result of compare an object with this.
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
     * Default hash code method.
     * @return a numeric representation of this.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.element);
        hash = 61 * hash + (this.openTag ? 1 : 0);
        return hash;
    }

    /**
     * To string method.
     * @return the current element in string value.
     */
    public String toString() {
        return "<" + (openTag ? "" : "/")
                + (element.equals("!--") ? "!-- --" : element) + ">";
    }

    /**
     * The remaining fields and functions are related to HTML file parsing.
     */
    // a set of tags that don't need to be matched (self-closing)
    private static final Set<String> SELF_CLOSING_TAGS = new HashSet<String>(
            Arrays.asList("!doctype", "!--", "?xml", "xml", "area", "base",
                    "basefont", "br", "col", "frame", "hr", "img",
                    "input", "link", "meta", "param"));

    /**
     * Static whitespace value.
     */
    protected static final String WHITESPACE = " \f\n\r\t";

    /**
     * Method to tokenize a string.
     * @param text to tokenize,
     * @return a Queue with GtmlTags elements.
     */
    public static Queue<HtmlTag> tokenize(final String text) {
        StringBuffer buf = new StringBuffer(text);
        Queue<HtmlTag> queue = new LinkedList<HtmlTag>();

        HtmlTag nextTag = nextTag(buf);
        while (nextTag != null) {
            queue.add(nextTag);
            nextTag = nextTag(buf);
        }
        return queue;
    }

    /**
     * Default iterator.
     * @param buf current buffer.
     * @return a HtmlTag value.
     */
    protected static HtmlTag nextTag(final StringBuffer buf) {
        int openBracket = buf.indexOf("<");
        int closeBracket = buf.indexOf(">");
        if (openBracket >= 0 && closeBracket > openBracket) {
            // check for HTML comments: <!-- -->
            int commentIndex = openBracket + 4;
            if (commentIndex <= buf.length()
                    && buf.substring(openBracket + 1, commentIndex).equals("!--")) {
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
