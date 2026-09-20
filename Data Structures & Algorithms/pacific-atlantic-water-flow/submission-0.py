class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        directions = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        ROWS, COL = len(heights), len(heights[0])
        pac = [[False] * COL for _ in range(ROWS)]
        atl = [[False] * COL for _ in range(ROWS)]

        def bfs(point, ocean):
            q = deque(point)
            while q:
                r, c = q.popleft()
                ocean[r][c] = True

                for dr, dc in directions:
                    nr, nc = r + dr, c + dc
                    if (0 <= nr < ROWS and 0 <= nc < COL
                    and not ocean[nr][nc]
                    and heights[nr][nc] >= heights[r][c]):
                        q.append([nr, nc])

        pacific = []
        atlantic = []

        for r in range(ROWS):
            pacific.append((r, 0))
            atlantic.append((r, COL - 1))

        for c in range(COL):
            pacific.append((0, c))
            atlantic.append((ROWS - 1, c))

        bfs(pacific, pac)
        bfs(atlantic, atl)

        res = []

        for r in range(ROWS):
            for c in range(COL):
                if pac[r][c] and atl[r][c]:
                    res.append([r, c])

        return res
