class Solution {
    public int[] leftRightDifference(int[] nums) {
        int leftsum = 0;
        int rightsum = 0;
        
        int suffix = 0;
        for(int ele : nums){
            suffix += ele;
        }
        int temp = 0;
        for(int i=0; i<nums.length; i++){
            leftsum += nums[i];
            temp = nums[i];
            nums[i] = Math.abs(leftsum - suffix);
            suffix -= temp;
            temp = 0;
        }
        return nums;
        
    }
}