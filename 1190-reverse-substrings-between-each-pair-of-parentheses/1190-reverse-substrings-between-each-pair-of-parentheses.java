class Solution {
    public String reverseParentheses(String s) {
       
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || Character.isLetter(ch))st.push(ch);
            else{
                StringBuilder sb = new StringBuilder();
                while(st.peek() != '('){
                    sb.append(st.pop());
                }
                st.pop();

                for(int j=0; j<sb.length(); j++){
                    st.push(sb.charAt(j));
                }
                
            }
        }
        
        while(st.size() != 0){
            ans.append(st.pop());

        }
        ans.reverse();
        return ans.toString();



        
    }
}