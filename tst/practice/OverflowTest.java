package practice;

import org.junit.Test;

public class OverflowTest {

    @Test
    public void test() {
        System.out.println(Integer.MIN_VALUE-1);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE & (Integer.MIN_VALUE-1));
    }
}
