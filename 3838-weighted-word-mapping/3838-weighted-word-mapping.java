class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
       
        String ans = "";
        for(String word : words){
            int count = 0;
            for(char ch : word.toCharArray()){
                int idx = ch - 'a';
                int num = weights[idx];
                count += num;
            }
            count = count % 26;
            int last = 26 - count;
            char curr = (char)(last + 96);
            ans += curr;

        }
        return ans;
        
    }
}