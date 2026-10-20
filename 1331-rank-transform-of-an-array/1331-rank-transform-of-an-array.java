class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // hashMap st store every element and their indices
        TreeMap<Integer,List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        

        for(int i=0; i<arr.length; i++){
            int ele = arr[i];
            if(map.containsKey(ele)){
                map.get(ele).add(i);
            }
            else{
                map.put(ele,new ArrayList<>(Arrays.asList(i)));
            }
        }
        int track = 1;
        while(map.size()>0){
            int top = map.lastKey();
            for(int idx : map.get(top)){
                arr[idx] = track;
            }
            track++;
            map.remove(top);
        }
        return arr;
    }
}