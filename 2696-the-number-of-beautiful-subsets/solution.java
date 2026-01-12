class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        return dfsBeautifulSubsets(nums, 0, k, new HashMap<>()) - 1;
    }

    public Integer dfsBeautifulSubsets(int[] nums, int index, int k, HashMap<Integer, Integer> previousValuesCount) {
        if (index == nums.length) {
            return 1;
        }
        Integer result = dfsBeautifulSubsets(nums, index + 1, k, previousValuesCount);

        if (!previousValuesCount.containsKey(nums[index] - k) && !previousValuesCount.containsKey(nums[index] + k)) {
            previousValuesCount.put(nums[index], previousValuesCount.getOrDefault(nums[index], 0) + 1);
            result += dfsBeautifulSubsets(nums, index + 1, k, previousValuesCount);
            previousValuesCount.put(nums[index], previousValuesCount.get(nums[index]) - 1);
            if (previousValuesCount.get(nums[index]) == 0) {
                previousValuesCount.remove(nums[index]);
            }
        }
        return result;
    }
}