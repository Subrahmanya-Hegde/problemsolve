from typing import List

"""
https://leetcode.com/problems/find-a-peak-element-ii/

We can apply binary search because answer can be any peak element in the grid.
So we start from the middle column. Then find the max number in the row. 
Because only that number can be the peak number. Then search for the neighbors if they are greater than the current max.
If current max is greater then we found the peak element. If left neighbor is greater then move left, else move right. 
We can apply binary search only because there are no equal adjacent elements.
"""
class Solution:

    #Using Binary search

    def find_peak_grid(self, mat: List[List[int]]) -> List[int]:
        rows, columns = len(mat), len(mat[0])
        left, right = 0, columns - 1

        while left <= right:

            mid = (left + right) // 2

            max_row = 0
            for i in range(rows):
                if mat[i][mid] > mat[max_row][mid]:
                    max_row = i

            left_neighbor = mat[max_row][mid - 1] if mid - 1 >= 0 else -1
            right_neighbor = mat[max_row][mid + 1] if mid + 1 < columns else -1
            current_max = mat[max_row][mid]

            if current_max > left_neighbor and current_max > right_neighbor:
                return [max_row, mid]
            elif left_neighbor > current_max:
                right = mid - 1
            else:
                left = mid + 1
        return [-1, -1]

    #Naive approach.
    def find_peak_grid_naive(self, mat: List[List[int]]) -> List[int]:
        rows, columns = len(mat), len(mat[0])

        for i in range(rows):
            for j in range(columns):
                if self._is_peak(mat, i, j, rows, columns):
                    return [i, j]
        return [-1, -1]

    def _is_peak(self, mat: List[List[int]], row_index: int, col_index: int, rows: int, cols: int):
        for dr, dc in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            i, j = row_index + dr, col_index + dc
            if i >= rows or j >= cols or i < 0 or j < 0:
                continue
            if mat[i][j] >= mat[row_index][col_index]:
                return False
        return True