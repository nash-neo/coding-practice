package leetcode;

import org.junit.Test;

public class NumberIslandsTest {
    private NumberIslands numberIslands = new NumberIslands();

    @Test
    public void test() {
        char[][] grid = {{'1', '1', '1'}, {'0','1','0'}, {'0', '1', '0'}};
        System.out.println(numberIslands.numIslands(grid));
    }
}
