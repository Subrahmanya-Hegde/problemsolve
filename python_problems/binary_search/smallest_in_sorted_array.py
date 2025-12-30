from typing import List


class Solution:
    """
    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    Simple - we need to decide which direction we need to move.
    If nums[mid] > nums[right] that means smallest is in the right direction. Else left direction.
    Just keep on updating the indices. Left index will hold the smallest number.
    If nums[mid] == nums[right] then just shrink the right window. i.e. right--
    """
    def find_min(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        while left < right:
            mid = (left + right) // 2
            if nums[mid] > nums[right]:
                left = mid + 1
            elif nums[mid] < nums[right]:
                right = mid
            else:
                right -= 1
        return nums[left]