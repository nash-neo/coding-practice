package leetcode;


import java.util.PriorityQueue;
import java.util.Queue;

public class Maze2 {

    private static int[][] dirs = {{1,0}, {-1,0}, {0, 1}, {0, -1}};
    //graph search, next position is determined by following the directions until a wall is hit

    //incorrect, because the edges are not equally weighted.
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int m = maze.length;
        if (m == 0) {
            return -1; //or throw an exception
        }
        int n = maze[0].length;
        int[][] shortest = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                shortest[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Node> queue = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        queue.offer(new Node(start[0], start[1], 0));
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.distance >= shortest[curr.row][curr.col]) {
                continue;
            }
            shortest[curr.row][curr.col] = curr.distance;
            for (int[] dir : dirs) {
                int nextX = curr.row + dir[0];
                int nextY = curr.col + dir[1];
                int steps = 1;
                while (nextX >= 0 && nextX < maze.length
                        && nextY >= 0 && nextY < maze[0].length
                        && maze[nextX][nextY] == 0) { //not wall
                    nextX += dir[0];
                    nextY += dir[1];
                    ++steps;
                }
                nextX -= dir[0]; //revert back
                nextY -= dir[1];
                --steps;
                if ((nextX != curr.row || nextY != curr.col)) { //!= start && unvisited
                    queue.offer(new Node(nextX, nextY, curr.distance + steps));
                }
            }
        }
        return shortest[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : shortest[dest[0]][dest[1]];
    }

    private static final class Node {
        int row;
        int col;
        int distance;
        Node(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
}