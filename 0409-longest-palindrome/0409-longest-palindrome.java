class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch:s.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
            map.put(ch,1);
        }
        }
        int count = 0;
        int track = 0;

        for(int val : map.values()){
            if(val % 2 == 0)count += val;
            else if(track == 0){
                count += val;
                track++;
            }
            else{
                count = count + val-1;
            }
        }
        return count;
        
    }
}