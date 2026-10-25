class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] arr = new int[13];
        arr[1] = 31;
        arr[2] = 28;
        arr[3] = 31;
        arr[4] = 30;
        arr[5] = 31;
        arr[6] = 30;
        arr[7] = 31;
        arr[8] = 31;
        arr[9] = 30;
        arr[10] = 31;
        arr[11] = 30;
        arr[12] = 31;

    String[] arrive_Alice = arriveAlice.split("-");
    int arrive_Alice_date = Integer.parseInt(arrive_Alice[1]);
    int arrive_Alice_month = Integer.parseInt(arrive_Alice[0]);
    String[] leave_Alice = leaveAlice.split("-");
    int leave_Alice_date = Integer.parseInt(leave_Alice[1]);
    int leave_Alice_month = Integer.parseInt(leave_Alice[0]);


    String[] arrive_bob = arriveBob.split("-");
    int arrive_bob_date = Integer.parseInt(arrive_bob[1]);
    int arrive_bob_month = Integer.parseInt(arrive_bob[0]);

    String[] leave_bob = leaveBob.split("-");
    int leave_bob_date = Integer.parseInt(leave_bob[1]);
    int leave_bob_month = Integer.parseInt(leave_bob[0]);

        // Convert each date into its day number in the year.
    int aliceStart = arrive_Alice_date;
    for (int month = 1; month < arrive_Alice_month; month++) {
        aliceStart += arr[month];
    }

    int aliceEnd = leave_Alice_date;
    for (int month = 1; month < leave_Alice_month; month++) {
        aliceEnd += arr[month];
    }

    int bobStart = arrive_bob_date;
    for (int month = 1; month < arrive_bob_month; month++) {
        bobStart += arr[month];
    }

    int bobEnd = leave_bob_date;
    for (int month = 1; month < leave_bob_month; month++) {
        bobEnd += arr[month];
    }

    // The common period starts when the later person arrives.
    int start = Math.max(aliceStart, bobStart);

    // The common period ends when the earlier person leaves.
    int end = Math.min(aliceEnd, bobEnd);

    return Math.max(0, end - start + 1);
    }
}

    




        
    
