class Solution {

    public int reverseDegree(String s) {
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            int ascii = Math.abs(ch - 'a' - 26);
            sum += ascii * (i+1);
        }

        return sum;
        
    }
}