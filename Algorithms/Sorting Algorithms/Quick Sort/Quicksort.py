# quick sort
def partition(myList, start, end):
    pivot = myList[start]
    left = start+1
    # Start outside the area to be partitioned
    right = end
    done = False
    while not done:
        while left <= right and myList[left] <= pivot:
            left = left + 1
        while myList[right] >= pivot and right >=left:
            right = right - 1
        if right < left:
            done = True
        else:
            # swap places
            temp = myList[left]
            myList[left] = myList[right]
            myList[right] = temp
    # start with myList[right]
    temp = myList[start]
    myList[start] = myList[right]
    myList[right] = temp
    return right


def quick_sort(myList, start, end):
    if start < end:
        # partitioning the list
        split = partition(myList, start, end)
        # split halves & sort both halves
        quick_sort(myList, start, split - 1)
        quick_sort(myList, split + 1, end)
    return myList



my_List = [7,2,5,1,29,6,4,19,11]
sortedList = quick_sort(my_List, 0, len(my_List) - 1)
print(sortedList)
