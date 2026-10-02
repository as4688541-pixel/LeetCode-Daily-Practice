class Solution {
    public void helper(int n, List<String> ans, String s,int open,int close){
        // Base Case
        if(s.length() == 2 * n){
            ans.add(s);
            return;
        }

        // open '('
        if(open < n){
            helper(n,ans,s+'(',open+1,close);
        }
        if(close < open){ // V.V.Imp it stop adding extra close bracket than open bracket or it stop to genearate parenthesis from close bracket
            helper(n,ans,s+')',open,close+1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        
        helper(n,ans,"",0,0);
        return ans;
        
    }
}