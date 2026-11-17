class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        directions = [[1,0], [0, 1], [-1, 0], [0, -1]]
        q = deque()
        time = 0
        fresh = 0

        ROW, COL = len(grid), len(grid[0])

        for r in range(ROW):
            for c in range(COL):
                if grid[r][c] == 1:
                    fresh += 1
                if grid[r][c] == 2:
                    q.append((r, c))
        
        while fresh > 0 and q:
            length = len(q)

            for i in range(length):
                r, c = q.popleft()
                
                for dir in directions:
                    nr, nc = r + dir[0], c + dir[1]

                    if (nr in range(len(grid))
                    and nc in range(len(grid[0]))
                    and grid[nr][nc] == 1
                    ):
                        grid[nr][nc] = 2
                        fresh -= 1
                        q.append((nr, nc))
            
            time += 1
        
        return time if fresh == 0 else -1
        