class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0)
            return null;

        int interval = 1;

        while (interval < lists.length) {

            for (int i = 0; i + interval < lists.length; i += interval * 2) {
                lists[i] = merge(lists[i], lists[i + interval]);
            }

            interval *= 2;
        }

        return lists[0];
    }

    private ListNode merge(ListNode a, ListNode b) {

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (a != null && b != null) {

            if (a.val <= b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }

            cur = cur.next;
        }

        cur.next = (a != null) ? a : b;

        return dummy.next;
    }
}