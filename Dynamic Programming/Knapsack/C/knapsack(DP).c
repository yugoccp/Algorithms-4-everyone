#include<conio.h>
#include<stdio.h>
#define MAX 10
int K[MAX][MAX];
int max(int a, int b) { return (a > b)? a : b; }


int knapSack(int W, int wt[], int val[], int n)
{
	int i, w;

	for (i = 0; i <= n; i++)
	{
		for (w = 0; w <= W; w++)
		{
			if (i==0 || w==0)
				K[i][w] = 0;
			else if (wt[i-1] <= w)

//                current value     one row back   go back by the weight
				K[i][w] = max(    val[i-1] +       K [i-1]          [w-wt[i-1]],
//If the current weight not included then take last rows value
					K[i-1][w]);
	   else  //weight not enought to fit in knapsack
	   	K[i][w] = K[i-1][w];
	}
}

return K[n][W];
}

void main()
{
	int i,W,n,profit[MAX],weight[MAX];
	
	clrscr();
	printf("Enter the total number of items\n");
	scanf("%d",&n);
	printf("Enter the total weight\n");
	scanf("%d",&W);
	printf("Enter the profits and weights\n");

	for(i=0;i<n;i++) {
		scanf("%d%d",&profit[i],&weight[i]);
	}
	
	printf("Total profit is %d", knapSack(W, weight, profit, n));
	getch();
}
