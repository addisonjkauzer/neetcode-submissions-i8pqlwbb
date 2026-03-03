class Solution {
    public int minDeletions(String s) {
        HashMap<Character, Integer> characterCounter = new HashMap<>();

        for (Character ch : s.toCharArray()) {
            characterCounter.put(ch, characterCounter.getOrDefault(ch, 0) + 1);
        }

        HashSet<Integer> values = new HashSet<>();
        int operations = 0;

        for (Character ch : characterCounter.keySet()) {
            int value = characterCounter.get(ch);
            while (value > 0 && values.contains(value)) {
                value--;
                operations++;
            }
            values.add(value);
        }

        return operations;
        
    }
}