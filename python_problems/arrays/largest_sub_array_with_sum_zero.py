class Solution:
    """
    Prefix sum approach - keep the earliest index(to get the max length)
    of the prefix_sum in a map and get the difference of current index and prefix_sum index.
    Why this works? - because if the prefix_sum same as old means there is a subarray between these
    2 indices with sum = 0. {9,-3, 3, -1, 6, 6} - Prefix sum at last 6 becomes 9.
    That means 9 + (something - something) = 9 i.e. something - something is zero.
    Problem - https://takeuforward.org/data-structure/length-of-the-longest-subarray-with-zero-sum
    """
    def max_len(self, arr):
        prefix_sum_index = {}
        prefix_sum: int = 0
        max_length = 0

        for i, num in enumerate(arr):
            prefix_sum += num
            if prefix_sum == 0:
                max_length = i + 1
            elif prefix_sum in prefix_sum_index:
                max_length = max(i - prefix_sum_index[prefix_sum], max_length)
            else:
                prefix_sum_index[prefix_sum] = i

        return max_length