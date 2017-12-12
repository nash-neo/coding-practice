package airbnb;

import org.junit.Test;

public class IPv4ToCIDRTest {

    private IPv4ToCIDR iPv4ToCIDR = new IPv4ToCIDR();

    @Test
    public void test() {
        System.out.println(iPv4ToCIDR.ipRangeToCIDR("0.0.0.1", "0.0.0.13"));
    }

    @Test
    public void test1() {
        System.out.println(iPv4ToCIDR.ipRangeToCIDR("0.0.0.0", "0.0.0.0"));
    }

    @Test
    public void test2() {
        System.out.println(iPv4ToCIDR.ipRangeToCIDR("0.0.0.0", "255.255.255.255"));
    }
}
