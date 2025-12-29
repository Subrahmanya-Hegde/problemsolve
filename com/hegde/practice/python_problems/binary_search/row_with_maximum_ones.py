class Solution:
    def row_with_max1s(self, mat):
        first_index = -1
        max_one_index = float('inf')
        for index, row in enumerate(mat):
            current_first_one_index = self._first_one_index(row)
            if current_first_one_index < max_one_index:
                max_one_index = current_first_one_index
                first_index = index

        if max_one_index == len(mat[0]):
            return -1

        return first_index

    def _first_one_index(self, row) -> int:
        left, right = 0, len(row) - 1
        while left <= right:
            mid = (left + right) // 2
            if row[mid] == 1:
                right = mid - 1
            else:
                left = mid + 1
        return left
