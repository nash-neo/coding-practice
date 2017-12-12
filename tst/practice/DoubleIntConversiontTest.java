package practice;

import org.junit.Test;

public class DoubleIntConversiontTest {

    @Test
    public void test() {
        double d = 1.3;
        System.out.println((int)d);
        d = 1.5;
        System.out.println((int)d);
        d = 1.9;
        System.out.println((int)d);

        d = -1.3;
        System.out.println((int)d);
        d = -1.5;
        System.out.println((int)d);
        d = -1.9;
        System.out.println((int)d);
    }

    @Test
    public void testLog() {
        System.out.println(Math.log(0));
        System.out.println((int)Math.log(0));
    }

    @Test
    public void test2() {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(-Integer.MIN_VALUE);
        System.out.println(1+Integer.MAX_VALUE);
    }
}
