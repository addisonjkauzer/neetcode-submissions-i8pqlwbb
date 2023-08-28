class Solution {
    int globalCounter = 0;
    public int countSubstrings(String s) {
        globalCounter = 0;
        if (s.length() == 0) {
            return 0;
        }

        char[] characters = s.toCharArray();

        for(int i = 0; i < characters.length; i++) {
            //Odd Length
            expandPalindromeIndexes(characters, i, i);

            //Even Length
            if (i+1 < characters.length && characters[i] == characters[i+1]) {
                expandPalindromeIndexes(characters, i, i+1);
            }

        }
        return globalCounter;
    }

    private void expandPalindromeIndexes(char[] characters, int startIndex, int endIndex) {

        while(startIndex >= 0 && endIndex < characters.length && characters[startIndex] == characters[endIndex]) {
            globalCounter++;
            startIndex--;
            endIndex++;
        }
    }
}