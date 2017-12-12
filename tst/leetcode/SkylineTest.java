package leetcode;

import org.junit.Test;

import java.util.List;

public class SkylineTest {

    private Skyline skyline = new Skyline();

    @Test
    public void test() {
        //[[0,3,3],[1,5,3],[2,4,3],[3,7,3]]
        int[][] buildings = {{0,3,3}, {1,5,3}, {2,4,3}, {3,7,3}};
        List<int[]> result = skyline.getSkyline(buildings);
        System.out.println(result);
    }
}
