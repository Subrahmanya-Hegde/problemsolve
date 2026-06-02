from typing import List

#https://leetcode.com/problems/maximum-product-subarray/description/
class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        min_end = max_end = best = nums[0]

        for x in nums[1:]:
            if x < 0:
                max_end, min_end = min_end, max_end

            max_end = max(x, x * max_end)
            min_end = min(x, x * min_end)

            best = max(best, max_end)

        return best