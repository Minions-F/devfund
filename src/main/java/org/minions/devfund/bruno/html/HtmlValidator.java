package org.minions.devfund.bruno.html;

import java.util.Queue;
import java.util.Stack;

public class HtmlValidator {
    public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
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