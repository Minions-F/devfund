package org.minions.devfund.bruno.html;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/**
 * This class contains a method that will read an HTML file and convert it to a Queue of HtmlTags.
 */
public final class HtmlReader {

    /**
     * Constructor private.
     */
    private HtmlReader() {
        // Default Constructor.
    }

    /**
     * Reads in the path to an HTML file and separates it into tokens.
     *
     * @param filename path with the file.
     * @return a queue.
     */
    public static Queue<HtmlTag> getTagsFromHtmlFile(final String filename) {
        StringBuilder buffer = new StringBuilder();
        try (InputStream stream = new FileInputStream(filename)) {
            int ch;
            while ((ch = stream.read()) > 0) {
                buffer.append((char) ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String htmlFileString = buffer.toString();
        return HtmlTag.tokenize(htmlFileString);
    }
}
