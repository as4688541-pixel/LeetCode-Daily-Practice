class Solution {
    public int minValue(int a, int b, int c){
        if(a <= b && a <= c)return a;
        else if(b <= a && b <= c)return b;
        return c;
    }
    public int countSquares(int[][] matrix) {
        int count = 0;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(i==0 || j==0){
                    count += matrix[i][j];
                    continue;
                }
                if(matrix[i][j] == 0)continue;
                
                matrix[i][j] = minValue(matrix[i-1][j],matrix[i][j-1],matrix[i-1][j-1]) + 1;
                count += matrix[i][j];
            }
        }

        return count;
        
        
    }
}