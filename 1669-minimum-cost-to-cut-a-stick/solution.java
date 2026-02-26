class Solution {
    public int minCost(int n, int[] cuts) {
        return dfsMinCost(cuts, 0, n, new HashMap<>());
    }

    public int dfsMinCost(int[] cuts, int start, int end, HashMap<String, Integer> cache) {
        String key = start + "," + end;

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < cuts.length; i++) {
            if (cuts[i] >= end || cuts[i] <= start) {
                continue;
            }

            int left = dfsMinCost(cuts, start, cuts[i], cache);
            int right = dfsMinCost(cuts, cuts[i], end, cache);
            min = Math.min(min, left + right + end - start);
        }
        int result = min == Integer.MAX_VALUE ? 0 : min;
        cache.put(key, result);
        return result;
    }
}