class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        double prob;
         Pair(int node , double prob){
            this.node = node;
            this.prob = prob;
         }
         public int compareTo(Pair p){
            if(this.prob == p.prob)return this.node - p.node;
            return Double.compare(this.prob,p.prob);
         }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Pair>());
        }

        for(int i=0; i<edges.length; i++){ 
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(new Pair(v,succProb[i]));
            adj.get(v).add(new Pair(u,succProb[i])); 
        }

        // Dijkshtra Algo

        double[] ans = new double[n];
        ans[start_node] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());// max heap

        pq.add(new Pair(start_node , 1));

        while(pq.size()>0){
            Pair p = pq.remove();
            int node = p.node;
            double prob = p.prob;
            for(Pair t : adj.get(node)){
                double totalprob = prob * t.prob;
                if(ans[t.node] < totalprob){
                    ans[t.node] = totalprob;
                    pq.add(new Pair(t.node,totalprob));
                }
            }

        }
        return ans[end_node];
        

    }
}