from typing import List

"""
https://leetcode.com/problems/koko-eating-bananas/description/
What we are finding here:
Koko can eat maximum(piles) banana every hour and can finish it, but Koko cannot enjoy it. Because it is too fast.
So we need to find the just enough speed from 1 to max(piles) - [Binary search]

Approach:
Koko can choose how many bananas she eats per hour.
If she eats slowly, she needs more hours.
If she eats faster, she needs fewer hours.

At a speed equal to the largest pile size, Koko can always finish all bananas,
because each pile takes at most one hour. So a valid speed is guaranteed.

However, we are not asked for any valid speed.
We are asked for the minimum speed at which Koko can still finish within h hours.

For a given eating speed, we can calculate how many hours it takes to eat all piles.
For each pile, the number of hours needed is the pile size divided by the speed,
rounded up, since even leftover bananas take a full hour.

As the eating speed increases, the total hours required never increase.
Because of this monotonic behavior, we can apply binary search on the speed range
from 1 to max(piles).

If Koko can finish at a given speed, we try smaller speeds.
If she cannot finish, we try larger speeds.

The final result is the smallest speed at which Koko can finish within h hours.
"""
class Solution:
    def min_eating_speed(self, piles: List[int], h: int) -> int:
        left, right = 1, max(piles)

        while left < right:
            mid = (left + right) // 2
            if self.can_eat(piles, mid, h):
                right = mid
            else:
                left = mid + 1
        return left

    def can_eat(self, piles: List[int], speed: int, h: int):
        hours = 0
        for pile in piles:
            hours += (pile + speed - 1) // speed
            if hours > h:
                return False
        return True