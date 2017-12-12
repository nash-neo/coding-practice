package leetcode;

public class ContinuousArray {

    public int findMaxLength(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int[] p = new int[nums.length];
        int maxSoFar = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i-1 >= 0 && i - p[i-1] -1 >= 0 && nums[i] != nums[i-p[i-1]-1]) {
                p[i] = p[i-1] + 2;
                if (i-p[i-1]-2 >= 0) {
                    p[i] += p[i-p[i-1]-2];
                }
            }
            if (i-2 >= 0 && nums[i] != nums[i-1]) {
                p[i] = Math.max(p[i], p[i-2] +2);
            }
            maxSoFar = Math.max(maxSoFar, p[i]);
        }
        return maxSoFar;
    }
}
