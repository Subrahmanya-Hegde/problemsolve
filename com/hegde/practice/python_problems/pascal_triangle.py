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

    def generate_recursive(self, numRows: int) -> List[List[int]]:
        if numRows == 0:
            return []
        if numRows == 1:
            return [[1]]
        prevRows = self.generate_recursive(numRows - 1)
        newRow = [1] * numRows

        for i in range(1, numRows - 1):
            newRow[i] = prevRows[-1][i - 1] + prevRows[-1][i]

        prevRows.append(newRow)
        return prevRows