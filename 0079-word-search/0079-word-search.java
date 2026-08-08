class Solution {

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (board[r][c] == word.charAt(0) &&
                    dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word,
                         int r, int c, int i) {

        if (i == word.length())
            return true;

        if (r < 0 || r >= board.length ||
            c < 0 || c >= board[0].length ||
            board[r][c] != word.charAt(i))
            return false;

        char temp = board[r][c];

        // Mark current cell as visited
        board[r][c] = '#';

        boolean found =
                dfs(board, word, r + 1, c, i + 1) ||
                dfs(board, word, r - 1, c, i + 1) ||
                dfs(board, word, r, c + 1, i + 1) ||
                dfs(board, word, r, c - 1, i + 1);

        // Backtrack
        board[r][c] = temp;

        return found;
    }
}