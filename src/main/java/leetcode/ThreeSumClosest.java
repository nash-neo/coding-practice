package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        if (nums == null) {
            return 0;
        }
        if (nums.length <= 3) {
            sum = Arrays.stream(nums).sum();
            return sum;
        }
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length -2; ++i) {
            int target2 = target - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            int bestDiff2 = Math.abs(target2 - nums[left] - nums[right]);
            int bestLeft = left;
            int bestRight = right;
            while (left < right) {
                if (Math.abs(target2 - nums[left] - nums[right]) < bestDiff2) {
                    bestLeft = left;
                    bestRight = right;
                    bestDiff2 = Math.abs(target2 - nums[left] - nums[right]);
                }
                if (nums[left] + nums[right] > target2) {
                    --right;
                }
                else if (nums[left] + nums[right] < target2) {
                    ++left;
                }
                else {
                    bestLeft = left;
                    bestRight = right;
                    return nums[i] + nums[bestLeft] + nums[bestRight];
                }
            }
            if (Math.abs(target-closestSum) > Math.abs(target - nums[i] - nums[bestLeft] - nums[bestRight]))
                closestSum = nums[i] + nums[bestLeft] + nums[bestRight];
        }
        return closestSum;
    }
}
