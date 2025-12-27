class Solution:
    def findMissingRepeatingNumbers(self, nums):
        """
        Approach:
        1. Find XOR of the missing and repeating numbers.
           - XOR all elements in the given array.
           - XOR all numbers from 1 to n.
           - Since XOR of a number with itself is 0, all correctly
             occurring numbers cancel out.
           - The final result is:
                 xr = missing ^ repeating

        2. Separate missing and repeating using a bit mask.
           - Find the rightmost set bit in xr using:
                 bit_mask = xr & -xr
           - This works because:
             - xr has bits set where missing and repeating differ
             - -xr is computed using two’s complement (~xr + 1)
             - ANDing them isolates the rightmost set bit
           - This bit guarantees missing and repeating fall into
             different groups.

        3. Partition numbers into two groups and XOR again.
           - Maintain two XOR variables: candidate_a and candidate_b.
           - For each number in the array:
                 if (num & bit_mask) != 0 → XOR into candidate_a
                 else → XOR into candidate_b
           - Repeat the same grouping and XOR for numbers from 1 to n.
           - After this step:
                 candidate_a and candidate_b are the missing and
                 repeating numbers (in some order).

        4. Identify which number is repeating.
           - Traverse the original array and count occurrences.
           - The number appearing twice is the repeating number;
             the other is the missing number.
        """
        xor_missing_repeating = 0
        n = len(nums)

        for num in nums:
            xor_missing_repeating ^= num
        for i in range(1, n + 1):
            xor_missing_repeating ^= i

        bit_mask = xor_missing_repeating & -xor_missing_repeating

        candidate_1 = candidate_2 = 0
        for num in nums:
            if num & bit_mask:
                candidate_1 ^= num
            else:
                candidate_2 ^= num

        for i in range(1, n + 1):
            if i & bit_mask:
                candidate_1 ^= i
            else:
                candidate_2 ^= i

        return [candidate_1, candidate_2] if nums.count(candidate_1) == 2 else [candidate_2, candidate_1]