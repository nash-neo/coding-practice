package practice;

public class ForestDisjointSet {

    public TreeNode makeSet(int val) {
        TreeNode node = new TreeNode(val);
        node.parent = null;
        node.rank = 0;
        return node;
    }

    public TreeNode union(TreeNode x, TreeNode y) {
        TreeNode rootX = find(x); //path compression
        TreeNode rootY = find(y); //path compression
        if (rootX == rootY) { //in the same set
            return rootX;
        }
        if (rootY.rank > rootX.rank) { //union by rank
            TreeNode tmp = rootX;
            rootX = rootY;
            rootY = tmp;
        }
        //rootX.rank >= rootY.rank
        rootY.parent = rootX;
        if (rootX.rank == rootY.rank) {
            rootX.rank += 1;
        }
        return rootX;
    }

    public TreeNode find(TreeNode x) {
        if (x.parent == null) {
            return x;
        }
        x.parent = find(x.parent);
        return x.parent;
    }

    //if we want to explore all the elements of a set, children pointers are needed.

}

class TreeNode {

    TreeNode parent;
    int rank;
    int val;
    TreeNode(int val) {
        this.val = val;
    }
}
