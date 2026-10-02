class Solution {
    public int lcs(int i, int j, String s,String t,int[][] dp){
        if(i == -1 || j == -1)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = 1 + lcs(i-1,j-1,s,t,dp);
        }
        else{
            return dp[i][j] = Math.max(lcs(i-1,j,s,t,dp),lcs(i,j-1,s,t,dp));
        }
    }
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i],-1);
        }
        int ans = lcs(m-1,n-1,s,t,dp);
        if(ans == m)return true;
        return false;
      
    }
}