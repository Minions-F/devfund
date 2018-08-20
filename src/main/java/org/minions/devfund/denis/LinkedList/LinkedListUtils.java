
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */
public final class LinkedListUtils {

    /**
     * Constructor.
     */
    private LinkedListUtils() {
    }

    /**
     * Method to insert a number in a sorted list.
     * @param list where insert.
     * @param value to insert.
     */
    public static void insertSorted(final LinkedList<Integer> list, final int value) {
        if (list == null) {
            return;
        }
        if (list.isEmpty()) {
            list.add(value);
        } else {
            long indexGreather = list.stream().filter(number -> number < value).count();
            list.add((int) indexGreather, value);
        }
    }

    /**
     * Method to remove maximum words of a list.
     * @param list to remove elements.
     * @param amount elements to remove.
     */
    public static void removeMaximumValues(final LinkedList<String> list, final int amount) {
        if (list != null && !list.isEmpty() && amount > 0) {
            int length = list.size();
            int wordsToFind = length > amount ? amount : length;
            for (int i = 0; i < wordsToFind; i++) {
                List<String> aux = list.stream().sorted().collect(Collectors.toList());
                String word = aux.get(aux.size() - 1);
                list.removeIf(wordToRemove -> wordToRemove.equals(word));
            }
        }
    }

    /**
     * Method to verify if a subsequence exist in a list.
     * @param one list.
     * @param two to search.
     * @return true if a subsequence or no in otherwise.
     */
    public static boolean containsSubsequence(final LinkedList<Integer> one, final LinkedList<Integer> two) {
        LinkedList<Integer> aux = one;
        if (one == null | two == null) {
            return false;
        }
        if (two.isEmpty()) {
            return false;
        }
        while (aux.size() >= two.size()) {
            LinkedList<Integer> auxTwo = new LinkedList<>(two);
            boolean isSubsequence = true;
            for (int i = 0; i < two.size(); i++) {
                isSubsequence &= aux.get(i) == auxTwo.removeFirst();
            }
            if (isSubsequence) {
                return true;
            } else {
                aux.removeFirst();
            }
        }
        return false;
    }

}
