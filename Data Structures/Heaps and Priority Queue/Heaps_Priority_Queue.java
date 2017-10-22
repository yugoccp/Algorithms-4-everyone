public class Heaps_Priority_Queue {
	//global heap/priority array
    public static int[] array;
    //heap soze
    public static int heapSize;

    public static void max_heapify(int i, int N) {
        //left node
        int left = 2 * i;
        //right node
        int right = 2 * i + 1;
        //initial largest -> i
        int largest = i;
        //check for larger condition
        if (left <= N) if (array[left] > array[largest]) largest = left;
        if (right <= N) if (array[right] > array[largest]) largest = right;
        //if largest != i , again maxheapify after swaping
        if (largest != i) {
            array[i] = array[largest] + array[i] - (array[largest] = array[i]);
            max_heapify(largest, N);
        }
    }

    public static void build_maxheap(int N) {
    	//Iterate through all N/2 first nodes and maxheapify each node
        for (int i = N / 2; i >= 1; i--) max_heapify(i, N);
    }

    public static void heap_sort(int N) {
    	//temporary heap size
        int heap_size = heapSize;
        //initial sorting
        build_maxheap(N);
        for (int i = heap_size; i >= 2; i--) {
        	//swap ith and 1st element
            array[i] = array[i] + array[1] - (array[1] = array[i]);
            //decrement heap size
            heap_size--;
            max_heapify(1, heap_size);
        }
    }

    public static int extractmaximum() {
        int temp = array[1];
        array[1] = array[heapSize] + array[1] - (array[heapSize] = array[1]);
        heapSize--;
        max_heapify(1, heapSize);
        return temp;
    }

    public static int maximum() {
        return array[1];
    }

    public static void increasevalue(int i, int val) {
        array[i] = val;
        while (i > 1 && array[i / 2] < array[i]) {
            array[i / 2] = array[i] + array[i / 2] - (array[i] = array[i / 2]);
            i /= 2;
        }

    }

    public static void insert(int val) {
        heapSize++;
        array[heapSize] = -1;
        increasevalue(heapSize, val);
    }

    public static void main(String as[]) {
        heapSize = 5;
        array = new int[]{0, 4, 3, 7, 9, 1, 0, 0, 0};
        build_maxheap(heapSize);
        insert(8);
        System.out.println(extractmaximum());
        System.out.println(extractmaximum());
    }


}
