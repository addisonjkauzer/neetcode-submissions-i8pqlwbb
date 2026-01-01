class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {

        Set<Integer> minRows = new HashSet<>();
        Set<Integer> maxColumns = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            Integer minRow = matrix[i][0];
            for (int j = 0; j < matrix[i].length; j++) {
                minRow = Math.min(minRow, matrix[i][j]);
            }
            minRows.add(minRow);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            Integer maxColumn = matrix[0][i];
            for (int j = 0; j < matrix.length; j++) {
                maxColumn = Math.max(maxColumn, matrix[j][i]);
            }
            maxColumns.add(maxColumn);
        }

        List<Integer> result = new ArrayList<>();

        for (Integer minRow : minRows) {
            if (maxColumns.contains(minRow)) {
                result.add(minRow);
            }
        }
        return result;
    }
}