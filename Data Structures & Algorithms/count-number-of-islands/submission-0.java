class Solution {
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return;
        }

        if(grid[r][c] == '0') 
                return;

        grid[r][c] = '0';

        for(int[] dir : directions){
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
}
