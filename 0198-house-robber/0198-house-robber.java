
class Solution {
    public int rob(int[] nums) {

        int prev2 = 0;
        int prev1 = 0;

        for (int money : nums) {

            int current = Math.max(
                prev1,           // Skip current house
                prev2 + money    // Rob current house
            );

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
