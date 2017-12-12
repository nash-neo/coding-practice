package elements.of.programming.interview;

import org.junit.Test;

import java.util.Arrays;
import static elements.of.programming.interview.PaintBooleanMatrixCh19P2.Node;

public class PaintBooleanMatrixCh19P2Test {
    private PaintBooleanMatrixCh19P2 solution = new PaintBooleanMatrixCh19P2();
    private boolean[][] colors = {
            {false, false, true, false},
            {false, false, true, false},
            {false, false, true, false},
    };

    @Test
    public void testDFS() {
        System.out.println(Arrays.deepToString(colors));
        solution.flipDFS(colors, new Node(1,1));
        System.out.println(Arrays.deepToString(colors));
    }

    @Test
    public void testBFS() {
        System.out.println(Arrays.deepToString(colors));
        solution.flipBFS(colors, new Node(1,1));
        System.out.println(Arrays.deepToString(colors));
    }

    @Test
    public void testDFSUsingStack() {
        System.out.println(Arrays.deepToString(colors));
        solution.flipDFSUsingStack(colors, new Node(1,1));
        System.out.println(Arrays.deepToString(colors));
    }

}
