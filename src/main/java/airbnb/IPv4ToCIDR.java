package airbnb;

import java.util.ArrayList;
import java.util.List;

public class IPv4ToCIDR {
    //from start to end, find the maximum number of bits could be used as a mask starting from start
    //there are two cases: 1. number of zeros to the right of last one 2. log2 of end-start+1, take the minimum of them
    //start += 1 << max_bits
    public List<String> ipRangeToCIDR(String startIp, String endIp) {
        List<String> cidrs = new ArrayList<>();
        long start = toVal(startIp);
        long end = toVal(endIp);
        while (start <= end) {
            int zeroBitsFromRight = zerosFromRight(start); //could use log2, need to check zero
            int maxFromStartToEnd = log2(end-start+1); //or the first bit 1 from left log2
            maxFromStartToEnd = Math.min(zeroBitsFromRight, maxFromStartToEnd);
            cidrs.add(toCIDR(start, maxFromStartToEnd)); //add result
            start += pow2(maxFromStartToEnd); //update start
        }
        return cidrs;
    }

    private long toVal(String ip){ //long for unsigned int
        String[] bytes = ip.split("\\.");
        long val = 0;
        for (String b : bytes) {
            val = val * 256 + Long.valueOf(b);
        }
        return val;
    }

    private String toCIDR(long val, int mask) {
        StringBuilder cidr = new StringBuilder();
        int[] segments = new int[4];
        for (int i = 0; i < 4; ++i) {
            segments[3-i] = (int)(val % 256);
            val /= 256;
        }
        for (int i = 0; i < 4; ++i) {
            cidr.append(segments[i]).append(".");
        }
        cidr.deleteCharAt(cidr.length()-1);
        cidr.append("/").append(32-mask);
        return cidr.toString();
    }

    private int zerosFromRight(long start) {
        int count = 0;
        for (int i = 0; i < 32; ++i) { // i < 32 so that if start is 0, return 32
            if ((start & 1) == 0) { //last bit is 0, or start % 2 == 0
                ++count;
                start = start >>> 1;
            }
            else {
                break;
            }
        }
        return count;
    }

    private int log2(long x) {
        int power2 = 1 << 30;
        while (power2 > x) {
            power2 = power2 >>> 1;
        }
        return zerosFromRight(power2);
    }

    private long pow2(int power) {
        return 1L << power;
    }
}
