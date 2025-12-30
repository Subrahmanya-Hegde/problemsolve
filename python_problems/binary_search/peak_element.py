from typing import List

"""
https://leetcode.com/problems/find-peak-element/description/
Simple - if the middle element and next element is increasing then peak should be on the right. Else left.
"""
class Solution:
    def find_peak_element(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right) // 2
            if nums[mid] > nums[mid + 1]:
                right = mid
            else:
                left = mid + 1
        return left