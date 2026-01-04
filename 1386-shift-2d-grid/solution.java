class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        for (int counter = 0; counter < k; counter++) {
            int carryToNext = grid[0][0];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    int tempValue = grid[i][j];
                    grid[i][j] = carryToNext;
                    carryToNext = tempValue; 
                }
            }
            grid[0][0] = carryToNext;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : grid) {
            ArrayList<Integer> rowAsList = new ArrayList<>();
            for (int value : row) {
                rowAsList.add(value);
            }
            result.add(rowAsList);
        }
        return result;
    }
}