from typing import List


class Solution:
    def ship_within_days(self, weights: List[int], days: int) -> int:
        left = right = 0
        for weight in weights:
            left = max(left, weight)
            right += weight

        while left < right:
            mid = (left + right) // 2
            if self._required_days(weights, mid) <= days:
                right = mid
            else:
                left = mid + 1
        return left

    def _required_days(self, weights: List[int], max_weight: int):
        days_needed = 1
        current_weight = 0
        for weight in weights:
            if current_weight + weight > max_weight:
                current_weight = 0
                days_needed += 1
            current_weight += weight
        return days_needed