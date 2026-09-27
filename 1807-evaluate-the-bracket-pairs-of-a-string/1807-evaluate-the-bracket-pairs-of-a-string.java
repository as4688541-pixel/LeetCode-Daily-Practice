class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map = new HashMap<>();
        for(int i=0; i<knowledge.size(); i++){
           
           
            String key = knowledge.get(i).get(0);
            String val = knowledge.get(i).get(1);
            map.put(key,val);
        }
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || Character.isLetter(ch))st.push(ch);
            else{
                StringBuilder sb = new StringBuilder();
                while(st.peek() != '('){
                    sb.append(st.pop());
                }
                st.pop();
                sb.reverse();
                String ans = "?";
                if(map.containsKey(sb.toString()))ans = map.get(sb.toString());
                for(int j=0; j<ans.length(); j++){
                    st.push(ans.charAt(j));

                }
            }
        }
        StringBuilder s1 = new StringBuilder();
        while(st.size() != 0){
            s1.append(st.pop());
        }
        s1.reverse();
        return s1.toString();
    }
}