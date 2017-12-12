package leetcode;

public class RangeSumQuery {

    private int[] nums; //length n

    private int[] segments; // length m

    public RangeSumQuery(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        if (n == 0) {
            segments = new int[0];
            return;
        }
        int height = (int) (Math.ceil(Math.log(n)/Math.log(2))) + 1;
        int m = (int)Math.pow(2, height + 1) - 1;
        this.segments = new int[m];
        build(0, nums.length-1, 0);
    }

    public void update(int i, int val) {
        //update segment tree
        update(0, nums.length - 1, i, 0, val - nums[i]);
        //update original array
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return sumRange(0, nums.length-1, i, j, 0);
    }

    //return sum of [left, right]
    //left and right are indices of nums
    //k is index of segment tree
    private int build(int left, int right, int k) {
        if (left == right) {
            segments[k] = nums[left];
            return segments[k];
        }
        int mid = (left + right) / 2; //or left + (right-left)/2
        segments[k] = build(left, mid, 2 * k + 1) + build(mid + 1, right, 2 * k + 2);
        return segments[k];
    }

    //left, right, pos are indices of nums
    //k is index of segment tree
    private void update(int left, int right, int pos, int k, int delta) {
        segments[k] += delta;
        if (left == right) {
            return;
        }
        int mid = left + (right-left) / 2;
        if (pos <= mid) {
            update(left, mid, pos, 2 * k + 1, delta);
        }
        else {
            update(mid + 1, right, pos, 2 * k + 2, delta);
        }
    }
    //left, right range of segments[k]
    //i, j, range of the requested sum
    private int sumRange(int left, int right, int i, int j, int k) {
        if (left >= i && right <= j) { //i <= left <= right <= j
            return segments[k];
        }
        else if (right < i || left > j) { // [left, right] and [i,j] are not overlapped
            return 0;
        }
        else {
            int mid = left + (right-left)/2;
            return sumRange(left, mid, i, j, 2 * k + 1) + sumRange(mid + 1, right, i, j, 2 * k + 2);
        }
    }
}