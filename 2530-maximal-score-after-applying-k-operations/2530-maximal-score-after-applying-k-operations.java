class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            maxHeap.offer(num);
        }

        long score = 0;

        for (int i = 0; i < k; i++) {
            int maxScore = maxHeap.poll();
            score += maxScore;
            maxHeap.offer((int)Math.ceil(maxScore / 3.0));
        }
        return score;
    }
}