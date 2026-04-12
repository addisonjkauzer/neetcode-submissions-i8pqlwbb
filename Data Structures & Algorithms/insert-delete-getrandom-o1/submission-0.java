class RandomizedSet {

    Set<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
        
    }
    
    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }
        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            return true;
        }
        return false;
        
    }
    
    public int getRandom() {
        return set.stream().mapToInt(a -> a).findFirst().orElse(-1);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */