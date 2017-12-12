package google;




//    Please use this Google doc to code during your interview. To free your hands for coding, we recommend that you use a headset or a phone with speaker option.
//
//        Write a function that can compute the length of the longest path of consecutive integers in a tree.
//        For example:
//        1 -> 2 -> 4
//        -> 3
//        Should return 2 (for the path 1->2)
//
//        1 -> 3 -> 4 -> 6
//        1 -> 4 -> 3 -> 6 -> 7 -> 8 -> 7

import java.util.ArrayList;
import java.util.List;

class Node {
    int val;
    Node[] children; //no null Node
    Node(int val, Node[] children) {
        this.val = val;
        this.children = children;
    }
}


public class LongestConsecutivePathInTree {

    private int longest;
    //Time : O(numOfLeaves * maxHeightOfTree)
    public int find(Node root) {
        longest = 0;
        List<Integer> path = new ArrayList<>();
        if (root == null) {
            return 0;
        }
        backtrack(path, root);
        return longest;
    }
    // curr should not be null
    private void backtrack(List<Integer> path, Node curr) {
        if (curr.children == null || curr.children.length == 0) {
            path.add(curr.val);
            int currLongest = find(path);
            longest = Math.max(longest, currLongest);
            path.remove(path.size()-1);
            return;
        }
        for (Node node : curr.children) {
            path.add(curr.val);
            backtrack(path, node);
            path.remove(path.size()-1);
        }
    }

    // case to check, [], [1], [1, 3, 4, 6] [1 -> 4 -> 3 -> 6 -> 7 -> 8 -> 7]
    private int find(List<Integer> path) {
        if (path == null) {
            return 0;
        }
        int max = 0;
        int countDec = 0;
        int countAsc = 0;
        for (int i = 0; i < path.size(); ++i) {
            if (i == 0) {
                countDec = 1;
                countAsc = 1;
                max = 1;
                continue;
            }
            if (path.get(i) != path.get(i-1) + 1) {
                countAsc = 1;
            }
            else {
                ++countAsc;
            }
            if (path.get(i) != path.get(i-1) - 1) {
                countDec = 1;
            }
            else {
                ++countDec;
            }
            max = Math.max(max, countAsc);
            max = Math.max(max, countDec);
        }
        return max;
    }
}

//countDec 2, 1, 2
//countAsc 1, 1 , 2, 3
//max 3,

