class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int goal = 0;
        for (int num : nums) {
            goal |= num;
        }
        return dfsCountMaxOrSubsets(nums, 0, 0, goal);
    }

    public int dfsCountMaxOrSubsets(int[] nums, int index, int runningOr, int goal) {
        if (index == nums.length) {
            if (runningOr == goal) {
                return 1;
            } else {
                return 0;
            }
        }

        int skip = dfsCountMaxOrSubsets(nums, index + 1, runningOr, goal);
        int take = dfsCountMaxOrSubsets(nums, index + 1, runningOr | nums[index], goal);

        return skip + take;
    }
}