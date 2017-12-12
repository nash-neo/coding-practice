package leetcode;

import org.junit.Test;

import java.util.List;

public class CombinationSumTest {

    CombinationSum solution = new CombinationSum();

    @Test
    public void test() {
        int[] arr = {2, 3, 6, 7};
        List<List<Integer>> result = solution.combinationSum(arr, 7);
        System.out.println(result);
    }
}
