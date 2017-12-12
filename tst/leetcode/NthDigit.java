package leetcode;

public class NthDigit {
    public int findNthDigit(int n) {
        int nDigits = 1;
//        for (nDigits = 1; n - nDigits * ((int)Math.pow(10, nDigits) - (int)Math.pow(10, nDigits-1)) > 0; ++nDigits) {
//            n -= nDigits * ((int)Math.pow(10, nDigits) - (int)Math.pow(10, nDigits-1));
//        }
        while(nDigits < 9) {
            int digits = nDigits * ((int)Math.pow(10, nDigits) - (int)Math.pow(10, nDigits-1));
            if (n > digits) {
                n -= digits;
                ++nDigits;
            }
            else {
                break;
            }
        }
//
        int start = (int) Math.pow(10, nDigits - 1);
        start += n / nDigits;
        n = n % nDigits;
        if (n == 0) {
            return (start - 1) % 10;
        }
        else {
            return start / (int)Math.pow(10, nDigits - n) % 10;
        }
    }

}
