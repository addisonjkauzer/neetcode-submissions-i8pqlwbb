class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> numCounter = new HashMap<>();
        for (int num : nums) {
            numCounter.put(num, numCounter.getOrDefault(num, 0) + 1);
        }

        for (int value : numCounter.values()) {
            if (value % 2 == 1) {
                return false;
            }
        }
        return true;
    }
}