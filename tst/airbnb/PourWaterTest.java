package airbnb;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PourWaterTest {

    private PourWater pourWater = new PourWater();

    @Test
    public void test0() {
        List<Integer> heights = List.of(4,3,2,3);
        List<Integer> water = pourWater.pourWater3(heights, 2, 1);
        assertEquals(List.of(0,0,1,0), water);
        pourWater.print(heights, water);
    }

    @Test
    public void test1() {
        List<Integer> heights = List.of(4,3,2,3);
        List<Integer> water = pourWater.pourWater3(heights, 2, 2);
        assertEquals(List.of(0,0,1,0), water);
        pourWater.print(heights, water);
    }

    @Test
    public void test2() {
        List<Integer> heights = List.of(4,3,2,3);
        List<Integer> water = pourWater.pourWater3(heights, 2, 3);
        assertEquals(List.of(0,0,1,0), water);
        pourWater.print(heights, water);
    }

    @Test
    public void test3() {
        List<Integer> heights = List.of(4,3,2,3);
        List<Integer> water = pourWater.pourWater3(heights, 2, 4);
        assertEquals(List.of(0,0,1,0), water);
        pourWater.print(heights, water);
    }

    @Test
    public void test4() {
        List<Integer> heights = List.of(4,3,2,3);
        List<Integer> water = pourWater.pourWater3(heights, 2, 5);
        assertEquals(List.of(0,0,1,0), water);
        pourWater.print(heights, water);
    }
}
