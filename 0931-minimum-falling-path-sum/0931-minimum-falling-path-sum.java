class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int[][] ans = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(ans[i],Integer.MAX_VALUE);
        }
        for(int i=0; i<n; i++){
            ans[0][i] = matrix[0][i];
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){
            

               if(i < n && j < n){
                    
                    ans[i][j] = Math.min(ans[i-1][j] + matrix[i][j],ans[i][j]);
                }
                
                // down and left
                if(j > 0){
                    
                    ans[i][j-1] = Math.min(ans[i-1][j] + matrix[i][j-1],ans[i][j-1]);
                }
                

             

               

                // down and right

                if(j < n-1){
                    
                    ans[i][j+1] = Math.min(ans[i-1][j] + matrix[i][j+1],ans[i][j+1]);
                }

            }
        }
        int max = Integer.MAX_VALUE;
        for(int j=0; j<n; j++){
            if(max > ans[n-1][j])max = ans[n-1][j];

        }

        return max;
        
    }
}