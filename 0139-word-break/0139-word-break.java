class Solution {
    public boolean helper(int i, String s , Set<String> set,Boolean[] dp){
        if(i == s.length())return true;
        if(dp[i] != null)return dp[i];
        for(int k = i+1; k<=s.length(); k++){
            if(set.contains(s.substring(i,k))){
                if(helper(k,s,set,dp)){
                    dp[i] = true;
                    return true;
            }
        }
    }
       dp[i] = false;
        return false;
    
    }
    public boolean wordBreak(String s, List<String> wordDict) {

        Boolean[] dp = new Boolean[s.length()];

        Set<String> set = new HashSet<>(wordDict);
        return helper(0,s,set,dp);
        
        
    }
}