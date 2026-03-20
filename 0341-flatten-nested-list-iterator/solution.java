/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {


    Stack<List<NestedInteger>> stackedLists;
    Stack<Integer> stackedIndex;

    List<NestedInteger> currentList;
    Integer currentIndex;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.stackedLists = new Stack<>();
        this.stackedIndex = new Stack<>();
        this.currentList = nestedList;
        this.currentIndex = 0;
    }

    @Override
    public Integer next() {
        return currentList.get(currentIndex++).getInteger();
    }

    @Override
    public boolean hasNext() {
        while (currentIndex == currentList.size()) {
            if (stackedLists.isEmpty()) {
                return false;
            }
            currentList = stackedLists.pop();
            currentIndex = stackedIndex.pop();
        }
        NestedInteger current = currentList.get(currentIndex);
        if (current.isInteger()) {
            return true;
        } else {
            stackedLists.push(currentList);
            stackedIndex.push(currentIndex + 1);
            currentList = current.getList();
            currentIndex = 0;
            return hasNext();
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */