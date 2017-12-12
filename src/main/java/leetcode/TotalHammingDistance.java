package leetcode;

public class TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < Integer.SIZE; ++i) {
            int ones = 0;
            for (int num : nums) {
                if ((num & 1 << i) != 0) {
                    ++ones;
                }
            }
            sum += ones * (nums.length-ones);
        }
        return sum;
    }
}