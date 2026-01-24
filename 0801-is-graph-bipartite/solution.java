class Solution {
    public boolean isBipartite(int[][] graph) {

        int[] groups = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (groups[i] != 0) {
                continue;
            }
            Queue<Integer> bfsQueue = new LinkedList<>();
            bfsQueue.offer(i);
            Integer currentColor = 1;
            while(!bfsQueue.isEmpty()) {
                Queue<Integer> newQueue = new LinkedList<>();
                for (Integer node : bfsQueue) {
                    groups[node] = currentColor;
                    int[] neighbors = graph[node];
                    for (int neighbor : neighbors) {
                        if (groups[neighbor] == currentColor) {
                            return false;
                        }
                        if (groups[neighbor] == 0) {
                            newQueue.offer(neighbor);
                        }
                    }
                }
                currentColor *= -1;
                bfsQueue = newQueue;
            }
        }
        return true;
        
    }


}