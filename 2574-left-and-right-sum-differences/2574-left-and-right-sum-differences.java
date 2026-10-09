class Solution {
    public int[] leftRightDifference(int[] nums) {
        int leftsum = 0;
        int rightsum = 0;
        int r = nums.length-1;
        int suffix = 0;
        for(int ele : nums){
            suffix += ele;
        }
        for(int i=0; i<nums.length; i++){
            leftsum += nums[i];
            int temp = nums[i];
            nums[i] = Math.abs(leftsum - suffix);
            suffix -= temp;
        }
        return nums;
        
    }
}