package leetcode;

//binary index tree
public class RangeSumQueryBIT {

    private int[] nums;

    private int[] bit;

    public RangeSumQueryBIT(int[] nums) {
        this.nums = new int [nums.length]; //all 0
        bit = new int[nums.length+1];
        //all bit[i] are 0
        for (int i = 0; i < nums.length; ++i ) {
            update(i, nums[i]);
        }
    }

    public void update(int i, int val) {
        int delta = val - nums[i];
        nums[i] += delta;

        ++i; //convert to index of bit;
        while (i <= bit.length-1) {
            bit[i] += delta;
            i = i + (i & -i);
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(j) - sumRange(i-1);
    }

    //sum of [0, i]
    private int sumRange(int i) {
        ++i; // convert to bit index
        int sum = 0;
        while (i > 0) { //i >= 0 works as well as bit[0] = 0;
            sum += bit[i];
            i = i - (i & -i);
        }
        return sum;
    }
}
