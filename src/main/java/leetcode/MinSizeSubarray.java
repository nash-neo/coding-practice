package leetcode;

public class MinSizeSubarray {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null) {
            return 0;
        }
        int minLength = Integer.MAX_VALUE;
        int lastLeft = 0;
        int sum = 0; //sum between lastLeft to right
        for (int right = 0; right < nums.length; ++right) {
            sum += nums[right];

            if (sum >= s) { //slide left
                for (int left = lastLeft; left <= right; ++left) {
                    sum -= nums[left];
                    if (sum < s) {
                        minLength = Math.min(minLength, right - left + 1);
                        lastLeft = left + 1;
                    }
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

}
