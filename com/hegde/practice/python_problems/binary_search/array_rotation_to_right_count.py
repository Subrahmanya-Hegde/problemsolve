class Solution:
    """
    https://takeuforward.org/plus/dsa/problems/find-out-how-many-times-the-array-is-rotated
    Find out how many times an array is rotated to the right.
    Question - [3, 4, 5, 1, 2] Ans = 3 right rotations.
    Original - [1, 2, 3, 4, 5]. Rotations - 1st - [5, 1, 2, 3, 4], 2nd - [4, 5, 1, 2, 3], 3rd - [3, 4, 5, 1, 2]
    """
    def findKRotation(self, nums):
        n = len(nums)
        left, right = 0, n - 1

        while left < right:
            mid = (left + right) // 2
            if nums[mid] > nums[right]:
                left = mid + 1
            elif nums[mid] < nums[right]:
                right = mid
            else:
                right -= 1
        return left