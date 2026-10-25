class Solution {
   public boolean dfs(int i, int j, boolean[][] vis, int[][] grid) {
        // Reaching outside means this island is open.
        if (i < 0 || j < 0 || i >= grid.length
                || j >= grid[0].length) {
            return false;
        }

        // Water or visited land needs no further checking.
        if (grid[i][j] == 1 || vis[i][j]) {
            return true;
        }

        vis[i][j] = true;

        boolean down = dfs(i + 1, j, vis, grid);
        boolean up = dfs(i - 1, j, vis, grid);
        boolean right = dfs(i, j + 1, vis, grid);
        boolean left = dfs(i, j - 1, vis, grid);

        return down && up && right && left;
    }
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!vis[i][j] && grid[i][j] == 0){
                    if (dfs(i, j, vis, grid)) {
                        count++;
                }
            }
        }
        }
        return count;
        
    }
  
}