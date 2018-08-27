
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/**
 * SD2x Homework #2 This class contains a method that will read an HTML file and
 * convert it to a Queue of HtmlTags. It is simply provided as a convenience
 * class for you to use during your testing. You do not need to submit this
 * code.
 */
public final class HtmlReader {

    /**
     * Default constructor.
     */
    private HtmlReader() { }

    /**
     * Method to get tags from file.
     * @param filename file path to get tags.
     * @return a Queue of tags.
     * @throws IOException when file is corrupt or invalid.
     */
    public static Queue<HtmlTag> getTagsFromHtmlFile(final String filename) throws IOException {
        StringBuffer buffer;
        try (InputStream stream = new FileInputStream(filename)) {
            buffer = new StringBuffer();
            int ch;
            while ((ch = stream.read()) > 0) {
                buffer.append((char) ch);
            }
        }
        String htmlFileString = buffer.toString();
        return HtmlTag.tokenize(htmlFileString);
    }

}
