class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        frequency_map = Counter(nums)
        quantity = len(nums) // 3
        return [key for key in frequency_map if frequency_map[key] > quantity]

    #https://www.youtube.com/watch?v=nP_ns3uSh80 - Moore's algo.
    def majority_element_moore_s_algo(self, nums: List[int]) -> List[int]:
        candidate_1 = candidate_2 = None
        counter_1 = counter_2 = 0

        for num in nums:
            if num == candidate_1:
                counter_1 += 1
            elif num == candidate_2:
                counter_2 += 1
            elif counter_1 == 0:
                candidate_1, counter_1 = num, 1
            elif counter_2 == 0:
                candidate_2, counter_2 = num, 1
            else:
                counter_1 -= 1
                counter_2 -= 1

        result = []
        if candidate_1 is not None and nums.count(candidate_1) > len(nums) // 3:
            result.append(candidate_1)
        if candidate_2 is not None and nums.count(candidate_2) > len(nums) // 3:
            result.append(candidate_2)
        return result