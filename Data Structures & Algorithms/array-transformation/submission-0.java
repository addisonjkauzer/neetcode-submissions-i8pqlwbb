class Solution {
    public List<Integer> transformArray(int[] arr) {
        int[] yesterday = Arrays.copyOf(arr, arr.length);
        int[] today = Arrays.copyOf(arr, arr.length);
        while (true) {
            for (int i = 1; i < arr.length -1; i++) {
                int left = yesterday[i-1];
                int middle = yesterday[i];
                int right = yesterday[i+1];
                if (middle > left && middle > right) {
                    today[i] = middle - 1;
                } else if (middle < left && middle < right) {
                    today[i] = middle + 1;
                }
            }
            if (Arrays.equals(today, yesterday)) {
                break;
            }
            yesterday = Arrays.copyOf(today, today.length);
        }
        return Arrays.stream(today).boxed().toList();
    }
}
