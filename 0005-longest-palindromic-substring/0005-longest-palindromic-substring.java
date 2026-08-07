class Solution {

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2)
            return s;

        StringBuilder t = new StringBuilder("^");

        for (char c : s.toCharArray()) {
            t.append("#").append(c);
        }

        t.append("#$");

        int n = t.length();

        int[] p = new int[n];

        int center = 0;
        int right = 0;

        int maxLen = 0;
        int centerIndex = 0;

        for (int i = 1; i < n - 1; i++) {

            int mirror = 2 * center - i;

            if (i < right)
                p[i] = Math.min(right - i, p[mirror]);

            while (t.charAt(i + 1 + p[i]) ==
                   t.charAt(i - 1 - p[i])) {
                p[i]++;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2;

        return s.substring(start, start + maxLen);
    }
}