class Solution {
    public int removeDuplicates(int[] nums) {
        int current = nums[0];
        int currentIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (current != nums[i]) {
                nums[currentIndex] = nums[i];
                currentIndex++;
                current = nums[i];
            }
        }
        return currentIndex;
    }
}