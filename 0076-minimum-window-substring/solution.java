class Solution {
    public String minWindow(String s, String t) {

        char[] charactersOfT = t.toCharArray();
        HashMap<Character, Integer> tCounter = new HashMap();

        for (char character : charactersOfT) {
            int currentCounter = tCounter.getOrDefault(character, 0);
            currentCounter++;
            tCounter.put(character, currentCounter);
        }


        int start = 0;
        char[] characters = s.toCharArray();

        int answerStart = 0;
        int answerEnd = s.length();

        boolean hasSolution = false;

        for (int end = 0; end < s.length(); end++) {
            if (tCounter.containsKey(characters[end])) {
                int currentCounter = tCounter.get(characters[end]);
                currentCounter--;
                tCounter.put(characters[end], currentCounter);
            }

            while (isSolved(tCounter)) {
                hasSolution = true;
                if (end - start < answerEnd - answerStart) {
                    answerStart = start;
                    answerEnd = end;
                }

                char startCharacter = characters[start];
                if (tCounter.containsKey(startCharacter)) {
                    int currentCount = tCounter.get(startCharacter);
                    currentCount++;
                    tCounter.put(startCharacter, currentCount);
                }
                start++;
            }
        }

        String answer = "";

        if (!hasSolution) {
            return answer;
        }

        for (int i = answerStart; i <= answerEnd; i++) {
            answer += characters[i];
        }

        return answer;
    }

    private boolean isSolved(HashMap<Character, Integer> map) {

        for (int value : map.values()) {
            if (value > 0 ) {
                return false;
            }
        }
        return true;
    }
}