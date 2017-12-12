package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

    //In the single word dict case, we only start search from the cell that eqauls to first letter of the word in the dict
    //For the multiple words dict case, we could do sth similar using prefix checking, by building a trie of the dict
    //1. build a trie
    //2. for each cell in the board, check if there is a prefix match, if yes, keep backtrack, if no, return

    public List<String> findWords(char[][] board, String[] words) {
        //build a trie
        TrieNode root = buildTrie(words);
        //for each cell in board, start from root TrieNode, check if next node has a valid edge in Trie
        int m = board.length;
        if (m == 0) {
            return Collections.emptyList();
        }
        int n = board[0].length;
        Set<String> result = new HashSet<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                boolean[][] visited = new boolean[m][n]; //or reset for each loop
                find(i,j,m,n,board, root, new StringBuilder(), visited, result);
            }
        }
        return new ArrayList<>(result);
    }

    private int[][] steps = {{0,1},{0,-1},{1,0},{-1,0}};

    private void find(int i, int j, int m, int n, char[][] board, TrieNode currNode, StringBuilder prefix, boolean[][] visited, Set<String> result) {
        if (currNode.isWord) {
            result.add(prefix.toString());
            //no return, need to continue
        }
        if (currNode.children[board[i][j]-'a'] == null) {
            return;
        }
        currNode = currNode.children[board[i][j]-'a'];
        prefix.append(board[i][j]);
        visited[i][j] = true;
        //for each adjacent cell, check if there is a match in currNode
        for (int[] step : steps) {
            int nextI = i + step[0];
            int nextJ = j + step[1];
            //if in boundary && not visited(already in prefix) && currNode.children[next] is not null
            if (nextI >= 0 && nextI < m && nextJ >=0 && nextJ < n && !visited[nextI][nextJ]) {
                find(nextI, nextJ, m, n, board, currNode, prefix, visited, result);
            }
        }
        prefix.deleteCharAt(prefix.length()-1); //remove the last char
        visited[i][j] = false;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                if (curr.children[ch-'a'] == null) {
                    curr.children[ch-'a'] = new TrieNode();
                }
                curr = curr.children[ch-'a'];
            }
            curr.isWord = true;
        }
        return root;
    }

    private static class TrieNode {
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
}