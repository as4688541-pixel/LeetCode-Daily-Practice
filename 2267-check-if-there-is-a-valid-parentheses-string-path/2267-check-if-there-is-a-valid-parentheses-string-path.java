class Solution {
    static Boolean[][][] dp;
    public boolean helper(int i, int j ,int balance , char[][] grid){
        if(i>=grid.length || j >= grid[0].length)return false;
        if(grid[i][j] == '(')balance++;
        else balance--;

        if(balance < 0)return false;

        if(i == grid.length-1 && j == grid[0].length-1){
            return balance == 0;
        }

        if(dp[i][j][balance] != null)return dp[i][j][balance];

        // right
        boolean right = helper(i,j+1,balance,grid);
        // down
        boolean down = helper(i+1,j,balance,grid);

        dp[i][j][balance] = right || down;

        return dp[i][j][balance];
    }
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new Boolean[m][n][m+n];

        return helper(0,0,0,grid);
        
    }
}