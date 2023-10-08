class Solution {
    public int lengthOfLIS(int[] nums) {
        HashMap<Integer, Integer> numToLength = new HashMap<>();

        for(int num : nums) {
            int currentMaxLength = 1;
            for (Integer key : numToLength.keySet()) {
                if (key < num) {
                    Integer currentLength = numToLength.get(key) + 1;
                    currentMaxLength = Math.max(currentMaxLength, currentLength);
                }
            }
            int newMax;
            if (numToLength.containsKey(num)) {
                newMax = Math.max(numToLength.get(num), currentMaxLength);
            } else {
                newMax = currentMaxLength;
            }
            numToLength.put(num, newMax);
        }

        Integer answer = 0;

        for(Integer value: numToLength.values()) {
            answer = Math.max(answer, value);
        }

        return answer;
        
    }
}