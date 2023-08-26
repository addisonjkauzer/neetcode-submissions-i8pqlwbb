class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSum(candidates, target, new ArrayList());


    }

    public List<List<Integer>> combinationSum(int[] candidates, int target, List<Integer> pastNumbers) {
        Set<List<Integer>> returned = new HashSet();
        for (Integer candidate : candidates) {
            ArrayList<Integer> newSolution = new ArrayList();
            newSolution.addAll(pastNumbers);
            newSolution.add(candidate);
            int newSum = target - candidate;
            if (newSum > 0) {
                returned.addAll(combinationSum(candidates, newSum, newSolution));
            } else if (newSum == 0) {
                newSolution.sort(Comparator.naturalOrder());
                returned.add(newSolution);
            }
        }
        return new ArrayList(returned);       
    }
}