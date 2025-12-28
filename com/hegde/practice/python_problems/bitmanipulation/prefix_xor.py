class Solution:
    """
    Idea is same as prefix sum. We will keep track of prefix sum and their frequency.
    i.e. how many times we got the given xor value. Now we iterate through the array xoring from 0.
    And for given prefix xor, we need find the reminder to make the current value as k. Find that prefix xor in the map
    and increase the count by that many times. If we are getting some give prefix sum X twice or thrice
    that means rest of the elements cancels out. So we can safely look for target - current_prefix_sum's occurence in the map.
    """
    def subarrays_with_xor_k(self, nums, k):
        xor_dict = {0: 1}
        count = 0
        xor = 0

        for i, num in enumerate(nums):
            xor ^= num
            required = k ^ xor
            count += xor_dict.get(required, 0)
            xor_dict[xor] = xor_dict.get(xor, 0) + 1

        return count