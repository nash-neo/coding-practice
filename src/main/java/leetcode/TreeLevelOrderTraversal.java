package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class TreeLevelOrderTraversal {

    /**
     * Definition for a binary tree node.
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> curr = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        curr.offer(root);
        result.add(toValue(curr));
        while(!curr.isEmpty()) {
            TreeNode node = curr.poll();
            if (node.left != null) {
                next.offer(node.left);
            }
            if (node.right != null) {
                next.offer(node.right);
            }
            if (curr.isEmpty()) {
                curr = next;
                if (!next.isEmpty()) {
                    result.add(toValue(next));
                }
                next = new LinkedList<>();
            }
        }
        return result;
    }

    private List<Integer> toValue(Queue<TreeNode> col) {
        return col.stream().map(node -> node.val).collect(Collectors.toList());
    }
}
