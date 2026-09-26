class Solution {
    private int count;
    public void helper(int i, int[] nums , int target){
        if(i == nums.length){
            if(target == 0){
                count++;
            }
                return;
        }
        //if(target + nums[i] > sum)return;
        helper(i+1, nums, target - nums[i]);
        
        //if(target - nums[i] < 0)return;
        helper(i+1,nums, target + nums[i]);

    }
    public int findTargetSumWays(int[] nums, int target) {
        count =  0;
        // if(nums.length == 1 && nums[0] == target)count++;
        
        // if(nums.length == 1 && nums[0] == (-target))count++;


        // if(nums.length == 1 && nums[0] != target)return count;


        helper(0,nums, target);

        return count;

        
    }
}