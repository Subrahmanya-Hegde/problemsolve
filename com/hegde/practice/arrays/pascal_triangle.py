class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        pascal_triangles = []
        for i in range(numRows):
            if i == 0:
                pascal_triangles.append([1])
                continue
            current_row = [1]
            prev_row = pascal_triangles[i - 1]
            prev_row_length = len(prev_row)
            for j in range(1, prev_row_length):
                current_row.append(prev_row[j - 1] + prev_row[j])
            current_row.append(1)
            pascal_triangles.append(current_row)
        return pascal_triangles