class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int lastWord1Index = -1;
        int lastWord2Index = -1;
        int shortestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (word.equals(word1)) {
                if (lastWord2Index != -1) {
                    int distance = i - lastWord2Index;
                    shortestDistance = Math.min(distance, shortestDistance);
                }
                lastWord1Index = i;
            }
            if (word.equals(word2)) {
                if (lastWord1Index != -1) {
                    int distance = i - lastWord1Index;
                    shortestDistance = Math.min(distance, shortestDistance);
                }
                lastWord2Index = i;
            }
        }
        return shortestDistance;
    }
}
