class Solution {
    public int minFallingPathSum(int[][] matrix) {
        Integer minValue = Integer.MAX_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            minValue = Math.min(minValue, dfsMinFallingPath(matrix, 0, j, new HashMap<>()));
        }
        return minValue;
    }

    public int dfsMinFallingPath(int[][] matrix, int i, int j, HashMap<String, Integer> cache) {
        String key = i + "," + j;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (j == matrix[0].length || j == -1) {
            return 101 * matrix.length;
        }
        if (i == matrix.length) {
            return 0;
        }
        Integer fallLeft = dfsMinFallingPath(matrix, i + 1, j-1, cache);
        Integer fallMiddle = dfsMinFallingPath(matrix, i + 1, j, cache);
        Integer fallRight = dfsMinFallingPath(matrix, i + 1, j + 1, cache);

        Integer minFalling = matrix[i][j] + Math.min(fallLeft, Math.min(fallMiddle, fallRight));
        cache.put(key, minFalling);
        return minFalling;

    }
}