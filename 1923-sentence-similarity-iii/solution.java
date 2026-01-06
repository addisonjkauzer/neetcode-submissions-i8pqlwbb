class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        String[] longerSentence = words1.length > words2.length ? words1 : words2;
        String[] shorterSentence = words1.length > words2.length ? words2 : words1;

        //Identify if Prefix
        return isPrefix(shorterSentence, longerSentence) || isSuffix(shorterSentence, longerSentence) || isPrefixAndSuffix(shorterSentence, longerSentence);
    }

    public boolean isPrefix(String[] shorterSentence, String[] longerSentence) {
        for (int i = 0; i < shorterSentence.length; i++) {
            if (!shorterSentence[i].equals(longerSentence[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean isSuffix(String[] shorterSentence, String[] longerSentence) {
        for (int i = 0; i < shorterSentence.length; i++) {
            Integer shorterSentenceIndex = shorterSentence.length - 1 - i;
            Integer longerSentenceIndex = longerSentence.length - 1 - i;
            if (!shorterSentence[shorterSentenceIndex].equals(longerSentence[longerSentenceIndex])) {
                return false;
            }
        }
        return true;
    }


    public boolean isPrefixAndSuffix(String[] shorterSentence, String[] longerSentence) {
        Integer index = 0;
        while (shorterSentence[index].equals(longerSentence[index])) {
            index++;
        }
        Integer longerIndex = longerSentence.length - 1;
        for (int i = shorterSentence.length - 1; i >= index; i--) {
            if (!shorterSentence[i].equals(longerSentence[longerIndex])) {
                return false;
            }
            longerIndex--;
        }
        return true;
    }
}