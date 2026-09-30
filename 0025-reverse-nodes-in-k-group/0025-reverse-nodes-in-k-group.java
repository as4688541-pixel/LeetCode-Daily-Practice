class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroup = dummy;

        while (true) {

            // Find the kth node
            ListNode kth = prevGroup;

            for (int i = 0; i < k; i++) {
                kth = kth.next;

                // Less than k nodes remaining
                if (kth == null) {
                    return dummy.next;
                }
            }

            ListNode groupNext = kth.next;

            // Reverse current group
            ListNode prev = groupNext;
            ListNode curr = prevGroup.next;

            while (curr != groupNext) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect previous group to reversed group
            ListNode oldStart = prevGroup.next;
            prevGroup.next = kth;

            // oldStart is now the last node of this group
            prevGroup = oldStart;
        }
    }
}