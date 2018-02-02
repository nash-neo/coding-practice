package airbnb;

import java.util.*;

//[[3, 5, 7, 9], [2, 3, 8], [5, 8]] 然后你要根据这个输入，输出一个总的preference list。 这这一题应该就是： [2, 3, 5, 8, 7, 9]
// cycle detection?
public class PreferenceList {

    public List<Integer> calculatePreferenceList(List<List<Integer>> preferences) {
        LinkedList<Integer> ans = new LinkedList<>();

        //build preference graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        //add all nodes
        for (List<Integer> pref : preferences) {
            for (Integer vertex : pref) {
                graph.putIfAbsent(vertex, new HashSet<>());
            }
        }

        for (List<Integer> pref : preferences) {
            for (int i = 0; i < pref.size() - 1; ++i) { //add pref[i]->pref[i+1] to the graph
                graph.get(pref.get(i)).add(pref.get(i+1));
            }
        }

        //topological sort
        Set<Integer> visited = new HashSet<>(); //assume no cycle, true is gray
        for (Integer vertex : graph.keySet()) {
            if (!visited.contains(vertex)) {
                dfs(vertex, graph, visited, ans);
            }
        }
        return ans;
    }

    private void dfs(Integer curr, Map<Integer, Set<Integer>> graph, Set<Integer> visited, LinkedList<Integer> ans) {

        visited.add(curr); // mark as gray
        for (Integer child : graph.getOrDefault(curr, Collections.emptySet())) {
            if (!visited.contains(child)) {
                dfs(child, graph, visited, ans);
            }
        }
        ans.addFirst(curr);
    }
}
