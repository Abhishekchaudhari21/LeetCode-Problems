class Solution {

    private final Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {

        if (s1.equals(s2))
            return true;

        String key = s1 + "#" + s2;

        if (memo.containsKey(key))
            return memo.get(key);

        int n = s1.length();

        // Character-frequency pruning
        int[] count = new int[26];

        for (int i = 0; i < n; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int x : count) {
            if (x != 0) {
                memo.put(key, false);
                return false;
            }
        }

        for (int cut = 1; cut < n; cut++) {

            // No swap
            if (isScramble(
                    s1.substring(0, cut),
                    s2.substring(0, cut)
                )
                &&
                isScramble(
                    s1.substring(cut),
                    s2.substring(cut)
                )) {

                memo.put(key, true);
                return true;
            }

            // Swap
            if (isScramble(
                    s1.substring(0, cut),
                    s2.substring(n - cut)
                )
                &&
                isScramble(
                    s1.substring(cut),
                    s2.substring(0, n - cut)
                )) {

                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }
}