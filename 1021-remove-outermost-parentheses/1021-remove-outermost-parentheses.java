class Solution {
    public String removeOuterParentheses(String s) {
        int start = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(')count++;
            else{
                count--;
            }
            if(count == 0){
                sb.append(s.substring(start+1,i));
                start = i+1;
            }
        }
        return sb.toString();
        
    }
}