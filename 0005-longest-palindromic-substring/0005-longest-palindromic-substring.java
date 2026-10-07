class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1)return s;
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        int[] arr = new int[2];
        int max = 0;
        arr[0] = 0;
        arr[1] = 0;
        for(int k=0; k<n; k++){
            int i=0, j = k;

            while(j < s.length()){
                if(i == j){
                    dp[i][j] = 1;
                }
                else if(i+1 == j){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 1;
                    }
                }
                else{
                    if(s.charAt(i) == s.charAt(j)){
                        if(dp[i+1][j-1] == 1){
                            dp[i][j] = 1;
                        }
                    }
                }
                if(dp[i][j] == 1 && max < Math.abs(i-j)){
                    arr[0] = i;
                    arr[1] = j;
                    max = Math.abs(i-j+1);
                }
                i++;
                j++;

            }
            
        }
        int a = arr[0];
        int b = arr[1];
        if(a < b){
            return s.substring(a,b+1);
        }
        return s.substring(b,a+1);
    }
}