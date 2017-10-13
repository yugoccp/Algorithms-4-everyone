function BubbleSort(a)
{
    // Each iteration moves the next largest element to the end of the array.
    // Because of this, each internal loop executes 1 iteration less (as the last
    // element is already the largest from the previous external loop)
    for(var m = 0; m < a.length; m++)
    {
        // Iterates over all elements (two at a time), moving the largest element
        // to the end of the the array.
        for(var i = 0; i < a.length-m-1; i++)
        {
            // If the current element is greater then the next element
            if( a[i] > a[i+1] )
            {
                // Swap the two elements
                var temp = a[i]
                a[i]=a[i+1];
                a[i+1]=temp;
            }
        }
    }

    return a;
}

function BubbleSortAlternative(a) {
    var debugTotalChecks = 0;
    var swapOccurred;

    // Iterate until no swaps are made (the array is fully sorted)
    do {
        swapOccurred = false;

        // Iterate from the first element to the 2nd to last element
        // (since we are looking ahead by 1). Each iteration moves the
        // larger element towards the end of the array
        for(var i = 0; i < a.length - 1; i++) {

            // If the current element is greater then the next element
            // Swap them and mark swapOccurred as true
            if( a[i] > a[i + 1] ) {
                var temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;

                swapOccurred = true;
            }

            debugTotalChecks++;
        }

    } while(swapOccurred);

    return debugTotalChecks;
}

function BubbleSortAlternativeOptimized(a) {
    var debugTotalChecks = 0;
    var iterations = 0;
    var swapOccurred;

    // Iterate until no swaps are made (the array is fully sorted)
    do {
        swapOccurred = false;

        // Iterate from the first element to the 2nd to last element
        // (since we are looking ahead by 1). Each iteration moves the
        // larger element towards the end of the array
        for(var i = 0; i < a.length - 1 - iterations; i++) {

            // If the current element is greater then the next element
            // Swap them and mark swapOccurred as true
            if( a[i] > a[i + 1] ) {
                var temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;

                swapOccurred = true;
            }

            debugTotalChecks++;
        }

        // Track the number of overall iterations
        // The internal for loop can execute 1 iteration less for ever
        // external loops, because one external loop results in the largest
        // element being placed at the end of the array. It will never need
        // to be compared again, thus we can shorten our internal loop by 1
        iterations++;

    } while(swapOccurred);

    return debugTotalChecks;
}

var a = [5,4,3,2,1];
console.log("Elements Before Bubble sort-->", a);
console.log("Elements After Bubble Sort-->", BubbleSort(a));
console.log();

var b = [1,5,2,4,3];
console.log("Elements Before Bubble sort alternative: ", b);
var checksToSort = BubbleSortAlternative(b);
console.log("Elements After Bubble sort alternative: ", b);
console.log("Total comparisons needed to sort: ", checksToSort);
console.log();

b = [1,5,2,4,3];
console.log("Elements Before Bubble sort alternative optimized: ", b);
checksToSort = BubbleSortAlternativeOptimized(b);
console.log("Elements After Bubble sort alternative optimized: ", b);
console.log("Total comparisons needed to sort: ", checksToSort);