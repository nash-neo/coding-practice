package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumberOfIslandsII {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        int islandsCount = 0;
        Map<Integer, Map<Integer, Node>> posToNode = new HashMap<>();
        int[][] steps = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] pos : positions) {
            Set<Node> islands = new HashSet<>();
            //add pos to posToNode
            if (!posToNode.containsKey(pos[0])) {
                posToNode.put(pos[0], new HashMap<>());
            }
            Node curr = new Node(pos[0], pos[1]);
            posToNode.get(pos[0]).put(pos[1], curr);
            for (int[] step: steps) {
                int row = pos[0] + step[0];
                int col = pos[1] + step[1];
                Node neighbor = posToNode.getOrDefault(row, Collections.emptyMap()).get(col);
                if (neighbor != null) {
                    islands.add(find(neighbor));
                }
            }
            for (Node island : islands) {
                union(island, curr);
            }
            islandsCount = islandsCount - islands.size() + 1;
            result.add(islandsCount);
        }
        return result;
    }

    private void union(Node x, Node y) {
        Node xRoot = find(x);
        Node yRoot = find(y);
        if (xRoot == yRoot) { //already in the same set
            return;
        }
        //make sure x.rank >= y.rank
        if (xRoot.rank < yRoot.rank) {
            Node tmp = xRoot;
            xRoot = yRoot;
            yRoot = tmp;
        }
        //now x.rank >= y.rank
        if (xRoot.rank == yRoot.rank) { //union by rank
            xRoot.rank += 1;
        }
        yRoot.parent = xRoot;
    }

    private Node find(Node node) {
        if (node.parent == null) {
            return node;
        }
        Node root = find(node.parent); //path compression
        node.parent = root;
        return root;
    }

    private static class Node {
        Node parent;
        int rank;
        int i;
        int j;
        Node (int i, int j) {
            this.i = i;
            this.j = j;
            rank = 0;
            parent = null;
        }
    }
}