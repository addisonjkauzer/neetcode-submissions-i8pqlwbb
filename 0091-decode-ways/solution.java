class Solution {
    HashMap<String, Integer> cache = new HashMap();

    public int numDecodings(String s) {

        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        if (s.length() <= 1 && !s.equals("0")) {
            return 1;
        }
        if (s.length() <= 1) {
            return 0;
        }

        char[] characters = s.toCharArray();

        for(int i = 0; i < characters.length; i = i + 2) {
            char character = characters[i];
            char character2 = characters[i+1];
            if (character == '0') {
                cache.put(s, 0);
                return 0;
            }
            if(character == '1') {
                int withoutNextchar = cache.getOrDefault(s.substring(i+2, s.length()), numDecodings(s.substring(i+2, s.length())));
                int withNextChar = cache.getOrDefault(s.substring(i+1, s.length()), numDecodings(s.substring(i+1, s.length())));
                cache.put(s, withNextChar + withoutNextchar);
                return withNextChar + withoutNextchar;
            }
            if (character == '2' && (character2 == '0' ||character2 == '2' || character2 == '3' || character2 == '4' || character2 == '5' || character2 == '6' || character2 == '1')) {
                int withoutNextchar = cache.getOrDefault(s.substring(i+2, s.length()), numDecodings(s.substring(i+2, s.length())));
                int withNextChar = cache.getOrDefault(s.substring(i+1, s.length()), numDecodings(s.substring(i+1, s.length())));
                cache.put(s, withNextChar + withoutNextchar);
                return withNextChar + withoutNextchar;
            }
            int withNextChar = numDecodings(s.substring(i+1, s.length()));
            cache.put(s, withNextChar);
            return withNextChar;
        }
        return 1;  
    }
}