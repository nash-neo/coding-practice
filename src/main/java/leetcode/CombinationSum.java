package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        solve(candidates, candidates.length -1, target, solution, result);
        return result;
    }

    private void solve(int[] candidates, int i, int target, List<Integer> solution, List<List<Integer>> result) {
        if (target == 0) {
            List<Integer> newSolution = new ArrayList<>(solution);
            result.add(newSolution);
            return;
        }
        if (i == 0) {
            if (target % candidates[i] == 0) {
                List<Integer> newSolution = new ArrayList<>(solution);
                for (int j = 0; j < target / candidates[i]; ++j) {
                    newSolution.add(candidates[i]);
                }
                result.add(newSolution);
                return;
            }
            else { //not a valid solution
                return;
            }
        }
        if (i - 1 >= 0) {
            solve(candidates, i - 1, target, solution, result);
            if (target - candidates[i] >= 0) {
                solution.add(candidates[i]);
                solve(candidates, i - 1, target - candidates[i], solution, result);
                solution.remove(solution.size()-1);
            }
        }
        if (target - candidates[i] >= 0) {
            solution.add(candidates[i]);
            solve(candidates, i, target - candidates[i], solution, result);
            solution.remove(solution.size()-1);
        }
    }
}
