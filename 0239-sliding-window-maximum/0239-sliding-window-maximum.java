class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        if (n == 1)
            return nums;

        int[] ans = new int[n - k + 1];

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        int idx = 0;

        for (int i = 0; i < n; i++) {

            // Remove indices outside the window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k)
                dq.pollFirst();

            // Remove smaller elements
            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] <= nums[i])
                dq.pollLast();

            dq.offerLast(i);

            if (i >= k - 1)
                ans[idx++] = nums[dq.peekFirst()];
        }

        return ans;
    }
}