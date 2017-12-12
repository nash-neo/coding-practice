package leetcode;



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLongestConsecutiveSequence2 {

    private int max;

    public int longestConsecutive(TreeNode root) {
        max = 0;
        if (root == null) {
            return 0;
        }
        dfs(root, null, new Pair());
        return max;
    }

    private Pair dfs(TreeNode curr, TreeNode parent, Pair p) {
        Pair currPair = calculate(curr, parent, p);
        Pair leftPair = new Pair();
        if (curr.left != null) {
            leftPair = dfs(curr.left, curr, currPair);
        }
        leftPair = calculate(curr, curr.left, leftPair);
        Pair rightPair = new Pair();
        if (curr.right != null) {
            rightPair = dfs(curr.right, curr, currPair);
        }
        rightPair = calculate(curr, curr.right, rightPair);
        //calculate max
        max = Math.max(max, currPair.inc + leftPair.desc - 1);
        max = Math.max(max, currPair.inc + rightPair.desc - 1);
        max = Math.max(max, leftPair.inc + currPair.desc - 1);
        max = Math.max(max, leftPair.inc + rightPair.desc - 1);
        max = Math.max(max, rightPair.inc + leftPair.desc - 1);
        max = Math.max(max, rightPair.inc + currPair.desc - 1);
        //calculate return from children
        return new Pair(Math.max(leftPair.inc, rightPair.inc), Math.max(leftPair.desc, rightPair.desc));
    }

    private Pair calculate(TreeNode curr, TreeNode from, Pair p) {
        Pair currPair = null;
        if (from == null) {
            currPair = new Pair(1,1);
        }
        else if (from.val + 1 == curr.val) {
            currPair = new Pair(p.inc+1, 1);
        }
        else if (from.val - 1 == curr.val) {
            currPair = new Pair(1, p.desc +1);
        }
        else {
            currPair = new Pair(1,1);
        }
        return currPair;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static class Pair {
        int inc;
        int desc;
        Pair() {
            inc = 0;
            desc = 0;
        }
        Pair(int inc, int desc) {
            this.inc = inc;
            this.desc = desc;
        }
    }
}