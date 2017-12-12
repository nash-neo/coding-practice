package practice;

import org.junit.Test;

public class IntegerDivisionAndModuloTest {

    @Test
    public void test0() {
        int a = 3;
        int b = -4;
        System.out.println(a/b + " | " + a%b);
    }

    @Test
    public void test1() {
        int a = -3;
        int b = 4;
        System.out.println(a/b + " | " + a%b);
    }

    @Test
    public void test2() {
        int a = 3;
        int b = -4;
        System.out.println(Math.floorDiv(a, b) + " | " + Math.floorMod(a, b));
    }

    @Test
    public void test3() {
        int a = -5;
        int b = 4;
        System.out.println(Math.floorDiv(a, b) + " | " + Math.floorMod(a, b));
    }
}
