class Solution:
    def get_row(self, row_index: int) -> List[int]:
        row = list()
        ans = 1
        row.append(ans)
        for i in range(1, row_index + 1):
            ans = ans * (row_index - i + 1) // i
            row.append(ans)

        return row