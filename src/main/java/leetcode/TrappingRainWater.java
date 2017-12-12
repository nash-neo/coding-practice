package leetcode;

public class TrappingRainWater {
    // given current bar > 0, find the next bar that either: 1. higher than the current
    // 2. if no one is higher, the higher one
    // as the right end, compute the area (right-left - 1) * min(left,right) and subtract by lower bars(remember when scan)
    public int trap(int[] height) {
        int area = 0;
        int left = 0;
        while (left < height.length) {
            int maxRight = left + 1;
            int internalArea = 0;
            boolean foundHigher = false;
            for (int right = maxRight; right < height.length; ++right) {
                if (height[right] >= height[left]) {
                    area += compute(height, left, right, internalArea);
                    left = right;
                    foundHigher = true;
                    break;
                }
                if (height[right] >= height[maxRight]) {
                    maxRight = right;
                }
                if (right - 1 > left) {
                    internalArea += height[right-1];
                }
            }
            if (!foundHigher) {
                if (maxRight < height.length) {
                    area += compute(height, left, maxRight, internalArea);
                }
                left = maxRight;
            }
        }
        return area;
    }

    private int compute(int[] height, int left, int right, int internalArea) {
        return Math.min(height[left], height[right]) * (right-left-1) - internalArea;
    }
}
