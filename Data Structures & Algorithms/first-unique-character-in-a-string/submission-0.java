class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> characterCounter = new HashMap<>();
        for (char ch : s.toCharArray()) {
            characterCounter.put(ch, characterCounter.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (characterCounter.get(character) == 1) {
                return i;
            }
        }
        return -1;
    }
}