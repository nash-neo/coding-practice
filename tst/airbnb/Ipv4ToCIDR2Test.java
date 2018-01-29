package airbnb;

import org.junit.Test;

public class Ipv4ToCIDR2Test {

    IPv4ToCIDR2 solution = new IPv4ToCIDR2();

    @Test
    public void test0() {
        String ip = "255.0.0.7";
        int n = 10;
        System.out.println(solution.ipToCIDR(ip, n));
    }

    @Test
    public void test1() {
        long l = 33;
        int i = (1 << l);
        System.out.println(i);
    }
}
