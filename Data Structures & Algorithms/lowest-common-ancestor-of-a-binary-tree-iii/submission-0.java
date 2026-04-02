/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> parents = new HashSet<>();
        parents.add(p);
        while (p != null) {
            p = p.parent;
            parents.add(p);
        }

        while (q != null) {
            if (parents.contains(q)) {
                return q;
            }
            q = q.parent;
        }
        return null;
    }
}