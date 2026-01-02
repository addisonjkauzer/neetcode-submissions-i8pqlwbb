class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> subarrays = getSubArraySums(nums);
        Collections.sort(subarrays);
        Integer index = left - 1;
        Integer sum = 0;
        Integer MOD = (int) Math.pow(10, 9) + 7;
        while (index < right) {
            sum += subarrays.get(index);
            sum %= MOD;
            index++;
        }
        return sum;

    }

    public List<Integer> getSubArraySums(int[] nums) {
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Integer currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                sums.add(currentSum);
            }
        }
        return sums;
    }
}