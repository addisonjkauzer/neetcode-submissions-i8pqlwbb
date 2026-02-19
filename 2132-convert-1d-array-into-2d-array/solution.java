class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        
        int[][] array = new int[m][n];

        if (original.length != m * n) {
            return new int[0][0];
        }

        int row = 0;
        int col = 0;
        for (int num : original) {
            array[row][col] = num;
            col++;
            if (col == n) {
                row++;
                col = 0;
            }
        }
        return array;
        
    }
}