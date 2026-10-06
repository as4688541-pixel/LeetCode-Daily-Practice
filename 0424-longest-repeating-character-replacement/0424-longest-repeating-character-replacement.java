class Solution {
    public int characterReplacement(String s, int k) {
       int[] freq = new int[26];
       int l = 0;
       
       int max = 0;
       // track the maximum frequency of current window
       int maxfreq = 0;

       for(int r = 0; r<s.length(); r++){
        int idx = s.charAt(r) - 'A';
        freq[idx]++;

        maxfreq = Math.max(maxfreq,freq[idx]);

        int changes = (r-l+1) - maxfreq;

        if(k < changes){
            freq[s.charAt(l) - 'A']--;
            l++;
        }
        
         max = Math.max(max,(r-l+1));
       
       }
       return max;
    }
}