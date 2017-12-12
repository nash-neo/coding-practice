package leetcode;

public class SqrtX {
    public int mySqrt(int x) {
        long xl = x;
        int upper = 3 * 128 * 128;
        int lower = 0;
        while (lower < upper) {
            int mid = (lower + upper) / 2;
            long y = mid * mid;
            if (y == xl) {
                return mid;
            }
            else if (y > xl) {
                upper = mid - 1;
            }
            else {
                lower = mid + 1;
            }
        }
        if (lower * lower > x) {
            return lower -1;
        }
        else {
            return lower;
        }
    }
}
