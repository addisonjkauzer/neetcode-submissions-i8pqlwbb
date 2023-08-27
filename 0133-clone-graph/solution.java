/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer, Node> existingNewNodes = new HashMap();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node copy = new Node(node.val);
        buildNeighbors(node, copy);
        return copy;
    }

    public void buildNeighbors(Node node, Node copy) {
        existingNewNodes.put(copy.val, copy);
        for (Node neighbor : node.neighbors) {
            if (existingNewNodes.containsKey(neighbor.val)) {
                copy.neighbors.add(existingNewNodes.get(neighbor.val));
            } else {
                Node newNeighbor = new Node(neighbor.val);
                copy.neighbors.add(newNeighbor);
                buildNeighbors(neighbor, newNeighbor);
            }
        }
    }
}