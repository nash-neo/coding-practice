package practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ForestDisjointSetTest {
    private ForestDisjointSet disjointSet = new ForestDisjointSet();

    @Test
    public void test() {
        TreeNode n0 = disjointSet.makeSet(0);
        TreeNode n1 = disjointSet.makeSet(1);
        TreeNode n2 = disjointSet.makeSet(2);
        TreeNode n3 = disjointSet.makeSet(3);
        TreeNode n4 = disjointSet.makeSet(4);

        disjointSet.union(n0, n2);
        disjointSet.union(n4, n2);

        disjointSet.union(n1, n3);

        assertEquals(disjointSet.find(n1), disjointSet.find(n3));
        assertEquals(disjointSet.find(n0), disjointSet.find(n2));
        assertEquals(disjointSet.find(n0), disjointSet.find(n4));
        assertNotEquals(disjointSet.find(n0), disjointSet.find(n1));
        assertNotEquals(disjointSet.find(n2), disjointSet.find(n3));
    }
}
