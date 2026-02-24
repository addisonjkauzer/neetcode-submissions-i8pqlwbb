class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        int prefix  = 0;
        int suffix = 0;
        int base = 29;
        int lastIndex = 0;
        int power = 1;
        double mod = Math.pow(10, 9) + 7;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int charValue = c - 'a';

            prefix = (prefix * base);
            prefix = (prefix + charValue);
            suffix = (suffix + charValue * power);
            power = (power * base);

            if (prefix == suffix) {
                lastIndex = i;
            }
            
        }

        String suffixString = new StringBuilder(s.substring(lastIndex + 1)).reverse().toString();
        return suffixString + s;
    }
}