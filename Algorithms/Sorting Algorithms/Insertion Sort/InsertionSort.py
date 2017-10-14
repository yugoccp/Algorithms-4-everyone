class InsertionSort():
    def sort(self, array):
        for i in range(len(array)):
            key = array[i]
            j = i - 1
            while (j >= 0 and array[j] > key):
                array[j+1] = array[j]
                j = j - 1
            array[j+1]=key
        return array

    def printArray(self, array):
        array = self.sort(array)
        for i in range(len(array)):
            print(array[i])
        return array

list = [64, 25, 12, 22, 11, 99]
s = InsertionSort()
s.printArray(list)