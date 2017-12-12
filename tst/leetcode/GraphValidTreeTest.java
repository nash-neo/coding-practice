package leetcode;

import org.junit.Test;

public class GraphValidTreeTest {
    GraphValidTree solution = new GraphValidTree();

    @Test
    public void test() {
        int[][] edges = {{0,1},{0,2},{2,3},{2,4}};
        System.out.println(solution.validTree(5, edges));
    }
}
