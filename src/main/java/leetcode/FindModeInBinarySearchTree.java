package leetcode;

import leetcode.common.TreeNode;

public class FindModeInBinarySearchTree {
    private int maxCount;
    private int numMax;
    private int[] result;
    private int prev; //previous val
    private int prevCount;

    public int[] findMode(TreeNode root) {
        //reset instance variables
        maxCount = 0;
        numMax = 0;
        result = null;
        prev = Integer.MAX_VALUE;
        prevCount = 0;
        //find maxCount and numMax
        traverse(root);
        //init the result int[]
        result = new int[numMax];
        // reset instance variable prevCount & numMax
        prevCount = 0;
        numMax = 0;
        // traverse again to set result
        traverse(root);
        return result;
    }

    private void traverse(TreeNode curr) {
        if (curr == null) {
            return;
        }
        traverse(curr.left);
        if (curr.val == prev) {
            ++prevCount;
        }
        else {
            prev = curr.val;
            prevCount = 1;
        }
        if (prevCount > maxCount) {
            maxCount = prevCount;
            numMax = 1;
        }
        else if (prevCount == maxCount) {
            if (result != null) { //only apply to the second traverse
                result[numMax] = curr.val;
            }
            ++numMax;
        }
        traverse(curr.right);
    }
}
