from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result: List[List[int]] = []
        path: List[int] = []

        def dfs(start: int, path_sum: int):
            if path_sum == target:
                result.append(path.copy())
                return

            for i in range(start, len(candidates)):
                val = candidates[i]
                if path_sum + val > target:
                    return

                path.append(val)
                dfs(i, path_sum + val)
                path.pop()

        dfs(0, 0)
        return result