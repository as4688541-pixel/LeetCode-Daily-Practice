class Solution {
    public int minimumCost(int[] cost) {
        PriorityQueue<Integer> set = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : cost){
            set.add(ele);
        }
        int count = 0;
        
        while(set.size() > 0){
            int x=0, y=0;
            if(set.size() > 0){
                x = set.poll();
            }
            if(set.size()>0){
                y = set.poll();
            }
            if(set.size()>0){
                set.poll();
            }
            count += x + y;
        }

        return count;
    }
}