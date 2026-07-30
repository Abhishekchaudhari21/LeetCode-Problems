class Solution {

    ListNode head;

    public TreeNode sortedListToBST(ListNode head) {

        this.head = head;

        int size = 0;

        while (head != null) {
            size++;
            head = head.next;
        }

        return build(0, size - 1);
    }

    private TreeNode build(int left, int right) {

        if (left > right)
            return null;

        int mid = left + (right - left) / 2;

        TreeNode leftChild = build(left, mid - 1);

        TreeNode root = new TreeNode(head.val);

        head = head.next;

        root.left = leftChild;

        root.right = build(mid + 1, right);

        return root;
    }
}