class Solution {
    public boolean check(int[] nums) {
        Integer numberOfLessThan = 0;
        Integer previousNumber = nums[0];
        for (int num : nums) {
            if (num < previousNumber) {
                numberOfLessThan++;
            }
            previousNumber = num;
        }
        if (nums[0] < nums[nums.length -1]) {
            numberOfLessThan++;
        }

        if (numberOfLessThan > 1) {
            return false;
        }
        return true;
        
    }
}