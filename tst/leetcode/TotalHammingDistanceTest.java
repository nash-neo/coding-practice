package leetcode;

import org.junit.Test;

public class TotalHammingDistanceTest {

    private TotalHammingDistance totalHammingDistance = new TotalHammingDistance();

    @Test
    public void test() {
        int[] nums = {4, 14, 2};
        System.out.println(totalHammingDistance.totalHammingDistance(nums));
    }
}
