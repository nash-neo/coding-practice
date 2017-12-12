package leetcode;

import org.junit.Test;

public class CombinationSum2Test {

    private CombinationSum2 solution = new CombinationSum2();

    @Test
    public void test() {
        int[] candidates = {1,1,2,5,6,7,10};
        System.out.println(solution.combinationSum2(candidates, 8));
    }
}
