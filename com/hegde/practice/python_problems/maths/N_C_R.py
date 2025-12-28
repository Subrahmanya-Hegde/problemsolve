from math import factorial


class Solution:

    def n_c_r(self, n, r):
        r = min(r, n - r)
        numerator = 1

        for i in range(n, n - r, -1):
            numerator *= i

        denominator = factorial(r)
        return numerator // denominator


solution = Solution()
print(solution.n_c_r(5, 2))