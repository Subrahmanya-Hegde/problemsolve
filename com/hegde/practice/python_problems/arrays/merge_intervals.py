from typing import List


class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        n = len(intervals)
        if n == 1:
            return intervals

        ans = []
        intervals.sort(key=lambda x: x[0])

        start, end = intervals[0]
        for i in range(1, n):
            if intervals[i][0] <= end:
                end = max(end, intervals[i][1])
            else:
                ans.append([start, end])
                start, end = intervals[i]

        ans.append([start, end])
        return ans