class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;

        long[] prefix = new long[n + 1];

        // Build prefix sums
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        return mergeSort(prefix, 0, n + 1, lower, upper);
    }

    private int mergeSort(long[] prefix, int left, int right,
                          int lower, int upper) {

        if (right - left <= 1) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        int count = mergeSort(prefix, left, mid, lower, upper)
                  + mergeSort(prefix, mid, right, lower, upper);

        int low = mid;
        int high = mid;

        // Count valid cross-half range sums
        for (int i = left; i < mid; i++) {

            while (low < right &&
                   prefix[low] - prefix[i] < lower) {
                low++;
            }

            while (high < right &&
                   prefix[high] - prefix[i] <= upper) {
                high++;
            }

            count += high - low;
        }

        // Merge two sorted halves
        long[] temp = new long[right - left];

        int i = left;
        int j = mid;
        int k = 0;

        while (i < mid && j < right) {
            if (prefix[i] <= prefix[j]) {
                temp[k++] = prefix[i++];
            } else {
                temp[k++] = prefix[j++];
            }
        }

        while (i < mid) {
            temp[k++] = prefix[i++];
        }

        while (j < right) {
            temp[k++] = prefix[j++];
        }

        System.arraycopy(temp, 0, prefix, left, temp.length);

        return count;
    }
}