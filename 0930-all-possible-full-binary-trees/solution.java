/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        return allPossibleFBT(n, new HashMap<>());
    }

    public List<TreeNode> allPossibleFBT(int n, HashMap<Integer, List<TreeNode>> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        List<TreeNode> result = new ArrayList<>();
        if (n == 1) {
            return Arrays.asList(new TreeNode(0));
        }
        if (n % 2 == 0) {
            return Arrays.asList();
        }
        for (int i = 1; i <= n - 2; i= i + 2) {
            List<TreeNode> leftSide = allPossibleFBT(i);
            for (TreeNode left : leftSide) {
                List<TreeNode> rightSide = allPossibleFBT(n - i - 1);
                for (TreeNode right : rightSide) {
                    TreeNode newRoot = new TreeNode(0, left, right);
                    result.add(newRoot);
                }
            }
        }
        cache.put(n, result);
        return result;
    }
}