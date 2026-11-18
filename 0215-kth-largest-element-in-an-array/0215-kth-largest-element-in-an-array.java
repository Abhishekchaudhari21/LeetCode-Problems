
class Solution {
    public int findKthLargest(int[] nums, int k) {

        int target = nums.length - k;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            // Random pivot
            int pivot = nums[
                java.util.concurrent.ThreadLocalRandom.current()
                .nextInt(left, right + 1)
            ];

            int lt = left;
            int i = left;
            int gt = right;

            // 3-way partition
            while (i <= gt) {

                if (nums[i] < pivot) {
                    swap(nums, lt++, i++);
                }
                else if (nums[i] > pivot) {
                    swap(nums, i, gt--);
                }
                else {
                    i++;
                }
            }

            // Search only the required partition
            if (target < lt) {
                right = lt - 1;
            }
            else if (target > gt) {
                left = gt + 1;
            }
            else {
                return nums[target];
            }
        }

        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
