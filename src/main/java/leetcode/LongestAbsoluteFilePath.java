package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LongestAbsoluteFilePath {
    //The idea is to build the directory graph and calculate length for each file(leaf) node
    public int lengthLongestPath(String input) {
        String[] nodes = input.split("\n");
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));

        return find(queue, 0);
    }
    //return the longest length rooted at queue.peek()
    private int find(Queue<String> queue, int parentLength) {
        if (queue.isEmpty()) {
            return 0;
        }
        String node = queue.poll();
        int tabs = getTabs(node);
        int length = getLength(node);
        int maxLength = 0;
        if (isDir(node)) {
            while (!queue.isEmpty() && getTabs(queue.peek()) > tabs) {
                //child, +1 for '/'
                maxLength = Math.max(maxLength, find(queue, parentLength + length +1));
            }
        }
        else {
            maxLength = Math.max(maxLength, parentLength + length);
        }
        return maxLength;
    }

    private boolean isDir(String node) {
        for (int i = 0; i < node.length(); ++i) {
            if (node.charAt(i) == '.') {
                return false;
            }
        }
        return true;
    }

    private int getLength(String node) {
        int i = 0;
        for (;i < node.length(); ++i) {
            if (node.charAt(i) != '\t') {
                break;
            }
        }
        return node.length() - i;
    }

    private int getTabs(String node) {
        return node.length() - getLength(node);
    }
}
