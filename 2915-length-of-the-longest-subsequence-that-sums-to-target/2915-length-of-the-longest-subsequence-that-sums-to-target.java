class Solution {
    public int helper(int i, List<Integer> nums, int target, int[][] dp){
        if(i == nums.size()){
            if(target == 0)return 0;
            else return Integer.MIN_VALUE; 
        }
        if(dp[i][target] != -1)return dp[i][target];
        int skip = helper(i+1, nums ,target,dp);
        if(target - nums.get(i) < 0)return dp[i][target] = skip;
        int take = 1 + helper(i+1,nums, target - nums.get(i),dp);
        return dp[i][target] = Math.max(skip,take);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] dp = new int[n][target+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i],-1);
        }
        int ans = helper(0,nums,target,dp);
        if(ans < 0)return -1;
        return ans;
        
    }
}