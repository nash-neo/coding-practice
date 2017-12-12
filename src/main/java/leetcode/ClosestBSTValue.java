package leetcode;

import leetcode.common.TreeNode;

public class ClosestBSTValue {

    double predecessor; // <= target

    double successor; // >= target

    public int closestValue(TreeNode root, double target) { //root is nonnull
        predecessor = -Double.MAX_VALUE;
        successor = Double.MAX_VALUE;
        find(root, target);
        if (target - predecessor <= successor - target) {
            return (int)predecessor;
        }
        else {
            return (int)successor;
        }
    }

    private void find(TreeNode curr, double target) {
        if (curr.val == target) {
            predecessor = curr.val;
            successor = curr.val;
            return;
        }
        else if (target < curr.val) {
            successor = curr.val;
            if (curr.left != null) {
                find(curr.left, target);
            }
        }
        else {
            predecessor = curr.val;
            if (curr.right != null) {
                find(curr.right, target);
            }
        }
    }
}