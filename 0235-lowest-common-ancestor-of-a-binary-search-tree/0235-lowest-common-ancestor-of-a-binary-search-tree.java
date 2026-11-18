
class Solution {
    public TreeNode lowestCommonAncestor(
        TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {

            // Both nodes are smaller: go left
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }

            // Both nodes are greater: go right
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }

            // Split point: current node is the LCA
            else {
                return root;
            }
        }

        return null;
    }
}
