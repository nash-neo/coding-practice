package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Skyline {
    public List<int[]> getSkyline(int[][] buildings) {
        List<Node> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return Collections.emptyList();
        }
        NavigableMap<Integer, Node> endsX = new TreeMap<>();
        NavigableMap<Integer, Node> endsY = new TreeMap<>();
        for (int[] b : buildings) {
            int leftX = b[0];
            Node endNode = new Node(b[1], b[2]);

            //remove all ends smaller than leftX
            while (!endsY.isEmpty() && endsX.firstKey() < leftX) {
                int x = endsX.firstKey();
                Node removed = endsX.get(x);
                endsX.remove(removed.x);
                endsY.remove(removed.y);
                int y = endsY.isEmpty() ? 0 : endsY.lastKey();
                if (result.get(result.size()-1).y != y) {
                    result.add(new Node(x,y));
                }
            }
            if (endsX.isEmpty() || leftX <= endsX.firstKey()) {
                int x = leftX;
                //add endNode to endsX
                if (endsX.containsKey(endNode.x)) {
                    Node existingNode = endsX.get(endNode.x);
                    if (existingNode.y < endNode.y) {
                        endsX.replace(endNode.x, endNode);
                        endsY.remove(existingNode.y);
                    }
                }
                else {
                    endsX.put(endNode.x, endNode);
                }
                //add endNode to endsY
                if (endsY.containsKey(endNode.y)) {
                    Node existingNode = endsY.get(endNode.y);
                    if (existingNode.x < endNode.x) {
                        endsY.replace(endNode.y, endNode);
                        endsX.remove(existingNode.x);
                    }
                }
                else {
                    endsY.put(endNode.y, endNode);
                }
                if(endsY.lastKey() == endNode.y&& (result.isEmpty() || result.get(result.size()-1).y != endNode.y)) { //max y
                    result.add(new Node(leftX, endNode.y));
                }
            }
        }
        //remaining in endsY
        while (!endsX.isEmpty() && !endsY.isEmpty() ) {
            int x = endsX.firstKey();
            Node removed = endsX.get(x);
            endsX.remove(removed.x);
            endsY.remove(removed.y);
            int y = endsY.isEmpty() ? 0 : endsY.lastKey();
            if (result.get(result.size()-1).y != y) {
                result.add(new Node(x,y));
            }
        }
        return convert(result);
    }

    private List<int[]> convert(List<Node> input) {
        List<int[]> output = new ArrayList<>(input.size());
        for (int i = 0; i < input.size(); ++i) {
            int[] arr = new int[2];
            arr[0] = input.get(i).x;
            arr[1] = input.get(i).y;
            if (i!=0 && output.get(output.size()-1)[0] == arr[0]) {
                output.remove(output.size()-1);
            }
            output.add(arr);
        }
        return output;
    }

    private static class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
