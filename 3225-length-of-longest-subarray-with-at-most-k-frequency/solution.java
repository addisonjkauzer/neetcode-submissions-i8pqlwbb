class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> intCounter = new HashMap<>();
        Integer maxLength = 0;
        Integer leftPointer = 0;
        Integer rightPointer = 0;

        while (rightPointer < nums.length) {
            intCounter.put(nums[rightPointer], intCounter.getOrDefault(nums[rightPointer], 0) + 1);
            while (intCounter.get(nums[rightPointer]) > k) {
                intCounter.put(nums[leftPointer], intCounter.get(nums[leftPointer]) - 1);
                if (intCounter.get(nums[leftPointer]) == 0) {
                    intCounter.remove(nums[leftPointer]);
                }
                leftPointer++;
            }
            maxLength = Math.max(maxLength, rightPointer - leftPointer + 1);
            rightPointer++;
        }
        return maxLength;
    }
}