class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        Integer maxInt = 0;
        Integer maxCount = 0;

        for (Integer num : nums) {
            int newCount = counter.getOrDefault(num, 0) + 1;
            if (newCount > maxCount) {
                maxCount = newCount;
                maxInt = num;
            }
            counter.put(num, newCount);
        }

        int dominantCount = 0;
        int otherCount = 0;

        for (int i = 0; i < nums.size(); i++) {
            Integer num = nums.get(i);
            if (num.equals(maxInt)) {
                dominantCount++;
            } else {
                otherCount++;
            }
            int remainingDom = maxCount - dominantCount;
            int totalRemaining = nums.size() - 1 - i;
            if (dominantCount > otherCount && remainingDom > totalRemaining / 2) {
                return i;
            }
        }
        return -1;
    }
}