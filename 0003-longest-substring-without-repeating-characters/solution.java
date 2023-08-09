class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        }
        String[] characters = s.split("");
        ArrayList currentSubstringCharacters = new ArrayList();
        int maxLength = 0;

        for(String character : characters) {
            int duplicateIndex = currentSubstringCharacters.indexOf(character);
            if (duplicateIndex != -1) {
                int currentSubstringLength = currentSubstringCharacters.size();
                if (currentSubstringLength > maxLength) {
                    maxLength = currentSubstringLength;
                }
                for(int i = 0; i <= duplicateIndex; i++) {
                    currentSubstringCharacters.remove(0);
                }
            }
            currentSubstringCharacters.add(character);
        }


        if (currentSubstringCharacters.size() > maxLength) {
            return currentSubstringCharacters.size();
        }

        return maxLength;
    }
}
    