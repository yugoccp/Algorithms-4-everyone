import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Generic insertion sort algorithm
 * @author Solange U. Gasengayire
 * @since 23/10/2017
 */
public class InsertionSort<T extends Comparable<T>> {

    /**
     * Sort an array of elements of type T in place
     * @param data an array of n elements
     */
    public void sort(T[] data) {
        final int n = data.length;

        // We consider the first element data[0] to be sorted.
        // So we start with the second element --> thus j = 1
        for (int j = 1; j < n; j++) {
            T current = data[j];
            int k = j;

            // let's find the correct index k for current:
            while (k > 0 && data[k-1].compareTo(current) > 0) {
                data[k] = data[k-1];
                k--;
            }

            // At this point, we've reached the proper place for current
            data[k] = current;
        }
    }

    /**
     * Sort a list of elements of type T in place
     * @param data an ArrayList of size n
     */
    public void sort(ArrayList<T> data) {
        final int n = data.size();

        for (int j = 1; j < n; j++) {
            T current = data.get(j);
            int k = j;

            // let's find the correct index k for current:
            while (k > 0 && data.get(k-1).compareTo(current) > 0) {
                data.set(k, data.get(k-1));
                k--;
            }

            // At this point, we've reached the proper place for current
            data.set(k, current);
        }

    }

    /**
     * Return a new list of sorted elements of type T
     * IE: the sorting isn't done in place
     * @param elements a list of size n
     * @return a new list of sorted elements
     */
    public List<T> sort(final List<T> elements) {

        // Using a LinkedList is very efficient in adding elements in the middle
        // (compared to an ArrayList) since it's done by simply rearranging
        // pointers of the nodes in the list.
        final List<T> sortedList = new LinkedList<>();

        originalList: for (T element : elements) {
            for (int i = 0; i < sortedList.size(); i++) {
                if (element.compareTo(sortedList.get(i)) < 0) {
                    sortedList.add(i, element);
                    continue originalList;
                }
            }
            sortedList.add(sortedList.size(), element);
        }

        return sortedList;
    }

    /**
     * Tester method
     */
    public static void main(String... args) {

        // Example 1 : sorting an ArrayList of integers
        InsertionSort<Integer> sortIntegers = new InsertionSort<>();
        ArrayList<Integer> elements = new ArrayList<>(
                Arrays.asList(98, 56, 42, 78, 36, 4, 12, 2)
        );
        sortIntegers.sort(elements);
        elements.forEach(element -> System.out.print(element + " "));

        // Example 2 : sorting an array of strings
        InsertionSort<String> sortStrings = new InsertionSort<>();
        String[] data = {"echo", "foxtrot", "charlie", "alpha", "bravo", "delta"};
        sortStrings.sort(data);
        System.out.println("\n" + Arrays.toString(data));

        // Example 3 : sorting an empty array
        InsertionSort<Character> sortChars = new InsertionSort<>();
        Character[] chars = new Character[0];
        sortChars.sort(chars);
        System.out.println(Arrays.toString(chars));

        // Example 4 : sorting an already sorted ArrayList of Integers
        ArrayList<Integer> sorted = new ArrayList<>(
                Arrays.asList(2, 4, 12, 36, 42, 56, 78, 98)
        );
        sortIntegers.sort(sorted);
        elements.forEach(element -> System.out.print(element + " "));
        System.out.println();

        // Example 5 : sorting a list that is sorted in reverse order
        final List<String> words = Arrays.asList(
                "foxtrot", "echo", "delta", "charlie", "bravo", "alpha");
        List<String> result = sortStrings.sort(words);
        result.forEach(element -> System.out.print(element + " "));
        System.out.println();
    }

}
