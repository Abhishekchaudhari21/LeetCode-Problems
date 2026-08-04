class Solution {

    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] h = new int[cols + 1];     // Sentinel 0
        int ans = 0;

        ArrayDeque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < rows; i++) {

            st.clear();

            for (int j = 0; j <= cols; j++) {

                if (j < cols) {
                    h[j] = matrix[i][j] == '1'
                            ? h[j] + 1
                            : 0;
                }

                while (!st.isEmpty() && h[st.peek()] > h[j]) {

                    int height = h[st.pop()];

                    int width = st.isEmpty()
                            ? j
                            : j - st.peek() - 1;

                    ans = Math.max(ans, height * width);
                }

                st.push(j);
            }
        }

        return ans;
    }
}