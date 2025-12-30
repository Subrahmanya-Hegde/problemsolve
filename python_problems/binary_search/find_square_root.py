class Solution:
    def floor_sqrt(self, n: int) -> int:
        if n < 2:
            return n

        left, right = 1, n // 2
        while left <= right:
            mid = (left + right) // 2
            mid_square = mid * mid
            if mid_square == n:
                return mid
            elif mid_square < n:
                left = mid + 1
            else:
                right = mid - 1
        return right