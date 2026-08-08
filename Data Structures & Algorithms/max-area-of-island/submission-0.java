class Solution {
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return 0;
        }

        grid[r][c] = 0;

        int area = 1;

        for(int[] dir : directions){
                area += dfs(grid, r + dir[0], c + dir[1]);
        }
        return area;
    }
}
