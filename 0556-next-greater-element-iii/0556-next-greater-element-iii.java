class Solution {
    public void reverse(int i, int j,int[] res){
        while(i<j){
            int temp = res[i];
            res[i] = res[j];
            res[j] = temp;
            i++;
            j--;
        }
    }
    public int nextGreaterElement(int n) {
       
        
        ArrayList<Integer> ans = new ArrayList<>();
        int copy = n;

        while(copy != 0){
            int digit = copy % 10;
            ans.add(digit); 
            copy = copy/10;
        }

        Collections.reverse(ans);

        int[] res = new int[ans.size()];

        for(int i=0; i<ans.size(); i++){
            res[i] = ans.get(i);
        }
        int k = res.length-2;

        while(k >= 0 && res[k] >= res[k+1]){  // this is pivot index
            k--;
        }
         if (k < 0) {
            return -1;
        }

        int j = res.length-1;

        while(res[j] <= res[k])j--;

        int temp = res[j];
        res[j] = res[k];
        res[k] = temp;

        reverse(k+1,res.length-1,res);
        
        long num = 0;  //IMP
        for(int i=0;i<res.length; i++){
            num = num * 10 + res[i];
        }
        if(num < 0 || num > Integer.MAX_VALUE)return -1;

        return (int)num;
    }
}


        