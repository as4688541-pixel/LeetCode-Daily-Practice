class Solution {
    public int lcs(int i, int j, StringBuilder a , StringBuilder b, int[][] dp){
        if(i < 0 || j < 0)return 0;

        if(dp[i][j] != -1)return dp[i][j];

        if(a.charAt(i) == b.charAt(j))return dp[i][j] = 1 + lcs(i-1,j-1,a,b,dp);
        else{
            return dp[i][j] = Math.max(lcs(i-1,j,a,b,dp),lcs(i,j-1,a,b,dp));
        }
    }
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        StringBuilder x  =new StringBuilder(s);
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0; i<s.length(); i++){
            Arrays.fill(dp[i],-1);
        }

        int ans = lcs(s.length()-1,s.length()-1, x , sb,dp);
        return ans;
        
    }
}