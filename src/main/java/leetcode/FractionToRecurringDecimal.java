package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

    //case: 20/7, 1/333, 1/99=0.(01) , -50/8, 0/-5
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if (numerator != 0 && ((numerator ^ denominator) >>> (Integer.SIZE-1)) == 1) {
            sb.append('-');
        }
        long n = Math.abs(numerator); //assuming no overflow
        long d = Math.abs(denominator); //assuming no overflow
        sb.append(n/d);
        if (n%d == 0) {
            return sb.toString();
        }
        n = n%d * 10;
        sb.append('.');
        Map<Long, Integer> map = new HashMap<>(); //numerator to position
        int i = sb.length();
        while (n != 0) {
            if (!map.containsKey(n)) { //position unset
                map.put(n, i);
                sb.append(n / d);
            }
            else { //position set, wrap with parentheses
                int j = map.get(n);
                sb.insert(j, '(');
                sb.append(')');
                return sb.toString();
            }
            ++i;
            n = n % d * 10;
        }
        return sb.toString();
    }
}