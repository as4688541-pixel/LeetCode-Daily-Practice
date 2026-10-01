class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        
        int[] ans = new int[nums.length];
        int k = 0;

        for(int i=0; i<nums.length; i++){
            int max = -1;
            int j = (i+1)%nums.length;
            while(j != i){
                if(nums[i] < nums[j]){
                    max = nums[j];
                    break;
                }
                else{
                j = (j+1)%nums.length;
            }
        }
            ans[k++] = max;
        }
        return ans;
        
        
        

        
    }
}