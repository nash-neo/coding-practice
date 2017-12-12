package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations2 {
    //check null array, [], [0]
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        backtrack(nums, new HashSet<>(), new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, Set<Integer> solutionIndex, List<Integer> solution, List<List<Integer>> result) {
        if (solution.size() == nums.length) {
            result.add(new ArrayList<>(solution));
            return;
        }
        for (int i = 0; i< nums.length; ++i) {
            if (solutionIndex.contains(i)) {
                continue;
            }
            if (i != 0 && nums[i-1] == nums[i] && !solutionIndex.contains(i-1)) {
                continue;
            }
            solutionIndex.add(i);
            solution.add(nums[i]);
            backtrack(nums, solutionIndex, solution, result);
            solution.remove(solution.size() - 1);
            solutionIndex.remove(i);
        }
    }
}
