class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        // Create gap of n + 1
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        // Move together
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Delete node
        slow.next = slow.next.next;

        return dummy.next;
    }
}