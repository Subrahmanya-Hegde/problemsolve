from typing import List

"""
https://leetcode.com/problems/search-a-2d-matrix/
"""
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        return self._search_in_row(
            matrix[self._get_row(matrix, target)],
            target
        ) != -1

    def _search_in_row(self, row: List[int], target: int):
        left, right = 0, len(row) - 1
        while left <= right:
            mid = (left + right) // 2
            if row[mid] == target:
                return mid
            elif row[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return -1

    def _get_row(self, matrix: List[List[int]], target: int):
        left, right = 0, len(matrix) - 1
        while left < right:
            mid = (left + right + 1) // 2
            if matrix[mid][0] <= target:
                left = mid
            else:
                right = mid - 1
        return left