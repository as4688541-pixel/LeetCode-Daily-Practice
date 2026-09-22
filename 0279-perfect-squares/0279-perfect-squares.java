class Solution {
    public boolean isPerfect(int n){
        int sqrt = (int)Math.sqrt(n);
        return (sqrt*sqrt == n);
    }

    public int numSquares(int n) {
        // tabulization
     
        

        if(n == 1 || n == 2)return n;

        
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        

        for(int i=3; i<=n; i++){
            if(isPerfect(i)){
                dp[i] = 1;
                continue;
            }
            int min = Integer.MAX_VALUE;
               for(int j=1; j*j<=i; j++){
                int count = dp[j*j] + dp[i - j*j];
                min = Math.min(min,count);
               }
               dp[i] = min;
        }
        return dp[n];
        
    }
}