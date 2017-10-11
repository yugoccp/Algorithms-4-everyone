#!/usr/bin/env python

class FenwickTree():
    """
    Data structure for providing O(lg(n)) single element alteration
    and range sum query. All indices are zero based.
    """
    def __init__(self, num_elements):
        self.num_elements = 4 * num_elements + 1
        self.array = [0] * self.num_elements

    @staticmethod
    def _get_fenwick_step_length(num):
        return num&-num

    def alter(self, index, amount):
        """
        Alter the element at index and add amount to it
        """
        while index < self.num_elements:
            self.array[index] += amount
            index += self._get_fenwick_step_length(index)

    def query(self, from_index, to_index):
        """
        Sum of the elements between from_index and to_index, both inclusive
        """
        return self._query(to_index) - self._query(from_index - 1)

    def _query(self, index):
        result = 0
        while index > 0:
            result += self.array[index]
            index -= self._get_fenwick_step_length(index)
        return result


if __name__ == "__main__":
    fw = FenwickTree(10)
    fw.alter(1, 1)
    fw.alter(2, 2)
    fw.alter(3, 3)
    fw.alter(4, 4)
    
    for i in range(1, 4 + 1):
        for j in range(i, 4 + 1):
            expected = 0
            for k in range(i, j + 1):
                expected += k
            assert expected == fw.query(i, j)
