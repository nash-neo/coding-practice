package leetcode;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoSumTest {

    private TwoSum twoSum = new TwoSum();

    @Test
    public void test() {
        int[] sums = {3, 2, 4};
        int[] result = twoSum.twoSum1(sums, 6);

        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
    }

}
