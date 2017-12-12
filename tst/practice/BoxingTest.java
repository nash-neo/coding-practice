package practice;

import org.junit.Test;

public class BoxingTest {

    @Test
    public void testInt() {
        int i0 = 1;
        Integer i1 = 1;
        Integer i2 = 1;
        System.out.println(i0 == i1);
        System.out.println(i1 == i0);
        System.out.println(i1 == i2);
    }
}
