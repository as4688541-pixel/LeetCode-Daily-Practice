class Solution {
    public int countSubstrings(String s) {
        // use tabulization method
        int n = s.length();
        int[][] dp = new int[n][n];
        int count = 0;

        for(int k=0; k<s.length(); k++){
            int i=0,j=k;
            while(j < s.length()){
                if(i == j){
                    dp[i][j] = 1;
                    count++;
                }
                else if(i+1 == j){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 1;
                        count++;
                    }
                }
                else{   // having subtrings more than two characters 
                    if(s.charAt(i) == s.charAt(j)){
                        if(dp[i+1][j-1] == 1){
                            dp[i][j] = 1;
                            count++;
                        }
                    }
                }
                i++;
                j++;
            }
        }
        return count;
    }
}