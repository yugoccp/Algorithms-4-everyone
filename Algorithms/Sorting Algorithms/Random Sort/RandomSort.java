import java.util.ArrayList;
import java.util.Collections;
public class RandomSort{
	
	public static final int ListCount = 5;
	
	public static void main(String [] args) {
		
		//creates Arraylist with n random Elements from 0 to 100
		System.out.print("unsorted list: ");
		ArrayList<Integer> intList = new ArrayList<Integer>(0);
		for(int i=0;i<ListCount;i++) {
			intList.add((int)(Math.random() * 100));
			System.out.print(intList.get(i)+" ");
		}		
		System.out.println();
		
		sort(intList);
		System.out.print("\nsorted List: ");
		for(int i=0;i<intList.size();i++) {
			System.out.print(intList.get(i)+" ");
		}		
		System.out.println();
	}
	
	private static ArrayList<Integer> sort(ArrayList<Integer> list){
		ArrayList<Integer> temp = list;
		int count = 1;
		
		while(!checkSorted(temp)) {
		System.out.print(count + " - ");
		count ++;
			Collections.shuffle(temp);
			for (int i=0;i<list.size();i++) {
				System.out.print(temp.get(i)+" ");
			}
			System.out.println();			
		} 
		return temp;
	}
	
	private static boolean checkSorted(ArrayList<Integer> list) {
	    boolean sorted = true;        
	    for (int i = 1; i < list.size(); i++) {
	        if (list.get(i-1).compareTo(list.get(i)) > 0) sorted = false;
	    }
	    return sorted;
	}
}