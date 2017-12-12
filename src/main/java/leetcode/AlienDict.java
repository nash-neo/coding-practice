package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AlienDict {

    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Color> colors = new HashMap<>();
        //init graph and colors
        for (String word :words) {
            for (int i = 0; i < word.length(); ++i) {
                if (!graph.containsKey(word.charAt(i))) {
                    graph.put(word.charAt(i), new HashSet<>());
                    colors.put(word.charAt(i), Color.WHITE);
                }
            }
        }
        //add edges
        for (int i = 0; i <= words.length-2; ++i) { //i+1 is in range
            String word0 = words[i];
            String word1 = words[i+1];
            for (int j = 0; j < word0.length() && j < word1.length(); ++j) {
                if (word0.charAt(j) != word1.charAt(j)) {
                    graph.get(word0.charAt(j)).add(word1.charAt(j)); //ok if already exists
                    break;
                }
            }
        }
        //run topoligical sort with cyclic detection
        List<Character> list = new ArrayList<>();
        for (Character ch : graph.keySet()) {
            if (colors.get(ch) == Color.WHITE) {
                boolean isACyclic = dfs(ch, graph, colors, list);
                if (!isACyclic) {
                    return "";
                }
            }
        }
        StringBuilder strBuilder = new StringBuilder();
        for (int i = list.size()-1; i >= 0; --i) {
            Character ch = list.get(i);
            strBuilder.append(ch);
            colors.remove(ch);
        }
        //append isolated char
        for (Character ch : colors.keySet()) {
            strBuilder.append(ch);
        }
        return strBuilder.toString();
    }

    //false if there is a cycle
    /**
     * @return isAcyclic
     */
    private boolean dfs(Character ch, Map<Character, Set<Character>> graph, Map<Character, Color> colors, List<Character> list) {
        colors.put(ch, Color.GREY);
        for (Character v : graph.get(ch)) {
            if (colors.get(v) == Color.GREY) {
                return false; //has a cycle
            }
            if (colors.get(v) == Color.WHITE) {
                boolean isAcyclic = dfs(v, graph, colors, list);
                if (!isAcyclic) {
                    return false;
                }
            }
        }
        colors.put(ch, Color.BLACK);
        list.add(ch);
        return true;
    }

    enum Color {WHITE, GREY, BLACK}
}