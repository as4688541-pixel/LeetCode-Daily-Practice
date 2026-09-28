class Solution {
    public String makeGood(String s) {
        if(s.length() == 1 || s.length() == 0)return s;
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i < s.length()){
            

            if(sb.length() > 0){

                int curr = (int)s.charAt(i);
                int prev = (int)sb.charAt(sb.length()-1);
               
               
               if(Math.abs(curr - prev) == 32){
                    sb.deleteCharAt(sb.length()-1);
                    i++;
                   continue; 
                }
            }
        
        
            sb.append(s.charAt(i));
                
            i++;
            

        }
        return sb.toString();
        
    }
}