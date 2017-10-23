class LinearSearch():
    def search(self, haystack, needle):
        length = len(haystack)
        # go through all values
        for i in range(length-1):
            # check if current value is search value
            if haystack[i] == needle:
                return i
        return -1 

ls = LinearSearch()
haystack = [2, 3, 5, 7, 11, 13, 17, 19]

print( ls.search(haystack, 7) )

