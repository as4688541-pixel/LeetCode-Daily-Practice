class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int st = n-k;
        if(st < 0)st = 1;
        int end = n + k;
        int sum = 0;
        while(st <= end){
            if((Math.abs(n-st) <= k) && ((n & st) == 0))sum += st;
            st++;
        }
        return sum;
        
    }
}