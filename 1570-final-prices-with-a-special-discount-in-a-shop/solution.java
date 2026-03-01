class Solution {
    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer[]> monotonicStack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!monotonicStack.isEmpty() && prices[i] <= monotonicStack.peek()[1]) {
                Integer[] previousPrice = monotonicStack.pop();
                result[previousPrice[0]] = previousPrice[1] - prices[i];
            }
            monotonicStack.push(new Integer[]{i, prices[i]});
        }
        while (!monotonicStack.isEmpty()) {
            Integer[] previousPrice = monotonicStack.pop();
            result[previousPrice[0]] = previousPrice[1];
        }
        return result;
    }
}