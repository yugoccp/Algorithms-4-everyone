#include <stdio.h>

#include "bubbleSort.h"

static void swap(int *p, int *q)
{
        int t = *p;
        *p = *q;
        *q = t;
}

void bubbleSort(int * arr, const size_t sz)
{
        int swapped = 1;
        while(swapped) {
                swapped = 0;
                for(int i = 0; i < sz - 1; ++i) {
                        if(arr[i] > arr[i+1]) {
                                swap(arr + i, arr + i + 1);
                                swapped = 1;
                        }
                }
        }
}
