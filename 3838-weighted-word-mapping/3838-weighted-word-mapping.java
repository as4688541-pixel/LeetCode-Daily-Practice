class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        HashMap<Character,Integer> map = new HashMap<>();
        int ascii = 97;
        for(int ele : weights){
            char ch = (char)ascii;
            map.put(ch,ele);
            ascii++;
        }
        String ans = "";
        for(String word : words){
            int count = 0;
            for(char ch : word.toCharArray()){
                int val = map.get(ch);
                count += val;
            }
            count = count % 26;
            int last = 26 - count;
            char curr = (char)(last + 96);
            ans += curr;

        }
        return ans;
        
    }
}