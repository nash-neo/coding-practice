package leetcode;

import leetcode.common.TreeNode;
import org.junit.Test;

public class ClosestBSTValueTest {

    private ClosestBSTValue solution = new ClosestBSTValue();

    @Test
    public void test() {
        TreeNode n0 = new TreeNode(2147483647);
        System.out.println(solution.closestValue(n0, 0.0));
    }
}
