import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Casper Rysgaard
 */
public class MergeSort<T extends MaxValue<T> & Comparable<T>> extends SortAlgorithm<T>
{
    /*
     * java class used for sorting any type of list
     */
    
    @Override
    public void sort(ArrayList<T> arrayList)
    {
        mergeSortSplit(arrayList, 0, arrayList.size()-1);
    }
    
    private void mergeSortSplit(ArrayList<T> listToSort, int start, int end)
    {
        if (start < end)
        {
            int middle = (start + end) / 2;
            mergeSortSplit(listToSort, start, middle);
            mergeSortSplit(listToSort, middle+1, end);
            merge(listToSort, start, middle, end);
        }
    }
    
    private void merge(ArrayList<T> listToSort, int start, int middle, int end)
    {
        ArrayList<T> A = new ArrayList<T>(listToSort.subList(start, middle+1));
        ArrayList<T> B = new ArrayList<T>(listToSort.subList(middle+1, end+1));
        A.add(A.get(0).getMaxObject());
        B.add(B.get(0).getMaxObject());
        
        int i = 0;
        int j = 0;
        
        for (int k = start; k <= end; k++)
        {
            if (A.get(i).compareTo(B.get(j)) <= 0)
            {
                listToSort.set(k, A.get(i));
                i++;
            }
            else
            {
                listToSort.set(k, B.get(j));
                j++;
            }
        }
    }
    
    
    @Override
    public void sort(T[] array)
    {
        // To be added
    }
}
