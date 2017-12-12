package airbnb;

import java.util.ArrayList;
import java.util.List;

public class IPv4ToCIDR {

    public List<String> ipRangeToCIDR(String startIp, String endIp) {
        List<String> cidrs = new ArrayList<>();
        long start = toVal(startIp);
        long end = toVal(endIp);
        while (start <= end) {
            long lastOne = start & (-start); //bit trick to get last one
            int zerosAfterLastOne = lastOne==0 ? 32:zeros(lastOne); //could use log2, need to check zero
            int maxFromStartToEnd = (int) (Math.log(end - start + 1) / Math.log(2));
            maxFromStartToEnd = Math.min(zerosAfterLastOne, maxFromStartToEnd);
            cidrs.add(toCIDR(start, maxFromStartToEnd)); //add result
            start += (long)Math.pow(2, maxFromStartToEnd); //update start
        }
        return cidrs;
    }

    private long toVal(String ip){ //long for unsigned int
        String[] bytes = ip.split("\\.");
        long val = 0;
        for (String b : bytes) {
            val = val * 256 + new Long(b);
        }
        return val;
    }

    private String toCIDR(long val, int mask) {
        StringBuilder cidr = new StringBuilder();
        cidr.append(val / 256 / 256 / 256).append('.');
        val %= (256 * 256 * 256);
        cidr.append(val / 256 / 256).append('.');
        val %= (256 * 256);
        cidr.append(val / 256).append('.');
        val %= (256);
        cidr.append(val);
        cidr.append('/').append(32 - mask);
        return cidr.toString();
    }

    private int zeros(long lastOne) {
        int count = 0;
        while ((lastOne & 1) == 0) { //while last bit == 0, be careful of the operator precedence
            ++count;
            lastOne = lastOne >>> 1;
        }
        return count;
    }
}
