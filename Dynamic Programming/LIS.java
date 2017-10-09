
public class LIS
{
 
  public static void main(String[] args)
  {
    

    int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
    int n = arr.length;
    int lis[] = new int[n];



    for (int i = 0; i < n; i++ )
      lis[i] = 1;
 
    /* Compute optimized LIS values in bottom up manner */
    for(int i=1;i<n;i++)
    {
      for(int j=0;j<n;j++)
      {
        if(arr[i] > arr[j] && lis[i] < lis[j] + 1)
        {
          lis[i] = lis[j] + 1;
        }
      }
    }
    

    int max=lis[0];


    /* Pick maximum of all LIS values */
    for (int i = 0; i < n; i++ )
    {
       if ( max < lis[i] )
            max = lis[i];
    }
 
    System.out.println("Length of lis is " + max  );
    
  }
 
}