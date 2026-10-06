class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        // mark nums[idx] = -nums[idx] in num[i] index thus again another nums[i](same element) try to access its place then find out easily

        for(int i=0; i<nums.length; i++){
            int idx = Math.abs(nums[i]) - 1; // java using 0-bases index but nums[i] given from 1 to n
            if(nums[idx] < 0){
                ans.add(idx+1);
            }
            else{
                nums[idx] = -nums[idx];
            }
        }
        return ans;
        
    }
}