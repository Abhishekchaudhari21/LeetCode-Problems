class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;

        int[] ugly = new int[n];
        int[] index = new int[k];
        long[] next = new long[k];

        ugly[0] = 1;

        for (int j = 0; j < k; j++) {
            next[j] = primes[j];
        }

        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;

            // Find the smallest candidate
            for (int j = 0; j < k; j++) {
                min = Math.min(min, next[j]);
            }

            ugly[i] = (int) min;

            // Update all matching prime pointers
            for (int j = 0; j < k; j++) {
                if (next[j] == min) {
                    index[j]++;
                    next[j] = (long) ugly[index[j]] * primes[j];
                }
            }
        }

        return ugly[n - 1];
    }
}