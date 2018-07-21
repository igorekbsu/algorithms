package quad_tree_intersection;

class Solution {
    public Node intersect(Node t1, Node t2) {
        if (t1.isLeaf)
            return t1.val ? t1 : t2;
        else if (t2.isLeaf)
            return t2.val ? t2 : t1;
        else {
            Node t = new Node();
            Node topLeft = intersect(t1.topLeft, t2.topLeft);
            Node topRight = intersect(t1.topRight, t2.topRight);
            Node bottomLeft = intersect(t1.bottomLeft, t2.bottomLeft);
            Node bottomRight = intersect(t1.bottomRight, t2.bottomRight);
            if (topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val &&
                topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
                t.val = topLeft.val;
                t.isLeaf = true;
            } else {
                t.topLeft = topLeft;
                t.topRight = topRight;
                t.bottomLeft = bottomLeft;
                t.bottomRight = bottomRight;
            }
            return t;
        }
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }
}