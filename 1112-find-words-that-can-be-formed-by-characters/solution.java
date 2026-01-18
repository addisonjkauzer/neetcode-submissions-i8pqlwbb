class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> characterCounter = new HashMap<>();
        for (char character : chars.toCharArray()) {
            characterCounter.put(character, characterCounter.getOrDefault(character, 0) + 1);
        }

        Integer goodWords = 0;
        for (String word : words) {
            HashMap<Character, Integer> wordCharCounter = new HashMap<>();
            boolean goodWord = true;
            for (char character : word.toCharArray()) {
                Integer count = wordCharCounter.getOrDefault(character, 0) + 1;
                if (count > characterCounter.getOrDefault(character, 0)) {
                    goodWord = false;
                    break;
                }
                wordCharCounter.put(character, count);
            }
            if (goodWord) goodWords += word.length();
        }
        return goodWords;
    }
}