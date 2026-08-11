class Solution {

    List<TreeNode>[][] memo;

    public List<TreeNode> generateTrees(int n) {

        memo = new ArrayList[n + 2][n + 2];

        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {

        if (start > end) {
            List<TreeNode> empty = new ArrayList<>();
            empty.add(null);
            return empty;
        }

        if (memo[start][end] != null)
            return memo[start][end];

        List<TreeNode> result = new ArrayList<>();

        for (int rootVal = start; rootVal <= end; rootVal++) {

            List<TreeNode> leftTrees =
                generate(start, rootVal - 1);

            List<TreeNode> rightTrees =
                generate(rootVal + 1, end);

            for (TreeNode left : leftTrees) {

                for (TreeNode right : rightTrees) {

                    TreeNode root = new TreeNode(rootVal);

                    root.left = left;
                    root.right = right;

                    result.add(root);
                }
            }
        }

        memo[start][end] = result;

        return result;
    }
}