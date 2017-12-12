package google;

import org.junit.Test;

public class LongestConsecutivePathInTreeTest {

    private LongestConsecutivePathInTree solution = new LongestConsecutivePathInTree();


    @Test
    public void test() {
        Node n1 = new Node(1, new Node[1]);
        Node n2 = new Node(2, new Node[1]);
        Node n3 = new Node(3, new Node[1]);
        Node n5 = new Node(5, new Node[0]);
        n1.children[0] = n2;
        n2.children[0] = n3;
        n3.children[0] = n5;
        System.out.println(solution.find(n1));
    }
}
