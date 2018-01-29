package airbnb;

import java.util.*;

//to test whether a given layer is solvable,
// we generate every permutation of the next layer,
// and if any of the next layer is solvable, the current layer is solvable
public class PyramidTransitionMatrix {
    //each node is a Set<Character>
    //each layer is a List<Set<Character>>

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        //convert bottom to layer
        List<Set<Character>> bottomLayer = new ArrayList<>();
        for (int i = 0; i < bottom.length(); ++i) {
            bottomLayer.add(Set.of(bottom.charAt(i)));
        }
        //convert allowed to Map<Character, Map<Character, Set<Character>>>
        Map<Character, Map<Character, Set<Character>>> transitionMap = new HashMap<>();
        for (String rule : allowed) {
            char left = rule.charAt(0);
            char right = rule.charAt(1);
            char result = rule.charAt(2);
            transitionMap.putIfAbsent(left, new HashMap<>());
            transitionMap.get(left).putIfAbsent(right, new HashSet<>());
            transitionMap.get(left).get(right).add(result);
        }
        //test is the bottom layer is solvable
        return isSolvable(bottomLayer, new ArrayList<>(), transitionMap);
    }

    //if curr layer has only one node, and the node is not empty, return true (reached the top layer)
    //if next layer is complete, assign curr = next, and next = new list
    //else generate next node in next layer
    private boolean isSolvable(List<Set<Character>> layer, List<Set<Character>> partialNextLayer,
                               Map<Character, Map<Character, Set<Character>>> transitionMap) {
        if (layer.size() == 1) { //reached the top layer & it is not empty
            return !layer.get(0).isEmpty();
        }
        if (partialNextLayer.size() == layer.size() - 1) {
            return isSolvable(new ArrayList<>(partialNextLayer), new ArrayList<>(), transitionMap);
        }
        // else partialNextLayer.size() < layer.size() - 1
        int k = partialNextLayer.size(); //generate from layer[k] and layer[k+1]
        partialNextLayer.add(new HashSet<>());
        for (Character left : layer.get(k)) {
            for (Character right : layer.get(k+1)) {
                partialNextLayer.get(k).addAll(
                        transitionMap.getOrDefault(left, new HashMap<>()).getOrDefault(right, new HashSet<>()));
                if (partialNextLayer.get(k).isEmpty()) { //shortcut if any node in layer is empty
                    continue;
                }
                if (isSolvable(layer, partialNextLayer, transitionMap)) {
                    return true;
                }
            }
        }
        return false; //all branches are nonsolvable
    }
}