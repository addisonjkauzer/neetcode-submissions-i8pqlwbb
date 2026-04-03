class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int maxDepth = 0;
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                    depth++;
                    break;
                case ')':
                    depth--;
                    break;
            }
            maxDepth = Math.max(maxDepth, depth);
        }
        return maxDepth;
    }
}