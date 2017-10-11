#include "Define.cpp"


void BubbleSort(int v[], int N)
{
	int flag = 0;
    for(int i = 0; i < N; i++)
    {
    	flag = 0;
        for(int j = 0; j < N - i - 1; j++){
            if(v[j] > v[j+1]){
                swap(v[j+1], v[j]);
                flag =1;
            }
        }
        if(flag == 0)
        	break;
    }
}
