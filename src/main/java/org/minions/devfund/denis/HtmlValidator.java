
import java.util.Queue;
import java.util.Stack;

/**
 * SD2x Homework #2 Implement the method below according to the specification in
 * the assignment description. Please be sure not to change the method
 * signature!
 */
public final class HtmlValidator {

    /**
     * Default constructor.
     */
    private HtmlValidator() { }

    /**
     * Method to check if a Queue of HtmlTag's is valid.
     * @param tags to check.
     * @return boolean value.
     */
    public static Stack<HtmlTag> isValidHtml(final Queue<HtmlTag> tags) {
        Stack<HtmlTag> result = new Stack<>();
        for (HtmlTag tag : tags) {
            if (!tag.isSelfClosing()) {
                if (tag.isOpenTag()) {
                    result.push(tag);
                } else {
                    if (result.isEmpty()) {
                        return null;
                    }
                    HtmlTag lasTag = result.peek();
                    if (!lasTag.getElement().equals(tag.getElement())) {
                        return result;
                    } else {
                        result.pop();
                    }
                }
            }
        }
        return result;
    }

}
