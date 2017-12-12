package leetcode;

public class NextGreaterElement3 {
    //next permutation? convert to int[] and build back, or toString.toCharArray and build back
    public int nextGreaterElement(int n) {
        //n > 0
        char[] digits = Integer.toString(n).toCharArray();

        //next permutation
        int len = digits.length;
        //1. find longest decreasing subarray from right, like 12'543'
        int i = len-1;
        for(;i-1>=0; --i) {
            if (digits[i-1]<digits[i]) { //nonincreasing
                break;
            }
        }
        if (i == 0){
            return -1;
        }
        --i;
        //2. find larger than digits[i] from right and swap
        for (int j = len-1; j > i; --j) {
            if (digits[j] > digits[i]) {//swap i and j
                char tmp = digits[i];
                digits[i] = digits[j];
                digits[j] = tmp;
                break;
            }
        }
        //3. rotate [i+1, len)
        for (int j = i+1, k = len-1; j < k; ++j, --k) {
            char tmp = digits[j];
            digits[j] = digits[k];
            digits[k] = tmp;
        }

        //convert back to integer
        try {
            return Integer.parseInt(new String(digits));
        } catch(Exception e) {
            return -1;
        }
    }
}