package org.minions.devfund.bruno.html;

import java.util.Queue;
import java.util.Stack;

/**
 * Represents the validate the information about a single HTML tags.
 */
public final class HtmlValidator {

    /**
     * Constructor private.
     */
    private HtmlValidator() {
        // Default Constructor.
    }

    /**
     * Takes as input a Queue of HtmlTags and return a Stack of HtmlTags that verifies the correctness
     * of the tag structure.
     *
     * @param tags queue tags.
     * @return a Stack.
     */
    public static Stack<HtmlTag> isValidHtml(final Queue<HtmlTag> tags) {
        Stack<HtmlTag> stack = new Stack<>();
        for (HtmlTag tag : tags) {
            if (tag.isOpenTag()) {
                stack.push(tag);
                continue;
            }
            if (tag.isSelfClosing()) {
                continue;
            }
            if (stack.isEmpty()) {
                return null;
            }
            if (stack.peek().matches(tag)) {
                stack.pop();
            } else {
                break;
            }
        }
        return stack;
    }
}
