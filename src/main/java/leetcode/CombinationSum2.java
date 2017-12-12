package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int availIndex, List<Integer> solution, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(solution));
            return;
        }
        for (int i = availIndex; i < candidates.length; ++i) {
            if (target - candidates[i] >= 0 && valid(candidates, i, solution)) {
                solution.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i + 1, solution, result);
                solution.remove(solution.size()-1);
            }
        }
    }

    private boolean valid(int[] candidates, int i, List<Integer> solution) {
        for (int j = i - 1; j >=0 && candidates[j] == candidates[i]; --j) {
            int solutionIndex = solution.size()-(i-j);
            if (solutionIndex < 0 || solution.get(solutionIndex) != candidates[i]) {
                return false;
            }
        }
        return true;
    }
}
