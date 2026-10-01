class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[Math.min(nums1.length,nums2.length)];

        for(int i=0; i<nums2.length; i++){
            map.put(nums2[i],i);
        }
        int k = 0;

        for(int ele : nums1){
            int idx = map.get(ele);
            int max = -1;

            for(int i=idx+1; i<nums2.length; i++){
                if(ele < nums2[i]){
                    max = nums2[i];
                    break;
                }
            }
            ans[k++] = max;
        }
        return ans;
        
    }
}