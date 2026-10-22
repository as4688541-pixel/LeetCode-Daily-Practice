class Solution {
    public int minOperations(String s) {
        // Greedy Approach  + observation
     
     char min = s.charAt(0);
     char max = s.charAt(0);

     boolean sorted = true;

     for(int i=1; i<s.length(); i++){
        char ch = s.charAt(i);
        if(ch < s.charAt(i-1))sorted = false;
        min = (char)Math.min(min,ch);
        max = (char)Math.max(max,ch);
     }
     // if string is already sorted
     if(sorted)return 0;
     if(s.length() == 2)return -1;
     // either min is in fast position or max is last position
     if(s.charAt(0) == min || s.charAt(s.length()-1) == max)return 1;
     // min and max character lies on any middle index
     for(int i=1; i<s.length()-1; i++){
        if(min == s.charAt(i) || max == s.charAt(i))return 2;
     }
     return 3;
    }
}