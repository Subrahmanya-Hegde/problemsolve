class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        result: List[List[int]] = []
        candidates.sort()

        def dfs(path: List[int], start: int, sum: int):
            if sum == target:
                result.append(path[:])
                return

            for i in range(start, len(candidates)):
                if i > start and candidates[i] == candidates[i - 1]:
                    continue

                if sum + candidates[i] > target:
                    break

                path.append(candidates[i])
                dfs(path, i + 1, sum + candidates[i])
                path.pop()

        dfs([], 0, 0)
        return result
