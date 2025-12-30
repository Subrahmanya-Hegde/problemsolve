"""
https://leetcode.com/problems/largest-odd-number-in-string/description/
"""
class Solution:
    def largest_odd_number(self, num: str) -> str:
        for i in range(len(num) - 1, -1, -1):
            if num[i] in '13579':
                return num[0:i + 1]
        return ""