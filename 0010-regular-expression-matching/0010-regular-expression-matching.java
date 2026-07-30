class Solution {
    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = m; i >= 0; i--) {

            boolean[] next = new boolean[n + 1];
            next[n] = (i == m);

            for (int j = n - 1; j >= 0; j--) {

                boolean match =
                        i < m &&
                        (s.charAt(i) == p.charAt(j) ||
                         p.charAt(j) == '.');

                if (j + 1 < n && p.charAt(j + 1) == '*') {

                    next[j] =
                            next[j + 2] ||
                            (match && dp[j]);

                } else {

                    next[j] =
                            match && dp[j + 1];
                }
            }

            dp = next;
        }

        return dp[0];
    }
}