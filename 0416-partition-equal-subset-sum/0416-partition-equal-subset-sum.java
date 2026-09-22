class Solution {
    public boolean helper(int i ,int[] nums,int target,int[][] dp){
         // base case
        if(i == nums.length){
            if(target == 0)return true;
            else return false;
        }
        if(dp[i][target] != -1){
            return dp[i][target] == 1 ? true:false;

        }

        boolean skip = helper(i+1,nums,target,dp);

        if(nums[i] > target)return skip;

        boolean take = helper(i+1,nums,target - nums[i],dp);
        boolean ans = (skip || take)?true : false;
        dp[i][target] = ans ? 1 : 0;

        return ans;

    }
    public boolean canPartition(int[] nums) {
       int n = nums.length;

       int totalsum = 0;
       for(int ele:nums){
        totalsum += ele;
       }
       if(totalsum % 2 != 0)return false;

       int target = totalsum / 2;
       int[][] dp = new int[n][target+1];
       for(int i=0; i<n; i++){
          Arrays.fill(dp[i],-1);
       }

       return helper(0,nums,target,dp);
    }
}