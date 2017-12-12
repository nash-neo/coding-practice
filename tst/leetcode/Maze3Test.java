package leetcode;

import org.junit.Test;

public class Maze3Test {
    Maze3Dfs maze3 = new Maze3Dfs();

    @Test
    public void test() {
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0,4};
        int[] dest = {4,4};
        System.out.println(maze3.findShortestWay(maze, start, dest));
    }

    @Test
    public void test1() {
        int[][] maze = {{0,0,0,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0}};
        int[] start = {4,3};
        int[] dest = {0,1};
        System.out.println(maze3.findShortestWay(maze, start, dest));
    }

    @Test
    public void test2() {
        int[][] maze = {{0,0,0,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0}};
        int[] start = {4,3};
        int[] dest = {3,0};
        System.out.println(maze3.findShortestWay(maze, start, dest));
    }
}
