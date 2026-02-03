class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> numberCounter = new HashMap<>();
        Integer goodPairs = 0;

        for (int num : nums) {
            Integer currentCount = numberCounter.getOrDefault(num, 0);
            numberCounter.put(num, currentCount + 1);
            goodPairs += currentCount;
        }

        return goodPairs;
    }
}