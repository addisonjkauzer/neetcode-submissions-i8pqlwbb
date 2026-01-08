class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] newMatrix = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                newMatrix[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= newMatrix[i][j];
                colSum[j] -= newMatrix[i][j];
            }
        }
        return newMatrix;
    }
}