package leetcode;

public class Problem7 {
    public int reverse(int x) {

        int output = 0;
        boolean sign = x >= 0;
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        if (!sign) {
            x = 0 - x;
        }
        while (x != 0) {
            if (output > Integer.MAX_VALUE / 10
                    || output == Integer.MAX_VALUE / 10 && x % 10 > Integer.MAX_VALUE % 10) {
                return 0;
            }
            output = output * 10 + x % 10;
            x /= 10;
        }
        if (!sign) {
            output = 0 - output;
        }
        return output;

    }
}
