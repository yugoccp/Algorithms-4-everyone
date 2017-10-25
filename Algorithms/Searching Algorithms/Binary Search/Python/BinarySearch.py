class BinarySearch():
    def search(self, haystack, needle):
        middle = 0
        lower_bound = 0
        higher_bound = len(haystack)

        while (lower_bound <= higher_bound):
            middle = lower_bound + (higher_bound - lower_bound) / 2
            if (haystack[middle] == needle):
                return middle
            elif (haystack[middle] < needle):
                lower_bound = middle + 1
            elif (haystack[middle] > needle):
                higher_bound = middle - 1

        return -1

bs = BinarySearch()
haystack = [2, 3, 5, 7, 11, 13, 17, 19]

print( bs.search(haystack, 1) )

