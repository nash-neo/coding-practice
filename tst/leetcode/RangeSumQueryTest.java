package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RangeSumQueryTest {

    private RangeSumQuery rangeSumQuery;

    @Test
    public void test() {
        int[] nums = {0,1,2,3,4};
        rangeSumQuery = new RangeSumQuery(nums);
        assertEquals(6, rangeSumQuery.sumRange(1,3));
        rangeSumQuery.update(2, 4);
        assertEquals(8, rangeSumQuery.sumRange(1,3));
        rangeSumQuery.update(3, 1);
        assertEquals(6, rangeSumQuery.sumRange(1,3));
    }

    @Test
    public void test1() {
        int[] nums = {-28,-39,53,65,11,-56,-65,-39,-43,97};
        rangeSumQuery = new RangeSumQuery(nums);

    }
}
