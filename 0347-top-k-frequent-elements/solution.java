class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> counts = new HashMap();

        for(int num : nums) {
            Integer currentValue = counts.getOrDefault(num, 0);
            counts.put(num, ++currentValue);
        }
        
        Integer[] topKeys = new Integer[k];
        Integer[] topValues = new Integer[k];

        int counter = 0;

        for(Integer key : counts.keySet()) {
            Integer value = counts.get(key);
            if (counter < k ) {
                topKeys[counter] = key;
                topValues[counter] = value;
                counter++;
                continue;
            }
            Integer lowestValue = topValues[0];
            Integer lowestIndex = 0;
            for (int i = 1; i < k; i++) {
                Integer current = topValues[i];
                if(current < lowestValue) {
                    lowestValue = current;
                    lowestIndex = i;
                }
            }
            if(value > lowestValue) {
                topKeys[lowestIndex] = key;
                topValues[lowestIndex] = value;
            }
        }
        int[] answer = new int[k];
        for(int i = 0; i < k; i++) {
            answer[i] = topKeys[i];
        }
        return answer;
    }
}