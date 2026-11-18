
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> level = new ArrayList<>(
                Collections.nCopies(size, 0)
            );

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                int index = leftToRight ? i : size - 1 - i;

                level.set(index, node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(level);

            leftToRight = !leftToRight;
        }

        return result;
    }
}
