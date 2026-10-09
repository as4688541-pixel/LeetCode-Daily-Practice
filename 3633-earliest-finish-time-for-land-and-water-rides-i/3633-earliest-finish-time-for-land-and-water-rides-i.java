class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
        int ans1 = calc(landStartTime, landDuration,
                        waterStartTime, waterDuration);

        int ans2 = calc(waterStartTime, waterDuration,
                        landStartTime, landDuration);

        return Math.min(ans1, ans2);
    }

    private int calc(int[] start1, int[] duration1,
                     int[] start2, int[] duration2) {

        int minFinish = Integer.MAX_VALUE;

        // Find the earliest finish time of the first ride
        for (int i = 0; i < start1.length; i++) {
            minFinish = Math.min(minFinish,
                                 start1[i] + duration1[i]);
        }

        int ans = Integer.MAX_VALUE;

        // Take the second ride after the first ride
        for (int i = 0; i < start2.length; i++) {
            int finish = Math.max(minFinish, start2[i])
                         + duration2[i];

            ans = Math.min(ans, finish);
        }

        return ans;
    }
}
