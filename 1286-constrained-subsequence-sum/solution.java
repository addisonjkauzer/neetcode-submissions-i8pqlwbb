class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<Integer[]> maxHeap = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparing(a -> a[0])));
        
        maxHeap.offer(new Integer[]{nums[0], 0});

        Integer result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            while (maxHeap.peek()[1] < i - k) {
                maxHeap.poll();
            }

            Integer currentMax = Math.max(nums[i], maxHeap.peek()[0] + nums[i]);
            result = Math.max(currentMax, result);

            maxHeap.offer(new Integer[]{currentMax, i});
        }
        return result;
    }
}