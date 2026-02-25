class Solution {
    public int maxUniqueSplit(String s) {
        return dfsMaxUniqueSplit(s, 0, 1, new HashSet<>());
    }

    public int dfsMaxUniqueSplit(String s, int left, int right, Set<String> existing) {
        if (right == s.length()) {
            if (existing.contains(s.substring(left, right))) {
                return 0;
            } else {
                return existing.size() + 1;
            }
        }
        //continue word
        int result = dfsMaxUniqueSplit(s, left, right + 1, existing);

        //new word
        if (!existing.contains(s.substring(left, right))) { 
            existing.add(s.substring(left, right));
            result = Math.max(result, dfsMaxUniqueSplit(s, right, right + 1, existing));
            existing.remove(s.substring(left, right));
        }

        return result;
    }
}