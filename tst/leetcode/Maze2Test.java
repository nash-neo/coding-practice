package leetcode;

import org.junit.Test;

public class Maze2Test {

    private Maze2 maze2 = new Maze2();

    @Test
    public void test() {
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0,4};
        int[] dest = {4,4};
        System.out.println(maze2.shortestDistance(maze, start, dest));
    }
}
