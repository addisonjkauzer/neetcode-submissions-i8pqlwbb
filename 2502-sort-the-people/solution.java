class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        List<Integer[]> indexAndHeights = new ArrayList<>();
        for (int i = 0 ; i < heights.length; i++) {
            indexAndHeights.add(new Integer[]{i, heights[i]});
        }
        Collections.sort(indexAndHeights, Collections.reverseOrder(Comparator.comparing(a -> a[1])));
        
        String[] result = new String[names.length];

        for (int i = 0; i < indexAndHeights.size(); i++) {
            result[i] = names[indexAndHeights.get(i)[0]];
        }
        return result;
    }
}