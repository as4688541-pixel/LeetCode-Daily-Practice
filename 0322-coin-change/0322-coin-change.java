class Solution {
     public int helper(int i, int[] coins, int amount , int[][] dp){
        if(i == coins.length){
            if(amount == 0)return 0;
            return 100000+1;
        }

        if(dp[i][amount] != -1)return dp[i][amount];
        int skip = helper(i+1,coins,amount, dp);
        if(amount - coins[i] < 0)return dp[i][amount] = skip;
        else{
             int take = 1 + helper(i,coins, amount-coins[i], dp);
             return dp[i][amount] = Math.min(skip,take);
        }
     }


    public int coinChange(int[] coins, int amount) {
       
        int n = coins.length;
        // 0/1 knapsack
        // 0 to n-1 and amount to 0;
        int[][] dp = new int[n][amount+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        
        int ans = helper(0,coins,amount,dp);
        if(amount == 0)return 0;
        if(ans > 100000)return -1;
        return ans;

        
    }
}