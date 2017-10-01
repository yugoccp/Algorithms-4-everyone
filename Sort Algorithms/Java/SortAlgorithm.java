import java.util.ArrayList;

public abstract class SortAlgorithm<T extends Comparable<T>> {
    abstract public void sort(ArrayList<T> arrayList);

    abstract public void sort(T[] array);

    // ------------

    protected final void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    protected final void swap(ArrayList<T> array, int i, int j) {
        T tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }
}
