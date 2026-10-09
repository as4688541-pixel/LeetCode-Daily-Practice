class Solution {
    public int[] leftRightDifference(int[] nums) {
        int leftsum = 0;
        int rightsum = 0;
        int[] ans = new int[nums.length];
        int r = nums.length-1;
        int suffix = 0;
        for(int ele : nums){
            suffix += ele;
        }
        for(int i=0; i<nums.length; i++){
            leftsum += nums[i];
            ans[i] = Math.abs(leftsum - suffix);
            suffix -= nums[i];
        }
        return ans;
        
    }
}