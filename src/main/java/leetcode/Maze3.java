package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class Maze3 {

    private static final int[][] steps = {{1,0}, {0,-1}, {0,1}, {-1,0}};
    private static final char[] dirs = {'d','l','r','u'};

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        //
        int m = maze.length;
        if (m == 0) {
            return "impossible";
        }
        int n = maze[0].length;
        Node[][] shortest = new Node[m][n]; //default to 0
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                shortest[i][j] = new Node(i,j, Integer.MAX_VALUE, "");
            }
        }
        Queue<Node> queue = new PriorityQueue<>();
        Node start = new Node(ball[0], ball[1], 0, "");
        queue.offer(start);
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.row == hole[0] && curr.col == hole[1]) { //reached the hole
                return shortest[curr.row][curr.col].path;
            }
            for (int i = 0; i < steps.length; ++i) {
                Node next = new Node(curr);
                while (!isWall(maze, next) && !(next.row == hole[0] && next.col == hole[1])) {
                    next.row += steps[i][0];
                    next.col += steps[i][1];
                    ++next.d;
                }
                if (!(next.row == hole[0] && next.col == hole[1])) { //if break at a wall not a hole
                    next.row -= steps[i][0];
                    next.col -= steps[i][1];
                    --next.d;
                }
                if (curr.d != next.d) { //ball moved and stopped at next
                    if (next.compareTo(shortest[next.row][next.col]) < 0) {
                        shortest[next.row][next.col] = next;
                        queue.offer(next);
                    }
                }
            }
        }
        return "impossible";
    }

    private boolean isWall(int[][] maze, Node node) {
        int m = maze.length;
        int n = maze[0].length;
        return node.row < 0 || node.row >= m || node.col < 0 || node.col >= n || maze[node.row][node.col] == 1;
    }

    private static final class Node implements Comparable<Node> {
        int row;
        int col;
        int d; //distance
        String path;
        public Node(int row, int col, int d, String path) {
            this.row = row;
            this.col = col;
            this.d = d;
            this.path = path;
        }

        public Node(Node node) {
            this.row = node.row;
            this.col = node.col;
            this.d = node.d;
            this.path = node.path;
        }
        @Override
        public int compareTo(Node n2) {
            return d == n2.d ? path.compareTo(n2.path) : d-n2.d;
        }
    }
}