class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Integer, Integer> remainingTasks = new HashMap<>();
        for (char task : tasks) {
            remainingTasks.put((int)task, remainingTasks.getOrDefault((int)task, 0) + 1);
        }

        PriorityQueue<Integer[]> availableTasks = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparing(a -> a[1])));
        for (Integer task : remainingTasks.keySet()) {
            availableTasks.add(new Integer[]{task, remainingTasks.get(task)});
        }

        Queue<Integer[]> unavailableTasks = new LinkedList<>();

        int currentTime = 1;

        while (!availableTasks.isEmpty() || !unavailableTasks.isEmpty()) {
            while (!unavailableTasks.isEmpty() && unavailableTasks.peek()[1] <= currentTime) {
                Integer[] nowAvailableTask = unavailableTasks.poll();
                availableTasks.add(new Integer[]{nowAvailableTask[0], nowAvailableTask[2]});
            }
            if (availableTasks.isEmpty()) {
                currentTime = unavailableTasks.peek()[1];
                continue;
            }

            Integer[] nextTask = availableTasks.poll();
            Integer taskId = nextTask[0];
            Integer remaining = nextTask[1] - 1;
            if (remaining != 0) {
                unavailableTasks.add(new Integer[]{taskId, currentTime + n + 1, remaining});
            }
            currentTime++;
        }
        return currentTime - 1;
    }
}