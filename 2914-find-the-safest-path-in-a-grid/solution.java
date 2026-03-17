class Solution {
    public final static Integer[][] DIRECTIONS = new Integer[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        Queue<Integer[]> bfsQueue = new LinkedList<>();
        Integer[][] safetyScoreGrid = new Integer[grid.size()][grid.get(0).size()];
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) == 1) {
                    bfsQueue.add(new Integer[]{i, j});
                    safetyScoreGrid[i][j] = 0;
                }
            }
        }
        int safetyScore = 0;
        while (!bfsQueue.isEmpty()) {
            Queue<Integer[]> newQueue = new LinkedList<>();
            for (Integer[] point : bfsQueue) {
                safetyScoreGrid[point[0]][point[1]] = safetyScore;
                for (Integer[] direction : DIRECTIONS) {
                    int newRow = point[0] + direction[0];
                    int newCol = point[1] + direction[1];
                    if (newRow < safetyScoreGrid.length && newRow >= 0 && newCol < safetyScoreGrid[0].length && newCol >= 0 && safetyScoreGrid[newRow][newCol] == null) {
                        safetyScoreGrid[newRow][newCol] = -1;
                        newQueue.add(new Integer[]{newRow, newCol});
                    }
                }
            }
            safetyScore++;
            bfsQueue = newQueue;
        }

        PriorityQueue<Integer[]> nextNodes = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparing(a -> a[2])));
        boolean[][] visited = new boolean[grid.size()][grid.get(0).size()];
        nextNodes.add(new Integer[]{0, 0, safetyScoreGrid[0][0]});
        Integer maxSafety = safetyScoreGrid[0][0];
        while (!nextNodes.isEmpty()) {
            Integer[] nextNode = nextNodes.poll();
            maxSafety = Math.min(maxSafety, nextNode[2]);
            if (nextNode[0] == grid.size() - 1 && nextNode[1] == grid.get(0).size() - 1) {
                break;
            }
            for (Integer[] direction : DIRECTIONS) {
                int newRow = nextNode[0] + direction[0];
                int newCol = nextNode[1] + direction[1];
                if (newRow < safetyScoreGrid.length && newRow >= 0 && newCol < safetyScoreGrid[0].length && newCol >= 0 && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    nextNodes.add(new Integer[]{newRow, newCol, safetyScoreGrid[newRow][newCol]});
                }
            }
        }
        return maxSafety;
    }
}