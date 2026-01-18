class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        long total = 0;
        long good = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer key = nums[i] - i;
            Integer count = countMap.getOrDefault(key, 0);
            good += count;
            countMap.put(key, count + 1);
            total += i;
        }
        return total - good;
    }
}