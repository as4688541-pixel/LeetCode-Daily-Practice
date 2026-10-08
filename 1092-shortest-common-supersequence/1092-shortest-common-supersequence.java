class Solution {
    public int lcs(String s1, String s2,int[][] dp){
        int n1 = s1.length();
        int n2 = s2.length();
        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
        
    }
        

    public String shortestCommonSupersequence(String str1, String str2) {
        
        int n1 = str1.length();
        int n2 = str2.length();
        int[][] dp = new int[n1+1][n2+1];
        // find the lcs String
        int  x = lcs(str1,str2,dp);
        StringBuilder sb = new StringBuilder();
        int i = n1;
        int j = n2;
        
        while(i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i-1][j] > dp[i][j-1])i--;
                else j--;
            }
        }
        sb.reverse();
        i = 0;
        j = 0;
        int k = 0;
        StringBuilder ans = new StringBuilder();
        while(i < str1.length() && j < str2.length() && k < sb.length()){
            while(i < str1.length() && k < sb.length()){
                if(str1.charAt(i) != sb.charAt(k)){
                    ans.append(str1.charAt(i));
                    i++;
                }
                else{
                break;
                }
                
            }
            while(j<str2.length() && k < sb.length()){
                if(str2.charAt(j) != sb.charAt(k)){
                    ans.append(str2.charAt(j));
                    j++;
                }
                else{
                break;
                }
                
            }
            ans.append(sb.charAt(k));
            k++;
            i++;
            j++;
        }
        // Add remaining characters
        while (i < n1) {
            ans.append(str1.charAt(i));
            i++;
        }

        while (j < n2) {
            ans.append(str2.charAt(j));
            j++;
        }
        return ans.toString();
        

        
    }
}