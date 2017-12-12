package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Maze3Dfs {


    private static final Dir[] dirs = {new Dir(1,0,'d'), new Dir(-1,0,'u'), new Dir(0,-1,'l'), new Dir(0,1,'r')};

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        List<Result> results = new ArrayList<>();
        int m = maze.length;
        if (m == 0) {
            return "impossible";
        }
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n]; //default to false;
        StringBuilder sb = new StringBuilder();
        dfs(maze, ball[0], ball[1], hole[0], hole[1], visited, sb, 0, results);
        if (results.isEmpty()) {
            return "impossible";
        }
        results.sort((r0, r1) -> r0.dist == r1.dist ? r0.path.compareTo(r1.path) : r0.dist - r1.dist);
        return results.get(0).path;
    }

    void dfs(int[][] maze, int currX, int currY, int destX, int destY, boolean[][] visited, StringBuilder path, int currSteps, List<Result> results) {
        visited[currX][currY] = true;
        if (currX == destX && currY == destY) {
            results.add(new Result(path.toString(), currSteps));
            return;
        }
        for (int i = 0; i < dirs.length; ++i) {
            int nextX = currX;
            int nextY = currY;
            int nextSteps = currSteps;
            while (nextX >=0 && nextX < maze.length && nextY >= 0 && nextY < maze[0].length && maze[nextX][nextY] == 0
                    && !( nextX== destX && nextY == destY))  { //not wall && not hole
                nextX += dirs[i].rowDelta;
                nextY += dirs[i].colDelta;
                ++nextSteps;
            }
            //if next is a wall, roll back, hole no roll back
            if (!( nextX== destX && nextY == destY)) {
                nextX -= dirs[i].rowDelta;
                nextY -= dirs[i].colDelta;
                --nextSteps;
            }
            if (!visited[nextX][nextY]) { //curr is visited
                path.append(dirs[i].dir);
                dfs(maze, nextX, nextY, destX, destY, visited, path, nextSteps, results);
                path.deleteCharAt(path.length()-1);
            }
        }
    }

    private static final class Result {
        String path;
        int dist; //distance
        Result(String path, int dist) {
            this.path = path;
            this.dist = dist;
        }
    }

    private static final class Dir {
        int rowDelta;
        int colDelta;
        char dir;
        Dir(int rowDelta, int colDelta, char dir) {
            this.rowDelta = rowDelta;
            this.colDelta = colDelta;
            this.dir = dir;
        }
    }

}