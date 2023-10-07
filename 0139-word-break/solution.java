class Solution {
    HashMap<String, Boolean> cache = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        if (s.length() == 0) {
            return true;
        }
        HashSet<String> dict = new HashSet(wordDict);
        for(int i = 0; i <= s.length(); i++) {
            String substring = s.substring(0,i);
            if (dict.contains(substring)) {
                if(cache.getOrDefault(s.substring(i, s.length()), wordBreak(s.substring(i, s.length()), wordDict))) {
                    return true;
                }
            }
        }
        cache.put(s, false);
        return false;
    }
}