class Solution:
    # Best approach.
    def unique_paths(self, m: int, n: int) -> int:
        return self.n_c_r(m + n - 2, m - 1)  # Robot needs to move total (m - 1 + n - 1) times in rows - 1 ways

    def n_c_r(self, n: int, r: int):
        r = max(r, n - r)
        numerator = 1

        for i in range(n, n - r, -1):
            numerator *= i
        denominator = factorial(r)

        return numerator // denominator


    # Naive approach
    def unique_paths_naive(self, m: int, n: int) -> int:
        count = 0

        def dfs(row: int, column: int):
            nonlocal count
            if row >= m or column >= n:
                return

            if row == m - 1 and column == n - 1:
                count += 1

            dfs(row + 1, column)
            dfs(row, column + 1)

        dfs(0, 0)
        return count