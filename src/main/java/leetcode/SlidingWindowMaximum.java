package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    //use a deque for storing the sliding window, and only contains elements in decreasing order
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0 || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<>(k);
        for (int i = 0; i < nums.length; ++i) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k-1) { //add to result
                if (deque.peekFirst() < i - (k-1)) {
                    deque.pollLast();
                }
                result[i-(k-1)] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}