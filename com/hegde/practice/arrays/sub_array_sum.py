class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefix_sum_occurence = {0: 1}
        prefix_sum = 0
        count = 0

        for number in nums:
            prefix_sum += number
            reminder = prefix_sum - k

            if reminder in prefix_sum_occurence:
                count += prefix_sum_occurence[reminder]
            prefix_sum_occurence[prefix_sum] = prefix_sum_occurence.get(prefix_sum, 0) + 1

        return count