package leetcode;

import leetcode.common.TreeNode;
import org.junit.Test;

public class FindModeInBinarySearchTreeTest {

    private FindModeInBinarySearchTree solution = new FindModeInBinarySearchTree();

    @Test
    public void test0() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        n1.right = n2;
        n2.left = n3;

        solution.findMode(n1);
    }
}
