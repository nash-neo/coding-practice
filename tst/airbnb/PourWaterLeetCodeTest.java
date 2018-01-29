package airbnb;

import org.junit.Test;

import java.util.Arrays;

public class PourWaterLeetCodeTest {

    PourWaterLeetCode pourWaterLeetCode = new PourWaterLeetCode();

    @Test
    public void test() {

        int[] result = pourWaterLeetCode.pourWater(new int[]{2,1,1,2,1,2,2}, 4, 3);
        System.out.println(Arrays.toString(result));
    }
}
