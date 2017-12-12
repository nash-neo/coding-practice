package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class SubSetTest {

    private Subset subSet = new Subset();

    @Test
    public void test() {
        int[] nums = {1,2,3};
        System.out.println(subSet.subsets(nums));

    }
}
