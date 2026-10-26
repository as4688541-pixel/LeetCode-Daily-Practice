class Solution {
    public long dfs(int i, int j, boolean[][] vis, int[][] grid){
        if(i < 0 || j<0 || i >= grid.length || j>= grid[0].length)return 0;
        if(vis[i][j] || grid[i][j] == 0)return 0;

        vis[i][j] = true;

        long up = dfs(i-1,j,vis,grid);
        long down = dfs(i+1,j,vis,grid);
        long left = dfs(i,j-1,vis,grid);
        long right = dfs(i,j+1,vis,grid);
        return grid[i][j] + up + down + left + right;
    }
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
            if(!vis[i][j] && grid[i][j] != 0){
                long sum = dfs(i,j,vis,grid);
                if(sum % k == 0)count++;
            }
        }
    }
        return count;

        
    }
}