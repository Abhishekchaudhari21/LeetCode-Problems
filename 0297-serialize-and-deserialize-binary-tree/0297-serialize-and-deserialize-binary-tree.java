
public class Codec {

    // Serialize: Tree -> String
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        buildString(root, sb);

        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {

        if (node == null) {
            sb.append("#,");
            return;
        }

        // Root
        sb.append(node.val).append(",");

        // Left subtree
        buildString(node.left, sb);

        // Right subtree
        buildString(node.right, sb);
    }

    // Deserialize: String -> Tree
    public TreeNode deserialize(String data) {

        String[] values = data.split(",");
        int[] index = {0};

        return buildTree(values, index);
    }

    private TreeNode buildTree(String[] values, int[] index) {

        String value = values[index[0]++];

        // Null node
        if (value.equals("#")) {
            return null;
        }

        TreeNode node = new TreeNode(
            Integer.parseInt(value)
        );

        // Rebuild left and right subtrees
        node.left = buildTree(values, index);
        node.right = buildTree(values, index);

        return node;
    }
}
