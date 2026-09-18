class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        HashMap<Character,String> map1 = new HashMap<>();

        String[] ans = s.split(" ");

       HashMap<String,Character> map2 = new HashMap<>();

       if(ans.length != pattern.length())return false;

    for(int i=0; i<ans.length; i++){
        if(map1.containsKey(pattern.charAt(i))){
            if(!map1.get(pattern.charAt(i)).equals(ans[i]))return false;
        }
        else{
            map1.put(pattern.charAt(i),ans[i]);
        }
        if(map2.containsKey(ans[i])){
            if(map2.get(ans[i]) != pattern.charAt(i))return false;
        }
        else{
        map2.put(ans[i],pattern.charAt(i));
        }

    }
    return true;

       
        
    }
}