class Solution {
    public int countPaths(int n, int[][] roads) {
        if (roads.length == 0) {
            return 1;
        }
        HashMap<Long, Set<Long[]>> edgeMap = new HashMap<>();

        for (int[] road : roads) {
            Long origin = (long)road[0];
            Long destination = (long)road[1];
            Long cost = (long)road[2];
            edgeMap.computeIfAbsent(origin, a -> new HashSet<>()).add(new Long[]{destination, cost});
            edgeMap.computeIfAbsent(destination, a -> new HashSet<>()).add(new Long[]{origin, cost});
        }

        PriorityQueue<Long[]> nextIntersectionAndCostToGetThere = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        nextIntersectionAndCostToGetThere.offer(new Long[]{0L, 0L});

        HashMap<Long, Long> visitedCost = new HashMap<>();
        visitedCost.put(0L,0L);
        HashMap<Long, Long> visitedCount = new HashMap<>();
        visitedCount.put(0L, 1L);



        while (!nextIntersectionAndCostToGetThere.isEmpty()) {
            Long[] nextEdge = nextIntersectionAndCostToGetThere.poll();
            Long intersection = nextEdge[0];
            Long runningCost = nextEdge[1];

            if (runningCost > visitedCost.getOrDefault(intersection, Long.MAX_VALUE)) {
                continue;
            }
            Set<Long[]> neighbors = edgeMap.get(nextEdge[0]);
            for (Long[] neighbor : neighbors) {
                Long newIntersection = neighbor[0];
                Long newCost = neighbor[1] + runningCost;
                Long bestKnown = visitedCost.getOrDefault(newIntersection, Long.MAX_VALUE);


                if (newCost < bestKnown) {
                    visitedCost.put(newIntersection, newCost);
                    visitedCount.put(newIntersection, visitedCount.get(intersection));
                    nextIntersectionAndCostToGetThere.offer(new Long[]{newIntersection, newCost});
                } else if (bestKnown.equals(newCost)) {
                    visitedCount.put(newIntersection, (visitedCount.get(newIntersection) + visitedCount.get(intersection)) % 1_000_000_007);
                }
            }
        }
        return (int)(visitedCount.get((long)n-1) % 1_000_000_007);
    }
}