package leetcode;

public class BasicCalculator2 {

    // minus sign could be either unary or binary? 2 + -3, -3*2
    // assume no unary '-' first
    // save prev sum and curr product or quotient, when the curr operator is "+" or "-", sum += curr, curr = 1
    public int calculate(String s) {
        //assume s is not empty
        int prev = 0;
        int curr = 1;
        boolean isPrevPlus = true;
        boolean isCurrTimes = true;
        int num = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch-'0'; //assume the encoding is ascii or unicode
                if (i == s.length()-1 || !Character.isDigit(s.charAt(i+1))) {
                    curr = isCurrTimes ? curr * num : curr / num;
                }
            }
            else if (ch == '+' || ch == '-') {
                prev = isPrevPlus ? prev + curr : prev - curr;
                isPrevPlus = ch == '+';
                curr = 1; //reset
            }
            else if (ch == '*' || ch == '/') {
                isCurrTimes = ch == '*';
            }
        }
        prev = isPrevPlus ? prev + curr : prev - curr;
        return prev;
    }
}