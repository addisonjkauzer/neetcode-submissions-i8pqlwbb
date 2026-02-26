class Solution {
    public int specialArray(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();

        for (int i = 0; i <= max; i++) {
            int greaterThanI = 0;
            for (int num : nums) {
                if (num >= i) {
                    greaterThanI++;
                }
            }
            if (greaterThanI == i) {
                return i;
            }
        }
        return -1;
        
    }
}