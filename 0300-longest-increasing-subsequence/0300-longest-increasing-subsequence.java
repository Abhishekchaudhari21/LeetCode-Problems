class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        int[] tails = new int[n];
        int size = 0;

        for (int num : nums) {

            int left = 0;
            int right = size;

            // Find first element >= num
            while (left < right) {

                int mid = left + (right - left) / 2;

                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // Replace or extend
            tails[left] = num;

            if (left == size) {
                size++;
            }
        }

        return size;
    }
}
