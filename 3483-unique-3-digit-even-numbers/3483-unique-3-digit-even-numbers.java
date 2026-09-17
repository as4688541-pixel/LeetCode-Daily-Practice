class Solution {
    public int totalNumbers(int[] digits) {
        // we have to find only count of three digits range 100 - 999

        // hudrends range 100 - 900 ( 1 to 9)  # we not placed zero at hundred place
        // tens range 10 - 90 (0 - 9)zero also included 
        // ones range (0 - 8)beacuse we take only even digits to make whole number is even.

        int[] freq = new int[10];

        int count = 0;

        for(int ele: digits){
            freq[ele]++;
        }

        for(int i=1; i<=9; i++){ // hundred place
            for(int j=0; j<=9; j++){  // tens place
                for(int k=0; k<=8; k+=2){ // ones place
                    int[] used = new int[10];
                    used[i]++;
                    used[j]++;
                    used[k]++;
                    boolean track = true;

                    for(int m=0; m<=9; m++){
                        if(used[m] > freq[m]){
                            track = false;
                            break;
                        }
                    }

                    if(track){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}