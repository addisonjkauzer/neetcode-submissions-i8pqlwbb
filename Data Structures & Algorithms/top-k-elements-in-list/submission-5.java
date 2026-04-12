class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numCounter = new HashMap<>();
        for (int num : nums) {
            numCounter.put(num, numCounter.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[1]));

        for (Integer key : numCounter.keySet()) {
            if (minHeap.size() < k) {
                minHeap.add(new Integer[]{key, numCounter.get(key)});
                continue;
            }
            if (minHeap.peek()[1] < numCounter.get(key)) {
                minHeap.poll();
                minHeap.add(new Integer[]{key, numCounter.get(key)});
            }
        }
        return minHeap.stream().map(a -> a[0]).mapToInt(a -> a).toArray();
    }

}
