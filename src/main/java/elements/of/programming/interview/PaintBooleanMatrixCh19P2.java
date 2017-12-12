package elements.of.programming.interview;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class PaintBooleanMatrixCh19P2 {
    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    //TODO: switch to List
    private static int[][] steps = {{1,0},{-1,0},{0,1},{0,-1}};

    public void flipDFS(boolean[][] colors, Node node) {
        boolean color  = colors[node.x][node.y];
        colors[node.x][node.y] = !color;
        for (int[] step :steps) {
            int newX = node.x + step[0];
            int newY = node.y + step[1];
            if (newX >= 0 && newX <colors.length && newY >= 0 && newY < colors[0].length
                && colors[newX][newY] == color) {
                flipDFS(colors, new Node(newX, newY));
            }
        }
    }
    // usually mark visited before enqueue, take action after dequeue
    public void flipBFS(boolean[][] colors, Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean color = colors[node.x][node.y];
        colors[node.x][node.y] = !color;
        queue.offer(node);
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            for (int[] step : steps) {
                int newX = curr.x + step[0];
                int newY = curr.y + step[1];
                if (newX >= 0 && newX <colors.length && newY >= 0 && newY < colors[0].length
                        && colors[newX][newY] == color) {
                    colors[newX][newY] = !color;
                    queue.offer(new Node(newX, newY));
                }
            }
        }
    }

    public void flipDFSUsingStack(boolean[][] colors, Node node) {
        if (colors == null || colors.length == 0 || node == null ||
                node.x < 0 || node.x >= colors.length || node.y < 0 || node.y >= colors[0].length) {
            return;
        }
        Deque<Node> stack = new ArrayDeque<>();
        boolean color = colors[node.x][node.y];
        colors[node.x][node.y] = !color;
        stack.push(node);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            for (int[] step : steps) {
                int newX = curr.x + step[0];
                int newY = curr.y + step[1];
                if (newX >= 0 && newX <colors.length && newY >= 0 && newY < colors[0].length
                        && colors[newX][newY] == color) {
                    colors[newX][newY] = !color;
                    stack.offer(new Node(newX, newY));
                }
            }
        }
    }
}
