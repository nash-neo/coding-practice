package airbnb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IPv4ToCIDR2 {
    //use long from represent ip since int is signed integer in Java
    public List<String> ipToCIDR(String ip, int n) {
        long startIp = toIp(ip);
        List<String> result = new ArrayList<>();
        while (n > 0){
            long i = getZerosFromRight(startIp);
            long j = log2(n);
            long k = Math.min(i,j);
            result.add(toCIDR(startIp, k));
            startIp += (1L << k); //2^k
            n -= (int)(1L << k);
        }
        return result;
    }

    //precondition: num >= 0
    private int getZerosFromRight(long ip) {
        int k = 0;
        for (long i = 0; i < 32; ++i) { //test the lowest 32 bits
            if ((ip & (1 << i)) != 0) { //ith lowest bit is not 0
                break;
            }
            ++k;
        }
        return k;
    }

    //precondition: n > 0
    private long log2(long n) { //ceiling, or count the number of bits after the first 1 from left
        for (long i = 32; i >=0; --i) {
            if ((n & (1L << i)) != 0) { //ith bit is 1
                return i;
            }
        }
        throw new RuntimeException("Unreachable");
    }

    private String toCIDR(long start, long varyingBits) {
        long prefix = 32 - varyingBits;
        StringBuilder cidr = new StringBuilder();
        List<String> segments = new ArrayList<>();
        for (int i = 0; i < 4; ++i) {
            segments.add(String.valueOf(start % 256));
            start /= 256;
        }
        Collections.reverse(segments);
        cidr.append(String.join(".", segments));
        cidr.append('/').append(prefix);
        return cidr.toString();
    }

    private long toIp(String ip) {
        long k = 0;
        String[] segments = ip.split("\\.");
        for (String seg : segments) {
            k = k * 256 + Long.valueOf(seg);
        }
        return k;
    }
}