class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        postIndex = postorder.length - 1;

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder,
                           int left, int right) {

        if (left > right)
            return null;

        TreeNode root = new TreeNode(postorder[postIndex--]);

        int mid = map.get(root.val);

        // Build RIGHT first
        root.right = build(inorder, postorder, mid + 1, right);

        root.left = build(inorder, postorder, left, mid - 1);

        return root;
    }
}