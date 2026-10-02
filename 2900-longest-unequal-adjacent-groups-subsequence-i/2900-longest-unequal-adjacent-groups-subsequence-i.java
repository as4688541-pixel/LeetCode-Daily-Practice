class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        if(words.length == 1)return new ArrayList<String>(Arrays.asList(words[0]));
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);

        for(int i=1; i<words.length; i++){
            if(groups[i] != groups[i-1]){
                ans.add(words[i]);
            }

        }
        
        
        return ans;
    }
}