class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];

        backtrack(nums, used);

        return ans;
    }

    private void backtrack(int[] nums, boolean[] used) {

        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i])
                continue;

            // Skip duplicate at the same recursion level
            if (i > 0 &&
                nums[i] == nums[i - 1] &&
                !used[i - 1])
                continue;

            used[i] = true;
            path.add(nums[i]);

            backtrack(nums, used);

            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}