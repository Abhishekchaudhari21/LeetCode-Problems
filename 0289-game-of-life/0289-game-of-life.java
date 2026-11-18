
class Solution {
    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        // All 8 possible directions
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            { 0, -1},          { 0, 1},
            { 1, -1}, { 1, 0}, { 1, 1}
        };

        // First pass: Calculate next state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int liveNeighbors = 0;

                // Count originally alive neighbors
                for (int[] d : directions) {

                    int r = i + d[0];
                    int c = j + d[1];

                    if (r >= 0 && r < m &&
                        c >= 0 && c < n &&
                        (board[r][c] == 1 || board[r][c] == 2)) {

                        liveNeighbors++;
                    }
                }

                // Apply Game of Life rules
                if (board[i][j] == 1) {

                    if (liveNeighbors < 2 ||
                        liveNeighbors > 3) {
                        board[i][j] = 2; // Alive -> Dead
                    }

                } else {

                    if (liveNeighbors == 3) {
                        board[i][j] = 3; // Dead -> Alive
                    }
                }
            }
        }

        // Second pass: Convert temporary states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] %= 2;
            }
        }
    }
}
