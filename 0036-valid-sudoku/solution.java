class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> duplicateChecker = new HashSet();

        for (char[] row : board) {
            for (char item : row) {
                if (duplicateChecker.contains(item)) {
                    return false;
                }
                if (item != '.') {
                    duplicateChecker.add(item);
                }
            }
            duplicateChecker.clear();
        }

        for (int i = 0; i < board[0].length; i++) {
            for (char[] row : board) {
                char item = row[i];
                if (duplicateChecker.contains(item)) {
                    return false;
                }
                if (item != '.') {
                    duplicateChecker.add(item);
                }
            }
            duplicateChecker.clear();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!subsquareChecker(board, i * 3, j * 3)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean subsquareChecker(char[][] board, int startingX, int startingY) {

        HashSet<Character> duplicateChecker = new HashSet();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char item = board[i+startingX][j+startingY];
                if (duplicateChecker.contains(item)) {
                    return false;
                }
                if (item != '.') {
                    duplicateChecker.add(item);
                }
            }
        }
        return true;
    }
}
