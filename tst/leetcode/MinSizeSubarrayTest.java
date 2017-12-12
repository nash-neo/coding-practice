package leetcode;

import org.junit.Test;

public class MinSizeSubarrayTest {
    private MinSizeSubarray minSizeSubarray = new MinSizeSubarray();

    @Test
    public void test() {
        minSizeSubarray.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }
}
