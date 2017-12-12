package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NextGreaterElement3Test {
    private NextGreaterElement3 solution = new NextGreaterElement3();

    @Test
    public void test() {
        assertEquals(13222344, solution.nextGreaterElement(12443322));
    }
}
