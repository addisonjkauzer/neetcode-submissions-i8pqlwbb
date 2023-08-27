class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        boolean[][] pacificFlows = new boolean[heights.length][heights[0].length];
        boolean[][] atlanticFlows = new boolean[heights.length][heights[0].length];

        for(int i=0; i < heights.length; i++) {
            dfs(heights, i, 0, pacificFlows, heights[i][0]);
            dfs(heights, i, heights[0].length-1, atlanticFlows, heights[i][heights[0].length-1]);
        }
        for(int j=0; j < heights[0].length; j++) {
            dfs(heights, 0, j, pacificFlows, heights[0][j]);
            dfs(heights, heights.length - 1, j, atlanticFlows, heights[heights.length-1][j]);
        }

        List<List<Integer>> solution = new ArrayList();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacificFlows[i][j] && atlanticFlows[i][j]) {
                    ArrayList indexes = new ArrayList(Arrays.asList(i, j));
                    solution.add(indexes);
                }
            }
        }
        return solution;
    }

    public void dfs(int[][] heights, int i, int j, boolean[][] visited, int previousHeight) {
        if ( i < 0 || i > heights.length - 1 || j < 0 || j > heights[0].length - 1 || visited[i][j] || previousHeight > heights[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(heights, i + 1, j, visited, heights[i][j]);
        dfs(heights, i - 1, j, visited, heights[i][j]);
        dfs(heights, i, j + 1, visited, heights[i][j]);
        dfs(heights, i, j - 1, visited, heights[i][j]);
    }
}