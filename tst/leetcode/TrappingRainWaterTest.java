package leetcode;

import org.junit.Test;

public class TrappingRainWaterTest {

    private TrappingRainWater solution = new TrappingRainWater();

    @Test
    public void test() {
        int[] heights = {5,4,1,2};
        System.out.println(solution.trap(heights));
    }
}
