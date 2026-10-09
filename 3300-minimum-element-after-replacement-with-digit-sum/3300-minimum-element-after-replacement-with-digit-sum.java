class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int ele : nums){
            int sum =0;
            while(ele != 0){
                sum += (ele%10);
                ele = ele / 10;
            }
            if(min > sum)min = sum;
        }

        return min;
        
    }
}