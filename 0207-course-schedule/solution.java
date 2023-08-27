class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashMap<Integer, List<Integer>> courseToPrereqs = new HashMap();
        boolean[] canTake = new boolean[numCourses];

        for (int[] courses : prerequisites) {
            List<Integer> prereqs = courseToPrereqs.getOrDefault(courses[0], new ArrayList());
            prereqs.add(courses[1]);
            courseToPrereqs.put(courses[0], prereqs);
        }
        boolean hasCycle = false;
        for (Integer key : courseToPrereqs.keySet()) {
            hasCycle = hasCycle || dfsHasCycle(courseToPrereqs, new boolean[numCourses], key, canTake);
        }
        return !hasCycle;
    }

    public boolean dfsHasCycle(HashMap<Integer,List<Integer>> prerequisites, boolean[] visitedCourses, int course, boolean[] canTake) {
        if (visitedCourses[course]) {
            return true;
        }
        if (canTake[course]) {
            return false;
        }
        visitedCourses[course] = true;
        List<Integer> allPrereqsForCourse = prerequisites.getOrDefault(course, new ArrayList());

        boolean hasCycle = false;
        for(Integer prereq: allPrereqsForCourse) {
            hasCycle = hasCycle || dfsHasCycle(prerequisites, visitedCourses.clone(), prereq, canTake);
        }
        canTake[course] = true;
        return hasCycle;
    }
}