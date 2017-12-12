package practice;

import org.junit.Test;

public class LinkedListDisjointSetTest {

    LinkedListDisjointSet disjointSet = new LinkedListDisjointSet();

    @Test
    public void test() {
        Node n0 = disjointSet.makeSet(0);
        Node n1 = disjointSet.makeSet(1);
        Node n2 = disjointSet.makeSet(2);
        Node n3 = disjointSet.makeSet(3);
        Node n4 = disjointSet.makeSet(4);
        Node n5 = disjointSet.makeSet(5);

        disjointSet.union(n0, n2);
        disjointSet.union(n4, n2);

        disjointSet.union(n1, n3);

        System.out.println(disjointSet.getSet(n0));
        System.out.println(disjointSet.getSet(n2));
        System.out.println(disjointSet.getSet(n4));
        System.out.println(disjointSet.getSet(n1));
        System.out.println(disjointSet.getSet(n3));
        System.out.println(disjointSet.getSet(n5));
    }
}
