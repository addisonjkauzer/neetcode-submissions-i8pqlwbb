class Solution {
    public List<String> commonChars(String[] words) {
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);

        for (String word : words) {
            int[] curCount = new int[26];
            for (char character : word.toCharArray()) {
                curCount[character - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                count[i] = Math.min(count[i], curCount[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= count[i]; j++) {
                result.add(Character.toString('a' + i));
            }
        }
        return result;
    }
}