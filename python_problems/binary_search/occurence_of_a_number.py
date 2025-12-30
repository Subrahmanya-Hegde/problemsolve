from typing import List


class Solution:
    def countOccurrences(self, arr: List[int], target: int) -> int:
        last_occurence = self._last_occurence(arr, target)
        if last_occurence == -1:
            return 0

        return last_occurence - self._first_occurence(arr, target) + 1

    def _first_occurence(self, array: List[int], target: int)-> int:
        left, right = 0, len(array) - 1
        index = -1
        while left <= right:
            mid = (left + right) // 2
            if array[mid] == target:
                index = mid
                right = mid - 1
            elif array[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return index

    def _last_occurence(self, array, target: int) -> int:
        left, right = 0, len(array) - 1
        index = -1
        while left <= right:
            mid = (left + right) // 2
            if array[mid] == target:
                index = mid
                left = mid + 1
            elif array[mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        return index