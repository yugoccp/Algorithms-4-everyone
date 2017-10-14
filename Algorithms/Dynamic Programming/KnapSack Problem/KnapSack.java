// A Dynamic Programming based solution for 0-1 Knapsack problem
/*Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).*/
//Time Complexity: O(nW) where n is the number of items and W is the capacity of knapsack.

import java.util.Scanner;

/**
 *
 * @author vedi
 */
public class KnapSack {
     //A utility function that returns maximum of two integers
    static int max(int a, int b) 
    { return (a > b)? a : b; }
      
   // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSack(int W, int wt[], int val[], int n)
    {
         int i, w;
     int K[][] = new int[n+1][W+1];
      
     // Build table K[][] in bottom up manner
     //recomputations of same subproblems can be avoided by constructing a temporary array K[][] in bottom up manner
     for (i = 0; i <= n; i++)
     {
         for (w = 0; w <= W; w++)
         {
             if (i==0 || w==0)
                  K[i][w] = 0;
             else if (wt[i-1] <= w)
                   K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
             else
                   K[i][w] = K[i-1][w];
         }
      }
      
      return K[n][W];
}
    public static void main(String args[])
    { int n,i;
      // n is number of items
      System.out.println("Enter the number of items");
      Scanner sc= new Scanner(System.in);
      n=sc.nextInt();
      System.out.println("\nEnter the value of items");
      int val[] = new int[n];
      // val array stores value of items
      for(i=0;i<n;i++)
        val[i]=sc.nextInt();
      int wt[] = new int[n];
      // wt array stores weight of items
      System.out.println("\nEnter the weight of items");
      for(i=0;i<n;i++)
          wt[i]=sc.nextInt();
      int  W;
      // W stores the maximum weight knapsack can carry
      System.out.println("\nEnter the weight of Knapsack");
      W=sc.nextInt();
      System.out.println("\nMaximum value of the items that can be taken is: ");
      System.out.println(knapSack(W, wt, val, n));
    }
}

