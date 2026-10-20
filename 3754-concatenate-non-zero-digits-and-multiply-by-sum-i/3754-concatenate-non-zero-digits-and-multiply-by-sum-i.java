class Solution {
    public long sumAndMultiply(int n) {
        if(n ==0)return 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while(n!=0){
            int digit = n%10;
            if(digit != 0){
                sb.append(digit);
                sum += digit;
            }
            n = n / 10;
    }
    sb.reverse();
    String curr = sb.toString();
    long ans = Long.parseLong(curr);
    return ans * sum;
}
}