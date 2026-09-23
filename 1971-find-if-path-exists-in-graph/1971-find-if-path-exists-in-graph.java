class Solution {
    public boolean bfs(int n, List<List<Integer>> list, int source, int destination, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis[source] = true;

        

        while(q.size() > 0){
            int front = q.remove();
            for(int ele: list.get(front)){
                if(ele == destination)return true;
                if(!vis[ele]){
                    vis[ele]=true;
                    q.add(ele);
                
                
                }

            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            List<Integer> temp = new ArrayList<>();
            list.add(temp);
        }
        for(int[] ele:edges){
            int a = ele[0];
            int b = ele[1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
        boolean[] vis = new boolean[n];  // undirected graph
        if(source == destination)return true;  // for single node
        return bfs(n,list,source,destination,vis);
    }
}