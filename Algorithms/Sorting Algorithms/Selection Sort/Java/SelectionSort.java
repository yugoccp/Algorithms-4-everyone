import java.util.List;

public class SelectionSort<T extends Comparable<T>> extends SortAlgorithm<T> {

    @Override
    public void sort(List<T> arrayList) {
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
        final int length = array.length;

        for (int i = 0; i < length; i++) {
            int indiceMinimo = i;

            for (int j = i; j < length; j++) {
                if (array[j].compareTo(array[indiceMinimo]) < 0) {
                    indiceMinimo = j;
                }
            }

            swap(array, i, indiceMinimo);
        }
    }
}
