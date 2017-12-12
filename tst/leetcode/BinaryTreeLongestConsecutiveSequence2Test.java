package leetcode;

import org.junit.Before;
import org.junit.Test;

import static leetcode.BinaryTreeLongestConsecutiveSequence2.TreeNode;
import static org.junit.Assert.assertEquals;

public class BinaryTreeLongestConsecutiveSequence2Test {

    private BinaryTreeLongestConsecutiveSequence2 solution = new BinaryTreeLongestConsecutiveSequence2();

    private TreeNode root;

    @Before
    public void init() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.right = n5;
        n2.left = n1;
        n2.right = n3;
        n3.right = n4;
        root = n2;
    }

    @Test
    public void test() {
        assertEquals(4, solution.longestConsecutive(root));
    }
}
