class Solution {
    public void helper(int open , int close , int n , ArrayList<String> list , String ans){
        if(ans.length() == 2*n){
            list.add(ans);
            return;
        }

        if(open < n){
            helper(open+1, close , n ,list , ans + '(');
        }
        if(open > close){
            helper(open , close + 1 ,n , list , ans + ')');
        }
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        helper(0,0,n,list,"");
        return list;
        
    }
}