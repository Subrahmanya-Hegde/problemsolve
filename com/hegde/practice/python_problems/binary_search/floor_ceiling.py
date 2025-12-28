class Solution:
    # https://takeuforward.org/plus/dsa/problems/floor-and-ceil-in-sorted-array
    def getFloorAndCeil(self, nums, x):
        left, right = 0, len(nums) - 1
        floor = ceil = -1

        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == x:
                return [x, x]
            elif nums[mid] < x:
                floor = nums[mid]
                left = mid + 1
            else:
                ceil = nums[mid]
                right = mid - 1
        return [floor, ceil]