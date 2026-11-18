
class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {

        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {

            int index = word.charAt(i) - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int index) {

        // Entire pattern matched
        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        // Wildcard: try all possible characters
        if (c == '.') {

            for (TrieNode child : node.children) {

                if (child != null &&
                    dfs(child, word, index + 1)) {
                    return true;
                }
            }

            return false;
        }

        // Normal character: follow only one path
        int position = c - 'a';

        TrieNode child = node.children[position];

        if (child == null) {
            return false;
        }

        return dfs(child, word, index + 1);
    }
}
