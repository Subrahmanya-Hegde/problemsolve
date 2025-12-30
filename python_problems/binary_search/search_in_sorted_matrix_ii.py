from bisect import bisect_left
from typing import List

"""
https://leetcode.com/problems/search-a-2d-matrix-ii/submissions/
"""
class Solution:
    def search_matrix(self, matrix: List[List[int]], target: int) -> bool:
        rows, columns = len(matrix), len(matrix[0])
        row, column = 0, columns - 1
        while row < rows and column >= 0:
            if matrix[row][column] == target:
                return True
            elif matrix[row][column] > target:
                column -= 1
            else:
                row += 1
        return False

    def search_matrix_binary_search(self, matrix: List[List[int]], target: int) -> bool:
        for row in matrix:
            if row[0] <= target <= row[-1]:
                idx = bisect_left(row, target)
                if idx < len(row) and row[idx] == target:
                    return True
        return False