class Solution {

    public final static Integer MOD = 1_000_000_007;
    public int numMusicPlaylists(int n, int goal, int k) {
        return (int)numMusicPlaylists(n, goal, k, 0, 0, new HashMap<>());
        
    }

    public long numMusicPlaylists(int n, int remainingSlots, int k, int numbersUsed, int onCoolDown, HashMap<String, Long> cache) {
        if (onCoolDown > k) {
            onCoolDown = k;
        }
        int remainingNumbers = n - numbersUsed;
        if (remainingNumbers > remainingSlots) {
            return 0;
        }
        if (remainingSlots == 0) {
            return 1;
        }

        String key = remainingSlots + "," + numbersUsed + "," + onCoolDown;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        // reuse number
        int reuseOptions = numbersUsed - onCoolDown;
        long total = reuseOptions * numMusicPlaylists(n, remainingSlots - 1, k, numbersUsed, onCoolDown + 1, cache);
        total %= MOD;

        //pick newNumber
        total += remainingNumbers * numMusicPlaylists(n, remainingSlots - 1, k, numbersUsed + 1, onCoolDown + 1, cache);
        total %= MOD;

        cache.put(key, total);
        return total;

    }
}