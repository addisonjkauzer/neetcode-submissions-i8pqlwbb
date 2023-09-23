class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> holder = new HashMap();
        for (int num : nums) {
                holder.put(num, false);
        }

        int longestLength = 0;

        for (Integer key : holder.keySet()) {
            if (holder.get(key)) {
                continue;
            }
            int length = 0;
            while(holder.containsKey(key)) {
                holder.put(key, true);
                key++;
                length++;
            }
            if (length > longestLength) {
                longestLength = length;
            }
        }

        return longestLength;
    }
}