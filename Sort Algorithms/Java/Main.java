import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SortAlgorithm<Integer> selectionSort = new SelectionSort<>();
        Integer[] array = new Integer[]{3, 5, 6, 8, 7};
        selectionSort.sort(array);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(8);
        arrayList.add(7);

        selectionSort.sort(arrayList);

        for (Integer i : array) {
            System.out.println(i);
        }

        for (Integer i : arrayList) {
            System.out.println(i);
        }
    }
}
