class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int leftIndexOfMax = 0;
        int rightIndexOfMax = 0;
        if (s.length() == 0) {
            return s;
        }

        char[] characters = s.toCharArray();

        for(int i = 0; i < characters.length; i++) {
            //Odd Length
            int[] expandedIndexes = expandPalindromeIndexes(characters, i, i);
            int expandedLength = expandedIndexes[1] - expandedIndexes[0] + 1;
            if (expandedLength > maxLength) {
                maxLength = expandedLength;
                leftIndexOfMax = expandedIndexes[0];
                rightIndexOfMax = expandedIndexes[1];
            }

            //Even Length
            if (i+1 < characters.length && characters[i] == characters[i+1]) {
                expandedIndexes = expandPalindromeIndexes(characters, i, i+1);
                expandedLength = expandedIndexes[1] - expandedIndexes[0] + 1;
                if (expandedLength > maxLength) {
                    maxLength = expandedLength;
                    leftIndexOfMax = expandedIndexes[0];
                    rightIndexOfMax = expandedIndexes[1];
                }
            }

        }
        return s.substring(leftIndexOfMax, rightIndexOfMax+1);
    }

    private int[] expandPalindromeIndexes(char[] characters, int startIndex, int endIndex) {

        while(startIndex >= 0 && endIndex < characters.length && characters[startIndex] == characters[endIndex]) {
            startIndex--;
            endIndex++;
        }
        startIndex++;
        endIndex--;

        int[] indexes = {startIndex, endIndex};
        return indexes;
    }
}