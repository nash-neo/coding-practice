package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestLineOfConsecutiveOneInMatrixTest {

    LongestLineOfConsecutiveOneInMatrix solution = new LongestLineOfConsecutiveOneInMatrix();

    @Test
    public void test() {
        int[][] M = {{1,1,1,1},{1,1,1,1},{0,0,0,1}};
        assertEquals(4, solution.longestLine(M));
    }
}
