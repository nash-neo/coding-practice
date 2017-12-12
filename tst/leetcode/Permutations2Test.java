package leetcode;

import org.junit.Test;

public class Permutations2Test {

    private Permutations2 solution = new Permutations2();

    @Test
    public void test(){
        int[] nums = {1,1,1,2};
        System.out.println(solution.permuteUnique(nums));
    }
}
