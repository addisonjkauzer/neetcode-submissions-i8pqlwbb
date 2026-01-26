class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> sequences = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (int i = 10; i <= s.length(); i++) {
            String sequence = s.substring(i-10, i);
            if(sequences.contains(sequence)) {
                duplicates.add(sequence);
            }
            sequences.add(sequence);
        }

        return new ArrayList<>(duplicates);
        
    }
}