class BubbleSort():
    def sort(self, List):
        Size=len(List)
        for i in range(Size-1):
          for j in range(Size-1):
              if List[j]>List[j+1]:                                      #If Element at next position is greater than current
                    temp=List[j]                                         #Then Swap both elements.
                    List[j]=List[j+1]
                    List[j+1]=temp
        return List

    def printArray(self, List):
        List = self.sort(List)
        for i in range(len(List)):
            print(List[i])
        return List

list = [5,4,3,2,1]
s = BubbleSort()
s.printArray(list) 

