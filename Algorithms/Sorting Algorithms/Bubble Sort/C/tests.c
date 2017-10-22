#include <stdio.h>

#include "bubbleSort.h"

#define MAX_ELEMENTS    100     // Maximum Elements that the user test function can handle

static void printArray(int * array, const size_t size);
void test_1();
void user_test();

int main(void)
{
        test_1();
        user_test();
        return 0;
}

// A function to print elements of an array separated by a tab
static void printArray(int * array, const size_t size)
{
        for(int i = 0; i < size; ++i) {
                printf("%d\t", array[i]);
        }
}

/*
 * Some Test cases to make sure the sorting algorithm is working
 * properly.
 */

void test_1()
{
        int tst[] = {12, 0, 90, 31498, 1243, -1435, -1};

        printf("Initial Array : ");
        printArray(tst, 7);
        printf("\n");

        bubbleSort(tst, 7);
        
        printf("Sorted Array : ");
        printArray(tst, 7);
        printf("\n");
}

void user_test()
{
        int tst[MAX_ELEMENTS];

        printf("Enter number of elements you would like to enter : ");
        int n;
        scanf("%d", &n);
        printf("Enter elements of array :\n");
        for(int i = 0; i < n; ++i) {
                scanf("%d", &tst[i]);
        }

        printf("Initial Array : ");
        printArray(tst, n);
        printf("\n");

        bubbleSort(tst, n);
        
        printf("Sorted Array : ");
        printArray(tst, n);
        printf("\n");
}