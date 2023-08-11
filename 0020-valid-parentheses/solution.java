class Solution {
    public boolean isValid(String s) {
        char[] characters = s.toCharArray();
        Stack<Character> stack = new Stack();

        for(char character : characters) {
            if(!stack.empty() && stack.peek() == character) {
                stack.pop();
                continue;
            }
            if (character == '(') {
                stack.push(')');
            } else if (character == '{') {
                stack.push('}');
            } else if (character == '[') {
                stack.push(']');
            } else {
                return false;
            }
        }

        if (stack.empty()) {
            return true;
        }
        return false;
    }
}