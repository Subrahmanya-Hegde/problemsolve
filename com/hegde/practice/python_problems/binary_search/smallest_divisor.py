from typing import List


class Solution:
    def smallest_divisor(self, nums: List[int], threshold: int) -> int:
        left, right = 1, max(nums)

        while left < right:
            mid = (left + right) // 2
            if self._divisor_sum(nums, mid) <= threshold:
                right = mid
            else:
                left = mid + 1
        return left

    def _divisor_sum(self, nums: List[int], divisor: int):
        divisor_sum = 0
        for num in nums:
            divisor_sum += (num + divisor - 1) // divisor
        return divisor_sum