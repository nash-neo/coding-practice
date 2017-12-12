package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            throw new IllegalArgumentException();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i == 0 || nums[i-1] != nums[i]) {
                int sum2 = 0 - nums[i];
                int left = i+1;
                int right = nums.length -1;
                while (left < right) {
                    if (nums[left] + nums[right] < sum2) {
                        ++left;
                        //TODO: dedupe
                    }
                    else if (nums[left] + nums[right] > sum2) {
                        --right;
                        //TODO: dedupe
                    }
                    else {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left+1] ) {
                            ++left;
                        }
                        while (left < right && nums[right-1] == nums[right] ) {
                            --right;
                        }
                        ++left;
                        --right;
                    }
                }
            }
        }
        return result;
    }
}
