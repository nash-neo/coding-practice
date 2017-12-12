package leetcode;

import java.util.ArrayList;
import java.util.List;

public class JumpGame2 {
    //edge case: [], [0]
    public int jump(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(Integer.MAX_VALUE);
        backtrack(nums, 0, 0, result);
        return result.get(0);
    }

    private void backtrack(int[] nums, int i, int steps, ArrayList<Integer> result) {
        if (i == nums.length -1) {
            result.set(0, Integer.min(steps, result.get(0)));
        }
        for (int step = 1; step <= nums[i]; ++step) {
            backtrack(nums, i + step, steps + 1, result);
        }
    }
}
