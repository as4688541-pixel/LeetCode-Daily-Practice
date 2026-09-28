class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int max = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')st.push(s.charAt(i));
            if(s.charAt(i) == ')')st.pop();
            int size = st.size();
            max = Math.max(size,max);
        }
        return max;
        
    }
}