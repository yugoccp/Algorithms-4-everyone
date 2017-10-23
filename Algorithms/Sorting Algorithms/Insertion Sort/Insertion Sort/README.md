## Insertion Sort Algorithm

**Insertion Sort** algorithm proceeds by considering one element at a time, placing the element in the correct order relative to those before it. If you're sorting an array of comparable elements for example, the idea of the algorithm is to build your sorted array in place, shifting elements out of the way if necessary to make room as you go.

**Outline**
- We start the first element of the array and call it **sorted**.
- When considering the next element in the array, if it is "smaller" than the first, we **swap** them.
- Next, we consider the third element of the array, swapping it leftward until it is in its proper order relative to the first two elements.
- We continue in this manner with the fourth element, the fifth, and so on, until the whole array is sorted.

**Worst-case scenario**
If the array is sorted in the reverse order, we have to shift each of the `n` elements `n` positions each time we make an insertion. Thus, giving us a time complexity of Θ(n²).

**Best-case scenario**
The array is already perfectly sorted, and we simply keep moving the line between *unsorted* and *sorted* as we examine each element. This results in a time complexity of Ω(n).

To read more about Insertion Sort algorithm: https://en.wikipedia.org/wiki/Insertion_sort
