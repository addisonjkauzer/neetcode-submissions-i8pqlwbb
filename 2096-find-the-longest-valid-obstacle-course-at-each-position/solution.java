class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] result = new int[obstacles.length];
        Integer[] countToLowestHeight = new Integer[obstacles.length + 1];
        Arrays.fill(countToLowestHeight, Integer.MAX_VALUE);

        for (Integer i = 0; i < obstacles.length; i++) {
            Integer count = upperBound(obstacles, i, countToLowestHeight);
            result[i] = count + 1;
            countToLowestHeight[count] = obstacles[i];
        }
        return result;

    }

    public int upperBound(int[] obstacles, Integer index, Integer[] countToLowestHeight) {
        Integer leftIndex = 0;
        Integer rightIndex = countToLowestHeight.length - 1;
        Integer resultIndex = 0;

        while (leftIndex < rightIndex) {
            Integer middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            Integer heightValue = countToLowestHeight[middleIndex];
            if (heightValue <= obstacles[index]) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex;
            }
        }
        return leftIndex;
    }
}