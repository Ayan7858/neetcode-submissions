class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        directions = [[1,0], [0, 1], [-1, 0], [0, -1]]
        q = deque()
        time = 0
        fresh = 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    fresh += 1
                if grid[i][j] == 2:
                    q.append((i, j))

        while fresh > 0 and q:
            length = len(q)
            for i in range(length):
                r, c = q.popleft()

                for dr, dc in directions:
                    row, col = r + dr, c + dc

                    if (row in range(len(grid))
                    and col in range(len(grid[0]))
                    and grid[row][col] == 1
                    ):
                        grid[row][col] = 2
                        fresh -= 1
                        q.append((row, col))
            time += 1
        return time if fresh == 0 else -1


        