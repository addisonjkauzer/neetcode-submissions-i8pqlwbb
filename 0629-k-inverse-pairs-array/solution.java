class Solution {
    private static final int MOD = 1_000_000_007;


    public int kInversePairs(int n, int k) {
        int[] prev = new int[k+1];
        prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] current = new int[k+1];
            int total = 0;
            for (int j = 0; j <= k; j++) {
                if (j >= i) {
                    total = (total - prev[j - i] + MOD) % MOD;
                }
                total = (total + prev[j]) % MOD;
                current[j] = total;
            }
            prev = current;
        }
        return prev[k];
    }
}