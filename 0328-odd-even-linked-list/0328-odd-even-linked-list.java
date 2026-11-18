class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;

        // Save the beginning of the even list
        ListNode evenHead = even;

        while (even != null && even.next != null) {

            // Connect next odd node
            odd.next = even.next;
            odd = odd.next;

            // Connect next even node
            even.next = odd.next;
            even = even.next;
        }

        // Attach even list after odd list
        odd.next = evenHead;

        return head;
    }
}