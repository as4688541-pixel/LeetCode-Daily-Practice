class Solution {
    public int minSteps(int i, int j, String a , String b,int[][] dp){
        if(i == -1)return j+1;
        if(j == -1)return i+1;

        if(dp[i][j] != -1)return dp[i][j];

        if(a.charAt(i) == b.charAt(j)){
            return dp[i][j] = minSteps(i-1,j-1,a,b,dp);
        }
        else{
            int del = minSteps(i-1,j,a,b,dp);
            int insert = minSteps(i,j-1,a,b,dp);
            int rep = minSteps(i-1,j-1,a,b,dp);
            return dp[i][j] = 1 + Math.min(del,Math.min(insert,rep));
        }
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return minSteps(m-1,n-1,word1,word2,dp);
        
    }
}