import java.util.ArrayList;

public class BubbleSort<T extends Comparable<T>> extends SortAlgorithm<T> {
    @Override
    public void sort(ArrayList<T> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.size() - i - 1; j++) {
                if (arrayList.get(j).compareTo(arrayList.get(j + 1)) > 0) {
                    swap(arrayList, j, j + 1);
                }
            }
        }
    }

    @Override
    public void sort(T[] array) {
        final int N = array.length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
}
