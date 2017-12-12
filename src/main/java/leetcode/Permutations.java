package leetcode;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return result;
        }
        backtrack(nums, new LinkedHashSet<>(), result);
        return result;
    }

    private void backtrack(int[] nums, Set<Integer> solution, List<List<Integer>> result) {
        if (solution.size() == nums.length) {
            result.add(new ArrayList<>(solution));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!solution.contains(nums[i])) {
                solution.add(nums[i]);
                backtrack(nums, solution, result);
                solution.remove(nums[i]);
            }
        }
    }
}
