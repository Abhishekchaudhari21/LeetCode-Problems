
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {

        // Both nodes are null: symmetric
        if (left == null && right == null) {
            return true;
        }

        // Only one node is null: not symmetric
        if (left == null || right == null) {
            return false;
        }

        // Values must match
        if (left.val != right.val) {
            return false;
        }

        // Compare opposite children
        return isMirror(left.left, right.right) &&
               isMirror(left.right, right.left);
    }
}
