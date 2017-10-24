import java.util.ArrayList;
import java.util.Collections;

public class QuickSort<T extends Comparable<T>> 
{
  private int partition(ArrayList<T> arrayList, int start, int end) {
    T pivot = arrayList.get(start);
    boolean done = false;
    int original = start;
    start += 1;
    while(!done) {
      // Iterate until "start" points to a value that is bigger than the pivot
      while (arrayList.get(start).compareTo( pivot) < 0 && start < end) {
        start += 1;
      }
      // Iterate until "end" points to a value that is smaller than the pivot
      while (arrayList.get(end).compareTo(pivot) >= 0 && start < end) {
        end -= 1;
      }
      // Swap them
      if (start < end) {
        Collections.swap(arrayList, start, end);
        start+=1;
      } else {
        done = true;
      }
  
    }

    // The Loop will always end with start=end. We must check if that position is smaller or bigger than the pivot
    if (arrayList.get(start).compareTo( pivot) > 0) {
	start -= 1;
    }
    // Put pivot in the middle
    Collections.swap(arrayList, original, start);
    return start;
  }
  
  private int partition(T[] arrayList, int start, int end) {
    T pivot = arrayList[start];
    boolean done = false;
    int original = start;
    start += 1;
    while(!done) {
      // Iterate until "start" points to a value that is bigger than the pivot
      while (arrayList[start].compareTo( pivot) < 0 && start < end) {
        start += 1;
      }
      // Iterate until "end" points to a value that is smaller than the pivot
      while (arrayList[end].compareTo(pivot) >= 0 && start < end) {
        end -= 1;
      }
      // Swap them
      if (start < end) {
        T temp = arrayList[start];
        arrayList[start] = arrayList[end];
        arrayList[end] = temp;
        start+=1;
      } else {
        done = true;
      }

    }

    // The Loop will always end with start=end. We must check if that position is smaller or bigger than the pivot
    if (arrayList[start].compareTo( pivot) > 0) {
      start -= 1;
    }
    // Put pivot in the middle
    arrayList[original] = arrayList[start];
    arrayList[start] = pivot;
    return start;

  }

  public void sort(ArrayList<T> arrayList) {
	sort(arrayList, 0, arrayList.size()-1);
  }
                      
  public void sort(ArrayList<T> arrayList, int start, int end) {
    if (start < end) {
      int split = partition(arrayList, start, end);
      sort(arrayList, start, split-1);
      sort(arrayList, split+1, end);
    }
  }

  public void sort(T[] array) {
	sort(array, 0, array.length-1);
  }
  
  public void sort(T[] arrayList, int start, int end) {
    if (start < end) {
      int split = partition(arrayList, start, end);
      sort(arrayList, start, split-1);
      sort(arrayList, split+1, end);
    }
  }
}
