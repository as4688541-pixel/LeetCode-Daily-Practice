class Solution {
    public int findCenter(int[][] edges) {
        
        int[] ans = new int[edges.length+2];

        for(int[] arr : edges){
            int u1 = arr[0];
            int v1 = arr[1];
            ans[u1]++;
            ans[v1]++;
            
        }
        int star = 0;

        for(int i=0; i<ans.length; i++){
            if(ans[i]>1){
                star = i;
            }
        }
        return star;
        
    }
}