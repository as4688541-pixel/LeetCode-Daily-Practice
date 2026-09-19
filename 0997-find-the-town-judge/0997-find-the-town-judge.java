class Solution {
    public int findJudge(int n, int[][] trust) {

        // two condtion are 
        // 1. everyone trust to the town judge
        //2. judge not trust to anyone
        // means there indegree is n-1 and outdegree is 0;

        // edges case
        if(n == 1 && trust.length == 0)return 1;
        

        int[] out = new int[n+1];
        int[] in = new int[n+1];

        for(int[] ele:trust){
            int u1 = ele[0];
            int v1 = ele[1];
            out[u1]++;
            in[v1]++;
        }

        for(int i=1; i<out.length; i++){
            if(out[i] == 0 && in[i] == n-1)return i;
        }
        return -1;

        
    }
}