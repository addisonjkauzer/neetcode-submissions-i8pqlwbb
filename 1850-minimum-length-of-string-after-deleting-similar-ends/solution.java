class Solution {
    public int minimumLength(String s) {
        Integer leftPointer = 0;
        Integer rightPointer = s.length() -1;

        while (leftPointer < rightPointer) {
            char leftCharacter = s.charAt(leftPointer);
            char rightCharacter = s.charAt(rightPointer);
            if (leftCharacter == rightCharacter) {
                char savedCharacter = leftCharacter;
                while (leftPointer <= rightPointer && leftCharacter == savedCharacter && leftPointer < s.length() - 1) {
                    leftPointer++;
                    leftCharacter = s.charAt(leftPointer);
                }
                while (leftPointer <= rightPointer && rightCharacter == savedCharacter && rightPointer > 0) {
                    rightPointer--;
                    rightCharacter = s.charAt(rightPointer);
                }
            } else {
                break;
            }
        }
        return rightPointer - leftPointer + 1;
    }
}