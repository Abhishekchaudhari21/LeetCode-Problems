class Solution {

    public void recoverTree(TreeNode root) {

        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;
        TreeNode curr = root;

        while (curr != null) {

            if (curr.left == null) {

                // Process current node
                if (prev != null && prev.val > curr.val) {

                    if (first == null)
                        first = prev;

                    second = curr;
                }

                prev = curr;
                curr = curr.right;

            } else {

                // Find inorder predecessor
                TreeNode pred = curr.left;

                while (pred.right != null &&
                       pred.right != curr) {

                    pred = pred.right;
                }

                if (pred.right == null) {

                    // Create temporary thread
                    pred.right = curr;
                    curr = curr.left;

                } else {

                    // Remove temporary thread
                    pred.right = null;

                    // Process current node
                    if (prev != null && prev.val > curr.val) {

                        if (first == null)
                            first = prev;

                        second = curr;
                    }

                    prev = curr;
                    curr = curr.right;
                }
            }
        }

        // Swap the two incorrect values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}