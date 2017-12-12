package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int i = -1, j = -1;
        boolean found = false;
        for (i = 0; i < nums.length; ++i) {
            for (j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        int[] result = new int[2];
        result[0] = i;
        result[1] = j;
        return result;
    }

    public int[] twoSum1(int[] nums, int target) {
        int[] result = {-1, -1};
        Map<Integer, Integer> value2Index = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if(value2Index.containsKey(target - nums[i])) {
                result[0] = value2Index.get(target - nums[i]);
                result[1] = i;
                break;
            }
            value2Index.put(nums[i], i);
        }
        return result;
    }
}
