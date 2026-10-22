class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        
        
        // binary search
        // we have to find the starting element of the target elemeent

        int left = 0;
        int right =  nums.length-1;
        int first = -1;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                first = mid;
                right = mid -1;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid -1;
            }
        }
        if(first == -1)return list;
        while(first <= nums.length-1 && nums[first] == target){
            list.add(first);
            first++;
        }
        return list;

    }
}