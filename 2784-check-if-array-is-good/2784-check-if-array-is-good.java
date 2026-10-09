class Solution {
    public boolean isGood(int[] nums) {
        int max = Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
            if(max < num)max = num;
        }

        if((max + 1) != nums.length) return false;

        for(int i=1; i<= max; i++){
            if(!map.containsKey(i))return false;
        }

        if(map.get(max) != 2)return false;
        return true;

        
       
    }
}