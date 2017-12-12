package leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordSquare {

    //backtracking all permutation of word.length, or do some pruning
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ret = new ArrayList<>();
        //check null
        int n = words[0].length();
        Trie trie = new Trie(words);

        for (String word : words) {
            List<String> square = new ArrayList<>(n);
            square.add(word);
            backtrack(n, square, trie, ret);
        }
        return ret;
    }

    private void backtrack(int n, List<String> square, Trie trie, List<List<String>> ret) {
        if (square.size() == n) {
            ret.add(new ArrayList<>(square));
            return;
        }
        int m = square.size();
        StringBuilder prefix = new StringBuilder();
        for (String word : square) {
            prefix.append(word.charAt(m));
        }
        for (String word : trie.getWordsStartsWith(prefix.toString())) {
            square.add(word);
            backtrack(n, square, trie, ret);
            square.remove(square.size()-1); //remove last
        }
    }



    private static class Node {
        Node[] children;
        List<String> words; //words whose prefix follow this path
        Node() {
            children = new Node[26];
            words = new ArrayList<>();
        }
    }

    private static class Trie {
        Node root;

        Trie(String[] words) {
            root = new Node();
            for (String word : words) {
                Node curr = root;
                for (int i = 0; i < word.length(); ++i) {
                    curr.words.add(word);
                    char ch = word.charAt(i);
                    int j = ch - 'a';
                    if (curr.children[j] == null) {
                        curr.children[j] = new Node();
                    }
                    curr = curr.children[j];
                }
                curr.words.add(word);
            }
        }

        List<String> getWordsStartsWith(String prefix) {
            Node curr = root;
            for (int i = 0; i < prefix.length(); ++i) {
                curr = curr.children[prefix.charAt(i) - 'a'];
            }
            return curr.words;
        }
    }
}