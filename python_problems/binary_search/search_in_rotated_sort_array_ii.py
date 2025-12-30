class Solution:
    """
    https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
    Contains duplicate. So when we get some condition like this - [1,0,1,1,1]
    Here there is an ambiguity, we can tell whether the number is in right or left half.
    So we just shrink both the left and right boundary.
    """
    def search(self, nums: List[int], target: int) -> bool:

        left, right = 0, len(nums) - 1

        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                return True

            if nums[left] == nums[mid] == nums[right]:
                left += 1
                right -= 1
                continue

            if nums[left] <= nums[mid]:
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if nums[mid] < target <= nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1

        return False