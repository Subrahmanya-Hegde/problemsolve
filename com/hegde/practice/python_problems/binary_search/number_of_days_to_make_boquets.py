from typing import List

"""
https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
Here as well, take the small and large number in the array and start applying the binary search.
We need to find the smallest number which satisfies the condition. 
"""
class Solution:
    def min_days(self, bloom_day: List[int], m: int, k: int) -> int:
        flowers = len(bloom_day)
        if m * k > flowers:
            return -1
        left, right = min(bloom_day), max(bloom_day)
        while left < right:
            mid = (left + right) // 2
            if self.can_make_bouquet(bloom_day, m, k, mid):
                right = mid
            else:
                left = mid + 1
        return left

    def can_make_bouquet(self, bloom_day: List[int], required_bouquets: int, min_flowers: int, current_day: int):
        consecutive = 0
        for day in bloom_day:
            if day > current_day:
                consecutive = 0
            else:
                consecutive += 1
                if consecutive == min_flowers:
                    required_bouquets -= 1
                    consecutive = 0
                    if required_bouquets == 0:
                        return True
        return False