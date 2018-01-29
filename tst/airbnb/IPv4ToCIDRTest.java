package airbnb;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class IPv4ToCIDRTest {

    private IPv4ToCIDR iPv4ToCIDR = new IPv4ToCIDR();

    @Test
    public void test() {
        List<String> cidrs = iPv4ToCIDR.ipRangeToCIDR("0.0.0.1", "0.0.0.13");
        assertEquals(List.of("0.0.0.1/32", "0.0.0.2/31", "0.0.0.4/30", "0.0.0.8/30", "0.0.0.12/31"), cidrs);
    }

    @Test
    public void test1() {
        System.out.println(iPv4ToCIDR.ipRangeToCIDR("0.0.0.0", "0.0.0.0"));
    }

    @Test
    public void test2() {
        System.out.println(iPv4ToCIDR.ipRangeToCIDR("0.0.0.0", "255.255.255.255"));
    }

    @Test
    public void test3() {
        List<String> cidrs = iPv4ToCIDR.ipRangeToCIDR("10.0.0.1", "10.0.1.0");
        System.out.println(cidrs);
    }
}
