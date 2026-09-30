class Solution {
    public String minRemoveToMakeValid(String s) {
          int count = 0;
          StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);


            if(count < 0)count = 0;

            if(ch == '(' && count >= 0){
                count++;
                sb.append(ch);
            }
            else if(ch == ')'){
                count--;
                if(count >= 0){
                    sb.append(ch);
                }
            }
            else{
                sb.append(ch);
            }
        }
        

        for(int i = sb.length()-1; i>=0 && count > 0; i--){
            if(sb.charAt(i) == '('){
               sb.deleteCharAt(i);
               count--;
            }

        }
        return sb.toString();
    }
}