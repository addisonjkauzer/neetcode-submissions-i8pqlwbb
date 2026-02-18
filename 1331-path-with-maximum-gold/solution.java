class Solution {

    private final static Integer[][] DIRECTIONS = {{1,0},{0,1},{-1,0},{0,-1}};
    public int getMaximumGold(int[][] grid) {
        Integer max = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                max = Math.max(max, dfsMaxGold(grid, row, col, new HashSet<>()));
            }
        }
        return max;
    }

    public int dfsMaxGold(int[][] grid, int row, int col, HashSet<String> seen) {
        String key = row + "," + col;
        if (row >= grid.length || row < 0 || col >= grid[row].length || col < 0 || seen.contains(key) || grid[row][col] == 0) {
            return 0;
        }
        seen.add(key);
        Integer maxGold = 0;
        for (Integer[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            maxGold = Math.max(maxGold, dfsMaxGold(grid, newRow, newCol, seen));
        }
        seen.remove(key);
        return maxGold + grid[row][col];
    }
}