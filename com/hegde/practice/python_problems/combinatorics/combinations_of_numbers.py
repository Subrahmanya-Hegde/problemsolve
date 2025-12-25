from typing import List


def combine(n: int, k: int) -> List[List[int]]:
    result: List[List[int]] = []
    path: List[int] = []

    def dfs(start: int) -> None:
        path_length = len(path)
        if path_length == k:
            result.append(path.copy())
            return

        need = k - path_length

        for i in range(start, n - need + 2):
            path.append(i)
            dfs(i + 1)
            path.pop()

    dfs(1)
    return result

print(combine(5, 2))