class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        Integer maxValue = 0;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }

        Integer leftPointer = 1;
        Integer rightPointer = maxValue;
        Integer index = nums.length;
        while (leftPointer <= rightPointer) {
            Integer minBalls = (leftPointer + rightPointer) / 2;
            if (canDevide(nums, (double)minBalls, maxOperations)) {
                rightPointer = minBalls - 1;
                index = minBalls;
            } else {
                leftPointer = minBalls + 1;
            }
        }
        return index;
    }

    public boolean canDevide(int[] nums, double maxBalls, int maxOperations) {
        Integer totalOperations = 0;
        for (int num : nums) {
            Integer operations = (int) Math.ceil(num / maxBalls) - 1;
            totalOperations += operations;
            if (totalOperations > maxOperations) {
                return false;
            }
        }
        return true;
    }
}