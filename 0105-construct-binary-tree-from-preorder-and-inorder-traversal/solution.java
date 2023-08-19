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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inOrderValToIndex = new HashMap();
        for (int i =0; i < inorder.length; i++) {
            inOrderValToIndex.put(inorder[i], i);
        }
                if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }
        if (preorder.length == 1 && inorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        TreeNode root = new TreeNode(preorder[0]);
        int[] leftOfInOrder = getArrayLeftOf(inorder, inOrderValToIndex.get(root.val));
        int[] rightOfInOrder = getArrayRightOf(inorder, inOrderValToIndex.get(root.val));
        int[] preOrderLeft = new int[leftOfInOrder.length];
        int[] preOrderRight = new int[rightOfInOrder.length];

        for(int i = 0; i < preOrderLeft.length; i++) {
            preOrderLeft[i] = preorder[i+1];
        }
        for(int i = 0; i < preOrderRight.length; i++) {
            preOrderRight[i] = preorder[i + preOrderLeft.length + 1];
        }


        root.left = buildTree(preOrderLeft, leftOfInOrder);
        root.right = buildTree(preOrderRight, rightOfInOrder);
        return root; 
    }

    private int[] getArrayLeftOf(int[] source, int index) {
        int[] newIntArray = new int[index];
        for (int i = 0; i < index; i++) {
            newIntArray[i] = source[i];
        }
        return newIntArray;
    }

    private int[] getArrayRightOf(int[] source, int index) {
        if (index >= source.length - 1) {
            return new int[0];
        }
        int[] newIntArray = new int[source.length - index - 1];
        for (int i = 0; i < newIntArray.length; i++) {
            newIntArray[i] = source[index + 1 + i];
        }
        return newIntArray;
    }
}