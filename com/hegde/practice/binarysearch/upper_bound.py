class Solution:
    def upperBound(self, nums, x):
        n = len(nums)
        left, right = 0, n - 1
        ans = -1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] > x:
                right = mid - 1
                ans = mid
            else:
                left = mid + 1
        return ans