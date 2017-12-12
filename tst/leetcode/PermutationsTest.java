package leetcode;

import org.junit.Test;

public class PermutationsTest {

    private Permutations solution = new Permutations();

    @Test
    public void test() {
        int[] nums = {1,2,3};
        System.out.println(solution.permute(nums));
    }
}
