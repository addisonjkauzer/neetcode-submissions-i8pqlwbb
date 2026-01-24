class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Integer bricksRemaining = bricks;
        for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i] >= heights[i + 1]) {
                continue;
            }
            Integer difference = heights[i+1] - heights[i];
            if (minHeap.size() < ladders) {
                minHeap.offer(difference);
                continue;
            }
            minHeap.offer(difference);
            bricksRemaining -= minHeap.remove();
            if (bricksRemaining < 0) {
                return i;
            }
        }
        return heights.length - 1;
    }
}