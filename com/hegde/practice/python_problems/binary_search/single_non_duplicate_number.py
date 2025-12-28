from typing import List


"""
https://leetcode.com/problems/single-element-in-a-sorted-array/
O(nlogn) solution -
Logic - pairs should appear on even odd indices. 
So we need to find where it is broken.
If nums[mid] == nums[mid + 1] then pairs are intact on the left. So look for right side.
If mid % 2 == 1 make mid -= 1. Why? Because pairs always starts at even index. So if our logic should work then we need
to compare the even and odd indices.

O(n) solution -
Just do the xor of all elements. And return the xor.
"""
class Solution:
    def single_non_duplicate(self, nums: List[int]) -> int:

        left, right = 0, len(nums) - 1

        while left < right:
            mid = (left + right) // 2

            if mid % 2 == 1:
                mid -= 1

            if nums[mid] == nums[mid + 1]:
                left = mid + 2
            else:
                right = mid

        return nums[left]