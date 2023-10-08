class Solution {
    HashMap<String, Integer> areaToPaths = new HashMap();
    public int uniquePaths(int m, int n) {
        if (areaToPaths.containsKey(m + "," + n)) {
            return areaToPaths.get(m + "," + n);
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int paths = uniquePaths(m-1, n) + uniquePaths(m, n-1);
        areaToPaths.put(m + "," + n, paths);
        areaToPaths.put(n + "," + m, paths);
        return paths;
    }
}