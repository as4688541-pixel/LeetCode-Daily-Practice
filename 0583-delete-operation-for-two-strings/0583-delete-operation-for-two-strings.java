class Solution {
      public int helper(int i ,int j ,  String s1 , String s2,int[][] dp){
        if(i < 0 || j < 0)return 0;

        if(dp[i][j] != -1)return dp[i][j];

        if(s1.charAt(i)== s2.charAt(j)){

            return dp[i][j] = 1 + helper(i-1, j-1, s1, s2,dp);
        }
        else{
            return dp[i][j] = Math.max(helper(i-1,j,s1,s2,dp),helper(i,j-1,s1,s2,dp));
        }

    }
    public int lcs(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1][n2];
        for(int i=0; i<n1; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(n1-1,n2-1,s1,s2,dp);

    }
       public int minDistance(String word1, String word2) {
        int LCS = lcs(word1,word2);
        int s1 = word1.length() - LCS;
        int s2 = word2.length() - LCS;
        return s1 + s2;
        
    }
}