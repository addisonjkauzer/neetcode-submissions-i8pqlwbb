class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return dfsMaxSum(arr, k, 0, new HashMap<>());
    }

    public int dfsMaxSum(int[] arr, int k, int index, HashMap<Integer, Integer> cache) {
        if (index >= arr.length) {
            return 0;
        }
        if (cache.containsKey(index)) {
            return cache.get(index);
        }
        int max = 0;
        int toReplace = arr[index];
        for (int i = 1; i <= k; i++) {
            int result = i * toReplace + dfsMaxSum(arr, k, index + i, cache);
            if (index + i < arr.length) {
                toReplace = Math.max(toReplace, arr[index + i]);
            } else {
                toReplace = 0;
            }
            max = Math.max(max, result);
        }
        cache.put(index, max);
        return max;
    }
}