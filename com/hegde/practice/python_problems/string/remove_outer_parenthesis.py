import io


class Solution:
    def remove_outer_parentheses(self, s: str) -> str:
        stack = list()
        with io.StringIO() as buffer:
            for char in s:
                if char == '(':
                    stack.append(char)
                    if len(stack) > 1:
                        buffer.write(char)
                else:
                    if len(stack) > 1:
                        buffer.write(char)
                    stack.pop()
            return buffer.getvalue()

    def remove_outer_parentheses_approach_ii(self, s: str) -> str:
        depth = 0
        result = []

        for char in s:
            if char == '(':
                if depth > 0:
                    result.append(char)
                depth += 1
            else:
                depth -= 1
                if depth > 0:
                    result.append(char)
        return "".join(result)