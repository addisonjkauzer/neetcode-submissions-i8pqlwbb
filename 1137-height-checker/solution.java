class Solution {
    public int heightChecker(int[] heights) {
        int[] sortedHeights = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sortedHeights);

        Integer counter = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int sortedHeight = sortedHeights[i];

            if (height != sortedHeight) {
                counter++;
            }
        }
        return counter;
    }
}