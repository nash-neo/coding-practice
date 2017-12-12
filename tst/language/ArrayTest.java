package language;

import org.junit.Test;

import java.util.Arrays;

public class ArrayTest {

    @Test
    public void testInit() {
        int[][] arr = new int[3][4];
        System.out.println(Arrays.deepToString(arr));
    }

    @Test
    public void testSwap() {
        int[] a = new int[2];
        int[] b = new int[12];
        int[] tmp = a;
        a = b;
        b = tmp;
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    @Test
    public void test2() {
        int[] a = {0,0};
        a[0]++;
        ++a[1];
        System.out.println(Arrays.toString(a));
    }
}
