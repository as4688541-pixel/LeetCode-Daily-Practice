class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        int time;
        Pair(int node , int time){
            this.node = node;
            this.time = time;
        }
        public int compareTo(Pair p){
            if(this.time == p.time)return this.node - p.node;
            return this.time - p.time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int t = time[2];
            adj.get(u).add(new Pair(v,t));
        }
        if(k > times.length)return -1;

        // Dijkshtra Algoithm

        int[] ans = new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[0] = 0;
        ans[k] = 0;
       
        PriorityQueue<Pair> q = new PriorityQueue<>(); // min heap
        q.add(new Pair(k,0));

        while(q.size()>0){
            Pair p = q.remove();
            int node = p.node;
            int time = p.time;
            for(Pair ele : adj.get(node)){
                int totaltime = ele.time + time;
                if(ans[ele.node] > totaltime){
                    ans[ele.node] = totaltime;
                    q.add(new Pair(ele.node,totaltime));
                }
                
            }
        }

        int max = 0;

        for(int ele: ans){
            if(ele > max)max = ele;
        }

        if(max == Integer.MAX_VALUE)return -1;
        return max;



        
    }
}