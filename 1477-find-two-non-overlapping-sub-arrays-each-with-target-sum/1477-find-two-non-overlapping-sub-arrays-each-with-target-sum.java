class Solution {
   
    public int minSumOfLengths(int[] arr, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        int sum = 0;

        int[] best = new int[arr.length];
        int INF = Integer.MAX_VALUE/2;
        Arrays.fill(best,INF);

        int minlen = INF;
        int ans = INF;


        for(int i=0; i<arr.length; i++){
            sum += arr[i];

            if(map.containsKey(sum - target)){
                int st = map.get(sum - target);
                int len = i - st;

                if(st >= 0 && best[st] != INF){
                    ans = Math.min(ans,len+ best[st]);
                }
                minlen = Math.min(len,minlen);
            }
        best[i] = minlen;

        map.put(sum,i);
    }
    return ans == INF?-1:ans;
    }

}