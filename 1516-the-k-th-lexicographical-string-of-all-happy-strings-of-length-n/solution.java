class Solution {
    public String getHappyString(int n, int k) {
        StringBuilder result = new StringBuilder();
        Integer numberOfStrings = (int) Math.pow(2, n - 1);
        numberOfStrings *= 3;
        Integer oneThird = numberOfStrings / 3;

        Character lastCharacter;
        if (k <= oneThird) {
            result.append('a');
            lastCharacter = 'a';
        } else if (k <= 2 * oneThird) {
            result.append('b');
            lastCharacter = 'b';
            k -=  oneThird;
        } else if (k <= numberOfStrings) {
            result.append('c');
             lastCharacter = 'c';
            k -= 2 * oneThird;
        } else {
            return "";
        }
        n--;

        while (n > 0) {
            numberOfStrings = (int) Math.pow(2, n);
            Integer oneHalf = numberOfStrings / 2;
            if (k <= oneHalf) {
                if (lastCharacter == 'a') {
                    result.append('b');
                    lastCharacter = 'b';
                } else {
                    result.append('a');
                    lastCharacter = 'a';
                }
            } else if (k <= numberOfStrings) {
                if (lastCharacter == 'c') {
                    result.append('b');
                    lastCharacter = 'b';
                } else {
                    result.append('c');
                    lastCharacter = 'c';
                }
                k -= oneHalf;
            } else {
                return "";
            }
            n--;
        }
        return result.toString();
    }
}