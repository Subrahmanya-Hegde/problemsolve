class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        frequency_map = Counter(nums)
        quantity = len(nums) // 3
        return [key for key in frequency_map if frequency_map[key] > quantity]