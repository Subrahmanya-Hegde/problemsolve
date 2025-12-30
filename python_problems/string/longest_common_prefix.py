from typing import List

"""
https://leetcode.com/problems/longest-common-prefix/
"""
class Solution:
    def longest_common_prefix(self, strs: List[str]) -> str:
        prefix = strs[0]
        for word in strs[1:]:
            while not word.startswith(prefix):
                prefix = prefix[:-1]
                if not prefix:
                    return ""
        return prefix