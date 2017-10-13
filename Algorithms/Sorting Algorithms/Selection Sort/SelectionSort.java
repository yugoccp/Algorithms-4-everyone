import java.util.ArrayList;

public class SelectionSort<T extends Comparable<T>> extends SortAlgorithm<T> {
    @Override
    public void sort(ArrayList<T> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            int indiceMinimo = i;

            for (int j = i; j < arrayList.size(); j++) {
                if (arrayList.get(j).compareTo(arrayList.get(indiceMinimo)) < 0) {
                    indiceMinimo = j;
                }
            }

            swap(arrayList, i, indiceMinimo);
        }
    }

    @Override
    public void sort(T[] array) {
        final int N = array.length;

        for (int i = 0; i < N; i++) {
            int indiceMinimo = i;

            for (int j = i; j < N; j++) {
                if (array[j].compareTo(array[indiceMinimo]) < 0) {
                    indiceMinimo = j;
                }
            }

            swap(array, i, indiceMinimo);
        }
    }
}
